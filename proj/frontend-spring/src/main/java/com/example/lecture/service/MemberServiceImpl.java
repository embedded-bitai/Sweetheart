package com.example.lecture.service;

import com.example.lecture.entity.Member;
import com.example.lecture.entity.MemberAuth;
import com.example.lecture.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Service
public class MemberServiceImpl implements MemberService {
    static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberRepository repository;

    @Override
    public void register(Member member) throws Exception {
        log.info("member: " + member);

        Member memEntity = new Member();
        memEntity.setUserId(member.getUserId());
        memEntity.setUserName(member.getUserName());
        memEntity.setUserNickname(member.getUserNickname());
        memEntity.setUserPassword(member.getUserPassword());
        memEntity.setDate(member.getDate());
        memEntity.setUserGender(member.getUserGender());
        memEntity.setUserEmail(member.getUserEmail());
        memEntity.setTotalAddress(member.getTotalAddress());
        memEntity.setRole(member.getRole());

        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_MEMBER");

        memEntity.addAuth(memberAuth);

        repository.save(memEntity);

        member.setUserNo(memEntity.getUserNo());
    }

    @Override
    public void setupAdmin(Member member) throws Exception {
        Member memEntity = new Member();
        memEntity.setUserId(member.getUserId());
        memEntity.setUserName(member.getUserName());
        memEntity.setUserNickname(member.getUserNickname());
        memEntity.setUserPassword(member.getUserPassword());
        memEntity.setDate(member.getDate());
        memEntity.setUserGender(member.getUserGender());
        memEntity.setUserEmail(member.getUserEmail());
        memEntity.setTotalAddress(member.getTotalAddress());
        memEntity.setRole(member.getRole());

        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_ADMIN");

        memEntity.addAuth(memberAuth);

        repository.save(memEntity);
    }

    @Override
    public List<Member> read(Long userNo) throws Exception {
        log.info("Member Service read(): " + userNo);
        log.info("String.valueOf(userNo): " + String.valueOf(userNo));

        return repository.findByUserNo(userNo);
    }

//    @Override
//    public void modify(Member member) throws Exception {
//        log.info("MemberServiceImpl - modify: " + member.getUserNo());
//        List<Member> memEntity = repository.findByUserNo(member.getUserNo());
//        log.info("memEntity - " + memEntity);
//        log.info("memEntity - " + memEntity.get(0).getSex());
//        Member mem = memEntity.get(0);
//        mem.setName(member.getName());
//        mem.setAddress(member.getAddress());
//
//        List<MemberAuth> memberAuthList = mem.getAuthList();
//        List<MemberAuth> authList = member.getAuthList();
//
//        for(int i = 0; i < authList.size(); i++) {
//            MemberAuth auth = authList.get(i);
//
//            if(i < memberAuthList.size()) {
//                MemberAuth memberAuth = memberAuthList.get(i);
//                memberAuth.setAuth(auth.getAuth());
//            }
//        }
//
//        repository.save(mem);
//    }

    @Override
    public void remove(Long userNo) throws Exception {
        repository.deleteById(userNo);
    }

//    @Override
//    public List<Member> list() throws Exception {
//        List<Object[]> valArrays = repository.listAllMember();
//        List<Member> memberList = new ArrayList<Member>();
//
//        for(Object[] valArr : valArrays) {
//            Member mem = new Member();
//
//            mem.setUserNo((Long) valArr[0]);
//            mem.setEmail((String) valArr[1]);
//            mem.setPw((String) valArr[2]);
//            mem.setName((String) valArr[3]);
//            mem.setSex((String) valArr[4]);
//            mem.setRole((String) valArr[5]);
//            mem.setAddress((String) valArr[6]);
//            mem.setRegDate((Date) valArr[7]);
//
//            memberList.add(mem);
//        }
//
//        return memberList;
//    }

    @Override
    public long countAll() throws Exception {
        return repository.count();
    }

    @Override
    public boolean checkId(String userId) throws Exception {
        log.info("checkId() - userId: " + userId);
        List<Member> memEntity = repository.findByUserId(userId);
        log.info("memEntity: " + memEntity);

        if (!memEntity.isEmpty()) {
            log.info("userId가 존재한다.");
            return true;
        }

        return false;
    }

    @Override
    public boolean checkEmail(String userEmail) throws Exception {
        log.info("checkId() - userEmail: " + userEmail);

        return false;
    }

    @Override
    public String findId(String userName, String userEmail) throws Exception {
        log.info("findId() - userName: "+userName+", userEmail: "+userEmail);
        String userId = repository.findUserIdByNameAndEmail(userName, userEmail);

        if(userId.isEmpty()) {
            log.info("ID가 존재하지 않습니다.");
        }

        return userId;
    }

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;

    @Override
    public int mailSend(HttpSession session, String userEmail) throws Exception {
        log.info("mailSend() - userEmail: " + userEmail);
        try {
            MailHandler mailHandler = new MailHandler(javaMailSenderImpl);
            Random random = new Random(System.currentTimeMillis());
            long start = System.currentTimeMillis();

            int result = 100000 + random.nextInt(900000);

            mailHandler.setTo(userEmail);
            mailHandler.setFrom("developer@gmail.com");
            mailHandler.setSubject("인증번호입니다");
            String htmlContent = "<p>인증번호: + "+result+"</p>";
            mailHandler.setText(htmlContent, true);
            mailHandler.send();

            long end = System.currentTimeMillis();

            session.setAttribute(userEmail, result);
            log.info("userEmail: " + userEmail + "result: " + result + "실행 시간: " + (end - start )/1000.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean emailCertification(HttpSession session, String userEmail, int inputCode) throws Exception {
        log.info("emailCertification() - userEmail: " + userEmail + ", inputCode: " + inputCode);
        try {
            int generationCode = (int)session.getAttribute(userEmail);

            if(generationCode == inputCode){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw  e;
        }
    }

    @Override
    public void makeFriends(String userId) throws Exception {
        log.info("makeFriends() - userId: " + userId);

    }
}
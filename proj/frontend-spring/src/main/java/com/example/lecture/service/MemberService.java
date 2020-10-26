package com.example.lecture.service;

import com.example.lecture.entity.Member;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MemberService {
    public void register(Member member) throws Exception;
    public void setupAdmin(Member member) throws Exception;

    public List<Member> read(Long userNo) throws Exception;
//    public void modify(Member member) throws Exception;
    public void remove(Long userNo) throws Exception;
//    public List<Member> list() throws Exception;
    public long countAll() throws Exception;
    public boolean checkId(String userId) throws Exception;
    public boolean checkEmail(String userEmail) throws Exception;
    public String findId(String userName, String userEmail) throws Exception;
    public int mailSend(HttpSession session, String userEmail) throws Exception;
    public boolean emailCertification(HttpSession session, String userEmail, int inputCode) throws Exception;
    public void makeFriends(String userId) throws Exception;
//    public boolean emailCertification(String userEmail, int inputCode) throws Exception;
}

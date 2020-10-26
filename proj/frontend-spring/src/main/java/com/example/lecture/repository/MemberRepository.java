package com.example.lecture.repository;

import com.example.lecture.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public List<Member> findByUserId(String email);
    public List<Member> findByUserNo(Long userNo);

    @Query("select m.userId from Member m where m.userName = :user_name and m.userEmail = :user_email")
    public String findUserIdByNameAndEmail(@Param("user_name") String userName, @Param("user_email") String userEmail);

//    @Query("select m.userNo, m.pw, m.name, m.regDate from sh_member m")
//    public List<Object[]> listAllMember();
//
//    @Query("select m.userNo, m.pw, m.name, m.regDate from sh_member m where m.userNo = :user_no")
//    public Member listMember(@Param("user_no") Long userNo);
}
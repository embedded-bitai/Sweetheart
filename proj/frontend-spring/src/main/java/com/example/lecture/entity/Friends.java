package com.example.lecture.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Friends")
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendsNo;

    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "user_Name", length = 100, nullable = false)
    private String userName;

    @Column(name = "profileImg", length = 100, nullable = true)
    private String profileImg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private Date regDate;
}
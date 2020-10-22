package com.example.lecture.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TimelinePost")
public class TimelinePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;

    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "user_Name", length = 100, nullable = false)
    private String userName;

    @Column(name = "profileImg", length = 100, nullable = true)
    private String profileImg;

    @Column(length = 2000, nullable = true)
    private String Image;

    @Column(length = 500, nullable = true)
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private Date upDate;
}

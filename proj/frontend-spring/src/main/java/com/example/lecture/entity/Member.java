package com.example.lecture.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;

@JsonIgnoreProperties(value="hibernateLazyInitializer")
@Getter
@Setter
@EqualsAndHashCode(of = "userNo")
@ToString
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(length = 100, nullable = false)
    private String userId;

    //@NotBlank
    @Column(name = "user_Name", length = 100, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String userNickname;

    @Column(length = 200, nullable = false)
    private String userPassword;

    @Column(length = 100, nullable = false)
    private String date;

    @Column(length = 16, nullable = false)
    private String userGender;

    @Column(length = 100, nullable = false)
    private String userEmail;

    @Column(length = 1000, nullable = false)
    private String totalAddress;

    @Column(length = 100, nullable = false)
    private String role;

    @Column(name = "profileImg", length = 100, nullable = true)
    private String profileImg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private Date updDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private Date dropDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private Date pw_change_date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    private Set<MemberAuth> authList = new HashSet<MemberAuth>();
    public void addAuth(MemberAuth auth) {
        authList.add(auth);
    }
    public void clearAuthList() {
        authList.clear();
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    private Set<TimelinePost> timelinePosts = new HashSet<TimelinePost>();
    public void addTimeLinePost(TimelinePost timelinePost) {
        timelinePosts.add(timelinePost);
    }
    public void clearTimeLinePost() {
        authList.clear();
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    private Set<Friends> friends = new HashSet<Friends>();
    public void addFriends(Friends friend) {
        friends.add(friend);
    }
    public void clearFriends() {
        friends.clear();
    }
}
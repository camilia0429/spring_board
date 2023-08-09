package com.fantasy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes={
        @Index(name="idx_member_userNm",columnList = "userNm"),
        @Index(name="idx_member_email",columnList = "email")
})
public class Member extends BaseEntity {


    @Id @GeneratedValue
    private Long userNo;

    @Column(length=40, nullable = false, unique = true)
    private String userId;

    @Column(length=65, nullable = false)
    private String userPw;

    @Column(length=40, nullable = false)
    private String userNm;

    @Column(length=100, nullable = false)
    private String email;

    @Column(length=11)
    private String mobile;

    @Lob
    private String termsAgree; // 약관 동의 내역
}
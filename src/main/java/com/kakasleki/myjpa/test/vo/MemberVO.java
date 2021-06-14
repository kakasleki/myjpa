package com.kakasleki.myjpa.test.vo;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "member")
@Table
public class MemberVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mbrNo;

    private String id;

    private String name;

    @Builder
    public MemberVO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

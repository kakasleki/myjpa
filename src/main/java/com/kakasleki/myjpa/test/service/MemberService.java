package com.kakasleki.myjpa.test.service;

import com.kakasleki.myjpa.test.repository.MemberRepository;
import com.kakasleki.myjpa.test.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<MemberVO> findAll() {
        return new ArrayList<>(this.memberRepository.findAll());
    }

    public Optional<MemberVO> findById(Long mbrNo) {
        return this.memberRepository.findById(mbrNo);
    }

    public void deleteById(Long mbrNo) {
        this.memberRepository.deleteById(mbrNo);
    }

    public MemberVO save(MemberVO member) {
        this.memberRepository.save(member);
        return member;
    }

    public void updateById(Long mbrNo, MemberVO member) {
        Optional<MemberVO> e = this.memberRepository.findById(mbrNo);

        if(e.isPresent()) {
            e.get().setMbrNo(member.getMbrNo());
            e.get().setId(member.getId());
            e.get().setName(member.getName());
            this.memberRepository.save(member);
        }
    }
}

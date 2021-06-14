package com.kakasleki.myjpa.test.repository;

import com.kakasleki.myjpa.test.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long> {
    List<MemberVO> findById(String id);

    List<MemberVO> findByName(String name);

    List<MemberVO> findByNameLike(String keyword);
}

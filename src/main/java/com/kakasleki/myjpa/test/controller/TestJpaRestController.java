package com.kakasleki.myjpa.test.controller;

import com.kakasleki.myjpa.test.service.MemberService;
import com.kakasleki.myjpa.test.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "memberTest")
public class TestJpaRestController {
    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(TestJpaRestController.class);
    }

    @Autowired
    private MemberService memberService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MemberVO>> getAllMembers() {
        List<MemberVO> members = this.memberService.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberVO> getMember(@PathVariable("mbrNo") Long mbrNo) {
        Optional<MemberVO> member = this.memberService.findById(mbrNo);
        return new ResponseEntity<>(member.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Long mbrNo) {
        this.memberService.deleteById(mbrNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberVO> updateMember(@PathVariable("mbrNo") Long mbrNo, MemberVO member) {
        this.memberService.updateById(mbrNo, member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MemberVO> save(MemberVO member) {
        return new ResponseEntity<>(this.memberService.save(member), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveMember", method = RequestMethod.GET)
    public ResponseEntity<MemberVO> save(HttpServletRequest request, MemberVO member) {
        return new ResponseEntity<>(this.memberService.save(member), HttpStatus.OK);
    }
}

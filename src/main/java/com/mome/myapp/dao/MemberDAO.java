package com.mome.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mome.myapp.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO { 
	
	
	//회원가입 생성
	public int memberWrite(MemberVO vo);
	
	// 로그인
	public MemberVO loginOk(MemberVO vo);
	
	//회원선택 : 로그인한 회원
	public MemberVO getMember(String useremail);
	
	//회원정보 수정
	public int memberEditOk(MemberVO vo);

}

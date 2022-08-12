package com.mome.myapp.service;

import java.util.List;

import com.mome.myapp.vo.MemberVO;

public interface MemberService { 
	public int memberWrite(MemberVO vo);
	public MemberVO loginOk(MemberVO vo);
	public MemberVO getMember(String useremail);
	public int memberEditOk(MemberVO vo);

}

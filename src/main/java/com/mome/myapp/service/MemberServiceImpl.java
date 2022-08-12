package com.mome.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mome.myapp.dao.MemberDAO;
import com.mome.myapp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDAO dao;

	 



	@Override
	public int memberWrite(MemberVO vo) {
		return dao.memberWrite(vo);
	}

	@Override
	public MemberVO loginOk(MemberVO vo) {
		return dao.loginOk(vo);
	}

	@Override
	public MemberVO getMember(String useremail) {
		return dao.getMember(useremail);
	}

	@Override
	public int memberEditOk(MemberVO vo) {
		return dao.memberEditOk(vo);
	}

}

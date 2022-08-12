package com.mome.myapp.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mome.myapp.service.MemberService;
import com.mome.myapp.vo.MemberVO;

@RestController
@RequestMapping("/member/*") //앞에 /member/로 접속이되면, 어떤 페이지로든 접속이 가능하게 설정
public class MemberController {
	@Inject
	MemberService service;
	
	//@RequestMapping("/member/memberForm") //top.jspf에서 호출됨
	
	// 12행과 15~16행은 같은 말
	//get방식일 때는 @GetMapping	post방식일 때는 @PostMapping	=> 지금은 get방식
	@GetMapping("memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav=new ModelAndView();
		//return "member/memberForm"; //member폴더 안에 memberForm
		mav.setViewName("member/memberForm"); //member/memberForm로 이동됨
		return mav;
	}
	
 

	
	//회원가입
	@PostMapping("memberWrite")
	public ResponseEntity<String> memberWrite(MemberVO vo) {
		
		//RestController에서는 ResponseBody를 보낼 수 있다.
		//클라이언트에게 데이터와 뷰파일을 담을 수 있는 객체이며, 뷰페이지를 별도로 만들 필요가 없다.
		ResponseEntity<String> entity=null;
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=utf-8");
		
		try{ // 회원등록 => 로그인폼으로 이동
			int result = service.memberWrite(vo);
			
			String msg="<script>";
			msg+="alert('회원가입이 성공하였습니다. 로그인페이지로 이동합니다.');";
			msg+="location.href='/member/login'";
			msg+="</script>";
			
			entity=new ResponseEntity<String>(msg,headers, HttpStatus.OK); //성공이란 의미로, 200을 보냄
		}catch(Exception e) { //회원등록 실패 => 이전페이지로 이동(history)
			String msg="<script>";
			msg+="alert('회원가입이 실패하였습니다!');";
			msg+="history.back();";
			msg+="</script>";
			entity=new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
			
			e.printStackTrace();
		}
		return entity;
	}
	//로그인 폼
	@GetMapping("login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;
		
	}
	
	//로그인 DB조회
	@PostMapping("loginOK")
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		ModelAndView mav=new ModelAndView();
		
		MemberVO logVO = service.loginOk(vo);
		
		if(logVO!=null) {//로그인 성공
			session.setAttribute("logId", logVO.getUseremail());
			session.setAttribute("logStatus", "Y");
			mav.setViewName("redirect:/"); //홈페이지로 이동하도록
		}
		else { //로그인 실패
			mav.setViewName("redirect:login"); //login폼으로 이동하도록
		}
		return mav;
	}
	
	//로그아웃
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();//로그인 했을때 저장되었던 세션의 로그인 정보를 제거하는 역할 (사실 세션이 지워지는 것임)
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
		
	}
	
	//////////////////////////////////////////////////////////////////////////////회원수정 대신 흰 박스만 남기기////////////////////////////////////
	//회원정보 수정 폼 : 세션의 아이디와 같은 회원정보를 선택한 후, 뷰페이지로 이동해야한다.
	@GetMapping("memberEdit")
	public ModelAndView memberEdit(HttpSession session) {//session에 저장되어있는 것들
		String userid = (String)session.getAttribute("logId");
		
		MemberVO vo = service.getMember(userid);// 선택한 회원의 정보
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("member/memberEdit");
		
		return mav;
	}
	
	//회원정보 수정 DB 업데이트
	@PostMapping("memberEditOk")
	public ResponseEntity<String> memberEditOk(MemberVO vo) {
		ResponseEntity<String> entity=null;
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		String msg="<script>";
		int cnt = service.memberEditOk(vo);
		if(cnt>0) {//수정됨
			msg+="alert('회원정보가 수정되었습니다.');";
		}
		else {//수정 못함
			msg+="alert('회원정보수정이 실패하였습니다.');";
		}
		msg+="location.href='/member/memberEdit';</script>";
		
		entity=new ResponseEntity<String>(msg,headers,HttpStatus.OK);
		return entity;
	}
	
	
}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	h1{
		font-size:20px;
		text-align:center;
		color:#f98169;
		margin-top:40px;
	}
	.frm{
		padding:0 70px;
		top:100px;
		position:absolute;
		width:280px;
		
	}
	.form-box{ /* 흰 박스 */
		width:500px;
		height:500px;
		position:relative;
		margin:6% auto;
		background:#fff;
		padding:5px;
		overflow:hidden; /* 로그인, 회원가입 폼이 박스 밖으로 나가면 숨기기 */
		box-shadow:0 4px 16px #ddd;
		border-radius:30px;
	}
	#register{
	left:450px;
	}
	.input-group{ /* 로그인폼 회원가입폼 부분 */
		padding:0 40px;
		top:150px;
		width:280px;
	}
	.input-field{
		width:100%;
		padding:5px 0;
		margin:5px 0;
		margin-left:5px;
		border-left:0;
		border-top:0;
		border-right:0;
		border-bottom:1px solid #999;
		outline:none;
		background:transparent;
	}
	.submit-btn{
		width:100%;
		padding:10px 20px;
		cursor:pointer;
		display:block;
		margin:auto;
		margin-left:5px;
		margin-top:20px;
		background:#f98169;
		color:#fff;
		font-weight:bold;
		border:0;
		outline:none;
	
</style>
<script>
	$(function(){
		
		//유효성 검사
		$("#mFrm").submit(function(){
			//이메일
			if($("#useremail").val()==""){
				alert("이메일을 입력하세요!");
				return false;
			}
 
			if($("#userpwd").val()==""){ //비번 입력 안했을때
				alert("비밀번호를 입력하세요!");
				return false;				
			}
			//이름
			if($("#username").val()==""){
				alert("이름을 입력하세요!");
				return false;
			}
			
			//닉네임
			if($("#nickname").val()==""){
				alert("닉네임을 입력하세요!");
				return false;
			}
			
			//연락처 (3개)
			if($("#usertel").val()==""){ 
				alert("연락처를 입력하세요!");
				return false;
			}
			return true;
		});
		
	});
</script>
<div class="form-box">
	<h1>회원등록</h1>
	<form method="post" action="/member/memberWrite" id="mFrm" class="input-group"> <!-- MemberController.java에서 10행에 /member/*라고 해서, 여기도 /member/로 시작을 해야함 -->
		<ul class="frm">
			<li>이메일</li>
			<li><input type="text" name="useremail" id="useremail" class="input-field"/>
			</li>
			<li>비밀번호</li>
			<li><input type="password" name="userpwd" id="userpwd" class="input-field"/></li>
			<li>이름</li>
			<li><input type="text" name="username" id="username" class="input-field"/></li>
			<li>닉네임</li>
			<li><input type="text" name="nickname" id="nickname" class="input-field"/></li>
			<li>연락처</li>
			<li><input type="text" name="usertel" id="usertel" class="input-field"/></li>	
			<li>
				<input type="submit" class="submit-btn" value="회원가입하기"/>
			</li>
		</ul>
	</form>
	
</div>
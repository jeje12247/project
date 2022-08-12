<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	h1{
		font-size:20px;
		text-align:center;
		color:#f98169;
		margin-top:40px;
	}
	.frm{
		padding:0 110px;
		top:150px;
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
	#login{
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
		
		$("#log").submit(function(){
			if($("#useremail").val()==""){
				alert("이메일을 입력하세요.");
				return false; //다음으로 가면 안되기때문
			}
			if($("#userpwd").val()==""){
				alert("비밀번호를 입력하세요.");
				return false; 
			}
			return true;
			
		});
		
	});

</script>


<div class="form-box">
	<h1>로그인</h1>
	<form method="post" action="/member/loginOK" id="log">
	<ul class="frm">
		<li>이메일</li>
		<li><input type="text" name="useremail" id="useremail" class="input-field"/></li>
		<li>비밀번호</li>
		<li><input type="password" name="userpwd" id="userpwd" class="input-field"/></li>
		<li><input type="submit" class="submit-btn" value="로그인"/></li>
	</ul>
	</form>
	
</div>
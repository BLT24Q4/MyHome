<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

                   <form id="join-form" 
						name="joinForm" 
						method="POST" 
						action="<%= request.getContextPath() %>/users"
						onsubmit="return checkForm(this)">
						<input type="hidden" name="a" value="join">
						
						<label class="block-label" for="name">이름</label>
						<input id="name" name="name" type="text" value="">
	
						<label class="block-label" for="email">이메일</label>
						<input id="email" name="email" type="text" value="">
						<input type="button" value="id 중복체크">
						
						<label class="block-label">패스워드</label>
						<input name="password" type="password" value="">
						
						<fieldset>
							<legend>성별</legend>
							<label>여</label> <input type="radio" name="gender" value="F" checked="checked">
							<label>남</label> <input type="radio" name="gender" value="M">
						</fieldset>
						
						<fieldset>
							<legend>약관동의</legend>
							<input name="agree" type="checkbox" value="y">
							<label for="agree">서비스 약관에 동의합니다.</label>
						</fieldset>
						
						<input type="submit" value="가입하기">
						
					</form>
					
					
</body>
</html>
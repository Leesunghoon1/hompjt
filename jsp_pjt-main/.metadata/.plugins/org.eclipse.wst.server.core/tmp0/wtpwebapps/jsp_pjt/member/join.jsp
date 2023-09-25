<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<h1>회원가입</h1>
	<br>
	<form action="/mem/register" method="post">
	아이디 입력 : <input type="text" name="id"><br>
	비밀번호 입력 : <input type="password" name="pwd"><br>
	핸드폰 번호 입력 : <input type="text" name="pnum"><br>
	이메일 입력 : <input type="text" name="email"><br>
	나이 입력 : <input type="text" name="age"><br>
	
	
	<button type="submit">가입하기.</button>
	</form>
</body>
</html>
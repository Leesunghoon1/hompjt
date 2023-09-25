<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>계시판 상세정보</h1>
<table border="1">
	<tr>
		<th>BNO</th>
		<td>${bvo.bno }</td>
	</tr>
	<tr>
		<th>TITLE</th>
		<td>${bvo.title }</td>
	</tr>
	<tr>
		<th>WRITER</th>
		<td>${bvo.writer }</td>
	</tr>
	<tr>
		<th>REG_DATE</th>
		<td>${bvo.regdate }</td>
	</tr>
	<tr>
		<th>MOD_DATE</th>
		<td>${bvo.moddate }</td>
	</tr>
	<tr>
		<th>CONTENT</th>
		<td>${bvo.content }</td>
	</tr>
</table>

<a href="/brd/modify?bno=${bvo.bno }"><button type="button">수정</button></a>
<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제</button></a>
<a href="/brd/list?bno=${bvo.bno }"><button type="button">리스트로 되돌아가기</button></a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th colspan="2">로그인 창</th>
		</tr>
		<tr>
			<td>아이디 :</td>
			<td><input type="text" placeholder="아이디를 입력해주세요."></td>
		</tr>
		<tr>	
			<td>패스워드 :</td>
			<td><input type="password" placeholder="비밀번호를 입력해주세요."></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="로그인">
			<a href="/member/signup"><input type="button" value="회원가입"></a>
			</td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/inputProc" method="post">
		<table border="1" align="center">
			<tr>
				<th colspan="2">메세지 입력폼</th>
			</tr>
			<tr>
				<td><input type="text" name="writer" placeholder="이름"></td>
				<td><input type="text" name="message" placeholder="메세지"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>
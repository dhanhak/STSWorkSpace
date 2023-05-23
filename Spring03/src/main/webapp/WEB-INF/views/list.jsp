<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>id</th>
			<th>writer</th>
			<th>message</th>
		</tr>
		<c:forEach var="i" items="${list }">
			<tr>
				<td>${i.seq }</td>
				<td>${i.writer }</td>
				<td>${i.message }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="center">
				<form action="/delete" method="post">
					<input type="text" placeholder="삭제할 ID" name="seq"> 
					<input type="submit" value="삭제">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<form action="/modify" method="post">
					<input type="text" placeholder="수정할 ID" name="seq"> 
					<input type="text" placeholder="수정할 이름" name="writer"> 
					<input type="text" placeholder="수정할 메세지" name="message"> 
					<input type="submit" value="수정">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
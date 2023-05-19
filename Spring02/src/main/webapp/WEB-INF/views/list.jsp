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
			<th colspan="3">Movies
		</tr>
		<c:forEach var="i" items="${list }">
			<tr>
				<td>${i.id }</td>
				<td>${i.title }</td>
				<td>${i.genre }<br></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="center">
				<form action="/delete" method="post">
					<input type="text" name="deleteID" placeholder="삭제할 영화 ID">
					<input type="submit" value="삭제하기">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<form action="/modify" method="post">
					<input type="text" name="id" placeholder="수정할 영화 ID"> <input
						type="text" name="title" placeholder="수정할 영화 title"> <input
						type="text" name="genre" placeholder="수정할 영화 genre"> <input
						type="submit" value="수정하기">
				</form>
			</td>
		</tr>
		
	</table>
</body>
</html>
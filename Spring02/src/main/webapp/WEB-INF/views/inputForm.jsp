<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Form</title>
</head>
<body>
	<form action="/inputProc" method="post">
		<table border="1" align="center">
			<tr>
				<th colspan="1">Input</th>
			</tr>
			<tr>
				<td><input type="text" name="id" placeholder="영화 ID"></td>
			</tr>
			<tr>
				<td><input type="text" name="title" placeholder="영화 제목"></td>
			</tr>
			<tr>
				<td><input type="text" name="genre" placeholder="영화 장르"></td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit">
					<a href="/"><button type="button">뒤로가기</button></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
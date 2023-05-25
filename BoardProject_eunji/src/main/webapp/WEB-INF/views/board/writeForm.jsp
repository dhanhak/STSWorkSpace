<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form</title>
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
</head>
<body>
<form action="/board/writeContent" method="post">
	<table border="1">
		<tr>
			<th height="40">자유게시판 </th>
		</tr>
		<tr>
			<td>
			<input type="text" name="title" id="title" placeholder="글 제목을 입력하세요"></td>
		</tr>
		<tr>
			<td><textarea name="contents" id="contents" placeholder="글 내용을 입력하세요." cols="100" rows="20"></textarea></td>
		</tr>
		<tr>
			<td>
			<input type=file name=file>
			<button type="button">업로드 취소</button>
			</td>
		</tr>
		<tr>
			<td align="right">
				<a><input type="submit" value="작성완료"></a>
				<a href="/board/boardlist"> <input type="button" value="목록으로"></a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
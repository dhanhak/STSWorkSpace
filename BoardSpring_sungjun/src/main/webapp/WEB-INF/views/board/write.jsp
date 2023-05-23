<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/write" method="post" enctype="multipart/form-data"
		id="form" name="form">
		<table border="1" width="500" height="400">

			<tr>
				<th colspan="2" align="center">자유게시판 글 작성하기</th>
			</tr>
			<tr>
				<td colspan="2">작성자 : <input type="text" name="writer"
					value="${sessionScope.loginId}" readonly></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" size="100%"
					placeholder="글 제목을 입력하세요" id="title" name="title"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea cols="100%" rows="20%"
						placeholder="글 내용을 입력해주세요" id="content" name="content"></textarea></td>
			</tr>

			<tr>
				<td><input type="file" name="file"></td>
				<td align="right">
				<input type="button" value="목록으로" id="toList"> 
				<input type="submit" value="작성완료" id="complete">
				</td>
			</tr>

		</table>
	</form>
	<script>
		$("#toList").on("click", function() {
			location.href = "/board/boardlist?cpage=${sessionScope.currentPage}";
		});
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content View</title>
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<style>
table {
	margin: auto
}
</style>
</head>
<body>
	<form action="/updateContentsCheck.board?seq=${dto.seq}" method="post">
		<table border="1">
			<tr>
				<th height="40" colspan=2><input type="text" name="title"
					id="title" value="${dto.title}"
					style="text-align: center; width: 99%; height: 40px;" readonly>
				</th>
			</tr>
			<tr>
				<td>작성자 : ${dto.writer}</td>
				<td>조회수 : ${dto.view_count}</td>
			</tr>
			<tr>
				<td colspan=2><textarea name="contents" id="contents"
						cols="100" rows="20" readonly>${dto.contents}</textarea></td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${fdto.seq == -1}">
						<td colspan=2>첨부파일 없음</td>
					</c:when>
					<c:otherwise>
						<td colspan=2>첨부파일 : <a href="/downloadFile.board?oriName=${fdto.oriName}&sysName=${fdto.sysName}">${fdto.oriName}</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${dto.writer == loginID}">
						<td id="control" align="right" colspan=2><a><input
								type="button" id="update" value="수정하기"></a> <a
							href="/deleteContentsCheck.board?seq=${dto.seq}"><input
								type="button" id="delete" value="삭제하기"></a> <a
							href="/list.board?cpage=${ctPage}"><input type="button"
								id="back" value="목록으로"></a></td>
					</c:when>
					<c:otherwise>
						<td align="right" colspan=2><a href="/list.board?cpage=1"><input
								type="button" value="목록으로"></a></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</form>
	<br>
	<hr>
	<br>
	<form action="/insertReplyCheck.reply">
		<input type="hidden" name="parent_seq" value="${dto.seq}"> <input
			type="hidden" name="writer" value="${loginID}">
		<table border="1">
			<tr>
				<td colspan=2>작성자 : ${loginID}</td>
			</tr>
			<tr>
				<td><textarea name="replyContents" id="replyContents" cols="90"
						rows="5"></textarea></td>
				<td><button style="width: 50px; height: 50px">등록</button></td>
			</tr>
		</table>
	</form>
	<br>
	<c:forEach var="i" items="${replyList}">
		<form
			action="/updateReplyCheck.reply?parent_seq=${dto.seq}&seq=${i.seq}"
			method="post">
			<table border="1" style="width: 719px">
				<tr>
					<td style="width: 60%">작성자 : ${i.writer}</td>
					<td style="width: 40%">작성날짜 : <%@page
							import="kh.spring.commons.CalculationUtils"%>
						${CalculationUtils.calculateTime(i.write_date)}
					</td>
				</tr>
				<tr>
					<td><textarea name="selectReplyContents"
							id="selectReplyContents" cols="70" rows="5" readonly>${i.contents}</textarea></td>
					<c:choose>
						<c:when test="${i.writer == loginID}">
							<td id="replyControl"><a><input type="button"
									id="replyUpdate" value="수정" style="width: 50px; height: 50px"></a>
								<a
								href="/deleteReplyCheck.reply?parent_seq=${dto.seq}&seq=${i.seq}">
									<input type="button" id="replyDelete" value="삭제"
									style="width: 50px; height: 50px">
							</a></td>
						</c:when>
					</c:choose>
				</tr>
			</table>
		</form>
	</c:forEach>

	<script>
		$("#update").on("click", function() {
			$("#title").removeAttr("readonly");
			$("#contents").removeAttr("readonly");
			$("#back,#update,#delete").css("display", "none");

			let updateComplete = $("<button>");
			updateComplete.text("수정 완료");

			let cancel = $("<button>");
			cancel.attr("type", "button");
			cancel.text("취소");
			cancel.on("click", function() {
				location.reload();
			})

			$("#control").append(cancel);
			$("#control").prepend(updateComplete);

		})

		$("#replyUpdate").on("click", function() {
			$("#selectReplyContents").removeAttr("readonly");
			$("#replyUpdate,#replyDelete").css("display", "none");

			let updateComplete = $("<button>");
			updateComplete.text("수정 완료");

			let cancel = $("<button>");
			cancel.attr("type", "button");
			cancel.text("취소");
			cancel.on("click", function() {
				location.reload();
			})

			$("#replyControl").append(cancel);
			$("#replyControl").prepend(updateComplete);
		})
	</script>
</body>
</html>
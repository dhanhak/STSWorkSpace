<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<table border="1" width="1000" height="400">
		<tr>
			<th align="center" colspan="5">자유게시판</th>
		</tr>
		<tr>
			<td width="200" align="center">글 번호</td>
			<td width="500" align="center">제목</td>
			<td width="100" align="center">작성자</td>
			<td width="100" align="center">조회수</td>
			<td width="100" align="center">작성일</td>
		</tr>

		<c:choose>
			<c:when test="${list!=null}">
				<c:forEach var="i" items="${list}">
					<tr>
						<td align="center">${i.seq}</td>
						<td><a href="contents.board?seq=${i.seq}">${i.title}</a></td>
						<td align="center">${i.writer}</td>
						<td align="center">${i.view_count}</td>
						<td align="center"><fmt:formatDate value="${i.write_date}"
								pattern="yy-MM-dd" /></td>

					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5" align="center" height="300" id="boardMain">
						표시할 내용이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>



		<tr>
			<td colspan="5" align="center">${navi }</td>
		</tr>

		<tr>
			<td align="center">UserID : ${sessionScope.loginId}</td>
			<td colspan="3"></td>
			
			<td align="right">
			<input type="button" value="작성하기" id="write" style="width:100%"></td>
		</tr>
		<form action="/" method="post">
			<tr>
				<td colspan="5" align="center">
				<select id="searchSel" name="searchSel">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
						<option value="contents">글내용</option>
				</select> 
					<input type="text" placeholder="검색" id="search" name="search">
					<input type="submit" id="searchBtn" name="searchBtn" value="검색">
				</td>
			</tr>
		</form>
	</table>
	
	<script>
		$("#write").on("click",function(){
			location.href="/board/toWrite"
		})
	</script>
	
</body>
</html>
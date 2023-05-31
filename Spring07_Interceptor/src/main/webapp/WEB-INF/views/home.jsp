<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interceptor Practice</title>
</head>
<body>

	<c:choose>
		<c:when test="${loginID != null }">
			${loginID }님 환영합니다.
		</c:when>
		<c:otherwise>
			로그인을 하지 않았습니다.
		</c:otherwise>
	</c:choose>
	
	<hr>
	
	<a href="/member/Login">로그인</a>
	<a href="/member/Logout">로그아웃</a>
	<hr>
	<a href="/guest"><button>로그인 없어도 접속할 수 있는 페이지</button></a>
	<a href="/member"><button>로그인 해야만 접속할 수 있는 페이지</button></a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	
	<c:choose>
		<c:when test="${empty loginId}">
			<form action="member/login" method="post">
				<table border="1" align="center">
					<tr>
						<th colspan="2">Login Box</th>
					</tr>
					<tr>
						<td>아이디 :</td>
						<td><input type="text" name="id"
							placeholder="Input your id"></td>
					</tr>
					<tr>
						<td>패스워드 :</td>
						<td><input type="password" name="pw"
							placeholder="Input your pw"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							id="login" value="로그인"> <input type="button" id="toJoin"
							value="회원가입"><br> <input type="checkbox">ID
							기억하기</td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<table border=1 align=center>
				<tr>
					<th colspan=4>${loginId} 님 환영합니다.</th>
				</tr>
				<tr>
					<td align=center><a href="board/boardlist"><button>게시판으로</button></a></td>
					<td align=center><a href="member/mypage"><button>마이페이지</button></a></td>
					<td align=center><a href="member/logout"><button>로그아웃</button></a></td>
					<td align=center><button id="memberOut">회원탈퇴</button></a></td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>

	<script>
		$("#memberOut").on("click", function() {
			let result = confirm("정말 탈퇴 하시겠습니까?");
			if (result) {
				location.href = "member/memberout";
			}
		})
		$("#toJoin").on("click", function() {
			// 파일 안에 있어서 루트 적어줘야
			location.href = "member/signup";
		})
	</script>
</body>
</html>
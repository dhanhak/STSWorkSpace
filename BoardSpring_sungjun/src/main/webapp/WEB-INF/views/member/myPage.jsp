<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<script>
		$(function() {
			$("#search").css("display", "none");
		})
	</script>
		<form action="/member/updateMyInfo" method="post" id="form">
		<table border=1 align=center>
			<tr>
				<th colspan=2>마이 페이지</th>
			</tr>
			<tr>
				<td>ID</td>
				<td>${dto.id }
				<input type=text value="${dto.id }" name="id" id="id" readonly style="display:none">
				</td>
			</tr>
			
			<tr>
				<td>NAME</td>
				<td><input type=text value="${dto.name }" id="name" name="name"
					readonly></td>
			</tr>
			<tr>
				<td>PHONE</td>
				<td><input type=text value="${dto.phone }" id="phone" name="phone"
					readonly></td>
			</tr>
			<tr>
				<td>EMAIL</td> 
				<td><input type=text value="${dto.email }" id="email" name="email"
					readonly></td>
			</tr>
			<tr>
				<td>ZIPCODE</td>
				<td><input type=text value="${dto.zipcode }" id="zipcode"
					name="zipcode" readonly>
					<button type="button" id="search">우편번호 찾기</button></td>
			</tr>
			<tr>
				<td>ADDRESS1</td>
				<td><input type=text value="${dto.address1 }" id="address1"
					name="address1" readonly></td>
			</tr>
			<tr>
				<td>ADDRESS2</td>
				<td><input type=text value="${dto.address2 }" id="address2"
					name="address2" readonly></td>
			</tr>

			<tr>
				<td colspan=2 align=center id="control">
					<button id="update" type="button">정보수정</button>
					<button id="back" type="button">돌아가기</button>
				</td>
			</tr>
		</table>
	</form>

	<script>
		//도로명주소 및 주소넣기
		document.getElementById("search").onclick = function() {
			new daum.Postcode({ //daum 변수는 위 script src library 안에 존재
				oncomplete : function(data) {
					var roadAddr = data.roadAddress; // 도로명주소 변수
					document.getElementById("zipcode").value = data.zonecode;
					document.getElementById("address1").value = roadAddr;
				}
			}).open();
		};

		$("#update").on("click", function() {
			$("input").removeAttr("readonly");
			$("#update,#back").css("display", "none");
			$("#search").css("display", "");
			let updateComplete = $("<button>");
			updateComplete.text("수정완료");

			let cancle = $("<button>");
			cancle.attr("type", "button");
			cancle.text("취소");

			cancle.on("click", function() {
				location.reload();
			})
			//reload 는 새로고침과 같은 기능

			$("#control").append(cancle);
			$("#control").prepend(updateComplete);

		})
		
		

		$("#form").on("submit", function() {

			let nameregex = /^[가-힣]{3}$/;
			let name = $("#name").val();

			let phoneregex = /^010\d{4}\d{4}$/;
			let phone = $("#phone").val();

			let emailregex = /.+@.+..+/;
			let email = $("#email").val();

			if (name == "" || phone == "" || email == "") {
				alert(`주소 외 빈칸을 채워주세요. 우측 상단 회원가입 조건을 확인해주세요`);
				return false;
			}

			if (!nameregex.test(name)) {
				alert(`이름을 정확히 입력해주세요.`);
				return false;
			}
			if (!phoneregex.test(phone)) {
				alert(`전화번호를 정확히 입력해주세요.`);
				return false;
			}
			if (!emailregex.test(email)) {
				alert(`이메일을 정확하게 입력해주세요.`);
				return false;
			}

		})

		$("#back").on("click", function() {
			location.href = "/";
		});
	</script>

</body>
</html>
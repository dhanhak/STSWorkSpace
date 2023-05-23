<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!-- 주소API -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
table {
	border-radius: 5px;
	margin: auto;
}

th {
	text-align: right;
	font-size: 20px;
}

input {
	width: 200px;
}

td {
	width: 200px;
	text-align: right;
}

button {
	background-color: rgb(50, 50, 50);
	color: white;
	border: 1px solid black;
	border-radius: 5px;
}

button:hover {
	background-color: pink;
	border-radius: 5px;
}

#idoverlapbtn {
	text-align: left;
}

#pwcheck {
	text-align: left;
}

#roadAddress {
	width: 400px;
}

#detailAddress {
	width: 400px;
}
</style>

</head>

<body>

	<form action="/member/join" method="post" id="frm">
		<table>
			<tr>
				<th></th>
				<th>회원가입 정보</th>
				<!--  th>
					<button type="button" id="list">회원가입 입력 조건</button>
				</th-->
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id" name="id"></td>
				<td id="idoverlapbtn">
					<button type="button" id="IdCheck">중복 확인</button>
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" id="pw1" name="pw"></td>
				<td></td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td><input type="password" id="pw2"></td>
				<td id="pwcheck"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name"></td>
				<td></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" id="phone" name="phone"></td>
				<td></td>
			</tr>
			<tr>
				<td>이메일 주소</td>
				<td><input type="text" id="email" name="email"></td>
				<td></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" id="postcode" placeholder="우편번호" name="zipcode"></td>
				<td style="text-align: left;"><input type="button" id="search"
					 value="우편번호 찾기" style="width: 100px;"></td>

			</tr>
			<tr>
				<td></td>
				<td colspan="2" style="text-align: left;"><input type="text"
					id="roadAddress" placeholder="주소1" name="address1"></td>

			</tr>
			<tr>
				<td></td>
				<td colspan="2" style="text-align: left;"><input type="text"
					id="detailAddress" placeholder="주소2" name="address2"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">회원 가입</button>
					<button type="reset" id="reset">다시 입력</button>
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
					document.getElementById("postcode").value = data.zonecode;
					document.getElementById("roadAddress").value = roadAddr;
				}
			}).open();
		};

		// 회원가입 눌렀을 때 해당 변수가 true 일때만 회원가입 가능
		var idValidFlag = false;

		// id 입력란에 타이핑이 되는 순간에 false - true 반환 후 입력방지
		$("#id").on("keyup", function() {
			inValidFlag = false;
		});

		//id 중복확인버튼 alert
	//	$("#idoverlap").on(
	//			"click",
	//			function() {
	//				window.open("/IdCheck.members?id=" + $("#id").val(), "",
	//						"width = 500, height = 300")
	//			});
		
		$("#IdCheck").on("click",function(){
			$.ajax({
				url : "/member/IdCheck",
				type : "post",
				data : {
					id : $("#id").val()
				},
				datatype : "json"
			}).done(function(resp){
				if(resp=="1"){
					alert("이미 사용중인 아이디입니다.")
					$("#id").val("");
				}else{
					if(confirm("사용가능ID, 사용하시겠습니까?")){
						idValidFlag= true;
					}else{
						$("#id").val("")
					}
				}
			})
		})

		//회원가입 입력조건 popup
		//$("#list").on("click", function() {
		//	window.open("/member/list.html", "", "width = 650, height = 350");
		//});

		//패스워드 일치 확인 기능
		$("#pw1").on("keyup", function(e) {
			if ($("#pw1").val() == $("#pw2").val()) {
				$("#pwcheck").html("패스워드 일치");
			} else {
				$("#pwcheck").html("패스워드 불일치");
			}
		});

		$("#pw2").on("keyup", function(e) {
			if ($("#pw1").val() == $("#pw2").val()) {
				$("#pwcheck").html("패스워드 일치");
			} else {
				$("#pwcheck").html("패스워드 불일치");
			}
		});

		$("#frm").on(
				"submit",
				function() {
					//입력란 유효성검사
					let idregex = /^[A-Z][a-z0-9A-Z]{5,12}$/;
					let id = $("#id").val();

					let pwregex = /^[A-Z][a-z0-9A-Z]{5,12}$/;
					let pw = $("#pw1").val();

					let nameregex = /^[가-힣]{3}$/;
					let name = $("#name").val();

					let phoneregex = /^010\d{4}\d{4}$/;
					let phone = $("#phone").val();

					let emailregex = /.+@.+..+/;
					let email = $("#email").val();

					let pw1 = $("#pw1").val();
					let pw2 = $("#pw2").val();

					if (id == "" || pw == "" || name == "" || phone == ""
							|| email == "") {
						alert(`주소 외 빈칸을 채워주세요. 우측 상단 회원가입 조건을 확인해주세요`);
						return false;
					}
					//pw 불일치 검사
					if (pw1 != pw2) {
						alert("패스워드 불일치");
						return false;
					}

					//조건검사 실행
					if (!idregex.test(id)) {
						alert(`아이디 조건을 확인해주세요.`);
						return false;
					}
					if (!pwregex.test(pw)) {
						alert(`패스워드 조건을 확인해주세요.`);
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
					// 회원가입 눌렀을 때 아이디 중복확인을 위해 idValicFlag가 true 일때만 가입 가능
					if (idValidFlag == false) {
						alert(`ID 중복확인을 진행해주세요.`);
						return false;
					}
					;

					return true;

				});
	</script>
</body>
</html>
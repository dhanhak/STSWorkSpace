<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STOMP Practice</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
<body>

	<input type="text" id="message" placeholder="서버로 전송할 메세지 입력">
	<button id="send">전송</button>

	<script type="text/javascript">
		const socket = new WebSocket("ws://192.168.50.56/chat");
		const stompClient = Stomp.over(socket);
		
		stompClient.connect({},function(){	// 첫번째 객체는 헤더정보 연걸에 적용할 설정 정보
											// 두번째 STOMP 연결에 성공했을 때 실행할 callback
			// subscribe 함수의 반환값은 구독정보 객체로 향후 구독 취소등에 사용될수 있으므로 변수로 보관.
			const subscription = stompClient.subscribe("/topic/test",function(message){
				console.log(message);
			});		//첫번째 구독할 채널의 이름 //두번째 채널에 접속했을 때 callback
			
		},function(error){
			console.log("연결 실패");			// 세번째 연결에 실패했을 때
			console.log(error);
		});
		
		document.getElementById("send").onclick = function(){
			let message = document.getElementById("message").value;
			const destination = "/app/message";
			const header = {};
			const body = JSON.stringify({name:"a",message:message}); // 실제로 서버에 보내고자 하는 데이터
			// JSON.stringify (객체를 문자로 바꿈) -> JSON.parse반대 
			stompClient.send(destination, header, body); 
		}
		
	</script>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
</head>
<style>
	*{
 		box-sizing: border-box;
	}
	div{
		border: 1px solid black;
		box-sizing: border-box;
		margin: auto;
	}
	.contents{
		width: 300px;
	}
	.body{
		height: 400px;
	}
	.footer{
		height: 50px;
	}
	.footer>input{
		width: 100%;
		height: 50px;
	}
</style>
<body>
	<script type="text/javascript">
		
		$(function(){
			const ws = new WebSocket("ws://192.168.50.56/chat");
			
			$('#chat').on('keyup', function(e){
				if(e.key=='Enter'){
					let message = $('#chat').val();
					ws.send(message);
					$('#chat').val("");
					$('#chat').focus();
				}
			});
			
			ws.onmessage = function(e){
				let body = $('.body').css("overflow","auto");
				body.append($('<div>').text(e.data).css("border","none"));
				$('.body').scrollTop($('.body')[0].scrollHeight);
			}
			
		});
		
	</script>

	<div class="contents">
		<div class="body"></div>
		<div class="footer">
			<input type="text" id="chat" placeholder="메세지를 입력하세요.">
		</div>
	</div>
	
</body>
</html>
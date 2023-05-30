<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>


   <style>
* {
   box-sizing: border-box;
}

.radius {
   border-radius: 50px;
}

.container {
   width: 350px;
   height: 500px;
   margin: auto;
   background-color: rgb(251, 215, 221)
}

.emoticon {
   height: 35%;
   width: 100%;
}

.emoticon>div {
   float: left;
   width: 25%;
   height: 100%;
}

.emoticon>div>img {
   width: 100%;
   height: 80%;
}

.submit {
   position: relative;
   top: 329px;
   width: 40px;
   height: 40px;
   text-align: center;
   font-size: 20px;
   color: rgb(250, 149, 166);
}

.message {
   position: relative;
   width: 85%;
   height: 85%;
   margin: auto;
   top: 40px;
   border-radius: 10px;
}

.message>div {
   width: 100%;
   border-radius: 10px;
}

.screen {
   height: 89%;
   background-color: #ffffff90;
   overflow: hidden;
}

.input {
   height: 11%;
   background-color: none;
}

.input>div {
   float: left;
}

.msg {
   position: relative;
   top: 15px;
   height: 80%;
   width: 82%;
   overflow: hidden;
   padding: 7px;
   outline: none;
   background-color: white;
   font-size: 14px;
}

.button {
   height: 100%;
   width: 18%;
   text-align: center;
}

.button>button {
   position: relative;
   top: 20px;
   width: 55%;
   height: 55%;
   background-color: white;
   border: 1px solid white;
}

.button>button:hover {
   cursor: pointer;
}

.item {
   overflow: hidden;
}

.item:hover {
   cursor: pointer;
}

.submit:hover {
   cursor: pointer;
}
</style>
<body>

<script type="text/javascript">
	
	$(function(){
		const ws = new WebSocket("ws://192.168.50.56/chat");
		
		$('.msg .radius').on('keyup', function(e){
			if(e.key == 'Enter'){
				e.preventDefault();
				let message = $('.msg .radius').text();
				ws.send(message);
				$('.msg .radius').text("");
				$('.msg .radius').focus();
			}
		});
		
		wd.onmessage = function(){
			let screen = $('.screen').css("overflow","auto");
			screen.append($('<div>').text(e.data).css("border","none"));
			$('.screen').scrollTop($('.screen')[0].scrollHeight);
		}
	});
	
</script>

   <div class="container radius">
      <div class="message">
         <div class="screen">
            <div class="submit">
               <i class="fa-solid fa-paper-plane"></i>
            </div>
         </div>
         <div class="input">
            <div class="msg radius" contenteditable="true"></div>
            <div class="button">
               <button class="radius" id="btn">
                  <i class="fa-solid fa-ellipsis"></i>
               </button>
            </div>
         </div>
      </div>
   </div>



</body>
</html>
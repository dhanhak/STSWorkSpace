<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Practice</title>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
</head>
<body>

	<fieldset>
		<legend>File Upload</legend>
		<form action="/file/upload" method="post" enctype="multipart/form-data">
			<input type="text" placeholder="메세지 입력" name=message> <br>
			<input type="file" value="첨부 파일" name="files" multiple="multiple"><br>
			<button>제출</button>
		</form>
	</fieldset>
	
	<fieldset>
		<legend>File List</legend>
		<button id="getFiles">파일 목록 불러오기</button>
		<div id="files"></div>
	</fieldset>
	
	<script type="text/javascript">
		$('#getFiles').on('click', function(){
			
			$.ajax({
				url:'/file/list'
			}).done(function(resp){
				for(let i = 0; i < resp.length; i++){	// (GSON pom.xml에 추가)  
					let anker = $('<a>');				//GSON에 의한 자동 직렬화 과정에서 resposne content-type필드에
					anker.attr('href','/file/download?sysName='+resp[i].sysName+'&oriName='+resp[i].oriName);				
					anker.text(resp[i].oriName);		// application/json이 적용 되며 ajax가 content-type 을 참조하여
														// 스스로 역직렬화 시키기 떄문에 수동 역직렬화 불필요. (type:JSON -> X)
					let line = $('<div>');
					line.append(anker);
					
					$('#files').append(line);
					
				}
				
			});
			
		});
	</script>

</body>
</html>
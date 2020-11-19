<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>댓글 목록</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>[댓글 목록]</h1>
	<div id="divInsert">
		<input type="text" id="txtReply" size="50">
		<input type="button" id="btnReply" value="">
	</div>
	<div id="divReply"></div>
		<script id="temp" type="text/x-handlebars-template">
			{{#each .}}
				<div rno="{{rno}}">
					[{{rno}}] {{reply}}
					<span>{{replyer}}</span>
					<span>{{replyDate}}</span>
					<button rno="{{rno}}">삭제</button>
				</div>
			{{/each}}
		</script>
</body>
<script>
	
	var page=1;
	var bno=320;
	getList();
	
	$("#divReply").on("click","button",function(){
		var rno = $(this).attr("rno");
		if(!confirm(rno + "을(를) 삭제하시겠습니까?")) return;
		$.ajax({
			type:"post",
			url:"/reply/delete",
			data:{"rno":rno},
			success:function(){
				getList();
			}
		});
	});
	
	$("#txtReply").keydown(function(key){
		if(key.keyCode==13){
			var reply = $("#txtReply").val();
			if(reply==""){ 
				alert("내용을 입력하세요");
				return;
			}
			if(!confirm("등록하시겠습니까?")) return;
			$.ajax({
				type:"post",
				url:"/reply/insert",
				data:{"bno":bno,"replyer":"user01","reply":reply},
				success:function(data){
					$("#txtReply").val("");
					getList();
				}
			});
		}
	});
	function getList(){
		$.ajax({
			type:"post",
			url:"/reply/list",
			data:{"page":page,"bno":bno},
			dataType:"json",
			success:function(data){
				var temp = Handlebars.compile($("#temp").html());
				$("#divReply").html(temp(data));
			}
		});
	}
</script>
</html>
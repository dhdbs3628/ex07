<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>게시판 목록</title>
		<style>
			a{text-decoration:none; color:green;}
			h2{margin: 0px auto; text-align:center; margin-bottom: 50px;}
			#tbl{margin: 0px auto; text-align:center;}
		</style>
	</head>
	<body>
		<h2>[게시판 목록]</h2>
		<a href = "insert">글쓰기</a>
		검색수 : ${pm.totalCount }
		<form action="list" name="fm">
		<input type = "text" name = "page" value="${pm.cri.page }">
			<select name="searchType">
				<option value="title" <c:out value="${pm.cri.searchType=='title'?'selected':'' }"/>>Title</option>
				<option value="content" <c:out value="${pm.cri.searchType=='content'?'selected':'' }"/>>Content</option>
				<option value="writer" <c:out value="${pm.cri.searchType=='writer'?'selected':'' }"/>>Writer</option>
			</select>
			<input type="text" name="keyword" value="${pm.cri.keyword }">
			<input type="submit" value="검색">
		</form>
		
		<table border = 1 id="tbl">
			<tr>
				<td width = 50>No.</td>
				<td width = 100>Title</td>
				<td width = 50>Writer</td>
				<td width = 200>Content</td>
				<td width = 100>Date</td>
			</tr>
			<c:forEach items = "${list }" var="vo">
			<tr>
				<td>${vo.rn }</td>
				<td><a href="read?bno=${vo.rn}">${vo.title }</a></td>
				<td>${vo.writer }</td>
				<td>${vo.content }</td>
				<td><fmt:formatDate value ="${vo.regdate }" pattern = "yyyy-MM-dd hh:mm:ss"/></td>
			</tr>
			</c:forEach>
		</table>
		<div id = "pagination">
			<c:if test = "${pm.prev }">
				<a href="${pm.startPage-1 }">←</a>
			</c:if>
			<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
				<c:if test="${pm.cri.page==i }">
					[<a href="${i }" class="active">${i }</a>]
				</c:if>
				<c:if test="${pm.cri.page!=i }">
					[<a href="${i }">${i }</a>]
				</c:if>
			</c:forEach>
			<c:if test = "${pm.next }">
				<a href="${pm.endPage+1 }">▶</a>
			</c:if>
		</div>
	</body>
	<script>
		$("#pagination a").click(function(e){
			e.preventDefault();
			$(fm.page).val($(this).attr("href"));
			fm.submit();
		});
	</script>
</html>
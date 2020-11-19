<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>통장목록</title>
</head>
<body>
	<h1>[통장 목록]</h1>
	<table border=1>
		<tr>
			<td width=100>계좌번호</td>
			<td width=100>성명</td>
			<td width=200>계좌개설일</td>
			<td width=200>잔액</td>
			<td width=80>통장 내역</td>
		</tr>
		<c:forEach items="#{list}" var="vo">
		<tr>
			<td width=100>${vo.ano }</td>
			<td width=100>${vo.name }</td>
			<td width=200><fmt:formatDate value="${vo.openDate }" pattern="yyyy-MM-dd HH:mm"/></td>
			<td width=100><fmt:formatNumber value="${vo.balance }" pattern="#,###"/></td>
			<td width=80><button onClick="location.href='read?ano=${vo.ano}'">통장 내역</button></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
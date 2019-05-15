<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.cafe24.mysite1.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
			<h1>MySite</h1>
			<ul>
		<c:choose>
		<c:when test='${empty authUser}'>
			<li><a href="${pageContext.servletContext.contextPath}/user?a=Loginform">로그인</a><li>
			<li><a href="${pageContext.servletContext.contextPath}/user?a=Joinform">회원가입</a><li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.servletContext.contextPath}/user?a=Updateform">회원정보수정</a><li>
				<li><a href="${pageContext.servletContext.contextPath}/user?a=Logoutform">로그아웃</a><li>
				<li>${authUser.name}님 안녕하세요 ^^;</li>
		</c:otherwise>
		</c:choose>
			</ul>
</div>
</body>
</html>
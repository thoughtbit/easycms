<%@ include file="/WEB-INF/template/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title><sitemesh:write property='title'/></title>
		<meta name="description" content="<tiles:insertAttribute name="page_description" ignore="true"/>">
		<link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet" type="text/css"/>
		<link rel="shortcut icon" href="<c:url value="/assets/images/favicon.ico"/>" type="image/x-icon" />			
		<sitemesh:write property='head'/>
	</head>
    <body>  
		<sitemesh:write property='body'/>
	</body>
</html>

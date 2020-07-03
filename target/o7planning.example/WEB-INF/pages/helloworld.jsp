<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC -HelloWorld</title>
</head>
 
 
<body>

    <c:forEach var="a1" items="${greeting}">
    	<h1>"${a1}"</h1>
    </c:forEach>
    
    <h1>${greeting}</h1>
    
     ${truyen.TENTACGIA}
     ${cttruyen.NOIDUNG}
     <a href="date">DAte</a>
</body>
 
 
</html>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
	<base href = "${pageContext.servletContext.contextPath}/">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="description" content="">
	  <meta name="author" content="">
    
    <!-- Bootstrap core CSS -->
  <link href="startbootstrap-shop-item-gh-pages/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="startbootstrap-shop-item-gh-pages/css/shop-item.css" rel="stylesheet">
    
    <title>ADMIN</title>

   
     
</head>
<body>
<%@ include file="header.jsp" %>

                        <h2 class="form-title">LOG IN</h2>
                        <form:form action="admin2" modelAttribute="acc" METHOD="POST">
                        	<form:errors path="*" element="ul"/>
                            <div class="wrap-input100 rs1 validate-input" data-validate="Username is required">
								<label>Nhập userName:</label>
								<form:input path="username" type="text"/>
							</div>
							<div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
								<label>Password:</label>
								<form:input path="password" type="password"/>
							</div>
							<div class="wrap-input100 rs1 validate-input" data-validate="Method is required">
								<label>Nhập METHOD:</label>
								<form:input path="method" type="text"/>
							</div>
							<div class="wrap-input100 rs1 validate-input" data-validate="Query is required">
								<label>Nhập Query:</label>
								<form:input path="query" type="text"/>
							</div>
                            <div class="form-group form-button">
                                <button class = "btn btn-default">EXCUTE</button>
                            </div>
                        </form:form>
                      

    <%@ include file="footer.jsp" %>

    
    
    <!-- Bootstrap core JavaScript -->
  <script src="startbootstrap-shop-item-gh-pages/vendor/jquery/jquery.min.js"></script>
  <script src="startbootstrap-shop-item-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
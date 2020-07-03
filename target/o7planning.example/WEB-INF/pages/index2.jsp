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
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Comic</title>

  <!-- Bootstrap core CSS -->
  <link href="startbootstrap-shop-item-gh-pages/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="startbootstrap-shop-item-gh-pages/css/shop-item.css" rel="stylesheet">

</head>

<body>
<%@ include file="header.jsp" %>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">Comic</h1>
		<form  action="search" method="GET">
			<div>
				<label>Tìm truyện:</label>
	            <input name="search"/>
			</div>
			<div>
				<button class = "btn btn-default">Tìm kiếm</button>
			</div>
		</form>
      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
		
        <div class="row">
		<c:forEach var="u" items="${dstruyen}">
			
	           <div class="col-lg-4 col-md-6 mb-4">
	            <div class="card h-100">
	              <a href="list/${u.MATRUYEN}.htm">
	              	
	              <img class="card-img-top" src="img/${u.HINH}" alt="">
	              
	              </a>
	              <div class="card-body">
	                <h4 class="card-title">
	                  <a href="list/${u.MATRUYEN}.htm">${u.TENTRUYEN}</a>
	                </h4>
	              </div>

	            </div>
	          </div>
	          
          </c:forEach>
          
        </div>
         
        <!-- /.row -->
	
      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
<%@ include file="footer.jsp" %>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="startbootstrap-shop-item-gh-pages/vendor/jquery/jquery.min.js"></script>
  <script src="startbootstrap-shop-item-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>

<%-- 
    Document   : whoAreYou
    Created on : Jul 19, 2023, 11:30:32 PM
    Author     : Neuu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Who are you</title>
        <%@include file="component/allCss.jsp"%>
         <style>
    body, html {
      height: 100%;
    }

    .container {
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .custom-card {
      text-align: center;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .btn-primary {
      font-size: 24px;
      padding: 20px 40px;
      margin: 10px;
    }
  </style>
</head>
<body>
     <%@include file="component/navBar.jsp" %>
  <div class="container">
    <div class="custom-card">
      <h1>Are You?</h1><br> <br>
      <a href="ownerRegisterPage.jsp" class="btn btn-primary btn-lg">Owner</a> <br> <br>
      <a href="customerRegisterPage.jsp" class="btn btn-primary btn-lg">Customer</a> <br> <br>
      <a href="adminRegisterPage.jsp" class="btn btn-primary btn-lg">Admin</a> <br> <br>
    </div>
  </div>
</body>
</html>
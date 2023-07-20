<%-- 
    Document   : customerRegisterPage
    Created on : Jul 19, 2023, 11:18:25 PM
    Author     : Neuu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer-Register</title>
        <%@include file="component/allCss.jsp"%>

        <style>
            body, html {
                height: 100%;
            }

            .container {
                width: 800px;
                height: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .card {
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            .card-header {
                background-color: #007BFF;
                color: #fff;
                border-radius: 10px 10px 0 0;
            }

            .card-body {
                padding: 20px;
            }

            .btn-primary {
                background-color: #007BFF;
                border-color: #007BFF;
            }

            .btn-primary:hover {
                background-color: #0056b3;
                border-color: #0056b3;
            }
            
            .errorMsg{
                display: flex;
                justify-content: center;
                font-size: 20px;
                color: red;
                font-family: monospace;
            }

        </style>
    </head>
    <body>
        <%@include file="component/navBar.jsp" %>
        <div class="container">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h2 class="mb-0">Customer Registration</h2>
                    </div>
                    <div class="card-body">
                        <form action="customerRegMap" method="post">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="firstName">First Name:</label>
                                    <input type="text" class="form-control" id="cFname" name="cFname" required>
                                </div>
                                <div class="form-group ">
                                    <label for="lastName">Last Name:</label>
                                    <input type="text" class="form-control" id="cLname" name="cLname" required>
                                </div>
                            </div>
                            <div class="form-group  ">
                                <label for="phoneNumber">Phone Number:</label>
                                <input type="tel" class="form-control" id="cPhoneNumber" name="cPhoneNumber" required>
                            </div>
                            <div class="form-group ">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="cEmail" name="cEmail" required>
                            </div>

                            <div class="form-row">
                                <div class="form-group">
                                    <label for="city">City:</label>
                                    <input type="text" class="form-control" id="cCity" name="cCity" required>
                                </div>
                                <div class="form-group ">
                                    <label for="state">State:</label>
                                    <input type="text" class="form-control" id="cState" name="cState" required>
                                </div>

                            </div>
                            <div class="form-group ">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="cPass" name="cPass" required>
                            </div>
                            <div class="form-group ">
                                <label for="confirmPass">Confirm Password:</label>
                                <input type="password" class="form-control" id="confirmPass" name="confirmPass" required>
                            </div>
                            <div class="errorMsg">
                                <%
                                    if (request.getMethod().equalsIgnoreCase("post")) {
                                        out.write((String) request.getAttribute("errorMessage"));
                                    }
                                %>
                            </div><br> 
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
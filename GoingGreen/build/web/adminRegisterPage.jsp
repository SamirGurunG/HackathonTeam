<%-- 
    Document   : adminRegisterPage
    Created on : Jul 19, 2023, 11:18:09 PM
    Author     : Neuu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Registration Page</title>
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
           
        </style>
    </head>
    <body>
        <%@include file="component/navBar.jsp" %>
        <div class="container">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h2 class="mb-0">Admin Registration</h2>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="firstName">First Name:</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" required>
                                </div>
                                <div class="form-group ">
                                    <label for="lastName">Last Name:</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" required>
                                </div>
                            </div>
                            <div class="form-group  ">
                                <label for="phoneNumber">Phone Number:</label>
                                <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" required>
                            </div>
                            <div class="form-group ">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group ">
                                <label for="companyName">Company Name:</label>
                                <input type="text" class="form-control" id="companyName" name="companyName" required>
                            </div>
                            <div class="form-group ">
                                <label for="street">Street:</label>
                                <input type="text" class="form-control" id="street" name="street" required>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="city">City:</label>
                                    <input type="text" class="form-control" id="city" name="city" required>
                                </div>
                                <div class="form-group ">
                                    <label for="state">State:</label>
                                    <input type="text" class="form-control" id="state" name="state" required>
                                </div>
                                <div class="form-group ">
                                    <label for="panNumber">Pan Number:</label>
                                    <input type="text" class="form-control" id="panNumber" name="panNumber" required>
                                </div>
                            </div>
                            <div class="form-group ">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
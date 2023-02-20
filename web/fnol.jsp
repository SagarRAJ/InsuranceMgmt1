<%-- 
    Document   : fnol
    Created on : 17-Feb-2023, 1:52:57 pm
    Author     : Win10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FNOL PAGE</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <meta name="theme-color" content="#712cf9">
        <link href="css/signin.css" rel="stylesheet">
    </head>
    <body>
        <main class="form-signin w-100 m-auto">
            <form action="Fnol" id="signupForm">
                <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please provide below information</h1>

                <div class="form-floating">
                    <input type="email" class="form-control" name="emailAddress"  id="floatingInput" placeholder="name@example.com" value="${EmailAddress}" readonly>
                    <label for="floatingInput">Email address</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="firstName" placeholder="first name"  name="policyNumber">
                    <label for="firstName">Policy Number</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="lastName" placeholder="last name"  name="description">
                    <label for="firstName">Description</label>
                </div>
                    <div class="form-floating">
                    <input type="text" class="form-control" id="lastName" placeholder="last name"  name="vehicleNumber">
                    <label for="firstName">Vehicle Number</label>
                </div>


















                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Register</button>
                <a href="landingPage.jsp">
                    <button type="button" class="w-100 btn btn-lg btn-warning">Cancel</button>
                </a>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>
    </body>
</html>

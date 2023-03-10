<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">
        <title>Sign up - Employee Management</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <meta name="theme-color" content="#712cf9">


        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.3.js" 
                integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                crossorigin="anonymous">

        </script>

    </head>





    <body class="text-center">
       



        <main class="form-signin w-100 m-auto">
            <form action="Signup" id="signupForm" method="post">
                <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please provide below information</h1>

                <div class="form-floating">
                    <input type="email" class="form-control" name="emailAddress"  id="floatingInput" placeholder="name@example.com" value="${User.getEmail()}" >
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" value="${User.getPassword()}" name="password">
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="firstName" placeholder="first name" value="${User.getFirstname()}" name="firstName">
                    <label for="firstName">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="lastName" placeholder="last name" value="${User.getLastName()}" name="lastName">
                    <label for="firstName">Last Name</label>
                </div>
                     <div class="form-floating">
                    <input type="text" class="form-control" name="address"  id="floatingInput" placeholder="name@example.com" value="${User.getEmail()}" >
                    <label for="floatingInput">Address</label>
                </div>
                     <div class="form-floating">
                    <select name="roleId" class="form-select" id="roleId">
                                    <option value="">Select a Role Name</option>

                                    <c:forEach items="${RoleList}" var="role">
                                    <option value="${role.getRoleId()}"> ${role.roleName} </option>
                                    </c:forEach>
                                    
                                </select>
                </div>
               



               
              







                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button>
                <a href="landingPage.jsp">
                    <button type="button" class="w-100 btn btn-lg btn-warning">Cancel</button>
                </a>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>



    </body>
</html>

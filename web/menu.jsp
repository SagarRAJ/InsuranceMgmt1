<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Insurance Management</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta name="theme-color" content="#712cf9">

        <!-- Custom styles for this template -->
        <link href="css/header.css" rel="stylesheet">
        <!--<link href="css/carousel.css" rel="stylesheet">-->
    </head>
    <header class="p-3 text-bg-dark">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <img src="images/flower-logo.jpg" width="75" height="75"></img>
                </a>

                <c:if test="${User.roleId=='1'}">
                     <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="Prefnol?emailAddress=${User.emailAddress}" class="nav-link px-2 text-secondary">Log FNOL</a></li>
                    <li><a href="Previousclaim?emailAddress=${User.emailAddress}" class="nav-link px-2 text-secondary">previous claim</a></li>
                    <li><a href="#" class="nav-link px-2 text-secondary">claim status</a></li>
                    <li><a href="#" class="nav-link px-2 text-secondary">contact us</a></li>
                </ul>
                </c:if>
                <c:if test="${User.roleId=='2'}">
                     <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="Viewlogedfnol" class="nav-link px-2 text-secondary">view Loged FNOL</a></li>
                    <li><a href="#" class="nav-link px-2 text-secondary">claim verification</a></li>
                    <li><a href="#" class="nav-link px-2 text-secondary">policy verification(Insurance Master)</a></li>
                    <li><a href="#" class="nav-link px-2 text-secondary">DMV verification</a></li>
                </ul>
                </c:if>
                <c:if test="${User.roleId=='3'}">
                     <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="Viewlogedfnolofficer" class="nav-link px-2 text-secondary">View Loged FNOL</a></li>
                    <li><a href="#" class="nav-link px-2 text-secondary">claim verification</a></li>
                    <li><a href="#" class="nav-link px-2 text-secondary">policy verification(Insurance Master)</a></li>
                    <li><a href="#" class="nav-link px-2 text-secondary">DMV verification</a></li>
                </ul>
                </c:if>

                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                    <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
                </form>

                <div class="text-end">

                    <c:if test="${Loggedin==null}">
                        <a href="login.jsp">
                            <button type="button" class="btn btn-outline-light me-2" >Login</button>
                        </a>
                        <a href="Presignup">
                            <button type="button" class="btn btn-warning">Sign-up</button>
                        </a>
                    </c:if>

                    <c:if test="${Loggedin!=null}">
                    <a href="Logout">
                    <button type="button" class="btn btn-outline-light me-2" >Log Out</button>
                    </a>
                    </c:if>





                </div>
            </div>
        </div>
    </header>
<%-- 
    Document   : viewfnol
    Created on : 19-Feb-2023, 12:40:34 am
    Author     : Win10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/self.css" rel="stylesheet">
        
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
    <body>
         <script>
                function getPolicy() {
                    var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            
                            var data = JSON.parse(this.responseText);
                            var result1 = "";
                            
                               result1 += "<p style='font-size: 16px; line-height: 1.5;'><span class='policy-number-heading'>Email Address:</span> " + data.emailAddress + "</p>";
                               result1 += "<p style='font-size: 16px; line-height: 1.5;'><span class='policy-number-heading'>Policy Number:</span> " + data.policyNumber + "</p>";
                               result1 += "<p style='font-size: 16px; line-height: 1.5;'><span class='policy-number-heading'>Vehicle Number:</span> " + data.vehicleNumber + "</p>";
                            
                            document.getElementById("result").innerHTML = result1;
                        }
                    };
                    xhttp.open("GET", "https://mocki.io/v1/3b14a1bf-47e6-470d-9be3-98e791c2ec1f", true);
                    xhttp.send();
                }
                function getDmv() {
                    var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                              var data = JSON.parse(this.responseText);
                            var result1 = "";
                            
                               result1 += "<p style='font-size: 16px; line-height: 1.5;'><span class='policy-number-heading'>Email Address:</span> " + data.emailAddress + "</p>";
                               result1 += "<p style='font-size: 16px; line-height: 1.5;'><span class='policy-number-heading'>Vehicle Number:</span> " + data.vehicleNumber + "</p>";
                            
                            document.getElementById("result1").innerHTML = result1;
                        }
                    };
                    xhttp.open("GET", "https://mocki.io/v1/fec5f0ce-2f89-4193-acc7-1d47c1889037", true);
                    xhttp.send();
                }
            </script>
        <div class="bootstrap-table bootstrap5">
                <div class="fixed-table-toolbar"><div class="bs-bars float-left">

                    </div><div class="columns columns-right btn-group float-right"><div class="keep-open btn-group" title="Columns">
                            <div class="dropdown-menu dropdown-menu-right" style=""><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="id" value="0" checked="checked"> <span>ID</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="name" value="1" checked="checked"> <span>Item Name</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="price" value="2" checked="checked"> <span>Item Price</span></label></div></div></div></div>

                <div class="table-responsive" style="height: 542px; padding-bottom: 50.5px;">

                    <div class="scrollable-table-container">
                        <table id="table" data-height="400" data-virtual-scroll="true" class="table table-bordered table-hover" style="margin-top: -9.5px;">
                            <thead>
                            <c:choose>
                                <c:when test = "${requestScope.noData != null}">
                                    <tr>
                                        <td colspan="5">
                                            <h2 style="border:2px solid rgb(255, 99, 71); background-color:rgba(255, 99, 71, 0.5); font-size:15px;">
                                                <c:out value="${requestScope.noData}"> </c:out>
                                                </h2>
                                            </td>
                                        </tr>
                                </c:when>
                            </c:choose>
                            <tr>
                                <th scope="col">
                                    Claim Number
                                </th>
                                <th scope="col">
                                    Email Address
                                </th>
                                <th scope="col">
                                    Policy Number
                                </th>
                                <th scope="col">
                                    Description
                                </th>
                                <th scope="col">
                                    Vehicle Number
                                </th>
                                <th scope="col">
                                    Status by UnderWriter
                                </th>
                                <th scope="col">
                                    Status by InsuranceOfficer
                                </th>
                                
                                

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${FnolList}" var="fnol">
                                <tr>
                                    <td>
                                        ${fnol.getClaimNumber()}
                                    </td>
                                    <td>
                                        ${fnol.getEmailAddress()}
                                    </td>
                                    <td>
                                        ${fnol.getPolicyNumber()}
                                    </td>
                                    <td>
                                        ${fnol.getDescription()}
                                    </td>
                                    <td>
                                        ${fnol.getVehicleNumber()}
                                    </td>
                                    <td>
                                        ${fnol.getApprovalByUnderWriterMessage()}
                                    </td>
                                    <c:if test="${!(fnol.getApprovalByUnderWriterMessage()).equals('rejected')}">
                                         <td>
                                        ${fnol.getApprovalByInsuranceOfficerMessage()}
                                    </td>
                                    </c:if>
                                    
                                   
                                    
                                </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    <div class="fixed-table-footer" style="display: none;"></div>
                </div>
                <div class="fixed-table-pagination" style="display: none;"></div>
            </div>
    </body>
</html>

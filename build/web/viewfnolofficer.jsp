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
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
    <body>
        <div class="bootstrap-table bootstrap5">
                <div class="fixed-table-toolbar"><div class="bs-bars float-left">

                    </div><div class="columns columns-right btn-group float-right"><div class="keep-open btn-group" title="Columns">
                            <div class="dropdown-menu dropdown-menu-right" style=""><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="id" value="0" checked="checked"> <span>ID</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="name" value="1" checked="checked"> <span>Item Name</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="price" value="2" checked="checked"> <span>Item Price</span></label></div></div></div></div>

                <div class="table-responsive" style="height: 542px; padding-bottom: 50.5px;">

                    <div class="fixed-table-body">
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
                                
                                <th scope="col">
                                    Action
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
                                     <td>
                                        ${fnol.getApprovalByInsuranceOfficerMessage()}
                                    </td>
                                    <td> 
                                        <c:if test="${(fnol.getApprovalByUnderWriterMessage()).equals('approved')}">
                                            <a href='Verifyio?claimNumber=${fnol.getClaimNumber()}&emailAddress=${fnol.getEmailAddress()}&policyNumber=${fnol.getPolicyNumber()}&vehicleNumber=${fnol.getVehicleNumber()}&description=${fnol.getDescription()}'>
                                            <button class="btn-dark">Verify</button>
                                        </a>
                                        </c:if>

                                        
                                            

                                    </td>
                                    
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

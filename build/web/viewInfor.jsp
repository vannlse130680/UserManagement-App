<%-- 
    Document   : viewInfor
    Created on : Nov 15, 2019, 3:34:35 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Information Page</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USER} <br>
        <a href="DispatchServlet?btAction=Logout">Logout</a>
        </font>
        <c:if test="${empty sessionScope.USER}">
            <jsp:forward page="login.html"></jsp:forward>
        </c:if>
        
        <h1>View Information</h1>


        <c:set var="result" value="${requestScope.LOADRESULT}"/>
        <table border="1">
            <thead>
                <tr>
                    <th>Photo</th>
                    <th>UserID</th>
                    <th>Full Name</th>
                    <th>Email</th>

                    <th>Phone</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${result}">
                    <tr>
                        <td>
                            <img src="${dto.photo}" width="100px" height="100px"/>

                        </td>
                        <td>${dto.userName}</td>
                        <td>${dto.fullName}</td>
                        <td>${dto.email}</td>

                        <td>${dto.phone}</td>
                        <td>${requestScope.ROLENAME}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>

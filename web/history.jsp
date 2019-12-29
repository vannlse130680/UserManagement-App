<%-- 
    Document   : history
    Created on : Nov 19, 2019, 7:26:07 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
    </head>
    <body>
        <c:if test="${empty sessionScope.USER}">
            <jsp:forward page="login.html"></jsp:forward>
        </c:if>
        <font color="red">
        Welcome, ${sessionScope.USER} <br>
        <a href="DispatchServlet?btAction=Logout">Logout</a>
        </font>
        <h1>Promotion History</h1>
        
        <c:set var="history" value="${requestScope.HISTORY}"/>
        <c:if test="${not empty history}">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO.</th>
                        <th>UserID</th>
                        <th>Rank</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody> 
                    <c:forEach var="h" items="${history}" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${h.userName}</td>
                        <td>${h.rank}</td>
                        <td>${h.date}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="DispatchServlet?btAction=Search">Back to search page ...</a>
        </c:if>
    </body>
</html>

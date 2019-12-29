<%-- 
    Document   : promotionList
    Created on : Nov 19, 2019, 8:14:55 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promotion List</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USER} <br>
        <a href="DispatchServlet?btAction=Logout">Logout</a>
        </font>
        <h1>Promotion List</h1>
        <c:if test="${empty sessionScope.USER}">
            <jsp:forward page="login.html"></jsp:forward>
        </c:if>
        
        <c:set var="session" value="${pageContext.session}"/>
        <c:if test="${not empty session}">
            <c:set var="promotion" value="${sessionScope.PROMOTION}"/>
            <c:if test="${not empty promotion}">
                <c:set var="promotionList" value="${promotion.promotionList}"/>
                <c:if test="${not empty promotionList}">

                    <table border="1">
                        <thead>
                            <tr>
                                <th>NO.</th>
                                <th>UserID</th>
                                <th>Full Name</th>
                                <th>Rank</th>
                                <th>Update</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <tbody>

                            <c:forEach var="user" items="${promotionList.entrySet()}" varStatus="counter">
                            <form action="DispatchServlet">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${user.key}
                                        <input type="hidden" name="userName" value="${user.key}" />
                                    </td>
                                    <td>
                                        ${user.value.fullName}
                                    </td>
                                    <td>
                                        <select name="rank">
                                            <c:forEach begin="1" end="10" step="1" var="r">
                                                <c:choose>
                                                    <c:when test="${user.value.rank == r}">
                                                        <option selected value="${r}">${r}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${r}">${r}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>

                                        </select> 

                                    </td>
                                    <td>
                                        <input type="submit" value="Remove" name="btAction" />

                                    </td>
                                    <td>
                                        <input type="submit" value="Update Rank" name="btAction" />

                                    </td>
                                </tr>
                            </form>

                        </c:forEach>


                    </tbody>

                </table>

                <a href="DispatchServlet?btAction=Search">Add more user to promotion List</a>



                <form action="DispatchServlet">
                    <input type="submit" value="Confirm" name="btAction" />
                </form>


            </c:if>
        </c:if>
    </c:if>
    <c:if test="${empty promotionList}">
        <h2>No user is existed!!!!</h2>
        <a href="DispatchServlet?btAction=Search">Add more user to promotion List</a>
    </c:if>
</body>
</html>

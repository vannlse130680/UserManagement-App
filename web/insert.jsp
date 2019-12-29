<%-- 
    Document   : insert
    Created on : Nov 18, 2019, 4:32:38 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USER} <br>
        <a href="DispatchServlet?btAction=Logout">Logout</a>
        </font>
        <c:if test="${empty sessionScope.USER}">
            <jsp:forward page="login.html"></jsp:forward>
        </c:if>
        
        <h1>Create A New Account</h1>
        <c:set var="listRole" value="${requestScope.LISTROLE}"/>
        <form action="DispatchServlet" method="POST">
            <c:set var="error" value="${requestScope.INSERTERRORS}"/>
            UserID <input type="text" name="userName" value="${param.userName}" /> 
            <c:if test="${not empty error.userName}">
                <font color="red">
                ${error.userName} 
                </font>
            </c:if>
            <br>
            Password <input type="password" name="password" value="" />
            <c:if test="${not empty error.password}">
                <font color="red">
                ${error.password} 
                </font>
            </c:if>
            <br>
            Confirm Password <input type="password" name="conPassword" value="" />
            <c:if test="${not empty error.notMactchPassword}">
                <font color="red">
                ${error.notMactchPassword} 
                </font>
            </c:if>
            <br>
            Full Name: <input type="text" name="fullName" value="${param.fullName}" />
            <c:if test="${not empty error.fullName}">
                <font color="red">
                ${error.fullName} 
                </font>
            </c:if>
            <br>
            Email <input type="text" name="email" value="${param.email}" /> 
            <c:if test="${not empty error.email}">
                <font color="red">
                ${error.email} 
                </font>
            </c:if>
            <br>
            Phone <input type="text" name="phone" value="${param.phone}" /> 
            <c:if test="${not empty error.phone}">
                <font color="red">
                ${error.phone} 
                </font>
            </c:if><br>
            Role <select name="roleName"> 
                <c:forEach var="roleName" items="${listRole}">
                    <c:choose>
                        <c:when test="${param.roleName == roleName.roleName}">
                            <option selected value="${roleName.roleId}">${roleName.roleName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${roleName.roleId}">${roleName.roleName}</option>
                        </c:otherwise>
                    </c:choose>


                </c:forEach>
            </select> </br>
            <img src="" width="100px" height="100px" alt="No image" id="img${counter.count}"/> <br>

            File <input type="file"  value="" id="file${counter.count}"/>

            <c:if test="${not empty error.photo}">
                <font color="red">
                ${error.photo} <br>
                </font>
            </c:if>

            <br>

            <script>
                window.addEventListener('load', function () {
                    document.getElementById('file${counter.count}').addEventListener('change', function () {
                        if (this.files && this.files[0]) {
                            var img = document.getElementById('img${counter.count}');
                            var source = document.getElementById('source${counter.count}');
                            var file = document.getElementById('file${counter.count}');
                            source.setAttribute('value', file.value);
                            img.src = file.value;
                        }
                    });
                });
            </script>
            <input type="hidden" name="source" value="" id="source${counter.count}" />

            <input type="submit" value="Create Account" name="btAction" />
            <input type="submit" value="Cancel" name="btAction" />
        </form>
    </body>
</html>

<%-- 
    Document   : adSearch
    Created on : Nov 13, 2019, 11:04:56 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body onload="myFunction()">
        <font color="red">
        Welcome, ${sessionScope.USER} <br>

        <a href="DispatchServlet?btAction=Logout">Logout</a>

        </font>
        <c:if test="${empty sessionScope.USER}">
            <jsp:forward page="login.html"></jsp:forward>
        </c:if>

        <h1>Search Page</h1>
        <a href="DispatchServlet?btAction=Insert">Create A New Account </a> <br>
        <a href="promotionList.jsp">View Promotion List </a> <br>
        <a href="DispatchServlet?btAction=History">View Promotion History</a>
        <form action="DispatchServlet">
            <input type="text" name="searchValue" value="${param.searchValue}" />
            <input type="submit" value="Search" name="btAction" />
        </form>
            <br>

        <c:set var="searchValue" value="${param.searchValue}"/>

        <c:set var="result" value="${requestScope.SEARCHRESULT}"/>

        <c:set var="listRole" value="${requestScope.LISTROLE}"/>
        <a href="DispatchServlet?btAction=Search&searchValue=${searchValue}">All</a>
        <c:forEach var="roleDto" items="${listRole}">

          &emsp;  <a href="DispatchServlet?btAction=Search&roleId=${roleDto.roleId}&searchValue=${searchValue}">${roleDto.roleName}</a> &emsp;
          
        </c:forEach>
         
        <c:if test="${not empty result}">


            <table border="1">
                <thead>
                    <tr>
                        <th>NO.</th>
                        <th>Photo</th>
                        <th>UserID</th>
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Role ID</th>
                        <th>Delete</th>
                        <th>Update</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="userDto" items="${result}" varStatus="counter">
                    <form action="DispatchServlet">
                        <tr>
                            <td>
                                ${counter.count}

                            </td>
                            <td>
                                <img src="${userDto.photo}" width="100px" height="100px"/>

                            </td>
                            <td>
                                ${userDto.userName}

                            </td>
                            <td>
                                ${userDto.fullName}
                                <input type="hidden" name="fullName" value="${userDto.fullName}" />
                            </td>
                            <td>
                                ${userDto.email}

                            </td>
                            <td>
                                ${userDto.phone}

                            </td>
                            <td>
                                ${userDto.role}

                            </td>
                            <td>
                                <input type="hidden" name="roleId" value="${param.roleId}" />
                                <input type="hidden" name="searchValue" value="${searchValue}" />
                                <input type="hidden" name="userName" value="${userDto.userName}" />
                                <input type="submit" value="Delete" name="btAction" />

                               
                                <input type="hidden" name="email" value="${userDto.email}" />
                                <input type="hidden" name="phone" value="${userDto.phone}" />
                            </td>
                            <td>
                                <input type="hidden" name="photo" value="${userDto.photo}" />
                                <input type="hidden" name="id" value="${userDto.role}" />
                                <input type="submit" value="Update" name="btAction" />
                            </td>

                            <td>
                                
                                <input type="submit" value="Add To Promotion List" name="btAction" />
                            </td>
                        </tr>
                    </form>

                </c:forEach>

            </tbody>
        </table>    

    </c:if>
    <c:set var="addError" value="${requestScope.ADDERROR}"/>
    <c:set var="updateAdmin" value="${requestScope.UPDATEADMIN}"/>
    <c:set var="deleteAdmin" value="${requestScope.DELETEADMIN}"/>
    <script>
        function myFunction() {
        <c:if test="${not empty addError}">
            alert("${addError}");
        </c:if>
        <c:if test="${not empty updateAdmin}">
            alert("${updateAdmin}");
        </c:if>
        <c:if test="${not empty deleteAdmin}">
            alert("${deleteAdmin}");
        </c:if>
        }

    </script>

    <c:if test="${empty result}">
        <h2>No record is match</h2>
    </c:if>

</body>
</html>

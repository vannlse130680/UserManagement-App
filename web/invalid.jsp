<%-- 
    Document   : invalid
    Created on : Nov 12, 2019, 10:12:06 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        
        <form method="POST" action="DispatchServlet">
            UserID: <input type="text" name="username" value="" /> <br>
            Password: <input type="password" name="password" value="" /> <br>
            <font color="red">
            invalid userid or password !!!1<br>
            </font>
            <input type="submit" value="Login" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>

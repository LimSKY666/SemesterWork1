<%@ page contentType="text/html;UTF-8" %>
<html lang="en">
<head>
    <title>Main Page</title>
</head>
<body>

<%
    String sessionUser = (String) session.getAttribute("login");
    if (sessionUser == null) {
        response.sendRedirect("login.html");
    }
    String userLogin = null;
    String userFirstName = null;
    String userSecondName = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c: cookies) {
            if ("firstName".equals(c.getName())) userFirstName = c.getValue();
            if ("lastName".equals(c.getName())) userSecondName = c.getValue();
            if ("login".equals(c.getName())) userLogin = c.getValue();
            if ("JSESSIONID".equals(c.getName())) sessionId = c.getValue();
        }
    } else {
        sessionId = session.getId();
    }
%>

<h1>
    Profile
    <br>
</h1>

<h3>
    Login: <%=userLogin%>
    <br>
    First Name: <%=userFirstName%>
    <br>
    Second Name: <%=userSecondName%>
</h3>

</body>
</html>
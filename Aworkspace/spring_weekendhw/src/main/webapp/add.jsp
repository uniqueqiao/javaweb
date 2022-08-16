<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>add</title>
    </head>
    <body>
    <form action="${pageContext.request.contextPath}/user/AddAction" method="post">
        <table cellpadding="0" cellspacing="0" border="0">
            <tr>
                <td >
                    name:
                </td>
                <td >
                    <input type="text"  name="u.name" />
                </td>
            </tr>
            <tr>
                <td>
                    age:
                </td>
                <td >
                    <input type="text"  name="u.age" />
                </td>
            </tr>
            <tr>
                <td >
                    bir:
                </td>
                <td >
                    <input type="date"  name="u.bir" />
                </td>
            </tr>

        </table>
        <p>
            <input type="submit" class="button" value="Confirm" />
        </p>
    </form>
    </body>
</html>
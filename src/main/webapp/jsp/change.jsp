<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Change</title>
        </head>
        <script>
        function alertMessage()
     { 
     if (document.getElementById("userid").value == ""){
	   alert ( "Please enter Userid." );
	   if(event.preventDefault)
		    event.preventDefault();
		else
		    event.returnValue = false;
	   return false;
	   }
	   if (document.getElementById("password").value == ""){
	   alert ( "Please enter password." );
	   if(event.preventDefault)
		    event.preventDefault();
		else
		    event.returnValue = false;
	   return false;
	   }
     }
	   </script>
        <body>
            <form:form id="changeForm" modelAttribute="change" action="changeProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="userid">Userid: </form:label>
                        </td>
                        <td>
                            <form:input path="userid" name="userid" id="userid" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password:</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="newPassword">NewPassword:</form:label>
                        </td>
                        <td>
                            <form:password path="newPassword" name="newPassword" id="newPassword" />
                        </td>
                    </tr>
                   
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="change" name="change" onClick="alertMessage()">Change</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
            <table align="center">
                <tr>
                    <td>${message}</td>
                </tr>
            </table>
        </body>
        </html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <%@ page import="Login.controller.ResetController"%>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Change</title>
        </head>
         <%
        String stringFromJava = ResetController.generateString();
          %>
        <script>
       
        function alertMessage()
     { 
     if (document.getElementById("email").value == ""){
	   alert ( "Please enter Userid." );
	   if(event.preventDefault)
		    event.preventDefault();
		else
		    event.returnValue = false;
	   return false;
	   }
	   
     }
	   </script>
	      <style>
	   div {
    width: 300px;
    border: 1px solid green;
    padding: 25px;
    margin-left: 250px;
}
</style>
        <body>
        <div>
            <form:form id="mychangeForm" modelAttribute="mychange" action="mychangeProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="email">Userid: </form:label>
                        </td>
                        <td>
                            <form:input path="email" name="userid" id="email" />
                        </td>
                    </tr>
                   
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="reset" name="reset" onClick="alertMessage()">Change</form:button>
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
            </div>
        </body>
        </html>

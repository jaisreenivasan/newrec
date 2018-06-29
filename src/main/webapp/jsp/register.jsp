<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
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
	   if (document.getElementById("firstname").value == ""){
		   alert ( "Please enter firstname." );
		   if(event.preventDefault)
			    event.preventDefault();
			else
			    event.returnValue = false;
		   return false;
		   }
	   if (document.getElementById("lastname").value == ""){
		   alert ( "Please enter lastname." );
		   if(event.preventDefault)
			    event.preventDefault();
			else
			    event.returnValue = false;
		   return false;
		   }
	   if (document.getElementById("desig").value == ""){
		   alert ( "Please enter designation." );
		   if(event.preventDefault)
			    event.preventDefault();
			else
			    event.returnValue = false;
		   return false;
		   }
	   if (document.getElementById("email").value == ""){
		   alert ( "Please enter email." );
		   if(event.preventDefault)
			    event.preventDefault();
			else
			    event.returnValue = false;
		   return false;
		   }
	   if (document.getElementById("phone").value == ""){
		   alert ( "Please enter phone." );
		   if(event.preventDefault)
			    event.preventDefault();
			else
			    event.returnValue = false;
		   return false;
		   }
	   
     }
	   </script>
        <body>
            <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="userid">Userid</form:label>
                        </td>
                        <td>
                            <form:input path="userid" name="userid" id="userid" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="firstname">FirstName</form:label>
                        </td>
                        <td>
                            <form:input path="firstname" name="firstname" id="firstname" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="lastname">LastName</form:label>
                        </td>
                        <td>
                            <form:input path="lastname" name="lastname" id="lastname" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="email">Email</form:label>
                        </td>
                        <td>
                            <form:input path="email" name="email" id="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="desig">Desig</form:label>
                        </td>
                        <td>
                            <form:input path="desig" name="desig" id="desig" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="phone">Phone</form:label>
                        </td>
                        <td>
                            <form:input path="phone" name="phone" id="phone" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register" onClick="alertMessage()">Register</form:button>
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
        </body>
        </html>
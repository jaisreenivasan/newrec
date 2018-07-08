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
        function myFunction() {
            var x = document.getElementById("password");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
	   </script>
	   <style>
div {
    width: 350px;
    border: 1px solid green;
    padding: 25px;
    margin-left: 250px;
}
</style>
        <body>
        <div>
            <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="userid">Userid</form:label>
                        </td>
                        <td>
                            <form:input path="userid" name="userid" id="userid" pattern=".{1,40}" title="userid mustnot exceed 40 characters"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" pattern=".{1,40}"  title="password mustnot exceed 40 characters"/>
                            <input type="checkbox" onclick="myFunction()"><font size="1px">ShowPassword</font>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="firstname">FirstName</form:label>
                        </td>
                        <td>
                            <form:input path="firstname" name="firstname" id="firstname" pattern="[A-Za-z]{1,40}" title="firstname must contain only alphabets and mustnot exceed 40 characters"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="lastname">LastName</form:label>
                        </td>
                        <td>
                            <form:input path="lastname" name="lastname" id="lastname" pattern="[A-Za-z]{1,40}" title="lastname must contain only alphabets and mustnot exceed 40 characters"/>
                         </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="email">Email</form:label>
                        </td>
                        <td>
                            <form:input type="email" path="email" name="email" id="email" pattern="[a-z0-9._-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="email must contain @ and domain name"/>   
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="desig">Designation</form:label>
                        </td>
                        <td>
                            <form:input path="desig" name="desig" id="desig"  pattern="[A-Za-z]{1,40}" title="designation must contain only alphabets and mustnot exceed 40 characters"/>
                         </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label  path="phone">Phone</form:label>
                        </td>
                        <td>
                            <form:input path="phone" name="phone" id="phone" pattern="[0-9]{10}" title="phone no must have 10 digits"/>
                            
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
            </div>
            <table >
 <tr>
 <td style="font-style: italic; color: red;">${message}</td>
 </tr>
 </table>
        </body>
        </html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
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
	   var txt;
	   var r = confirm("Do You really wish to delete user details");
	   if (r == true) {
		   return true;
	       
	   } else {
		   if(event.preventDefault)
			    event.preventDefault();
			else
			    event.returnValue = false;
		   return false;
	   }
     }function myFunction() {
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
            <form:form id="DeleteForm" modelAttribute="delete" action="deleteprocess" method="post">
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
                            <input type="checkbox" onclick="myFunction()"><font size="1px">ShowPassword</font>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="delete" name="delete" onClick="alertMessage()">Delete</form:button>
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
                    <td><font color="red">${message}</font></td>
                </tr>
            </table>
</div>
</body>
</html>
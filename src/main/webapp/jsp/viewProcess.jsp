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
        <TABLE border="1" align="center">
<COLGROUP>
<COL><COL align="char" char=".">
<THEAD>
<TR><TH>FirstName <TH>LastName  <TH>Designation <TH>Phone<TH>Email
<TBODY>
<c:forEach items="${lists}" var="lists">
<TR><TD>${lists.getFirstname()}<TD>${lists.getLastname()}<TD>${lists.getDesig()}<TD>${lists.getPhone()}<TD>${lists.getEmail()}
</c:forEach>
</TABLE>
            <form:form id="ViewProcessForm" modelAttribute="viewProcess">
                <table align="center">
                    <tr>
                        <td></td>
                        <td><a href="home.jsp">Home</a>
                        </td>
                    </tr>
                </table>
                </form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script> 
function validate()
{ 
 var fullname = document.form.fullname.value;
 var email = document.form.email.value;
 var username = document.form.username.value; 
 var password = document.form.password.value;
 
 
 if (fullname==null || fullname=="")
 { 
 alert("Full Name can't be blank"); 
 return false; 
 }
 else if (email==null || email=="")
 { 
 alert("Email can't be blank"); 
 return false; 
 }
 else if (username==null || username=="")
 { 
 alert("Username can't be blank"); 
 return false; 
 }
 else if(password.length<6)
 { 
 alert("Password must be at least 6 characters long."); 
 return false; 
 } 
 
 } 
</script>
</head>
<body>
<center><h2>Java Update application using MVC and MySQL </h2></center>
<form name="form" action="edit1" method="POST" onsubmit="return validate()">
<table align="center">
 <tr>
 <td>Full Name</td>
 <td><input type="text" name="fullname" /></td>
 </tr>
 <tr>
 <td>Email</td>
 <td><input type="text" name="email" /></td>
 </tr>
 <tr>
 <td>Username</td>
 <td><input type="text" name="username" /></td>
 </tr>
 <tr>
 <td>Password</td>
 <td><input type="password" name="password" /></td>
 </tr>
<tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
 <td><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></td>
 </tr> 
 <tr>
 <td></td>
 <td><input type="submit" value="Update"></input><input
 type="reset" value="Reset"></input></td>
 </tr>
</table>
</form>
</body>
</html>
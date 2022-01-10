<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>


<h2 style="margin-left: 43%; margin-top: 2% ">Profile</h2>

<form action="/action_page.php" method="post">
  <img src="data:image/jpg;base64,${user.image}" alt="No image" width=10%>
	<img src="data:image/jpg;base64,${user.image }"width=10%>
  <div class="container" style="margin-top: 2% ">
  	<label for="uname"><b>Name</b></label>
    <input type="text" value="${user.name}" name="user" readonly>

    <label for="user"><b>Email</b></label>
    <input type="text" value="${user.email}" name="user" readonly>
    
    <label for="phone"><b>Phone no</b></label>
    <input type="text" value="${user.phone}" name="user" readonly>
   
   
    
  </div>
  <div class="container" style="background-color:#f1f1f1">
    <a href = "Admin_new_ticket.html"><button type="button" class="cancelbtn">Back</button></a>
    
  </div>
</form>

</body>
</html>
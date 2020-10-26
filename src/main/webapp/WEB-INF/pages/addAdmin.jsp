<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE>
<html lang="en">
<head>
<title>Admin Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style><%@include file="/WEB-INF/css/style.css"%></style>

</head>
  <body>
  <div class="header">
  <h1>APPRAISAL MANAGEMENT SYSTEM</h1>
  <p>A system to provide appraisal to employees.</p>
</div>
  
  
  
  <div class="topnav" id="myTopnav">
  <a href="/Appraisal-Management/admin">Home</a>
  <a href="/Appraisal-Management/admin/employee">Employee</a>
  <a href="/Appraisal-Management/admin/manager">Manager</a>
  <a href="/Appraisal-Management/admin/hr">HR</a>
  <a href="/Appraisal-Management/admin/add" class="active">Admin</a>
  <a href="/Appraisal-Management/admin/profile/${admin.id} ">Profile</a>
  <a style="float:right;" href="/Appraisal-Management/logout">Logout</a>
    <a style="float:right;" href="/Appraisal-Management/admin">Back</a>
  
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <em class="fa fa-bars"></em>
  </a>
</div>
  
  <script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>
 <br><br>
 <div class="container">
   <form:form action="/Appraisal-Management/admin/create" method="post" modelAttribute="a">
	 <div class="row">
       <div class="col-25">
         <label for="name">Name</label>
       </div>
       <div class="col-75">
         <form:input path="name" placeholder="Required" required="true"/>
       </div>
     </div>
     <div class="row">
       <div class="col-25">
         <label for="dob">DOB</label>
       </div>
       <div class="col-75">
         <form:input type="date" path="dob" placeholder="DD/MM/YYYY" required="true" />
       </div>
     </div>
     <div class="row">
       <div class="col-25">
         <label for="email">Email</label>
       </div>
       <div class="col-75">
         <form:input type="email" path="email" placeholder="Required" required="true"/>
       </div>
     </div>
     <div class="row">
       <div class="col-25">
         <label for="phone">Phone</label>
       </div>
       <div class="col-75">
         <form:input type="number" path="phone" placeholder="Required" required="true" min="5555555555" max="9999999999"/>
       </div>
     </div>
     <div class="row">
       <div class="col-25">
         <label for="authorizationPass">Password</label>
       </div>
       <div class="col-75">
         <form:password path="authorization.authorizationPass" />
       </div>
     </div>
     <br>
     <div class="row">
       <input type="submit" value="Submit">
     </div>
   </form:form>
 </div>
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>

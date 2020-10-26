<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
  <a href="/Appraisal-Management/admin/employee" class="active">Employee</a>
  <a href="/Appraisal-Management/admin/manager">Manager</a>
  <a href="/Appraisal-Management/admin/hr">HR</a>
  <a href="/Appraisal-Management/admin/add">Admin</a>
  <a href="/Appraisal-Management/admin/profile/${admin.id} ">Profile</a>
  <a style="float:right;" href="/Appraisal-Management/logout">Logout</a>
      <a style="float:right;" href="/Appraisal-Management/admin/employee">Back</a>
  
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

 <div class="container">
   <div class="row">
    <div class="col-25">
     <h3>Id</h3>
    </div>
    <div class="col-75">
     <h3><c:out value="${employee.id}"/></h3>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Name</h3>
    </div>
    <div class="col-75">
     <h3><c:out value="${employee.name}"/></h3>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>DOB</h3>
    </div>
    <div class="col-75">
     <h3><c:out value="${employee.dob}"/></h3>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Email</h3>
    </div>
    <div class="col-75">
     <h3><c:out value="${employee.email}"/></h3>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Manager</h3>
    </div>
    <div class="col-75">
     <h3><c:out value="${employee.manager.name}"/></h3>
    </div>
   </div> 
 </div>
 <a href="/Appraisal-Management/admin/employee/delete/${employee.id}"><button class="addButton">Delete</button></a>
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>

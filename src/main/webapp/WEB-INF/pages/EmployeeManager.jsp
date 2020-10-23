<!DOCTYPE>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title>Employee Manager</title>
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
  <a href="/Appraisal-Management/employee" >Home</a>
  <a href="/Appraisal-Management/employee/goals">Goal</a>
    <a href="/Appraisal-Management/employee/manager" class="active">Manager</a>
  <a href="/Appraisal-Management/employee/profile">Profile</a> 
  <a style="float:right;" href="/Appraisal-Management/logout">Logout</a>
    <a style="float:right;" href="/Appraisal-Management/employee">Back</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <em class="fa fa-bars"></em>
  </a>
</div>
  
  
 <br>
  
<h2>MANAGER DETAILS</h2>
<br>
<div class="container">
   <div class="row">
    <div class="col-25">
     <h3>Id</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${manager.id}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Name</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${manager.name}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>DOB</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${manager.dob}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Email</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${manager.email}"/></p>
    </div>
   </div> 
   <div class="row">
    <div class="col-25">
     <h3>Phone</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${manager.phone}"/></p>
    </div>
   </div> 
   
 </div>
<br><br><br>




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
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
<head>
<title>HR Profile</title>
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
  <a href="/Appraisal-Management/hr">Home</a>
  <a href="/Appraisal-Management/hr/goals">Goal</a>
  <a href="/Appraisal-Management/hr/profile" class="active">Profile</a>
  <a style="float:right;" href="/Appraisal-Management/logout">Logout</a>
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
     <p><c:out value="${hr.id}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Name</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${hr.name}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>DOB</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${hr.dob}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Email</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${hr.email}"/></p>
    </div>
   </div> 
    <div class="row">
    <div class="col-25">
     <h3>Phone</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${hr.phone}"/></p>
    </div>
   </div> 
 </div>
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>
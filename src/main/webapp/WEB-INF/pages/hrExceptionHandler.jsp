<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
<head>
<title>Exception Page</title>
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
  <a href="/Appraisal-Management/hr/profile">Profile</a>
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

      <h1 style="float:center;"><c:out value="${message}"/></h1>
      <a class="button" href="/Appraisal-Management/hr">Back to Home</a>
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>
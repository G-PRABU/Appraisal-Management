<!DOCTYPE>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title>HR Dashboard</title>
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
  <a href="/Appraisal-Management/hr" >Home</a>
  <a href="/Appraisal-Management/hr/goals" class="active">Goal</a>
  <a href="/Appraisal-Management/hr/profile">Profile</a> 
  <a style="float:right;" href="/Appraisal-Management/logout">Logout</a>
    <a style="float:right;" href="/Appraisal-Management/hr/goals">Back</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <em class="fa fa-bars"></em>
  </a>
</div>
  
  <br>
  <br>
  <h3>UPDATE GOAL DETAILS</h3>

  <div class="container">
<mvc:form modelAttribute="goal" action="/Appraisal-Management/hr/addgoal/${goalId}">
     <div class="row">
       <div class="col-25">
         <label for="goalName">Goal Name</label>
       </div>
       <div class="col-75">
         <mvc:input path="goalName" value="${goalName }" required="true"/>
       </div>
     </div>
    <div class="row">
       <div class="col-25">
         <label for="goalDescription">Goal Description</label>
       </div>
       <div class="col-75">
         <mvc:input path="goalDescription" value="${goalDescription }" required="true"/>
       </div>
     </div>
     <div class="row">
       <div class="col-25">
         <label for="goalDuration">Goal Duration</label>
       </div>
       <div class="col-75">
         <mvc:input type="number" path="goalDuration" value="${goalDuration }" min="1" max="12" required="true"/>
       </div>
     </div>
     <br>
     <div class="row">
       <input type="submit" value="Submit">
     </div>
   </mvc:form>
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
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>

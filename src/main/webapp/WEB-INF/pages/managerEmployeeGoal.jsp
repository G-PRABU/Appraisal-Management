<!DOCTYPE>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title>Manager Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style><%@include file="/WEB-INF/css/style.css"%></style>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

</head>
  <body>
    
  <div class="header">
  <h1>APPRAISAL MANAGEMENT SYSTEM</h1>
  <p>A system to provide appraisal to employees.</p>
</div>
  
  
  
  <div class="topnav" id="myTopnav">
  <a href="/Appraisal-Management/manager" class="active">Home</a>
  <a href="/Appraisal-Management/manager/manager_profile/${manager.id}">Profile</a>
  <a style="float:right;" href="/Appraisal-Management/logout">Logout</a>
    <a style="float:right;" href="/Appraisal-Management/manager/viewprofile?id=${employee.id}">Back</a>
  
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
<br>
<br>
  <br>
  <h3>REVIEW GOAL</h3>
<div class="container">
<mvc:form modelAttribute="goalRating" action="/Appraisal-Management/manager/reviewgoal/${employee.id}/${assignedGoal }">
     <div class="row">
       <div class="col-25">
         <label for="onTimeCompletionScore">On Time Completion Score:</label>
       </div>      
       <div class="radioButton">
       		  <mvc:radiobutton path="onTimeCompletionScore" value="${outstanding }" />OutStanding
              <mvc:radiobutton path="onTimeCompletionScore" value="${good }" />Good
              <mvc:radiobutton path="onTimeCompletionScore" value="${fair }" />Fair
              <mvc:radiobutton path="onTimeCompletionScore" value="${improvement }" />Needs Improvement
              <mvc:radiobutton path="onTimeCompletionScore" value="${unsatisfactory }" />Unsatisfactory
       </div> 
     </div> 
     <br>
      <div class="row">
       <div class="col-25">
         <label for="teamCollaborationScore">Team Collaboration Score:</label>
       </div>
      <div class="radioButton">
       		  <mvc:radiobutton path="teamCollaborationScore" value="${outstanding }" />OutStanding
              <mvc:radiobutton path="teamCollaborationScore" value="${good }" />Good
              <mvc:radiobutton path="teamCollaborationScore" value="${fair }" />Fair
              <mvc:radiobutton path="teamCollaborationScore" value="${improvement }" />Needs Improvement
              <mvc:radiobutton path="teamCollaborationScore" value="${unsatisfactory }" />Unsatisfactory
       </div> 
     </div> 
     <br>
      <div class="row">
       <div class="col-25">
         <label for="problemSolvingScore">Problem Solving Score:</label>
       </div>
       <div class="radioButton">
       		  <mvc:radiobutton path="problemSolvingScore" value="${outstanding }" />OutStanding
              <mvc:radiobutton path="problemSolvingScore" value="${good }" />Good
              <mvc:radiobutton path="problemSolvingScore" value="${fair }" />Fair
              <mvc:radiobutton path="problemSolvingScore" value="${improvement }" />Needs Improvement
              <mvc:radiobutton path="problemSolvingScore" value="${unsatisfactory }" />Unsatisfactory
       </div> 
     </div> 
     <br>
      <div class="row">
       <div class="col-25">
         <label for="responsibilityScore">Responsibility Score:</label>
       </div>
       <div class="radioButton">
       		  <mvc:radiobutton path="responsibilityScore" value="${outstanding }" />OutStanding
              <mvc:radiobutton path="responsibilityScore" value="${good }" />Good
              <mvc:radiobutton path="responsibilityScore" value="${fair }" />Fair
              <mvc:radiobutton path="responsibilityScore" value="${improvement }" />Needs Improvement
              <mvc:radiobutton path="responsibilityScore" value="${unsatisfactory }" />Unsatisfactory
       </div> 
     </div> 
     <br>
<div class="row">
       <div class="col-25">
         <label for="workEfficiencyScore">Work Efficiency Score:</label>
       </div>
       <div class="radioButton">
       		  <mvc:radiobutton path="workEfficiencyScore" value="${outstanding }" />OutStanding
              <mvc:radiobutton path="workEfficiencyScore" value="${good }" />Good
              <mvc:radiobutton path="workEfficiencyScore" value="${fair }" />Fair
              <mvc:radiobutton path="workEfficiencyScore" value="${improvement }" />Needs Improvement
              <mvc:radiobutton path="workEfficiencyScore" value="${unsatisfactory }" />Unsatisfactory
       </div> 
     </div> 
    
     <br><br>
     <div class="row">
       <input type="submit" value="Submit">
     </div>
   </mvc:form>
 </div>



<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>

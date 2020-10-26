<!DOCTYPE>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title>Employees</title>
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
  <a href="/Appraisal-Management/hr" class="active" >Home</a>
  <a href="/Appraisal-Management/hr/goals">Goal</a>
  <a href="/Appraisal-Management/hr/profile">Profile</a> 
  <a style="float:right;" href="/Appraisal-Management/logout">Logout</a>
    <a style="float:right;" href="/Appraisal-Management/hr">Back</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <em class="fa fa-bars"></em>
  </a>
</div>
  
  
 <br>
  
<h2>EMPLOYEE DETAILS</h2>
<div class="container">
   <div class="row">
    <div class="col-25">
     <h3>Id</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${employee.id}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Name</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${employee.name}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>DOB</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${employee.dob}"/></p>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <h3>Email</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${employee.email}"/></p>
    </div>
   </div> 
   <div class="row">
    <div class="col-25">
     <h3>Phone</h3>
    </div>
    <div class="col-75">
     <p><c:out value="${employee.phone}"/></p>
    </div>
   </div>
 </div>
 <h3>EMPLOYEE GOAL DETAILS</h3>

<table class="user">
<caption></caption>
<tr>
<th id="">ASSIGNED GOAL ID</th>
<th id="">GOAL NAME</th>
<th id="">GOAL START DATE</th>
<th id="">GOAL END DATE</th>
<th id="">GOAL STATUS</th>
<th id="">TOTAL SCORE</th>
</tr>
<c:forEach var="g" items="${a}">
<tr>
<c:if test="${g.assignedGoalId >0 }">
<td>${g.assignedGoalId }</td>
<td>${g.goal.goalName }</td>
<td>${g.startDate}</td>
<td>${g.endDate}</td>

<c:if test="${g.goalStatus==true }">
<td>GOAL COMPLETED</td>

<c:if test="${g.goalRating==null }">
<td>Yet to be Reviewed</td>
</c:if>

<c:if test="${g.goalRating.totalScore>0 }">
<td>${g.goalRating.totalScore}</td>
</c:if>

</c:if>
<c:if test="${g.goalStatus==false }">
<td>IN PROGRESS</td>
<td></td>
</c:if>
</c:if>
</tr>
</c:forEach>
</table>
 

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

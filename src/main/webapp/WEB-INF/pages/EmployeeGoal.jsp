<!DOCTYPE>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title>Employee Goal</title>
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
  <a href="/Appraisal-Management/employee/goals" class="active">Goal</a>
    <a href="/Appraisal-Management/employee/manager">Manager</a>
  <a href="/Appraisal-Management/employee/profile">Profile</a> 
  <a style="float:right;" href="/Appraisal-Management/logout">Logout</a>
    <a style="float:right;" href="/Appraisal-Management/employee">Back</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <em class="fa fa-bars"></em>
  </a>
</div>
  <br>  
<h2>GOALS IN THE SYSTEM</h2>
 <br>
  <div style="margin:0px 400px">
  <form method="get" action="/Appraisal-Management/employee/search">
  	<input type="text" name="keyword"/> &nbsp;
  	<input type="submit" value="Search"/>
  </form>
  </div>
  <br><br><br>
<table class="user">
<caption></caption>
<tr>
<th id="">GOAL ID</th>
<th id="" >GOAL NAME</th>
<th id="">GOAL DESCRIPTION</th>
<th id="">GOAL DURATION</th>
<th id="">ADD</th>
</tr>
<c:forEach var="g" items="${goal}">
<tr>
<c:if test="${g.goalId >0 }">
<td>${g.goalId }</td>
<td>${g.goalName }</td>
<td>${g.goalDescription}</td>
<td>${g.goalDuration }</td>
<td><a href="/Appraisal-Management/employee/add/${g.goalId}">ADD</a></td>
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

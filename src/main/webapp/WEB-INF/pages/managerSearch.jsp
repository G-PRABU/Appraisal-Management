<!DOCTYPE>
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
    <a style="float:right;" href="/Appraisal-Management/manager">Back</a>
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

<div>
<form method="get" action="search">
		<input type="text" name="keyword" /> &nbsp;
		<input type="submit" value="Search" />
	</form>
	</div>
	<TABLE class="user" >
	<caption></caption>
		<div>
			<TR>
				<TH id=""><h6>ID</h6></TH>
				<TH id=""><h6>DOB</h6></TH>
				<TH id=""><h6>EMAIL</h6></TH>
				<TH id=""><h6>NAME</h6></TH>
				<TH id=""><h6>VIEW</h6></TH>
			</TR>
			
			<h1>Employee List</h1>
		<c:forEach items="${result}" var="employee">
				<tr>
					<td><c:out value="${employee.id}"/></td>
					<td><c:out value="${employee.dob}"/></td>
					<td><c:out value="${employee.email}"/></td>
					<td><c:out value="${employee.name}"/></td>
					<td><a href="viewprofile?id=${manager.id}">ViewProfile</a></td>
				</tr> 
		</c:forEach>
		</div>
	</TABLE>
	
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>

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
  <a href="/Appraisal-Management/admin" >Home</a>
  <a href="/Appraisal-Management/admin/employee">Employee</a>
  <a href="/Appraisal-Management/admin/manager">Manager</a>
  <a href="/Appraisal-Management/admin/hr" class="active">HR</a>
  <a href="/Appraisal-Management/admin/add">Admin</a>
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
  <br>
   <a href="/Appraisal-Management/admin/hr/add"><button class="addButton">Add HR</button></a>
  <br>
  <div>
  <table class="user">
  <caption>HRs</caption>
  <tr>
   <th id="id">ID</th>
   <th id="name">NAME</th>
   <th id="email">EMAIL</th>
   <th id=""></th>
  </tr>
  <c:forEach var="hr" items="${hrs}">
    <tr>
     <td><c:out value="${hr.id}"/></td>
     <td><c:out value="${hr.name}"/></td>
     <td><c:out value="${hr.email}"/></td>
     <td><a href="/Appraisal-Management/admin/hr/get/${hr.id}">View</a></td>
    </tr>
  </c:forEach>
 </table>
 </div>
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>

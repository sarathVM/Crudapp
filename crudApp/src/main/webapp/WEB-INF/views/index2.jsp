<html>
<head>
<%@include file="./base.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
 
</head>
<body>
<div class="container mt-3">
<div class="row">
<div class="col-md-12">
<h1 class="text-center mb-3">Welcome</h1>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">CUSTOMER_ID</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">Total_Units</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="p">
    <tr>
      <th scope="row">EBILL${p.id}</th>
      <td>${p.name}</td>
      <td>${p.description}</td>
      <td>${p.price}</td>
      <td>
      <a href="delete/${p.id}" class="btn btn-outline-danger">DELETE</a>
      <a href="update/${p.id}" class="btn btn-outline-primary">EDIT</a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<div class="container text-center"> 
<a href="add" class="btn btn-outline-success">Add New</a>  
</div>

</div> 

</div>
</div>

</body>
</html>
 
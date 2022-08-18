<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <div class="container">
   <div class="panel-group">
     <div class="panel panel-primary">
       <div class="panel-body">
         <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>First name</th>
		        <th>Last name</th>
		        <th>Date of Birth</th>
		        <th>Department</th>
		        <th>Salary</th>
		        <th>Manager ID</th>
		        <th>Action</th>
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${allEmployees}" var="emp">
		    		<tr>
				        <td>#${emp.id}</td>
				        <td>${emp.firstName}</td>
				        <td>${emp.lastName}</td>
				        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${emp.dob}" /></td>
				        <td>${emp.department}</td>
				        <td>USD ${emp.salary}</td>
				        <td>${emp.manager}</td>
				        <td><a href="edit-employee?id=${emp.id}" class="btn btn-warning btn-xs">Edit</a></td>
		      		</tr>
			     </c:forEach>   
		      </tbody>
		  </table>
       </div>
     </div>
   </div>
 </div>

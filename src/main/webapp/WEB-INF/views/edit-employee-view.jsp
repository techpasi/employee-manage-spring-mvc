<%@page import="com.mvc.enumeration.DepartmentEnum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


 <div class="container">

   <div class="panel-group">
     <div class="panel panel-warning">
       <div class="panel-body">
		
	  <form:form action="edit-employee" modelAttribute="editEmployee" method="post">
           <div class="row">
          	<form:input type="hidden" path="id" name="id" cssClass="form-control" />	
           		
             <div class="col-sm-6 field">
               <label class="form-label" for="firstName">First name <i class="req-txt">*</i></label>
               <form:errors path="firstName" cssClass="form-error"/>
               <form:input type="text" path="firstName" name="firstName" cssClass="form-control" />
             </div>
             
           	<div class="col-sm-6 mb-1">
               <label class="form-label" for="lastName">Last name <i class="req-txt">*</i></label>
               <form:errors path="lastName" cssClass="form-error"/>
               <form:input type="text" path="lastName" name="lastName" cssClass="form-control" />
             </div>
             
             <div class="col-sm-6 mb-1">
               <label class="form-label" for="dob">Date of Birth <i class="req-txt">*</i></label>
               <form:errors path="dob" cssClass="form-error"/>
               <form:input type="date" path="dob" name="dob" cssClass="form-control" />
             </div>
             
             <div class="col-sm-6 mb-1">
               <label class="form-label" for="department">Department <i class="req-txt">*</i></label>
               <form:errors path="department" cssClass="form-error"/>
               <form:select path="department" cssClass="form-control form-select">  
			        <form:option value="" label=" -Select- "/>
			        <c:forEach items="${departmentEnumValues}" var="depValue">
					     <form:option value="${depValue}" label="${depValue}"/>  
					</c:forEach>   
		        </form:select>
             </div>
             
             <div class="col-sm-6 mb-1">
               <label class="form-label" for="salary">Salary <i class="req-txt">*</i></label>
               <form:errors path="salary" cssClass="form-error"/>
               <form:input type="number" path="salary" name="salary" cssClass="form-control" />
             </div>
             
             <div class="col-sm-6 mb-1">
               <label class="form-label" for="manager">Manager</label>
               <form:errors path="manager" cssClass="form-error"/>
               <form:select path="manager" cssClass="form-control form-select">  
			        <form:option value="" label=" -Select- "/>
			        <c:forEach items="${managers}" var="managerObj">
					     <form:option value="${managerObj.id}" label="${managerObj.firstName} ${managerObj.lastName}"/>  
					</c:forEach>   
		        </form:select>
		        
             </div>
           </div>
           <br>
           
           <div class="row">
             <div class="col-sm-12">
             	<button type="submit" class="btn btn-primary form-btn">Update</button>
             	<button type="reset" class="btn btn-default form-btn">Reset</button>
           	 </div>
           </div>
          </form:form>

       </div>
     </div>
   </div>
 </div>

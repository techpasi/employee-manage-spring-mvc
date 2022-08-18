<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Employee Manage Dashboard</title>
    <tiles:insertAttribute name="header" />
  </head>
  <body>
  	<tiles:insertAttribute name="nav" />
  	
  	<h2 class="title">
  		<tiles:insertAttribute name="title" />
	</h2>
	
    <tiles:insertAttribute name="body" />
  </body>
  <tiles:insertAttribute name="footer" />
</html>
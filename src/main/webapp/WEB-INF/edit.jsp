<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html">
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/main.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<title>Books</title>
	
</head>
<body>
	<div class = "container">
	<%@ page isErrorPage="true" %>    
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
		<h1>Edit Book</h1>
			<form:form action="/books/${book.id}" method="post" modelAttribute="book">
    		<input type="hidden" name="_method" value="put">
    		<p>
        		<form:label path="title">Title</form:label>
        		<form:errors path="title"/>
        		<form:input path="title"/>
    		</p>
    		<p>
        		<form:label path="description">Description</form:label>
        		<form:errors path="description"/>
        		<form:textarea path="description"/>
    		</p>
    		<p>
        		<form:label path="language">Language</form:label>
        		<form:errors path="language"/>
        		<form:input path="language"/>
    		</p>
    		<p>
        		<form:label path="numberOfPages">Pages</form:label>
        		<form:errors path="numberOfPages"/>     
        		<form:input type="number" path="numberOfPages"/>
    		</p>    
    			<input type="submit" value="Submit"/>
			</form:form>
		<a href="/books/new">New Book</a>
 	</div><!-- close wrapper -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<title>HR Application System - Employee Salary Increment Form</title>
  	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
</head>
<body>
  <div class="container">
  	<h2 class="text-center mb-3">Employee Salary Increment Form</h2>
  	<form action="issueIncrement" method="POST">
      <div class="row">
        <div class="col mb-3">
          <label for="employee_name" class="col-form-label">Employee Name</label>
          <input type="text" class="form-control" id="employee_name" name="employee_name" value='${param.name}' aria-label='${param.name}' readonly/>
        </div>
        <div class="col mb-3">
          <label for="manager_name" class="col-form-label">Issued By Manager</label>
          <input type="text" class="form-control" id="manager_name" name="manager_name" value='${param.user}' aria-label='${param.user}' readonly/>
        </div> 
      </div>
	    <div class="row">
        <div class="col-4 mb-3">
          <label for="incremented_salary" class="col-form-label">Incremented Salary</label>
          <input type="text" class="form-control" id="incremented_salary" name="incremented_salary" required/>
        </div>
      </div>
	    <div class="row">
        <div class="col text-center">
          <button type="submit" class="btn btn-primary btn-lg btn-width-2">Submit</button> 
              <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Reset</button> 
          </div>
      </div> 
	</form>
	
  </div>
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script>
		$(window).on('beforeunload', function (e) {
	        e.preventDefault();
	        window.opener.location='manager?viewSalary';
    	});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<title>HR Application System - Edit Information Form</title>
  	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
</head>
<body>
  <div class="container-fluid">
    <div class="row mb-2 mt-2">
      <h2 class="text-center">Edit Information Form</h2>
    </div>
    <div class="row">
      <div class="col-2"></div>
      <div class="col-8">
        <form action="editInfo" method="POST">
          <div class="row mb-3">
            <div class="col-4">
              <label for="fullname" class="col-form-label">Full Name</label>
            </div>
            <div class="col-8">
              <input type="text" class="form-control" id="fullname" name="fullname" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="department" class="col-form-label">Department</label>
            </div>
            <div class="col-5">
              <input type="text" class="form-control" id="department" name="department" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="position" class="col-form-label">Position</label>
            </div>
            <div class="col-5">
              <input type="text" class="form-control" id="position" name="position" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="phone" class="col-form-label">Phone</label>
            </div>
            <div class="col-5">
              <input type="text" class="form-control" id="phone" name="phone" required/>
            </div>
          </div>
          <div class="row mb-5">
            <div class="col-4">
              <label for="email" class="col-form-label">Email</label>
            </div>
            <div class="col-6">
              <input type="text" class="form-control" id="email" name="email" required/>
            </div>
          </div>
          <div class="row">
            <div class="text-center">
              <button type="submit" class="btn btn-primary btn-lg btn-width-2">Submit</button> 
              <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Reset</button> 
            </div>
          </div> 
        </form>
      </div>
    </div>
  </div>

	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script>
		$(window).on('beforeunload', function(e) {
      e.preventDefault();
      window.opener.location='employee?profile';
    });
	</script>
</body>
</html>
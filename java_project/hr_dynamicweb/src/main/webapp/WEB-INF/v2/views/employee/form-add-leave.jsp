<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Leave Application Form</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
</head>

<body>
  <div class="container form-container">
  	<div class="row mb-2 mt-2">
      <h2 class="text-center">Leave Application Form</h2>
  	</div>
    <div class="row px-5">
      <hr>
      <form action="${pageContext.request.contextPath}/v2/employee/form/submit/submitLeave" method="POST">
        <div class="row mb-3">
          <div class="col-6">
            <label for="employee-name" class="col-form-label">Employee Name</label>
            <input type="text" class="form-control" id="employee-name" name="employee-name" value="${param.name}" readonly/>
          </div>    
        </div>
        <div class="row mb-3">
          <div class="col">
            <label for="reasons" class="col-form-label">Reasons</label>
            <input type="text" class="form-control" id="reasons" name="reasons"/>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-6">
            <label for="leave-type" class="col-form-label">Leave Type</label>
            <select class="form-select" aria-label="type" id="leave-type" name="leave-type">
              <option selected>--SELECT--</option>
              <option value="ANNUAL LEAVE">Annual Leave</option>
              <option value="MATERNITY LEAVE">Maternity Leave</option>
              <option value="SICK LEAVE">Sick Leave</option>
              <option value="UNPAID LEAVE">Unpaid Leave</option>
            </select>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-6">
            <div class="row">
              <label for="start-date" class="col-form-label">Start Date</label>
            </div>
            <div class="row">
              <div class="col-6">
                <input type="date" class="form-control" id="start-date" name="start-date" required/>
              </div>
              <div class="col-6">
                <input type="time" class="form-control" id="start-time" name="start-time" required/>
              </div>
            </div>
          </div>
          <div class="col-6">
            <div class="row">
              <label for="end-date" class="col-form-label">End Date</label>
            </div>
            <div class="row">
              <div class="col-6">
                <input type="date" class="form-control" id="end-date" name="end-date" required/>
              </div>
              <div class="col-6">
                <input type="time" class="form-control" id="end-time" name="end-time" required/>
              </div>
            </div>
          </div>
        </div>
        <div class="row mb-3">
          <div class="text-center">
            <button type="submit" class="btn btn-primary btn-lg btn-width-2">Submit</button>
          </div>
        </div>     
      </form>
    </div>
  </div>

  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  <script>
		$(window).on('beforeunload', function (e) {
	        e.preventDefault();
	        window.opener.location='${pageContext.request.contextPath}/v2/employee/view-leave';
    	});
  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Loan Application Form</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
</head>

<body>
  <div class="container form-container">
  	<div class="row mb-2 mt-2">
      <h2 class="text-center">Loan Application Form</h2>
  	</div>
    <div class="row px-5">
      <hr>
      <form action="${pageContext.request.contextPath}/v2/employee/form/submit/submitLoan" method="POST">
        <div class="row mb-3">
          <div class="col-6">
            <label for="employee-name" class="col-form-label">Employee Name</label>
            <input type="text" class="form-control" id="employee-name" name="employee-name" value="${param.name}" readonly/>
          </div>    
        </div>
        <div class="row mb-3">
          <div class="col">
            <label for="reasons" class="col-form-label">Reasons</label>
            <input type="text" class="form-control" id="reasons" name="reasons" required/>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-4">
            <label for="loan-amount" class="col-form-label">Loan Amount</label>
            <input type="number" class="form-control" id="loan-amount" name="loan-amount" min="0" step="any" required/>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-4">
            <label for="apply-date" class="col-form-label">Application Date</label>
            <input type="date" class="form-control" id="apply-date" name="apply-date" required/>
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
	        window.opener.location='${pageContext.request.contextPath}/v2/employee/view-loan';
    	});
  </script>
</body>
</html>
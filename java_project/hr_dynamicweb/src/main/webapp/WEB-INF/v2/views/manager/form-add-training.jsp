<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Employee Training Form</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-table.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/FileSaver/FileSaver.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsPDF/polyfills.umd.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsPDF/jspdf.umd.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html2canvas/html2canvas.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/tableExport.min.js"></script>
</head>

<body>
  <div class="container form-container">
  	<div class="row mb-2 mt-2">
      <h2 class="text-center">Employee Training Form</h2>
  	</div>
    <div class="row px-5">
      <hr>
        <form action="${pageContext.request.contextPath}/v2/manager/form/submit/submitTraining" method="POST">
          <div class="row mb-3">
	          <div class="col-6">
	          	<label for="employee-name" class="col-form-label">Employee Name</label>
	            <input type="text" class="form-control" id="employee-name" name="employee-name" required/>
	          </div>
	          <div class="col-6">
	            <label for="manager-name" class="col-form-label">Manager Name</label>
	            <input type="text" class="form-control" id="manager-name" name="manager-name" value="${user.fullname}"/>
	          </div> 
          </div>
          <div class="row mb-3">
          	<div class="col-12">
              <label for="info" class="col-form-label">Information</label>
              <input type="text" class="form-control" id="info" name="info" required/>
          	</div>
          </div>  
          <div class="row mb-3">
            <div class="col-6">
              <div class="row">
                <label for="start-date" class="col-form-label">Training Start Date</label>
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
                <label for="end-date" class="col-form-label">Training End Date</label>
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

  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table-locale-all.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table-export.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table.min.js"></script>
    <script>
		$(window).on('beforeunload', function (e) {
	        e.preventDefault();
	        window.opener.location='${pageContext.request.contextPath}/v2/manager/view-training';
    	});
  </script>
</body>
</html>
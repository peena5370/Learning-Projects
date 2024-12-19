<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Employee Promotion Form</title>
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
      <h2 class="text-center">Employee Promotion Form</h2>
  	</div>
    <div class="row px-5">
      <hr>
        <form action="${pageContext.request.contextPath}/v2/manager/form/submit/submitPromotion" method="POST">
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
            <div class="col-6">
              <label for="promote-title" class="col-form-label">Promote Title</label>
              <select class="form-select" aria-label="promote-title" id="promote-title" name="promote-title">
                <option selected>--SELECT--</option>
                <c:forEach var="title" items="${titleList}">
                  <option value="${title.titleName}">${title.id}, ${title.titleName}</option>
                </c:forEach>
              </select>
            </div>
            <div class="col-3">
              <label for="previous-salary" class="col-form-label">Previous Salary</label>
              <input type="number" class="form-control" id="previous-salary" name="previous-salary" min="0" step="any" required/>
            </div>
            <div class="col-3">
              <label for="promote-salary" class="col-form-label">Promote Salary</label>
              <input type="number" class="form-control" id="promote-salary" name="promote-salary" min="0" step="any" required/>
            </div>
          </div>  
          <div class="row mb-3">
            <div class="col-3">
              <label for="promote-date" class="col-form-label">Promote Date</label>
              <input type="date" class="form-control" id="promote-date" name="promote-date" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="text-center">
              <button type="submit" class="btn btn-primary btn-lg btn-width-2">Submit</button> 
              <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Clear</button> 
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
	        window.opener.location='${pageContext.request.contextPath}/v2/manager/view-promotion';
    	});
  </script>
</body>
</html>
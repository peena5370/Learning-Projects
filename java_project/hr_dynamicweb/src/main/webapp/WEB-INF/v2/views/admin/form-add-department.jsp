<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Add Department Form</title>
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
    <div class="row px-3 mt-2">
      <form action="${pageContext.request.contextPath}/v2/admin/form/submit/submitDepartment" method="POST">
        <div class="row mb-3">
          <h3 class="text-center">Add Department Form</h3>
          <hr>
        </div>
        <div class="row mb-3">
          <label for="dept-name" class="col-form-label">Department Name <span style="color: #f00;">*</span></label>
          <input type="text" class="form-control" id="dept-name" name="dept-name" required/>
        </div>
        <div class="row mb-3">
          <label for="address" class="col-form-label">Address <span style="color: #f00;">*</span></label>
          <input type="text" class="form-control" id="address" name="address" required/>
        </div>
        <div class="row mb-3">
          <label for="state" class="col-form-label">State <span style="color: #f00;">*</span></label>
              <select class="form-select" size="3" aria-label="state" id="state" name="state">
                <option value="Perlis">Perlis</option>
                <option value="Kedah">Kedah</option>
                <option value="Pulau Pinang">Pulau Pinang</option>
                <option value="Perak">Perak</option>
                <option value="Selangor">Selangor</option>
                <option value="Putrajaya">Putrajaya</option>
                <option value="Kuala Lumpur">Kuala Lumpur</option>
                <option value="Negeri Sembilan">Negeri Sembilan</option>
                <option value="Malacca">Malacca</option>
                <option value="Johor">Johor</option>
                <option value="Kelantan">Kelantan</option>
                <option value="Terengganu">Terengganu</option>
                <option value="Pahang">Pahang</option>
                <option value="Labuan">Labuan</option>
                <option value="Sabah">Sabah</option>
                <option value="Sarawak">Sarawak</option>
              </select>
        </div>
        <div class="row mb-3">
          <label for="country" class="col-form-label">Country <span style="color: #f00;">*</span></label>
          <input type="text" class="form-control" id="country" name="country" required/>
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
	        window.opener.location='${pageContext.request.contextPath}/v2/admin/view-department';
    	});
  </script>
</body>
</html>
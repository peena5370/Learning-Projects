<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Change User Password</title>
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
      <form action="${pageContext.request.contextPath}/v2/admin/form/submit/updateManagerPassword" method="POST">
        <div class="row mb-3">
          <h3 class="text-center">Change Manager Password</h3>
          <hr>
        </div>
        <div class="row mb-3">
          <div class="col">
            <label for="username" class="col-form-label">Username</label>
            <input type="text" class="form-control" id="username" name="username" value="${param.username}" readonly/>
          </div> 
        </div>
        <div class="row mb-3">
            <div class="col-6">
              <label for="old_password" class="col-form-label">Old Password</label>
              <input type="password" class="form-control" id="old_password" name="old_password" minlength="8" maxlength="20" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-6">
              <label for="new_password" class="col-form-label">New Password</label>
              <input type="password" class="form-control" id="new_password" name="new_password" minlength="8" maxlength="20" required/>
              <div class="form-text" id="validate-text"></div>
            </div>
          </div>
          <div class="row mb-5">
            <div class="col-6">
              <label for="c_password" class="col-form-label">Confirmed Password</label>
              <input type="password" class="form-control" id="c_password" name="c_password" minlength="8" maxlength="20" required/>
              <div class="form-text" id="match-text"></div>
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
	        window.opener.location='${pageContext.request.contextPath}/v2/admin/view-account-manager';
    	});
  </script>
  <script>
    $('#new_password, #c_password').keyup(function(e) {
      var pass = $('#new_password').val();
      var confirm_pass = $('#c_password').val();
      var passRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,20})");

      if(pass=="" || !pass.match(passRegex)) {
        e.preventDefault();
        $('#validate-text').text("Password should consists of atleast 1 upper and lowercase letter, 1 symbol, 1 numeric, and length should between 8 to 20.").addClass('text-danger');
      } else if(confirm_pass===pass && pass.match(passRegex)) {
        $('#validate-text').hide();
        $('#match-text').text("Password match.").addClass('text-success');
      } else {
        e.preventDefault();
        $('#match-text').text("Password Doesn't Match!");
      }
      return true;
    }); 
  </script>
</body>
</html>
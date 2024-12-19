<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Change Password Form</title>
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
</head>
<body>
  <div class="container-fluid">
    <div class="row mb-3 mt-2">
      <h2 class="text-center">Change Password Form</h2>
    </div>
    <div class="row">
      <div class="col-2"></div>
      <div class="col-8">
        <form action="changePassword" method="POST">
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
          <div class="row">
            <div class="text-center">
              <button type="submit" class="btn btn-primary btn-lg btn-width-2">Submit</button> 
              <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Clear</button> 
            </div>
          </div> 
        </form>
      </div>
    </div>
  </div>

	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script>
		$(window).on('beforeunload', function (e) {
        e.preventDefault();
        window.opener.location='employee?profile';
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
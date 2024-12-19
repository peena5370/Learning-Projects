<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Change Employee Account Password</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>
</head>

<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-2">
      <nav>
        <div class="flex-shrink-0 p-3 bg-white">
          <header>
            <img src="${pageContext.request.contextPath}/img/profile-template.png">
            <p>${user.fullname}</p>
            <p style="font-size: 15px;">${user.role}</p>
          </header>
          <ul class="list-unstyled ps-0">
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#department-collapse" aria-expanded="false">
              Departments
              </button>
              <div class="collapse" id="department-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/departmentsection" class="link-dark rounded">Information</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/addDepartment" class="link-dark rounded">Add New Department</a></li>
                </ul>
              </div>
            </li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#emplyoee-collapse" aria-expanded="false">
              Employee
              </button>
              <div class="collapse" id="emplyoee-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/employeesection" class="link-dark rounded">Employee Information</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/addEmployee" class="link-dark rounded">Register New Employee</a></li>
                </ul>
              </div>
            </li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#manager-collapse" aria-expanded="false">
              Manager
              </button>
              <div class="collapse" id="manager-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/main" class="link-dark rounded">Manager Information</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/addManager" class="link-dark rounded">Register New Manager</a></li>
                </ul>
              </div>
            </li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#system-account-collapse" aria-expanded="false">
              System Accounts
              </button>
              <div class="collapse" id="system-account-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/accountemployee" class="link-dark rounded">Employee</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/accountmanager" class="link-dark rounded">Manager</a></li>
                </ul>
              </div>
            </li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#title-collapse" aria-expanded="false">
              Title/Position
              </button>
              <div class="collapse" id="title-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/titlesection" class="link-dark rounded">Information</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/addTitle" class="link-dark rounded">Add New Title</a></li>
                </ul>
              </div>
            </li>
            <li class="border-top my-3"></li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
              Account
              </button>
              <div class="collapse" id="account-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/profile?id=${user.id}" class="link-dark rounded">Profile</a></li>
                  <li><a href="${pageContext.request.contextPath}/logout" class="link-dark rounded">Sign out</a></li>
                </ul>
              </div>
            </li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="col-10">
      <div class="row">
        <div class="col" style="background-color: #adf; height: 50px; display: block; position: relative;">
          <a href="${pageContext.request.contextPath}/logout">
            <img src="${pageContext.request.contextPath}/img/log-out.svg" alt="" width="40" height="40" class="float-end mt-1">
          </a>
        </div>
      </div>
      <div class="row">
        <section class="col-6 form-container">
          <form id="password-form">
            <div class="row mt-2 px-2">
              <h3 class="text-center">Change Employee Password</h3><hr>
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
                <button type="button" class="btn btn-primary btn-lg btn-width-2" onclick="submitAndRedirect('password-form', '${pageContext.request.contextPath}/admin/submitEmployeePassword');">Submit</button> 
                <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Clear</button> 
              </div>
            </div> 
          </form>
        </section>
      </div>
    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
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
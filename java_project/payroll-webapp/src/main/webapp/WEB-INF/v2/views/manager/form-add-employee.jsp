<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Add Employee Form</title>
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
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light">
          <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/main" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-group-solid.svg" width="16" height="16"></object>
                Employee Information
              </a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/salarysection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-salary.svg" width="16" height="16"></object>
                Employee Salary
              </a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/promotionsection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-promote.svg" width="18" height="18"></object>
                Promote Information
              </a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/promoteEmployee" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-add.svg" width="16" height="16"></object>
                Promote Employee
              </a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/addEmployee" class="nav-link active" aria-current="page">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-add.svg" width="16" height="16"></object>
                Register New Employee
              </a>
            </li>
            <li class="border-top my-2"></li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/issueSalary" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/payroll-issue.svg" width="16" height="16"></object>
                Issue Payroll
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/payrollsection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/payroll-statement.svg" width="16" height="16"></object>
                Payroll Statements
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/leavesection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/leave-section.svg" width="16" height="16"></object>
                Leave Section
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/loansection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/loan-section.svg" width="16" height="16"></object>
                Loan Section
              </a>
            </li>
            <li class="border-top my-2"></li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/resignsection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/resign-information.svg" width="16" height="16"></object>
                Resignation Information
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/issueResignation" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/resign-issue.svg" width="16" height="16"></object>
                Issue Resignation
              </a>
            </li>
            <li class="border-top my-2"></li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/trainingsection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/training-information.svg" width="16" height="16"></object>
                Training Information
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/issueTraining" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/resign-issue.svg" width="16" height="16"></object>
                Issue Training
              </a>
            </li>
          </ul>
          <hr>
          <div class="dropdown">
            <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown" aria-expanded="false">
              <img src="${pageContext.request.contextPath}/img/profile-template.png" alt="" width="32" height="32" class="rounded-circle me-2">
              <!-- <object type="image/svg+xml" data="./img/icons/manager-account.svg" width="32" height="32" class="rounded-circle me-2"></object> -->
              <strong>${user.fullname}</strong>
            </a>
            <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/manager/profile?id=${user.id}">Profile</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Sign out</a></li>
            </ul>
          </div>
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
      <section class="row form-container">
        <div class="row mt-2">
          <h2 class="text-center">Add Employee Form</h2>
        </div>
        <div class="row px-5">
          <form id="employee-form">
            <div class="row mb-3">
              <h4>Personal Information</h4><hr>
            </div>
            <div class="row mb-3">
              <div class="col-6">
                <label for="fullname" class="col-form-label">Full Name</label>
                <input type="text" class="form-control" id="fullname" name="fullname" required/>
              </div>
              <div class="col-3">
                <div class="row">
                  <label for="gender" class="col-form-label">Gender</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="gender" id="gender" value="MALE">
                  <label class="form-check-label" for="gender">Male</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="gender" id="gender" value="FEMALE">
                  <label class="form-check-label" for="gender">Felame</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="gender" id="gender" value="OTHER">
                  <label class="form-check-label" for="gender">Other</label>
                </div>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-2">
                <label for="age" class="col-form-label">Age</label>
                <input type="number" class="form-control" id="age" name="age" min="18" max="99" required/>
              </div>
              <div class="col-2">
                <label for="martial-status" class="col-form-label">Martial Status</label>
                <select class="form-select" aria-label="martial-status" id="martial-status" name="martial-status">
                  <option selected>--SELECT--</option>
                  <option value="SINGLE">SINGLE</option>
                  <option value="MARRIED">MARRIED</option>
                </select>
              </div>
              <div class="col-3">
                <label for="education" class="col-form-label">Education Level</label>
                <input type="text" class="form-control" id="education" name="education" required/>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-6">
                <label for="address" class="col-form-label">Home Address</label>
                <input type="text" class="form-control" id="address" name="address" required/>
              </div>
              <div class="col-3">
                <label for="state" class="col-form-label">State</label>
                <select class="form-select" aria-label="state" id="state" name="state">
                  <option selected>--SELECT--</option>
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
              <div class="col-3">
                <label for="country" class="col-form-label">Country</label>
                <input type="text" class="form-control" id="country" name="country" value="Malaysia" required/>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-4">
                <label for="phone" class="col-form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" required/>
              </div>
              <div class="col-4">
                <label for="email" class="col-form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" required/>
              </div>
              <div class="col-4">
                <label for="hirer" class="col-form-label">Hirer</label>
                <input type="text" class="form-control" id="hirer" name="hirer" value="${user.fullname}" readonly/>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-4">
                <label for="department" class="col-form-label">Department</label>
                <select class="form-select" aria-label="department" id="department" name="department">
                  <option selected>--SELECT--</option>
                  <c:forEach var="dept" items="${deptList}">
                    <option value="${dept.departmentName}">${dept.id}, ${dept.departmentName}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="col-4">
                <label for="title" class="col-form-label">Title</label>
                <select class="form-select" aria-label="title" id="title" name="title">
                  <option selected>--SELECT--</option>
                  <c:forEach var="title" items="${titleList}">
                    <option value="${title.titleName}">${title.id}, ${title.titleName}</option>
                  </c:forEach>
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-3">
                <label for="base-salary" class="col-form-label">Basic Salary</label>
                <input type="number" class="form-control" id="base-salary" name="base-salary" min="0" step="any" required/>
              </div>
            </div>
            <div class="row mb-3 mt-4">
              <h4>User Login Account</h4><hr>
            </div>
            <div class="row mb-3">
              <div class="col-4">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" required/>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-4">
                <label for="password" class="col-form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" minlength="8" maxlength="20" required/>
              </div>
              <div class="form-text" id="validate-text"></div>
            </div>
            <div class="row mb-3">
              <div class="col-4">
                <label for="c_password" class="col-form-label">Confirmed Password</label>
                <input type="password" class="form-control" id="c_password" name="c_password" minlength="8" maxlength="20" required/>
              </div>
              <div class="form-text" id="match-text"></div>
            </div>
            <div class="row mb-3">
              <div class="text-center">
                <button type="button" class="btn btn-primary btn-lg btn-width-2" onclick="submitAndReload('employee-form', '${pageContext.request.contextPath}/manager/submitEmployee');">Submit</button> 
                <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Clear</button> 
              </div>
            </div>          
          </form>
        </div>
      </section>
    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
<script>
  $('#password, #c_password').keyup(function(e) {
    var pass = $('#password').val();
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
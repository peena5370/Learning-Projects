<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - User's Profile</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>

<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-3">
      <nav>
        <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark">
          <header>
            <img src="${pageContext.request.contextPath}/img/profile-template.png">
            <p>${user.fullname}</p>
          </header>
          <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/employee/main/${user.id}" class="nav-link text-white">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-home.svg" width="16" height="16"></object>
                Home
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/employee/training?name=${user.fullname}" class="nav-link text-white">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-training-white.svg" width="16" height="16"></object>
                Training Information
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/employee/leave?name=${user.fullname}" class="nav-link text-white">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-leave.svg" width="16" height="16"></object>
                Attendance/Leave
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/employee/loan?name=${user.fullname}" class="nav-link text-white">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-loan-white.svg" width="16" height="16"></object>
                Loan Statements/Applications
              </a>
            </li>
          </ul>
          <hr>
          <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown" aria-expanded="false">
              <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-account-white.svg" width="32" height="32"></object>
              <strong>Account</strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/employee/profile?id=${user.id}">Profile</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Sign out</a></li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    <div class="col-9">
      <div class="row">
        <div class="col" style="background-color: #adf; height: 50px; display: block; position: relative;">
          <a href="${pageContext.request.contextPath}/logout">
            <img src="${pageContext.request.contextPath}/img/log-out.svg" alt="" width="40" height="40" class="float-end mt-1">
          </a>
        </div>
      </div>
      <div class="row">
        <section class="col form-container">
          <div class="mt-2">
            <h3>User's Profile</h3><hr>
          </div>

          <!-- Contact detail -->
          <form class="file-upload" action="${pageContext.request.contextPath}/employee/submitUpdateProfile">
            <div class="row mb-5 gx-5">
              <div class="col-xxl-8 mb-5 mb-xxl-0">
                <div class="bg-secondary-soft px-4 py-5 rounded">
                  <div class="row g-3">
                    <h4 class="mb-4 mt-0">Contact Details</h4>
                    <div class="col-md-6">
                      <label class="col-form-label">ID</label>
                      <input type="text" class="form-control" aria-label="user-id" value="${user.id}" id="id" name="id" readonly>
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Full Name <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="user-name" id="fullname" name="fullname" value="${user.fullname}">
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Gender <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="gender" id="gender" name="gender" value="${user.gender}">
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Age <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="age" id="age" name="age" value="${user.age}">
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Martial Status <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="martial-status" id="martial-status" name="martial-status" value="${user.martialStatus}">
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Education Level <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="education" id="education" name="education" value="${user.education}">
                    </div>
                    <div class="col-md-12">
                      <label class="col-form-label">Home Address <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="address" id="address" name="address" value="${user.address}">
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">State <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="state" id="state" name="state" value="${user.state}">
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Country <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="country" id="country" name="country" value="${user.country}">
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Job Title</label>
                      <input type="text" class="form-control" aria-label="title" id="title" name="title" value="${user.title}" readonly>
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Department</label>
                      <input type="text" class="form-control" aria-label="department" id="department" name="department" value="${user.department}" readonly>
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Phone Number <span style="color: #f00;">*</span></label>
                      <input type="text" class="form-control" aria-label="phone" id="phone" name="phone" value="${user.phone}">
                    </div>
                    <div class="col-md-6">
                      <label for="inputEmail4" class="col-form-label">Company Email <span style="color: #f00;">*</span></label>
                      <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                    </div>
                    <div class="col-md-6">
                      <label class="col-form-label">Service Start Date</label>
                      <input type="text" class="form-control" aria-label="dateHired" id="dateHired" name="dateHired" value="${user.dateHired}" readonly>
                    </div>
                    <div class="col-md-12 mt-3">
                      <button type="button" class="submit-btn btn btn-outline-primary">Edit Information</button>
                    </div>
                  </div>
                </div>
              </div>
              
              <!-- Upload profile -->
              <div class="col-xxl-4">
                <div class="bg-secondary-soft px-4 py-5 rounded">
                  <div class="row g-3">
                    <h4 class="mb-4 mt-0">Upload profile photo</h4>
                    <div class="text-center">
                      <div class="square position-relative display-2 mb-3">
                        <i class="fas fa-fw fa-user position-absolute top-50 start-50 translate-middle text-secondary"></i>
                      </div>
                      <input type="file" id="customFile" name="file" hidden="">
                      <label class="btn btn-success-soft btn-block" for="customFile">Upload</label>
                      <button type="button" class="btn btn-danger-soft">Remove</button>
                      <p class="text-muted mt-3 mb-0"><span class="me-1">Note:</span>Minimum size 300px x 300px</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </form>

          <!-- change password -->
          <form class="file-upload" action="${pageContext.request.contextPath}/employee/updateProfilePassword">
            <div class="row mb-5 gx-5">
              <div class="col-xxl-8">
                <div class="bg-secondary-soft px-4 py-5 rounded">
                  <div class="row g-3">
                    <h4 class="mb-4">Change Password</h4>
                    <div class="col-md-6">
                      <label for="old_password" class="col-form-label">Old password <span style="color: #f00;">*</span></label>
                      <input type="password" class="form-control" id="old_password" name="old_password" required>
                    </div>
                    <div class="col-md-6">
                      <label for="new_password" class="col-form-label">New password <span style="color: #f00;">*</span></label>
                      <input type="password" class="form-control" id="new_password" name="new_password" required>
                      <div class="form-text" id="validate-text"></div>
                    </div>
                    <div class="col-md-12">
                      <label for="c_password" class="col-form-label">Confirm Password <span style="color: #f00;">*</span></label>
                      <input type="password" class="form-control" id="c_password" name="c_password" required>
                      <div class="form-text" id="match-text"></div>
                    </div>
                  </div>
                  <div class="col-md-6 mt-3">
                    <button type="button" class="submit-btn btn btn-outline-primary">Change Password</button>
                  </div>
                </div>  
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
  
  $('.submit-btn').click(function(e) {
    var form = $(this).closest('form');
    var obj = form.serialize();
    $.ajax({
      async: false,
      type: "POST",
      url: form.attr('action'),
      contentType: "application/x-www-form-urlencoded; charset=utf-8",
      data: obj,
      dataType: "json",
      success: function(data) {
        if(data.status==="success") {
          alert(data.msg);
          window.location.href = "${pageContext.request.contextPath}" + data.httpUrl;
        } else {
          alert(data.msg);
        }
      },
      error: function() {
        alert('Submit failed, please try again later.');
      }
    });
  });
</script>
</body>
</html>
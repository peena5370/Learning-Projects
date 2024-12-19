<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Add Manager Form</title>
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
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav me-auto mb-2 my-lg-0">
          <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/v2/admin/view-manager">Main</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/admin/view-employee">Employee Section</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Account Section
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/admin/view-account-employee">Employee Account</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/admin/view-account-manager">Manager Account</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/admin/view-title">Title Section</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/admin/view-department">Department Section</a>
          </li>
          <li class="nav-item">
            <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="${pageContext.request.contextPath}/v2/admin/profile?id=${user.id}">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="${pageContext.request.contextPath}/user-logout">Logout</a>
          </li>
        </ul>
      </div>
      <div class="btn-group float-right d-none d-lg-block">
        <img src="${pageContext.request.contextPath}/resources/images/user-solid.svg" class="profile-btn opacity-3" id="btnGroupDrop1" data-bs-toggle="dropdown" aria-expanded="false">
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="btnGroupDrop1">
            <li><p class="dropdown-item">${user.fullname}</p></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/admin/profile?id=${user.id}"><img src="${pageContext.request.contextPath}/resources/images/info.svg" class="opacity-3">&nbsp;&nbsp;Profile</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user-logout"><img src="${pageContext.request.contextPath}/resources/images/log-out.svg" class="opacity-3">&nbsp;&nbsp;Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container form-container">
  	<div class="row mb-5 mt-2">
      <h2 class="text-center">Add Manager Form</h2>
  	</div>
    <div class="row px-5">
        <form action="${pageContext.request.contextPath}/v2/admin/form/submit/submitManager" method="POST">
          <div class="row mb-3">
            <h4>Personal Information</h4>
            <hr>
          </div>
          <div class="row mb-3">
            <div class="col-6">
              <label for="fullname" class="col-form-label">Full Name</label>
              <input type="text" class="form-control" id="fullname" name="fullname" required/>
            </div>
            <div class="col-4">
              <div class="row">
                <label for="role" class="col-form-label">Role</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="role" id="role" value="Administrator">
                <label class="form-check-label" for="role">Administrator</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="role" id="role" value="Manager" checked>
                <label class="form-check-label" for="role">Manager</label>
              </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
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
            <div class="col-2">
              <label for="age" class="col-form-label">Age</label>
              <input type="number" class="form-control" id="age" name="age" required/>
            </div>
            <div class="col-2">
              <label for="martial-status" class="col-form-label">Martial Status</label>
              <select class="form-select" aria-label="martial-status" id="martial-status" name="martial-status">
                <option selected>--SELECT--</option>
                <option value="SINGLE">SINGLE</option>
                <option value="MARRIED">MARRIED</option>
              </select>
            </div>
            <div class="col-4">
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
          <div class="row mb-3 mt-4">
            <h4>User Login Account</h4>
            <hr>
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
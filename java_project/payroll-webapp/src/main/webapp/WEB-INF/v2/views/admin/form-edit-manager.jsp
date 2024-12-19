<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Update Manager Information Form</title>
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
        <section class="form-container">
          <form id="manager-form">
            <div class="row mb-3">
              <h4>Update Manager Information Form</h4><hr>
            </div>
            <div class="row mb-3">
              <div class="col-6">
                <label for="id" class="col-form-label">Manager ID</label>
                <input type="text" class="form-control" id="id" name="id" value="${manager.id}" readonly/>
              </div>
              <div class="col-6">
                <label for="fullname" class="col-form-label">Full Name</label>
                <input type="text" class="form-control" id="fullname" name="fullname" value="${manager.fullname}" required/>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-4">
                <label for="gender" class="col-form-label">Gender</label>
                <input type="text" class="form-control" id="gender" name="gender" value="${manager.gender}" required/>
              </div>
              <div class="col-2">
                <label for="age" class="col-form-label">Age</label>
                <input type="number" class="form-control" id="age" name="age" value="${manager.age}" min="18" max="99" required/>
              </div>
              <div class="col-2">
                <label for="martial-status" class="col-form-label">Martial Status</label>
                <input type="text" class="form-control" id="martial-status" name="martial-status" value="${manager.martialStatus}" required/>
              </div>
              <div class="col-4">
                <label for="education" class="col-form-label">Education Level</label>
                <input type="text" class="form-control" id="education" name="education" value="${manager.education}" required/>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-6">
                <label for="address" class="col-form-label">Home Address</label>
                <input type="text" class="form-control" id="address" name="address" value="${manager.address}" required/>
              </div>
              <div class="col-3">
                <label for="state" class="col-form-label">State</label>
                <input type="text" class="form-control" id="state" name="state" value="${manager.state}" required/>
              </div>
              <div class="col-3">
                <label for="country" class="col-form-label">Country</label>
                <input type="text" class="form-control" id="country" name="country" value="${manager.country}" required/>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-4">
                <label for="phone" class="col-form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${manager.phone}" required/>
              </div>
              <div class="col-4">
                <label for="email" class="col-form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" value="${manager.email}" required/>
              </div>
            </div>
            <div class="row mb-3">
              <div class="text-center">
                <button type="button" class="btn btn-primary btn-lg btn-width-2" onclick="submitAndRedirect('manager-form', '${pageContext.request.contextPath}/admin/submitUpdateManager');">Submit</button> 
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
</body>
</html>
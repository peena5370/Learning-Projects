<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Training Section</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fullcalendar/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/js/fullcalendar/main.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
  <script>
    document.addEventListener('DOMContentLoaded', function() {
	    var calendarEl = document.getElementById('calendar');

	    var calendar = new FullCalendar.Calendar(calendarEl, {
  	    headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
	      displayEventEnd: true,
	      allDay: true,
	      nextDayThreshold: '00:00:00',
	      eventDidMount: function (info) {
          $(info.el).tooltip({
              title: info.event.extendedProps.description,
              placement: 'auto',
              trigger: 'hover',
              container: 'body'
          });
	      },
	      eventClick: function(info) {
	    	  if (confirm("Training completed?")) {
	    		  location.href='${pageContext.request.contextPath}/employee/submitTraining?id=' + info.event.id + '&status=COMPLETED&name=${user.fullname}';
	    		  // console.log('Event: ' + info.event.title + 'id: ' + info.event.id);
          } else {
            return false;
          }
	      }, 
	      events: ${json},
	      eventColor: '#5CB3FF'
	    });

	    calendar.render();
	  });
  </script>
  <style>
  #calendar a{
  	text-decoration: none;
  	color: black;
  }
  </style>
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
              <a href="${pageContext.request.contextPath}/employee/training?name=${user.fullname}" class="nav-link active" aria-current="page">
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
      <section class="row">
        <div class="row">
          <h3>Training Section</h3><hr>
        </div>
        <div class="row">
          <div id='calendar'></div>
        </div> 
      </section>
    </div>
  </div>
</div>
</body>
</html>
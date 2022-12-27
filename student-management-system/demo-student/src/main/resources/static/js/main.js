//Function view student table
function viewStudent(table) {
    $.getJSON($contextPath + 'student/list', function(resp) {
  // $.getJSON('http://localhost:8000/spring-boot-demo/student/list', function(resp) {
    var $table = $(table);
    $(function() {
      var data = resp;
      $table.bootstrapTable({
        data: data,
        columns: [
          {title: 'ID', field: 'id', align: 'center'},
          {title: 'Student Name', field: 'studName'},
          {title: 'Date Of Birth', field: 'dateOfBirth'},
          {title: 'Class Room', field: 'studClass'},
          {title: 'Race', field: 'race'},
          {title: 'Nationality', field: 'nationality'},
          {title: 'Action', field: 'action', align: 'left', valign: 'middle', clickToSelect: false,
          formatter: function(value, row, index) {
            return  "<div class='layui-btn-group'>" + 
                    "<button class='btn btn-outline-info' onclick='javascript:editStudent(" + row.id + ")'>Edit</button>" + 
                    "<button class='btn btn-outline-danger' onclick='javascript:removeStudent(" + row.id + ")'>Delete</button>" + 
                    "</div>"
          }}
        ],
      })
    })
  });
}

// Function submit student information
function submitStudent() {
  var data = {
    studName: $("#Modal1 input[name='stud-name']").val(),
    dateOfBirth: $("#Modal1 input[name='dob']").val(),
    studClass: $("#Modal1 input[name='class']").val(),
    race: $("#Modal1 input[name='race']").val(),
    nationality: $("#Modal1 input[name='nationality']").val()
  };
  console.log(data);
  $.ajax({
    type: "POST",
    url: $contextPath + "student/insert",
    // url: "http://localhost:8000/spring-boot-demo/student/insert",
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(data),
    success: function (resp) {
      switch(resp) {
        case 1:
          alert('Information inserted.');
          location.reload();
          break;
        case 0:
          alert('Fail to insert information.');
          location.reload();
          $('#Modal1').modal('hide');
          break;
        default:
          break;
      }
    },
    error: function (err) {
      console.log(err);
    }
  });
}

// Function load edit student information
function editStudent(id) {
  $.getJSON($contextPath + 'student/list/' + id, function(resp){
    // $.getJSON('http://localhost:8000/spring-boot-demo/student/list/' + id, function(resp){
    $("#Modal2 input[name='id']").val(resp.id);
    $("#Modal2 input[name='stud-name']").val(resp.studName);
    $("#Modal2 input[name='dob']").val(resp.dateOfBirth);
    $("#Modal2 input[name='class']").val(resp.studClass);
    $("#Modal2 input[name='race']").val(resp.race);
    $("#Modal2 input[name='nationality']").val(resp.nationality);
    $('#Modal2').modal('show');
  });
}

// Function submit edit student information
function submitEditStudent() {
  var data = {
  id: $("#Modal2 input[name='id']").val(),
  studName: $("#Modal2 input[name='stud-name']").val(),
  dateOfBirth: $("#Modal2 input[name='dob']").val(),
  studClass: $("#Modal2 input[name='class']").val(),
  race: $("#Modal2 input[name='race']").val(),
  nationality: $("#Modal2 input[name='nationality']").val()
  };
  console.log(data);
  $.ajax({
    type: "PUT",
    url: $contextPath + "student/" + data.id + "/update",
    // url: "http://localhost:8000/spring-boot-demo/student/" + data.id + "/update",
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(data),
    success: function (resp) {
      switch(resp) {
        case 1:
          alert('Information updated.');
          location.reload();
          break;
        case 0:
          alert('Fail to update information.');
          location.reload();
          $('#Modal2').modal('hide');
          break;
        default:
          break;
      }
    },
    error: function (err) {
      console.log(err);
    }
  });
}

// Function delete student information
function removeStudent(id) {
  $.ajax({
    type: "DELETE",
    url: $contextPath + "student/" + id + "/delete",
    // url: "http://localhost:8000/spring-boot-demo/student/" + id + "/delete",
    contentType: "application/json; charset=utf-8",
    success: function (res) {
      switch(res) {
        case 1:
          location.reload();
          break;
        case 0:
          alert('Fail to delete information.');
          location.reload();
          break;
        default:
          break;
      }
    },
    error: function (err) {
    console.log(err);
    }
  });
}
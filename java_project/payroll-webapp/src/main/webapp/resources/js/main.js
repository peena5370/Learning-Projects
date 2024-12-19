/* 
  Ajax method POST form
  @param   id   Form id
  @param   url  Form action url
  @return  json
*/
function loginValidate(id, url) {
    var form = $('#' + id);
    var obj = form.serialize();

    $.ajax({
      async: false,
      type: "POST",
      url: url,
      contentType: "application/x-www-form-urlencoded; charset=utf-8",
      data: obj,
      dataType: "json",
      success: function(data) {
        // console.log(data);
        switch(data.code) {
          case 100:
            alert(data.msg);
            break;
          case 103:
            alert(data.msg);
            break;
          case 104:
            alert(data.msg);
            break;
          default:
            window.location.href = "/payroll-webapp" + data.httpUrl;
            break;
        }
      },
      error: function() {
        alert('Error logging into system, please try again.');
      }
    });
}

/* 
  Ajax method POST form and reloading current page
  @param   id   Form id
  @param   url  Form action url
  @return  json
*/
function submitAndReload(id, url) {
  var form = $('#' + id);
  var obj = form.serialize();

  $.ajax({
    async: false,
    type: "POST",
    url: url,
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    data: obj,
    dataType: "json",
    success: function(data) {
      if(data.status==="success") {
        alert(data.msg);
        window.location.reload();
      } else {
        alert(data.msg);
      }
    },
    error: function() {
      alert('Submit failed, please try again later.');
    }
  });
}

/* 
  Ajax method POST form and redirect page to specific page
  @param   id   Form id
  @param   url  Form action url
  @return  json
*/
function submitAndRedirect(id, url) {
  var form = $('#' + id);
  var obj = form.serialize();

  $.ajax({
    async: false,
    type: "POST",
    url: url,
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    data: obj,
    dataType: "json",
    success: function(data) {
      if(data.status==="success") {
        alert(data.msg);
        window.location.replace("/payroll-webapp" + data.httpUrl);
      } else {
        alert(data.msg);
      }
    },
    error: function() {
      alert('Submit failed, please try again later.');
    }
  });
}

/* 
  Ajax method POST form and close current page after submit form
  @param   id   Form id
  @param   url  Form action url
  @return  json
*/
function submitAndClose(id, url) {
  var form = $('#' + id);
  var obj = form.serialize();

  $.ajax({
    async: false,
    type: "POST",
    url: url,
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    data: obj,
    dataType: "json",
    success: function(data) {
      if(data.status==="success") {
        alert(data.msg);
        window.close();
        window.opener.location = "/payroll-webapp" + data.httpUrl;
      } else {
        alert(data.msg);
      }
    },
    error: function() {
      alert('Submit failed, please try again later.');
    }
  });
}

/* 
  Open new page
  @param  url  Redirecting page url
*/
function openWindow(url) {
  openWindow = window.open(url,'_self','height=700,width=950,left=250,top=250,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

/* 
  Open pop up window
  @param  url  Popup window url
*/
function openPopUpWindow(url) {
  openWindow = window.open(url,'_blank','height=600,width=850,left=250,top=250,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

/* 
  Alert message for button click
  @param  url Url for page redirect after user click OK button
*/
function deleteAlertMsg(url) {
  if (confirm("Confirm Delete? There's no way to revert after deleting it.")) {
    window.location.href=url;
  } else {
    return false;
  }
}
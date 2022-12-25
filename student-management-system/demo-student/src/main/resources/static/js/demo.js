//浏览商品
function viewGoods() {
    var row = "";
    //先清空表格
    $('#GoodsTable').find("tr:gt(0)").remove();
    $.ajax({
    type: "GET",
    url: "http://localhost:8000/spring-boot-hello/goods",
    dataType: "json",
    contentType: "application/json; charset=utf-8",
    success: function (res) {
    console.log(res);
    $.each(res, function (i, v) {
    row = "<tr>";
    row += "<td>" + v.id + "</td>";
    row += "<td>" + v.name + "</td>";
    row += "<td>" + v.price + "</td>";
    row += "<td>" + v.pic + "</td>";
    row += "<td><a class='btn btn-primary btn-sm' href='javascript:editGoods(" + v.id + ")' >编辑</a>";
    row += "<a class='btn btn-danger btn-sm' href='javascript:removeGoods(" + v.id + ")' >删除</a></td>";
    row += "</tr>";
    console.log(row);
    $("#GoodsTable").append(row);
    });
    },
    error: function (err) {
    console.log(err);
    }
    });
    }
    //删除
    function removeGoods(id) {
    console.log(id);
    $.ajax({
    type: "DELETE",
    url: "http://localhost:8000/spring-boot-hello/goods/" + id,
    //dataType: "json",//由于删除方法无返回值,所以此处注释掉
    contentType: "application/json; charset=utf-8",
    success: function () {
    //删除后重新加载
    viewGoods();
    },
    error: function (err) {
    console.log(err);
    }
    });
    }
    //新增
    function addGoods() {
    $('#GoodsAddModal').modal('show');
    }
    //新增提交
    function addGoodsSubmit() {
    var data = {
    id: '',
    name: $("#GoodsAddModal input[name='name']").val(),
    
    price: $("#GoodsAddModal input[name='price']").val(),
    pic: $("#GoodsAddModal input[name='pic']").val()
    };
    $.ajax({
    type: "POST",
    url: "http://localhost:8000/spring-boot-hello/goods",
    //dataType: "json",
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(data), //需要将对象转换为字符串提交
    success: function () {
    //新增后重新加载
    viewGoods();
    //关闭弹窗
    $('#GoodsAddModal').modal('hide');
    },
    error: function (err) {
    console.log(err);
    }
    });
    }
    //编辑
    function editGoods(id) {
    //查询商品信息
    $.ajax({
    type: "GET",
    url: "http://localhost:8000/spring-boot-hello/goods/" + id,
    dataType: "json",
    contentType: "application/json; charset=utf-8",
    success: function (res) {
    console.log(res);
    //为编辑框赋值
    $("#GoodsEditModal input[name='id']").val(res.id);
    $("#GoodsEditModal input[name='name']").val(res.name);
    $("#GoodsEditModal input[name='price']").val(res.price);
    $("#GoodsEditModal input[name='pic']").val(res.pic);
    //显示编辑弹窗
    $('#GoodsEditModal').modal('show');
    },
    error: function (err) {
    console.log(err);
    }
    });
    }
    
    //编辑提交
    function editGoodsSubmit() {
    var data = {
    id: $("#GoodsEditModal input[name='id']").val(),
    name: $("#GoodsEditModal input[name='name']").val(),
    price: $("#GoodsEditModal input[name='price']").val(),
    pic: $("#GoodsEditModal input[name='pic']").val()
    };
    $.ajax({
    type: "PUT",
    url: "http://localhost:8000/spring-boot-hello/goods/" + data.id,
    //dataType: "json",
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(data), //需要将对象转换为字符串提交
    success: function () {
    //新增后重新加载
    viewGoods();
    //关闭弹窗
    $('#GoodsEditModal').modal('hide');
    },
    error: function (err) {
    console.log(err);
    }
    });
    }
mainPath = "";

$("document").ready(function(){
	$("#btn1").click(function(){
		var sid =  $("#getStudentId").val();
		var path = "http://localhost:8080/StudentMessage/student/"+sid;
		console.log(path);//测试数据正确与否
		$.ajax({
		    url: path,
		    type: "POST",
		    dataType : "json",
		})		  
		  .done(function(json) {
		  	var htmlContent = "";
		  	$.each(json,function(name,value) {
				htmlContent = htmlContent+"<strong>"+name+":"+"</strong>";
				htmlContent = htmlContent+value+"<br>";
				});
		     $("#find2").html(htmlContent);
		  })
		  .fail(function(){
			 alert("404");
		  });
	});
	
	//列表按钮重定向
	$("#btn2").click(function(){
		window.location = "http://localhost:8080/StudentMessage/student/list";
	});
	
	$("#btn3").click(function(){
		var path = $("#hid").val();
		window.location = "http://localhost:8080"+path;
	});
	
	$("#btn4").click(function(){
		var path = $("#hid").val();
		path = "http://localhost:8080"+path;
		mainPath = path;
		$.ajax({
		    url: path,
		    type: "DELETE",
		    dataType : "html",
		})		  
		  .done(function(html){
			  alert(html);
			  window.location = "http://localhost:8080/StudentMessage/student/list";
		  })
		  .fail(function(){
			 alert("UNKNOWN ERROR");
		  });
	});
	
	$("#update").click(function(){
		$.ajax({
		    url: mainPath,
		    type: "PUT",
		    contentType: 'application/json',
		    data: JSON.stringify({
		    	id:$("#id").val(),
		    	name:$("#name").val(),
		    	age:$("#age").val(),
		    	major:$("#major").val(),
		    	classRoom:$("#classRoom").val()
		    }),
		    dataType : "html",
		})		  
		  .done(function(html){
			  alert(html);
			  window.location = "http://localhost:8080/StudentMessage/student/list";
		  })
		  .fail(function(){
			 alert("UNKNOWN ERROR");
		  });
	});
	
});
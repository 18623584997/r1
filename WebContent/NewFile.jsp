<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script type="text/javascript">
  $(function(){
	  $.ajax({
		  url:'http://127.0.0.1:7140/api/easyhome/adv/getAdvList',
		  data:{adsTyp:["1","2","3"],communityId:'12345'},
		  type:'get',
		  dataType:'json',
		  success:function(data){
			  alert(1)
			  alert(data)
		  },
		  error:function(){
			  alert(1)
		  }
	  })
  })

</script>
</head>
<body>

</body>
</html>
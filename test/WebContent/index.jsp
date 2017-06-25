<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	var oldstr = "1+2";
	$(function(){
		var strsize = oldstr.length;
		for (var i = 1; i <= strsize; i++) {
			alert(oldstr.substring(i-1, i));
		}
	})
	</script>
</head>
<body>
	asdasd
</body>
</html>
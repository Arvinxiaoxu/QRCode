<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery.qrcode.min.js"></script>
</head>
<body>
这是用js生成的二维码图片<br>
<div id="qrcode"></div>

<script>
	jQuery("#qrcode").qrcode("www.baidu.com");
</script>
</body>
</html>
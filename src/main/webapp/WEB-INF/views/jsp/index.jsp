<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Welcome</title>
		
	</head>
	<body>
		Greeting : ${msg}
		<br/>
		<iframe id="Botservice" src="${secret}" height="500" width="500"></iframe>
		<br/>
		sample input img:
		<br/>
		<img style="-webkit-user-select: none;" src="${img}">
		<br/>
		Face detection result: 
		<br/>
		${faceDetectionResult}
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Create New Lead</h2>
	<form action ="SaveReg" method="post"> 
		<pre>
			first Name<input type="text" name="firstname"/>
			second Name<input type="text" name="secondname"/>
			course <input type="text" name="course"/>
			fee <input type="text" name="fee"/>
			<input type="submit" value="save"/>		
		</pre>
	</form>
	${msg}

</body>
</html>
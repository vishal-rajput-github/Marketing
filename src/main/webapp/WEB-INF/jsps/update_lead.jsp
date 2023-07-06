<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>UpdateLead</h2>
	<form action ="editReg" method="post"> 
		<pre>
			<input type="hidden" name="id" value="${lead.id}"/>
			first Name<input type="text" name="firstname" value="${lead.firstname}"/>
			second Name<input type="text" name="secondname" value="${lead.secondname}"/>
			course <input type="text" name="course" value="${lead.course}"/>
			fee <input type="text" name="fee" value="${lead.fee}"/>
			<input type="submit" value="update"/>		
		</pre>
	</form>
	${msg}

</body>
</html>
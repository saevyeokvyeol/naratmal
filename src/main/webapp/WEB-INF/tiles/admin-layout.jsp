<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>나랏:말</title>
	</head>
	<body>
		<header>
			<tiles:insertAttribute name="admin-header"/>
		</header>
		<section>
			<tiles:insertAttribute name="admin-content"/>
		</section>
	</body>
</html>
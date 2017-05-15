<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/globalCSS.css" />
</head>

<body>

<div class="form-style-10">
    
     <p><c:out value="${gamesWithReds}"></c:out></p>
     <p><c:out value="${gamesWithReds.size()}"></c:out></p>
     
     			<b>Matches Officiated (${games.size()})</b>
     

    
    <div class="section"><span>3</span>REDS</div>
    <div class="inner-wrap">
        <label><b>Matches with more than 1 red card (${gamesWithReds.size()})</b></label>
    </div>
     
    </div>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<title>Lunit_EXAM</title>

<h2>SIMPLE PAGE FOR TEST</h2>

<hr>
<hr>

<h3>Slide Upload</h3>

<form method="POST" action="/api/slides" enctype="multipart/form-data">
    <input type="file" name="file" /><br />
    <br /> <input type="submit" value="Submit" />
</form>

<hr><hr>

<h3>List of your slides</h3>
<c:forEach var="slide" items="${slides}">

    <a href="/api/slides" >조회 가능한 모든 슬라이드</a>

</c:forEach>
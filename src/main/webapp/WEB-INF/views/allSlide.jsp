<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<title>Simple page</title>

<h2>SIMPLE PAGE FOR TEST</h2>

<hr>
<hr>

<h3> Downloadable All Slide </h3>


<h3>List of your slides</h3>
<c:forEach var="slide" items="${slides}">

    <a href="/api/slides/download/${slide.id}" >${slide.fileName} << 다운로드 </a>
    <br>

</c:forEach>
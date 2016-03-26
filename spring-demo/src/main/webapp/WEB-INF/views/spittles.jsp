<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<P>Kolejny sukces: ${age}</P>
<c:out value="${spittle.message}"/>

<c:forEach items="${spittleList}" var="spittle" >
<c:out value="${spittle.message}"/>
</c:forEach>
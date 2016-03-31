<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<P>My form</P>

<sf:form method="POST" commandName="arekModleAtttribueName">
First Name: <sf:input  path="firstName" />
<sf:errors path="firstName">NOT VALID</sf:errors>
<br/>
Last Name: <sf:input path="lastName" /><br/>
Username: <sf:input  path="username" /><br/>
Password: <sf:password  path="password" /><br/>
<input type="submit" value="Register" />
</sf:form>
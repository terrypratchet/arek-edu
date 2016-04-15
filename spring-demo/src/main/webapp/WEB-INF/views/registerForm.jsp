<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!-- This enables you to create URL s without worrying about what the servlet context path -->
<%-- will be. The <s:url> tag takes care of it for you. --%>

  <head>
    <title>Arkadiusz</title>
    <link href="<s:url value="/resources/css" />/mycss.css" 
          rel="stylesheet" 
          type="text/css" />
  </head>

<P>My form</P>

<sf:form method="POST" commandName="arekModleAtttribueName">
First Name: <sf:input  path="firstName" />
<sf:errors path="firstName" cssClass="error"/>
<br/>
Last Name: <sf:input path="lastName" /><br/>
Username: <sf:input  path="username" /><br/>
Password: <sf:password  path="password" />
<sf:errors path="password" cssClass="error"/><br/>
<input type="submit" value="Register" />
</sf:form>


<s:escapeBody>
<H1>Example of escaping body</H1>
</s:escapeBody>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8"%><style>
.message{
	font-size:14px;
	text-align: left;
	padding-left: 20px;
}
</style>
<textarea rows="36" cols="140"  class="message">
<c:if test="${not empty result}">${result}</c:if> 
 <c:if test=" ${empty result}">empty string!</c:if>       
</textarea>



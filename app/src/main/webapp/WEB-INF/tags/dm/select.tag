<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ attribute name="typeCode" type="java.lang.String" required="true" description="字典code"%>
<%@ attribute name="defaultValue" type="java.lang.String" description="默认值"%>
<%@ attribute name="selectedValue" type="java.lang.String" description="默认选中"%>
<%@ attribute name="style" type="java.lang.String" description="style属性"%>
<%@ attribute name="cls" type="java.lang.String" description="class属性"%>
<%@ attribute name="name" type="java.lang.String" description="name属性"%>
<select style="${style}" class="${cls}" name="${name}" id="${name}" >
    <option value="${defaultValue}" >请选择...      </option>
    <c:if test="${not empty typeCode}">
        <c:forEach items="${fns:getDictList(typeCode)}" var='dict'>
            <option value='${dict.imenu}' ${selectedValue==dict.imenu?'selected':''}>${dict.menuName}</option>
        </c:forEach>
    </c:if>
</select>
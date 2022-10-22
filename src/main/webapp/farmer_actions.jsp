<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="theme" uri="http://liferay.com/tld/theme" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="entities.FarmerEntity" %>

<portlet:defineObjects />
<theme:defineObjects />

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");

    ResultRow row = (ResultRow) request
            .getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    FarmerEntity farmer = (FarmerEntity) row.getObject();
%>
<portlet:defineObjects />
<theme:defineObjects />

<liferay-ui:icon-menu>

        <portlet:renderURL var="editURL">
            <portlet:param name="farmerId"
                           value="<%=String.valueOf(farmer.getFarmerId()) %>" />
            <portlet:param name="mvcPath"
                           value="/edit_farmer.jsp" />
        </portlet:renderURL>

        <liferay-ui:icon image="edit" message="Edit"
                         url="<%=editURL.toString() %>" />


    <portlet:actionURL name="addFarmer" var="addFarmerURL"></portlet:actionURL>
        <portlet:actionURL name="deleteFarmer" var="deleteURL">
            <portlet:param name="farmerId"
                           value="<%= String.valueOf(farmer.getFarmerId()) %>" />
        </portlet:actionURL>

        <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>

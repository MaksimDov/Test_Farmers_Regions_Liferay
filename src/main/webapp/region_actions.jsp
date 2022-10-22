<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="theme" uri="http://liferay.com/tld/theme" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="entities.RegionEntity" %>

<portlet:defineObjects />
<theme:defineObjects />

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");

    ResultRow row = (ResultRow) request
            .getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    RegionEntity region = (RegionEntity) row.getObject();
%>
<portlet:defineObjects />
<theme:defineObjects />

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="regionId"
                       value="<%=String.valueOf(region.getRegionId()) %>" />
        <portlet:param name="mvcPath"
                       value="/edit_region.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url="<%=editURL.toString() %>" />


    <portlet:actionURL name="addRegion" var="addRegionURL"></portlet:actionURL>
    <portlet:actionURL name="deleteRegion" var="deleteURL">
        <portlet:param name="regionId"
                       value="<%= String.valueOf(region.getRegionId()) %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>

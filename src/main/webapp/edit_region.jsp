<%@ page import="com.liferay.farmerPortlet.model.Region" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.farmerPortlet.service.RegionLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>

<%@ page contentType="text/html;charset=utf-8" %>

<%
    Region region = null;

    long regionId = ParamUtil.getLong(request, "regionId");

    if (regionId > 0) {
        try {
            region = RegionLocalServiceUtil.getRegion(regionId);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }

%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view_region.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name='<%= region== null ? "addRegion" : "updateRegion" %>' var="editRegionURL" />

<aui:model-context bean="<%= region %>" model="<%= Region.class %>" />

<aui:form action="<%= editRegionURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input type="hidden" name="regionId"
                   value='<%= region == null ? "" : region.getRegionId() %>' />
        <aui:input  name="name" />
        <aui:input type="text" label="Название района" name="RegionName"
                   value='<%= region == null ? "" : region.getRegionName() %>'>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input type="text" label="Код района" name="RegionCode" maxlength="2" minlength="2"
                   value='<%= region == null ? "" : region.getRegionCode() %>'>
            <aui:validator name="required"/>
        </aui:input>
        <aui:select label="Статус архивности" name="ArchiveStatus"
                    value='<%= region == null ? "" : region.getArchiveStatus()%>'>>
            <aui:option value="Да">Да</aui:option>
            <aui:option value="Нет">Нет</aui:option>
            <%--            <aui:validator name="required"/>--%>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
    </aui:button-row>
</aui:form>

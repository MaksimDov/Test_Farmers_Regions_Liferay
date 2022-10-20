<%--
  Created by IntelliJ IDEA.
  User: maksim
  Date: 17.10.2022
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects/>


<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addRegion" var="addRegionURL"></portlet:actionURL>

<aui:form action="<%= addRegionURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input label="Название района" name="RegionName">
            <aui:validator name="required"/>
        </aui:input>
        <aui:input label="Код района" name="RegionCode">
            <aui:validator name="required"/>
            <aui:validator name="digits"/>
        </aui:input>
        <aui:select label="Статус архивности" name="ArchiveStatus">
            <aui:option value="Да">Да</aui:option>
            <aui:option value="Нет">Нет</aui:option>
            <%--            <aui:validator name="required"/>--%>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
    </aui:button-row>
</aui:form>


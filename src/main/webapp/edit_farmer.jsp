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

<portlet:actionURL name="addFarmer" var="addFarmerURL"></portlet:actionURL>

<aui:form action="<%= addFarmerURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input label="Название организации" name="CompanyName">
            <aui:validator name="required"/>
        </aui:input>
        <aui:input label="Организационно-правовая форма" name="OrganizationForm">
            <aui:validator name="required"/>
        </aui:input>
        <aui:input label="ИНН" name="INN" maxlength="12" minlength="10">
            <aui:validator name="required"/>
            <aui:validator name="digits"/>
        </aui:input>
        <aui:input label="КПП" name="KPP" maxlength="9" minlength="9">
            <aui:validator name="digits"/>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input label="ОГРН" name="OGRN" maxlength="13" minlength="13">
            <aui:validator name="digits"/>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input label="Район регистрации" name="RegionId">
            <aui:validator name="required"/>
        </aui:input>
        <aui:input label="Район посевных полей" name="FieldRegion">
            <aui:validator name="required"/>
        </aui:input>
        <aui:input label="Дата регистрации" type="date" name="RegistrationDate">
            <aui:validator name="required"/>
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


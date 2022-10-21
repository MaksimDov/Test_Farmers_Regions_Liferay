<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<jsp:useBean id="farmers" class="java.util.ArrayList" scope="request"/>

<liferay-ui:search-container>
    <liferay-ui:search-container-results
            results="<%= farmers %>"
    />

    <liferay-ui:search-container-row
            className="com.liferay.farmerPortlet.model.Farmer"
            modelVar="farmer"
    >
        <liferay-ui:search-container-column-text name="Название организации" property="companyName" />
        <liferay-ui:search-container-column-text name="Организационно-правовая форма" property="organizationForm" />
        <liferay-ui:search-container-column-text name="ИНН" property="inn" />
        <liferay-ui:search-container-column-text name="КПП" property="kpp" />
        <liferay-ui:search-container-column-text name="ОГРН" property="ogrn" />
        <liferay-ui:search-container-column-text name="Район регистрации" property="regionId" />
<%--        <liferay-ui:search-container-column-text name="Районы посевных полей" property="fieldRegion" />--%>
        <liferay-ui:search-container-column-text name="Дата регистрации" property="registrationDate" />
        <liferay-ui:search-container-column-text name="Статус архивности" property="archiveStatus" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:button-row cssClass="farmers-buttons">
    <portlet:renderURL var="addFarmerURL">
        <portlet:param name="mvcPath" value="/edit_farmer.jsp"></portlet:param>
    </portlet:renderURL>

    <aui:button onClick="<%= addFarmerURL.toString() %>" value="Add Farmer">
    </aui:button>
</aui:button-row>
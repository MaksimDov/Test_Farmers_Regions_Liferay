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
<jsp:useBean id="regions" class="java.util.ArrayList" scope="request"/>


<liferay-ui:search-container>
    <liferay-ui:search-container-results
            results="<%= regions %>"
    />

    <liferay-ui:search-container-row
            className="com.liferay.farmerPortlet.model.Region"
            modelVar="region"
    >

        <liferay-ui:search-container-column-text name="Название района" property="regionName" />
        <liferay-ui:search-container-column-text name="Код района" property="regionCode" />
        <liferay-ui:search-container-column-text name="Статус архивности" property="archiveStatus" />




    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:button-row cssClass="regions-buttons">
    <portlet:renderURL var="addRegionURL">
        <portlet:param name="mvcPath" value="/edit_region.jsp"></portlet:param>
    </portlet:renderURL>

    <aui:button onClick="<%= addRegionURL.toString() %>" value="Add region">
    </aui:button>
</aui:button-row>

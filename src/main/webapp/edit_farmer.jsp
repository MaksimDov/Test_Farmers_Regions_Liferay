<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.liferay.farmerPortlet.model.Farmer" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.farmerPortlet.service.FarmerLocalServiceUtil" %>
<%@ page import="com.liferay.farmerPortlet.model.Region" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.farmerPortlet.service.RegionLocalServiceUtil" %>
<%@ page contentType="text/html;charset=utf-8" %>

<%
    Farmer farmer = null;

    long farmerId = ParamUtil.getLong(request, "farmerId");
    System.out.println(farmerId);
    String fieldsName = "";
    if (farmerId > 0) {
        farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
        List<Region> fields = RegionLocalServiceUtil.getFarmerRegions(farmer.getFarmerId());
        for (Region field : fields){
            fieldsName += RegionLocalServiceUtil.getRegion(field.getRegionId()).getRegionName();
            fieldsName += ", ";
        }
        if (fieldsName.length() > 2 && fieldsName.charAt(fieldsName.length() - 2) == ',') {
            fieldsName = (fieldsName.substring(0, fieldsName.length() - 2));
        }
    }

%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name='<%= farmer == null ? "addFarmer" : "updateFarmer" %>' var="editFarmerURL" />

<aui:model-context bean="<%= farmer %>" model="<%= Farmer.class %>" />

<aui:form action="<%= editFarmerURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input type="hidden" name="farmerId"
                   value='<%= farmer == null ? "" : farmer.getFarmerId() %>' />
        <aui:input  name="name" />
        <aui:input type="text" label="Название организации" name="CompanyName"
                   value='<%= farmer == null ? "" : farmer.getCompanyName() %>'>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input type="text" label="Организационно-правовая форма" name="OrganizationForm"
                   value='<%= farmer == null ? "" : farmer.getOrganizationForm() %>'>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input type="text" label="ИНН" name="INN" maxlength="12" minlength="10"
                   value='<%= farmer == null ? "" : farmer.getInn() %>'>
            <aui:validator name="required"/>
            <aui:validator name="digits"/>
        </aui:input>
        <aui:input type="text" label="КПП" name="KPP" maxlength="9" minlength="9"
                   value='<%= farmer == null ? "" : farmer.getKpp() %>'>
            <aui:validator name="digits"/>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input type="text" label="ОГРН" name="OGRN" maxlength="13" minlength="13"
                   value='<%= farmer == null ? "" : farmer.getOgrn() %>'>
            <aui:validator name="digits"/>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input type="text" label="Район регистрации" name="RegionId"
                   value='<%= farmer == null ? "" : farmer.getRegionId()%>'>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input type="text" label="Район посевных полей(Через ',')" name="FieldRegion"
                   value='<%= farmer == null ? "" : fieldsName %>'>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input label="Дата регистрации" type="date" name="RegistrationDate"
                   value='<%= farmer == null ? "" : farmer.getRegistrationDate()%>'>>
            <aui:validator name="required"/>
        </aui:input>
        <aui:select label="Статус архивности" name="ArchiveStatus"
                    value='<%= farmer == null ? "" : farmer.getArchiveStatus()%>'>>
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








<%--<%@ page contentType="text/html;charset=utf-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>--%>
<%--<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>--%>
<%--<portlet:defineObjects/>--%>


<%--<portlet:renderURL var="viewURL">--%>
<%--    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>--%>
<%--</portlet:renderURL>--%>

<%--<portlet:actionURL name="addFarmer" var="addFarmerURL"></portlet:actionURL>--%>

<%--<aui:form action="<%= addFarmerURL %>" name="<portlet:namespace />fm">--%>
<%--    <aui:fieldset>--%>
<%--        <aui:input label="Название организации" name="CompanyName">--%>
<%--            <aui:validator name="required"/>--%>
<%--        </aui:input>--%>
<%--        <aui:input label="Организационно-правовая форма" name="OrganizationForm">--%>
<%--            <aui:validator name="required"/>--%>
<%--        </aui:input>--%>
<%--        <aui:input label="ИНН" name="INN" maxlength="12" minlength="10">--%>
<%--            <aui:validator name="required"/>--%>
<%--            <aui:validator name="digits"/>--%>
<%--        </aui:input>--%>
<%--        <aui:input label="КПП" name="KPP" maxlength="9" minlength="9">--%>
<%--            <aui:validator name="digits"/>--%>
<%--            <aui:validator name="required"/>--%>
<%--        </aui:input>--%>
<%--        <aui:input label="ОГРН" name="OGRN" maxlength="13" minlength="13">--%>
<%--            <aui:validator name="digits"/>--%>
<%--            <aui:validator name="required"/>--%>
<%--        </aui:input>--%>
<%--        <aui:input label="Район регистрации" name="RegionId">--%>
<%--            <aui:validator name="required"/>--%>
<%--        </aui:input>--%>
<%--        <aui:input label="Район посевных полей(Через ',')" name="FieldRegion">--%>
<%--            <aui:validator name="required"/>--%>
<%--        </aui:input>--%>
<%--        <aui:input label="Дата регистрации" type="date" name="RegistrationDate">--%>
<%--            <aui:validator name="required"/>--%>
<%--        </aui:input>--%>
<%--        <aui:select label="Статус архивности" name="ArchiveStatus">--%>
<%--            <aui:option value="Да">Да</aui:option>--%>
<%--            <aui:option value="Нет">Нет</aui:option>--%>
<%--&lt;%&ndash;            <aui:validator name="required"/>&ndash;%&gt;--%>
<%--        </aui:select>--%>
<%--    </aui:fieldset>--%>

<%--    <aui:button-row>--%>
<%--        <aui:button type="submit"></aui:button>--%>
<%--        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>--%>
<%--    </aui:button-row>--%>
<%--</aui:form>--%>



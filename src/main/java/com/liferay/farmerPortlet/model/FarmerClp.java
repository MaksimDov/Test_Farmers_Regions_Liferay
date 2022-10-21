package com.liferay.farmerPortlet.model;

import com.liferay.farmerPortlet.service.ClpSerializer;
import com.liferay.farmerPortlet.service.FarmerLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class FarmerClp extends BaseModelImpl<Farmer> implements Farmer {
    private long _farmerId;
    private String _companyName;
    private String _organizationForm;
    private String _inn;
    private String _kpp;
    private String _ogrn;
    private long _regionId;
    private String _registrationDate;
    private String _archiveStatus;
    private BaseModel<?> _farmerRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.farmerPortlet.service.ClpSerializer.class;

    public FarmerClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Farmer.class;
    }

    @Override
    public String getModelClassName() {
        return Farmer.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _farmerId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setFarmerId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _farmerId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("farmerId", getFarmerId());
        attributes.put("companyName", getCompanyName());
        attributes.put("organizationForm", getOrganizationForm());
        attributes.put("inn", getInn());
        attributes.put("kpp", getKpp());
        attributes.put("ogrn", getOgrn());
        attributes.put("regionId", getRegionId());
        attributes.put("registrationDate", getRegistrationDate());
        attributes.put("archiveStatus", getArchiveStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long farmerId = (Long) attributes.get("farmerId");

        if (farmerId != null) {
            setFarmerId(farmerId);
        }

        String companyName = (String) attributes.get("companyName");

        if (companyName != null) {
            setCompanyName(companyName);
        }

        String organizationForm = (String) attributes.get("organizationForm");

        if (organizationForm != null) {
            setOrganizationForm(organizationForm);
        }

        String inn = (String) attributes.get("inn");

        if (inn != null) {
            setInn(inn);
        }

        String kpp = (String) attributes.get("kpp");

        if (kpp != null) {
            setKpp(kpp);
        }

        String ogrn = (String) attributes.get("ogrn");

        if (ogrn != null) {
            setOgrn(ogrn);
        }

        Long regionId = (Long) attributes.get("regionId");

        if (regionId != null) {
            setRegionId(regionId);
        }

        String registrationDate = (String) attributes.get("registrationDate");

        if (registrationDate != null) {
            setRegistrationDate(registrationDate);
        }

        String archiveStatus = (String) attributes.get("archiveStatus");

        if (archiveStatus != null) {
            setArchiveStatus(archiveStatus);
        }
    }

    @Override
    public long getFarmerId() {
        return _farmerId;
    }

    @Override
    public void setFarmerId(long farmerId) {
        _farmerId = farmerId;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setFarmerId", long.class);

                method.invoke(_farmerRemoteModel, farmerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCompanyName() {
        return _companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        _companyName = companyName;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyName", String.class);

                method.invoke(_farmerRemoteModel, companyName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrganizationForm() {
        return _organizationForm;
    }

    @Override
    public void setOrganizationForm(String organizationForm) {
        _organizationForm = organizationForm;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setOrganizationForm",
                        String.class);

                method.invoke(_farmerRemoteModel, organizationForm);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getInn() {
        return _inn;
    }

    @Override
    public void setInn(String inn) {
        _inn = inn;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setInn", String.class);

                method.invoke(_farmerRemoteModel, inn);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKpp() {
        return _kpp;
    }

    @Override
    public void setKpp(String kpp) {
        _kpp = kpp;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setKpp", String.class);

                method.invoke(_farmerRemoteModel, kpp);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOgrn() {
        return _ogrn;
    }

    @Override
    public void setOgrn(String ogrn) {
        _ogrn = ogrn;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setOgrn", String.class);

                method.invoke(_farmerRemoteModel, ogrn);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRegionId() {
        return _regionId;
    }

    @Override
    public void setRegionId(long regionId) {
        _regionId = regionId;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setRegionId", long.class);

                method.invoke(_farmerRemoteModel, regionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRegistrationDate() {
        return _registrationDate;
    }

    @Override
    public void setRegistrationDate(String registrationDate) {
        _registrationDate = registrationDate;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setRegistrationDate",
                        String.class);

                method.invoke(_farmerRemoteModel, registrationDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getArchiveStatus() {
        return _archiveStatus;
    }

    @Override
    public void setArchiveStatus(String archiveStatus) {
        _archiveStatus = archiveStatus;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setArchiveStatus", String.class);

                method.invoke(_farmerRemoteModel, archiveStatus);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getFarmerRemoteModel() {
        return _farmerRemoteModel;
    }

    public void setFarmerRemoteModel(BaseModel<?> farmerRemoteModel) {
        _farmerRemoteModel = farmerRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _farmerRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_farmerRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FarmerLocalServiceUtil.addFarmer(this);
        } else {
            FarmerLocalServiceUtil.updateFarmer(this);
        }
    }

    @Override
    public Farmer toEscapedModel() {
        return (Farmer) ProxyUtil.newProxyInstance(Farmer.class.getClassLoader(),
            new Class[] { Farmer.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FarmerClp clone = new FarmerClp();

        clone.setFarmerId(getFarmerId());
        clone.setCompanyName(getCompanyName());
        clone.setOrganizationForm(getOrganizationForm());
        clone.setInn(getInn());
        clone.setKpp(getKpp());
        clone.setOgrn(getOgrn());
        clone.setRegionId(getRegionId());
        clone.setRegistrationDate(getRegistrationDate());
        clone.setArchiveStatus(getArchiveStatus());

        return clone;
    }

    @Override
    public int compareTo(Farmer farmer) {
        int value = 0;

        if (getFarmerId() < farmer.getFarmerId()) {
            value = -1;
        } else if (getFarmerId() > farmer.getFarmerId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FarmerClp)) {
            return false;
        }

        FarmerClp farmer = (FarmerClp) obj;

        long primaryKey = farmer.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{farmerId=");
        sb.append(getFarmerId());
        sb.append(", companyName=");
        sb.append(getCompanyName());
        sb.append(", organizationForm=");
        sb.append(getOrganizationForm());
        sb.append(", inn=");
        sb.append(getInn());
        sb.append(", kpp=");
        sb.append(getKpp());
        sb.append(", ogrn=");
        sb.append(getOgrn());
        sb.append(", regionId=");
        sb.append(getRegionId());
        sb.append(", registrationDate=");
        sb.append(getRegistrationDate());
        sb.append(", archiveStatus=");
        sb.append(getArchiveStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.liferay.farmerPortlet.model.Farmer");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>farmerId</column-name><column-value><![CDATA[");
        sb.append(getFarmerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyName</column-name><column-value><![CDATA[");
        sb.append(getCompanyName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>organizationForm</column-name><column-value><![CDATA[");
        sb.append(getOrganizationForm());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>inn</column-name><column-value><![CDATA[");
        sb.append(getInn());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kpp</column-name><column-value><![CDATA[");
        sb.append(getKpp());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ogrn</column-name><column-value><![CDATA[");
        sb.append(getOgrn());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>regionId</column-name><column-value><![CDATA[");
        sb.append(getRegionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>registrationDate</column-name><column-value><![CDATA[");
        sb.append(getRegistrationDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>archiveStatus</column-name><column-value><![CDATA[");
        sb.append(getArchiveStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

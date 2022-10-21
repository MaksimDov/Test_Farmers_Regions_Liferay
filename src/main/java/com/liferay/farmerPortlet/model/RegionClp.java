package com.liferay.farmerPortlet.model;

import com.liferay.farmerPortlet.service.ClpSerializer;
import com.liferay.farmerPortlet.service.RegionLocalServiceUtil;

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


public class RegionClp extends BaseModelImpl<Region> implements Region {
    private long _regionId;
    private String _regionName;
    private String _regionCode;
    private String _archiveStatus;
    private BaseModel<?> _regionRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.farmerPortlet.service.ClpSerializer.class;

    public RegionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Region.class;
    }

    @Override
    public String getModelClassName() {
        return Region.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _regionId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRegionId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _regionId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("regionId", getRegionId());
        attributes.put("regionName", getRegionName());
        attributes.put("regionCode", getRegionCode());
        attributes.put("archiveStatus", getArchiveStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long regionId = (Long) attributes.get("regionId");

        if (regionId != null) {
            setRegionId(regionId);
        }

        String regionName = (String) attributes.get("regionName");

        if (regionName != null) {
            setRegionName(regionName);
        }

        String regionCode = (String) attributes.get("regionCode");

        if (regionCode != null) {
            setRegionCode(regionCode);
        }

        String archiveStatus = (String) attributes.get("archiveStatus");

        if (archiveStatus != null) {
            setArchiveStatus(archiveStatus);
        }
    }

    @Override
    public long getRegionId() {
        return _regionId;
    }

    @Override
    public void setRegionId(long regionId) {
        _regionId = regionId;

        if (_regionRemoteModel != null) {
            try {
                Class<?> clazz = _regionRemoteModel.getClass();

                Method method = clazz.getMethod("setRegionId", long.class);

                method.invoke(_regionRemoteModel, regionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRegionName() {
        return _regionName;
    }

    @Override
    public void setRegionName(String regionName) {
        _regionName = regionName;

        if (_regionRemoteModel != null) {
            try {
                Class<?> clazz = _regionRemoteModel.getClass();

                Method method = clazz.getMethod("setRegionName", String.class);

                method.invoke(_regionRemoteModel, regionName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRegionCode() {
        return _regionCode;
    }

    @Override
    public void setRegionCode(String regionCode) {
        _regionCode = regionCode;

        if (_regionRemoteModel != null) {
            try {
                Class<?> clazz = _regionRemoteModel.getClass();

                Method method = clazz.getMethod("setRegionCode", String.class);

                method.invoke(_regionRemoteModel, regionCode);
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

        if (_regionRemoteModel != null) {
            try {
                Class<?> clazz = _regionRemoteModel.getClass();

                Method method = clazz.getMethod("setArchiveStatus", String.class);

                method.invoke(_regionRemoteModel, archiveStatus);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getRegionRemoteModel() {
        return _regionRemoteModel;
    }

    public void setRegionRemoteModel(BaseModel<?> regionRemoteModel) {
        _regionRemoteModel = regionRemoteModel;
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

        Class<?> remoteModelClass = _regionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_regionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            RegionLocalServiceUtil.addRegion(this);
        } else {
            RegionLocalServiceUtil.updateRegion(this);
        }
    }

    @Override
    public Region toEscapedModel() {
        return (Region) ProxyUtil.newProxyInstance(Region.class.getClassLoader(),
            new Class[] { Region.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RegionClp clone = new RegionClp();

        clone.setRegionId(getRegionId());
        clone.setRegionName(getRegionName());
        clone.setRegionCode(getRegionCode());
        clone.setArchiveStatus(getArchiveStatus());

        return clone;
    }

    @Override
    public int compareTo(Region region) {
        int value = 0;

        if (getRegionId() < region.getRegionId()) {
            value = -1;
        } else if (getRegionId() > region.getRegionId()) {
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

        if (!(obj instanceof RegionClp)) {
            return false;
        }

        RegionClp region = (RegionClp) obj;

        long primaryKey = region.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{regionId=");
        sb.append(getRegionId());
        sb.append(", regionName=");
        sb.append(getRegionName());
        sb.append(", regionCode=");
        sb.append(getRegionCode());
        sb.append(", archiveStatus=");
        sb.append(getArchiveStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.liferay.farmerPortlet.model.Region");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>regionId</column-name><column-value><![CDATA[");
        sb.append(getRegionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>regionName</column-name><column-value><![CDATA[");
        sb.append(getRegionName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>regionCode</column-name><column-value><![CDATA[");
        sb.append(getRegionCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>archiveStatus</column-name><column-value><![CDATA[");
        sb.append(getArchiveStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

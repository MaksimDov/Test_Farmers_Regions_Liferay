package com.liferay.farmerPortlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.farmerPortlet.service.http.RegionServiceSoap}.
 *
 * @author Test Test
 * @see com.liferay.farmerPortlet.service.http.RegionServiceSoap
 * @generated
 */
public class RegionSoap implements Serializable {
    private long _regionId;
    private String _regionName;
    private String _regionCode;
    private String _archiveStatus;

    public RegionSoap() {
    }

    public static RegionSoap toSoapModel(Region model) {
        RegionSoap soapModel = new RegionSoap();

        soapModel.setRegionId(model.getRegionId());
        soapModel.setRegionName(model.getRegionName());
        soapModel.setRegionCode(model.getRegionCode());
        soapModel.setArchiveStatus(model.getArchiveStatus());

        return soapModel;
    }

    public static RegionSoap[] toSoapModels(Region[] models) {
        RegionSoap[] soapModels = new RegionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RegionSoap[][] toSoapModels(Region[][] models) {
        RegionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RegionSoap[models.length][models[0].length];
        } else {
            soapModels = new RegionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RegionSoap[] toSoapModels(List<Region> models) {
        List<RegionSoap> soapModels = new ArrayList<RegionSoap>(models.size());

        for (Region model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RegionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _regionId;
    }

    public void setPrimaryKey(long pk) {
        setRegionId(pk);
    }

    public long getRegionId() {
        return _regionId;
    }

    public void setRegionId(long regionId) {
        _regionId = regionId;
    }

    public String getRegionName() {
        return _regionName;
    }

    public void setRegionName(String regionName) {
        _regionName = regionName;
    }

    public String getRegionCode() {
        return _regionCode;
    }

    public void setRegionCode(String regionCode) {
        _regionCode = regionCode;
    }

    public String getArchiveStatus() {
        return _archiveStatus;
    }

    public void setArchiveStatus(String archiveStatus) {
        _archiveStatus = archiveStatus;
    }
}

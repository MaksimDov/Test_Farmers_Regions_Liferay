package com.liferay.farmerPortlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.farmerPortlet.service.http.FarmerServiceSoap}.
 *
 * @author Test Test
 * @see com.liferay.farmerPortlet.service.http.FarmerServiceSoap
 * @generated
 */
public class FarmerSoap implements Serializable {
    private long _farmerId;
    private String _companyName;
    private String _organizationForm;
    private String _inn;
    private String _kpp;
    private String _ogrn;
    private long _regionId;
    private String _registrationDate;
    private String _archiveStatus;

    public FarmerSoap() {
    }

    public static FarmerSoap toSoapModel(Farmer model) {
        FarmerSoap soapModel = new FarmerSoap();

        soapModel.setFarmerId(model.getFarmerId());
        soapModel.setCompanyName(model.getCompanyName());
        soapModel.setOrganizationForm(model.getOrganizationForm());
        soapModel.setInn(model.getInn());
        soapModel.setKpp(model.getKpp());
        soapModel.setOgrn(model.getOgrn());
        soapModel.setRegionId(model.getRegionId());
        soapModel.setRegistrationDate(model.getRegistrationDate());
        soapModel.setArchiveStatus(model.getArchiveStatus());

        return soapModel;
    }

    public static FarmerSoap[] toSoapModels(Farmer[] models) {
        FarmerSoap[] soapModels = new FarmerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FarmerSoap[][] toSoapModels(Farmer[][] models) {
        FarmerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FarmerSoap[models.length][models[0].length];
        } else {
            soapModels = new FarmerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FarmerSoap[] toSoapModels(List<Farmer> models) {
        List<FarmerSoap> soapModels = new ArrayList<FarmerSoap>(models.size());

        for (Farmer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FarmerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _farmerId;
    }

    public void setPrimaryKey(long pk) {
        setFarmerId(pk);
    }

    public long getFarmerId() {
        return _farmerId;
    }

    public void setFarmerId(long farmerId) {
        _farmerId = farmerId;
    }

    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String companyName) {
        _companyName = companyName;
    }

    public String getOrganizationForm() {
        return _organizationForm;
    }

    public void setOrganizationForm(String organizationForm) {
        _organizationForm = organizationForm;
    }

    public String getInn() {
        return _inn;
    }

    public void setInn(String inn) {
        _inn = inn;
    }

    public String getKpp() {
        return _kpp;
    }

    public void setKpp(String kpp) {
        _kpp = kpp;
    }

    public String getOgrn() {
        return _ogrn;
    }

    public void setOgrn(String ogrn) {
        _ogrn = ogrn;
    }

    public long getRegionId() {
        return _regionId;
    }

    public void setRegionId(long regionId) {
        _regionId = regionId;
    }

    public String getRegistrationDate() {
        return _registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        _registrationDate = registrationDate;
    }

    public String getArchiveStatus() {
        return _archiveStatus;
    }

    public void setArchiveStatus(String archiveStatus) {
        _archiveStatus = archiveStatus;
    }
}

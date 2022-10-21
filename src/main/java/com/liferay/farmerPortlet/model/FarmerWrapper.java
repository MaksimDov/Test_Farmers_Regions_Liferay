package com.liferay.farmerPortlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Farmer}.
 * </p>
 *
 * @author Test Test
 * @see Farmer
 * @generated
 */
public class FarmerWrapper implements Farmer, ModelWrapper<Farmer> {
    private Farmer _farmer;

    public FarmerWrapper(Farmer farmer) {
        _farmer = farmer;
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

    /**
    * Returns the primary key of this farmer.
    *
    * @return the primary key of this farmer
    */
    @Override
    public long getPrimaryKey() {
        return _farmer.getPrimaryKey();
    }

    /**
    * Sets the primary key of this farmer.
    *
    * @param primaryKey the primary key of this farmer
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _farmer.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the farmer ID of this farmer.
    *
    * @return the farmer ID of this farmer
    */
    @Override
    public long getFarmerId() {
        return _farmer.getFarmerId();
    }

    /**
    * Sets the farmer ID of this farmer.
    *
    * @param farmerId the farmer ID of this farmer
    */
    @Override
    public void setFarmerId(long farmerId) {
        _farmer.setFarmerId(farmerId);
    }

    /**
    * Returns the company name of this farmer.
    *
    * @return the company name of this farmer
    */
    @Override
    public java.lang.String getCompanyName() {
        return _farmer.getCompanyName();
    }

    /**
    * Sets the company name of this farmer.
    *
    * @param companyName the company name of this farmer
    */
    @Override
    public void setCompanyName(java.lang.String companyName) {
        _farmer.setCompanyName(companyName);
    }

    /**
    * Returns the organization form of this farmer.
    *
    * @return the organization form of this farmer
    */
    @Override
    public java.lang.String getOrganizationForm() {
        return _farmer.getOrganizationForm();
    }

    /**
    * Sets the organization form of this farmer.
    *
    * @param organizationForm the organization form of this farmer
    */
    @Override
    public void setOrganizationForm(java.lang.String organizationForm) {
        _farmer.setOrganizationForm(organizationForm);
    }

    /**
    * Returns the inn of this farmer.
    *
    * @return the inn of this farmer
    */
    @Override
    public java.lang.String getInn() {
        return _farmer.getInn();
    }

    /**
    * Sets the inn of this farmer.
    *
    * @param inn the inn of this farmer
    */
    @Override
    public void setInn(java.lang.String inn) {
        _farmer.setInn(inn);
    }

    /**
    * Returns the kpp of this farmer.
    *
    * @return the kpp of this farmer
    */
    @Override
    public java.lang.String getKpp() {
        return _farmer.getKpp();
    }

    /**
    * Sets the kpp of this farmer.
    *
    * @param kpp the kpp of this farmer
    */
    @Override
    public void setKpp(java.lang.String kpp) {
        _farmer.setKpp(kpp);
    }

    /**
    * Returns the ogrn of this farmer.
    *
    * @return the ogrn of this farmer
    */
    @Override
    public java.lang.String getOgrn() {
        return _farmer.getOgrn();
    }

    /**
    * Sets the ogrn of this farmer.
    *
    * @param ogrn the ogrn of this farmer
    */
    @Override
    public void setOgrn(java.lang.String ogrn) {
        _farmer.setOgrn(ogrn);
    }

    /**
    * Returns the region ID of this farmer.
    *
    * @return the region ID of this farmer
    */
    @Override
    public long getRegionId() {
        return _farmer.getRegionId();
    }

    /**
    * Sets the region ID of this farmer.
    *
    * @param regionId the region ID of this farmer
    */
    @Override
    public void setRegionId(long regionId) {
        _farmer.setRegionId(regionId);
    }

    /**
    * Returns the registration date of this farmer.
    *
    * @return the registration date of this farmer
    */
    @Override
    public java.lang.String getRegistrationDate() {
        return _farmer.getRegistrationDate();
    }

    /**
    * Sets the registration date of this farmer.
    *
    * @param registrationDate the registration date of this farmer
    */
    @Override
    public void setRegistrationDate(java.lang.String registrationDate) {
        _farmer.setRegistrationDate(registrationDate);
    }

    /**
    * Returns the archive status of this farmer.
    *
    * @return the archive status of this farmer
    */
    @Override
    public java.lang.String getArchiveStatus() {
        return _farmer.getArchiveStatus();
    }

    /**
    * Sets the archive status of this farmer.
    *
    * @param archiveStatus the archive status of this farmer
    */
    @Override
    public void setArchiveStatus(java.lang.String archiveStatus) {
        _farmer.setArchiveStatus(archiveStatus);
    }

    @Override
    public boolean isNew() {
        return _farmer.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _farmer.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _farmer.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _farmer.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _farmer.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _farmer.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _farmer.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _farmer.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _farmer.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _farmer.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _farmer.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FarmerWrapper((Farmer) _farmer.clone());
    }

    @Override
    public int compareTo(com.liferay.farmerPortlet.model.Farmer farmer) {
        return _farmer.compareTo(farmer);
    }

    @Override
    public int hashCode() {
        return _farmer.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.farmerPortlet.model.Farmer> toCacheModel() {
        return _farmer.toCacheModel();
    }

    @Override
    public com.liferay.farmerPortlet.model.Farmer toEscapedModel() {
        return new FarmerWrapper(_farmer.toEscapedModel());
    }

    @Override
    public com.liferay.farmerPortlet.model.Farmer toUnescapedModel() {
        return new FarmerWrapper(_farmer.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _farmer.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _farmer.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmer.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FarmerWrapper)) {
            return false;
        }

        FarmerWrapper farmerWrapper = (FarmerWrapper) obj;

        if (Validator.equals(_farmer, farmerWrapper._farmer)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Farmer getWrappedFarmer() {
        return _farmer;
    }

    @Override
    public Farmer getWrappedModel() {
        return _farmer;
    }

    @Override
    public void resetOriginalValues() {
        _farmer.resetOriginalValues();
    }
}

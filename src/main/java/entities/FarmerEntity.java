package entities;

import java.util.List;

public class FarmerEntity {
    private long farmerId;
    private String companyName;
    private String organizationForm;
    private String inn;
    private String kpp;
    private String ogrn;
    private long regionId;
    private String fieldRegion;
    private String registrationDate;
    private String archiveStatus;

    public FarmerEntity() {
    }

    public FarmerEntity(long farmerId, String companyName, String organizationForm, String inn, String kpp, String ogrn, long regionId, String fieldRegion, String registrationDate, String archiveStatus) {
        this.farmerId = farmerId;
        this.companyName = companyName;
        this.organizationForm = organizationForm;
        this.inn = inn;
        this.kpp = kpp;
        this.ogrn = ogrn;
        this.regionId = regionId;
        this.fieldRegion = fieldRegion;
        this.registrationDate = registrationDate;
        this.archiveStatus = archiveStatus;
    }

    public long getFarmerId() {
        return farmerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getOrganizationForm() {
        return organizationForm;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getOgrn() {
        return ogrn;
    }

    public long getRegionId() {
        return regionId;
    }

    public String getFieldRegion() {
        return fieldRegion;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getArchiveStatus() {
        return archiveStatus;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public void setFieldRegion(String fieldRegion) {
        this.fieldRegion = fieldRegion;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
    }
}

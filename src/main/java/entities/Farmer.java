package entities;

public class Farmer {
    private String companyName;
    private String organizationForm;
    private String inn;
    private String kpp;
    private String ogrn;
    private String regionId;
    private String fieldRegion;
    private String registrationDate;
    private String archiveStatus;

    public Farmer() {
    }

    public Farmer(String companyName, String organizationForm, String inn, String kpp,
                  String ogrn, String regionId, String fieldRegion,
                  String registrationDate, String archiveStatus) {
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

    public String getRegionId() {
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

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public void setFieldRegion(String fieldRegion) {
        this.fieldRegion = fieldRegion;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setArchiveStatus(String archiveStatus) {
        archiveStatus = archiveStatus;
    }
}

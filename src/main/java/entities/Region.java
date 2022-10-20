package entities;

public class Region {
    private String regionName;
    private String regionCode;
    private String archiveStatus;

    public Region() {
    }

    public Region(String regionName, String regionCode, String archiveStatus) {
        this.regionName = regionName;
        this.regionCode = regionCode;
        this.archiveStatus = archiveStatus;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getArchiveStatus() {
        return archiveStatus;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
    }
}

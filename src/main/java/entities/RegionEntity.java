package entities;

public class RegionEntity {
    private long regionId;
    private String regionName;
    private String regionCode;
    private String archiveStatus;

    public RegionEntity() {
    }

    public RegionEntity(long regionId, String regionName, String regionCode, String archiveStatus) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionCode = regionCode;
        this.archiveStatus = archiveStatus;
    }

    public long getRegionId() {
        return regionId;
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

    public void setRegionId(long regionId) {
        this.regionId = regionId;
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

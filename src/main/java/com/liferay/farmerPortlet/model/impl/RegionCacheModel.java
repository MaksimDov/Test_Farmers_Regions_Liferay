package com.liferay.farmerPortlet.model.impl;

import com.liferay.farmerPortlet.model.Region;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Region in entity cache.
 *
 * @author Test Test
 * @see Region
 * @generated
 */
public class RegionCacheModel implements CacheModel<Region>, Externalizable {
    public long regionId;
    public String regionName;
    public String regionCode;
    public String archiveStatus;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{regionId=");
        sb.append(regionId);
        sb.append(", regionName=");
        sb.append(regionName);
        sb.append(", regionCode=");
        sb.append(regionCode);
        sb.append(", archiveStatus=");
        sb.append(archiveStatus);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Region toEntityModel() {
        RegionImpl regionImpl = new RegionImpl();

        regionImpl.setRegionId(regionId);

        if (regionName == null) {
            regionImpl.setRegionName(StringPool.BLANK);
        } else {
            regionImpl.setRegionName(regionName);
        }

        if (regionCode == null) {
            regionImpl.setRegionCode(StringPool.BLANK);
        } else {
            regionImpl.setRegionCode(regionCode);
        }

        if (archiveStatus == null) {
            regionImpl.setArchiveStatus(StringPool.BLANK);
        } else {
            regionImpl.setArchiveStatus(archiveStatus);
        }

        regionImpl.resetOriginalValues();

        return regionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        regionId = objectInput.readLong();
        regionName = objectInput.readUTF();
        regionCode = objectInput.readUTF();
        archiveStatus = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(regionId);

        if (regionName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(regionName);
        }

        if (regionCode == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(regionCode);
        }

        if (archiveStatus == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(archiveStatus);
        }
    }
}

package com.liferay.farmerPortlet.model.impl;

import com.liferay.farmerPortlet.model.Farmer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Farmer in entity cache.
 *
 * @author Test Test
 * @see Farmer
 * @generated
 */
public class FarmerCacheModel implements CacheModel<Farmer>, Externalizable {
    public long farmerId;
    public String companyName;
    public String organizationForm;
    public String inn;
    public String kpp;
    public String ogrn;
    public long regionId;
    public String registrationDate;
    public String archiveStatus;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{farmerId=");
        sb.append(farmerId);
        sb.append(", companyName=");
        sb.append(companyName);
        sb.append(", organizationForm=");
        sb.append(organizationForm);
        sb.append(", inn=");
        sb.append(inn);
        sb.append(", kpp=");
        sb.append(kpp);
        sb.append(", ogrn=");
        sb.append(ogrn);
        sb.append(", regionId=");
        sb.append(regionId);
        sb.append(", registrationDate=");
        sb.append(registrationDate);
        sb.append(", archiveStatus=");
        sb.append(archiveStatus);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Farmer toEntityModel() {
        FarmerImpl farmerImpl = new FarmerImpl();

        farmerImpl.setFarmerId(farmerId);

        if (companyName == null) {
            farmerImpl.setCompanyName(StringPool.BLANK);
        } else {
            farmerImpl.setCompanyName(companyName);
        }

        if (organizationForm == null) {
            farmerImpl.setOrganizationForm(StringPool.BLANK);
        } else {
            farmerImpl.setOrganizationForm(organizationForm);
        }

        if (inn == null) {
            farmerImpl.setInn(StringPool.BLANK);
        } else {
            farmerImpl.setInn(inn);
        }

        if (kpp == null) {
            farmerImpl.setKpp(StringPool.BLANK);
        } else {
            farmerImpl.setKpp(kpp);
        }

        if (ogrn == null) {
            farmerImpl.setOgrn(StringPool.BLANK);
        } else {
            farmerImpl.setOgrn(ogrn);
        }

        farmerImpl.setRegionId(regionId);

        if (registrationDate == null) {
            farmerImpl.setRegistrationDate(StringPool.BLANK);
        } else {
            farmerImpl.setRegistrationDate(registrationDate);
        }

        if (archiveStatus == null) {
            farmerImpl.setArchiveStatus(StringPool.BLANK);
        } else {
            farmerImpl.setArchiveStatus(archiveStatus);
        }

        farmerImpl.resetOriginalValues();

        return farmerImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        farmerId = objectInput.readLong();
        companyName = objectInput.readUTF();
        organizationForm = objectInput.readUTF();
        inn = objectInput.readUTF();
        kpp = objectInput.readUTF();
        ogrn = objectInput.readUTF();
        regionId = objectInput.readLong();
        registrationDate = objectInput.readUTF();
        archiveStatus = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(farmerId);

        if (companyName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(companyName);
        }

        if (organizationForm == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(organizationForm);
        }

        if (inn == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(inn);
        }

        if (kpp == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kpp);
        }

        if (ogrn == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ogrn);
        }

        objectOutput.writeLong(regionId);

        if (registrationDate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(registrationDate);
        }

        if (archiveStatus == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(archiveStatus);
        }
    }
}

package com.liferay.farmerPortlet.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.farmerPortlet.model.Farmer;
import com.liferay.farmerPortlet.model.Region;
import com.liferay.farmerPortlet.service.FarmerLocalServiceUtil;
import com.liferay.farmerPortlet.service.base.FarmerLocalServiceBaseImpl;
import com.liferay.farmerPortlet.service.persistence.FarmerUtil;
import com.liferay.farmerPortlet.service.persistence.RegionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the farmer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.farmerPortlet.service.FarmerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Test Test
 * @see com.liferay.farmerPortlet.service.base.FarmerLocalServiceBaseImpl
 * @see com.liferay.farmerPortlet.service.FarmerLocalServiceUtil
 */
public class FarmerLocalServiceImpl extends FarmerLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.farmerPortlet.service.FarmerLocalServiceUtil} to access the farmer local service.
     */
    public Farmer createFarmer(String companyName, String organizationForm, String inn, String kpp, String ogrn, long regionId, String registrationDate, String archiveStatus) throws SystemException {

        Farmer farmer = FarmerUtil.create(CounterLocalServiceUtil.increment());
        farmer.setCompanyName(companyName);
        farmer.setOrganizationForm(organizationForm);
        farmer.setInn(inn);
        farmer.setKpp(kpp);
        farmer.setOgrn(ogrn);
        farmer.setRegionId(regionId);
        farmer.setRegistrationDate(registrationDate);
        farmer.setArchiveStatus(archiveStatus);
        Farmer newFarmer = FarmerUtil.update(farmer);
        return newFarmer;
    }

    public List<Farmer> findAllFarmers() throws SystemException {
        List<Farmer> farmers = new ArrayList<Farmer>();
        farmers = FarmerUtil.findAll();
        return farmers;
    }

    public Farmer deleteFarmer(long farmerId, ServiceContext serviceContext)
            throws PortalException, SystemException {

        Farmer farmer = getFarmer(farmerId);

        resourceLocalService.deleteResource(
                serviceContext.getCompanyId(), Farmer.class.getName(),
                ResourceConstants.SCOPE_INDIVIDUAL, farmerId);

        farmer = deleteFarmer(farmerId);

        return farmer;
    }

    public Farmer updateFarmer(long farmerId, String companyName, String organizationForm, String inn, String kpp, String ogrn, long regionId, String registrationDate, String archiveStatus) throws SystemException, PortalException {

        Farmer farmer = getFarmer(farmerId);
//        Farmer farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
        farmer.setCompanyName(companyName);
        farmer.setOrganizationForm(organizationForm);
        farmer.setInn(inn);
        farmer.setKpp(kpp);
        farmer.setOgrn(ogrn);
        farmer.setRegionId(regionId);
        farmer.setRegistrationDate(registrationDate);
        farmer.setArchiveStatus(archiveStatus);;
        farmerPersistence.update(farmer);
        System.out.println(farmerId);
        System.out.println(farmer.getFarmerId());
//        updateFarmer(farmer);
        return farmer;
    }
}

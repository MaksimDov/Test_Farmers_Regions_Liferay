package com.liferay.farmerPortlet.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.farmerPortlet.model.Region;
import com.liferay.farmerPortlet.service.base.RegionLocalServiceBaseImpl;
import com.liferay.farmerPortlet.service.persistence.RegionUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the region local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.farmerPortlet.service.RegionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Test Test
 * @see com.liferay.farmerPortlet.service.base.RegionLocalServiceBaseImpl
 * @see com.liferay.farmerPortlet.service.RegionLocalServiceUtil
 */
public class RegionLocalServiceImpl extends RegionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.farmerPortlet.service.RegionLocalServiceUtil} to access the region local service.
     */
    public Region createRegion(String regionName, String regionCode, String archiveStatus) throws SystemException {

        Region region = RegionUtil.create(CounterLocalServiceUtil.increment());
        region.setRegionName(regionName);
        region.setRegionCode(regionCode);
        region.setArchiveStatus(archiveStatus);
        Region newRegion = RegionUtil.update(region);
        return newRegion;
    }

    public List<Region> findAllRegions() throws SystemException {
        List<Region> regions = new ArrayList<Region>();
        regions = RegionUtil.findAll();
        return regions;
    }

    public List<Region> findAllRegionsByName(String name) throws SystemException {
        List<Region> regions = new ArrayList<Region>();
        regions = RegionUtil.findAll();
        List<Region> regionsByName = new ArrayList<Region>();
        for(Region region : regions){
            if (region.getRegionName().equals(name)){
                regionsByName.add(region);
            }
        }
        return regionsByName;
    }

    public Region findFirstRegionByName(String name) throws SystemException {
        List<Region> regions = new ArrayList<Region>();
        Region region = RegionUtil.create(CounterLocalServiceUtil.increment());
        regions = RegionUtil.findAll();
        for(Region reg : regions){
            if (reg.getRegionName().equals(name)){
                region.setRegionId(reg.getRegionId());
                region.setRegionName(reg.getRegionName());
                region.setRegionCode(reg.getRegionCode());
                region.setArchiveStatus(reg.getArchiveStatus());
            }
        }
        return region;
    }

}

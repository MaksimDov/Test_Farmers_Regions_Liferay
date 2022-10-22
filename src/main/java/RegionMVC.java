import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.farmerPortlet.model.Farmer;
import com.liferay.farmerPortlet.model.Region;
import com.liferay.farmerPortlet.service.FarmerLocalServiceUtil;
import com.liferay.farmerPortlet.service.RegionLocalServiceUtil;
import com.liferay.farmerPortlet.service.persistence.RegionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import entities.RegionEntity;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegionMVC extends MVCPortlet {

    public void addRegion(ActionRequest request, ActionResponse response) throws SystemException {
        String regionName = ParamUtil.getString(request, "RegionName");
        String regionCode = ParamUtil.getString(request, "RegionCode");
        String archiveStatus = ParamUtil.getString(request, "ArchiveStatus");

        try {
            Region region = RegionLocalServiceUtil.createRegion(regionName, regionCode, archiveStatus);
            // Do whatever you want after creating new details
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteRegion (ActionRequest request, ActionResponse response) {

        long regionId = ParamUtil.getLong(request, "regionId");

        try {

            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    Farmer.class.getName(), request);


            RegionLocalServiceUtil.deleteRegion(regionId, serviceContext);

        } catch (Exception e) {

            SessionErrors.add(request, e.getClass().getName());
        }
    }

    public void updateRegion(ActionRequest request, ActionResponse response)
            throws PortalException, SystemException {

        long regionId = ParamUtil.getLong(request, "regionId");




        String regionName = ParamUtil.getString(request, "RegionName");
        String regionCode = ParamUtil.getString(request, "RegionCode");
        String archiveStatus = ParamUtil.getString(request, "ArchiveStatus");

        RegionLocalServiceUtil.updateRegion(regionId, regionName, regionCode, archiveStatus);


        SessionMessages.add(request, "regionUpdated");
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

            List<RegionEntity> regions = null;
            try {
                regions = fillRegionsList();
            } catch (SystemException e) {
                throw new RuntimeException(e);
            }
            renderRequest.setAttribute("regions", regions);

        super.render(renderRequest, renderResponse);
    }

    private List<RegionEntity> fillRegionsList() throws SystemException {
        ArrayList<RegionEntity> regions = new ArrayList();
        List<Region> regionsFormDB= RegionLocalServiceUtil.findAllRegions();
        for (Region region : regionsFormDB) {
            RegionEntity newRegion = new RegionEntity();
            newRegion.setRegionName(region.getRegionName());
            newRegion.setRegionCode(region.getRegionCode());
            newRegion.setArchiveStatus(region.getArchiveStatus());
            newRegion.setRegionId(region.getRegionId());
            regions.add(newRegion);
        }
        return regions;
    }


//    @Override
//    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
//
//        PortletPreferences prefs = renderRequest.getPreferences();
//        String[] listOfRegions = prefs.getValues("list-of-regions", new String[1]);
//
//        if (listOfRegions != null) {
//            List<Region> regions = parseRegions(listOfRegions);
//            renderRequest.setAttribute("regions", regions);
//        }
//        super.render(renderRequest, renderResponse);
//    }
//
//    private List<Region> parseRegions(String[] listOfRegions) {
//        ArrayList<Region> regions = new ArrayList();
//        for (String region : listOfRegions) {
//            String[] parts = region.split("\\^", 3);
//            Region gbRegion = new Region(parts[0], parts[1], parts[2]);
//            regions.add(gbRegion);
//        }
//        return regions;
//    }
}

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.farmerPortlet.model.Region;
import com.liferay.farmerPortlet.service.RegionLocalServiceUtil;
import com.liferay.farmerPortlet.service.persistence.RegionUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

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

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

            List<Region> regions = null;
            try {
                regions = fillRegionsList();
            } catch (SystemException e) {
                throw new RuntimeException(e);
            }
            renderRequest.setAttribute("regions", regions);

        super.render(renderRequest, renderResponse);
    }

    private List<Region> fillRegionsList() throws SystemException {
        ArrayList<Region> regions = new ArrayList();
        List<Region> regionsFormDB= RegionLocalServiceUtil.findAllRegions();
        for (Region region : regionsFormDB) {
            Region newRegion = RegionUtil.create(CounterLocalServiceUtil.increment());
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

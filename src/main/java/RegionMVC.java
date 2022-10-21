import com.liferay.farmerPortlet.model.Region;
import com.liferay.farmerPortlet.service.RegionLocalServiceUtil;
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
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    //    public void addRegion(ActionRequest request, ActionResponse response) {
//
//        try {
//            PortletPreferences prefs = request.getPreferences();
//            String[] listOfRegions = prefs.getValues("list-of-regions", new String[1]);
//            ArrayList<String> regions = new ArrayList<String>();
//
//            if (listOfRegions != null) {
//                regions = new ArrayList<String>(Arrays.asList(prefs.getValues(
//                        "list-of-regions", new String[1])));
//            }
//
//            String regionName = ParamUtil.getString(request, "RegionName");
//            String regionCode = ParamUtil.getString(request, "RegionCode");
//            String archiveStatus = ParamUtil.getString(request, "ArchiveStatus");
//
//            String region = regionName + "^" + regionCode + "^" + archiveStatus;
//            regions.add(region);
//            String[] array = regions.toArray(new String[regions.size()]);
//            prefs.setValues("list-of-regions", array);
//
//            try {
//                prefs.store();
//            } catch (IOException ex) {
//                Logger.getLogger(RegionMVC.class.getName()).log(
//                        Level.SEVERE, null, ex);
//            } catch (ValidatorException ex) {
//                Logger.getLogger(RegionMVC.class.getName()).log(
//                        Level.SEVERE, null, ex);
//            }
//        } catch (ReadOnlyException ex) {
//            Logger.getLogger(RegionMVC.class.getName()).log(
//                    Level.SEVERE, null, ex);
//        }
//    }
//
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

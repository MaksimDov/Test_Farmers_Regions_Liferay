import entities.Farmer;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmerMVC extends MVCPortlet {
        public void addFarmer(ActionRequest request, ActionResponse response) {

        try {
            PortletPreferences prefs = request.getPreferences();
            String[] listOfFarmers = prefs.getValues("list-of-farmers", new String[1]);
            ArrayList<String> farmers = new ArrayList<String>();

            if (listOfFarmers != null) {
                farmers = new ArrayList<String>(Arrays.asList(prefs.getValues(
                        "list-of-farmers", new String[1])));
            }

            String companyName = ParamUtil.getString(request, "CompanyName");
            String organizationForm = ParamUtil.getString(request, "OrganizationForm");
            String inn = ParamUtil.getString(request, "INN");
            String kpp = ParamUtil.getString(request, "KPP");
            String ogrn = ParamUtil.getString(request, "OGRN");
            String registrationForm = ParamUtil.getString(request, "RegionId");
            String fieldRegion = ParamUtil.getString(request, "FieldRegion");
            String registrationDate = ParamUtil.getString(request, "RegistrationDate");
            String archiveStatus = ParamUtil.getString(request, "ArchiveStatus");
            String farmer = companyName + "^" + organizationForm + "^" + inn + "^" + kpp + "^" + ogrn + "^" +
                    registrationForm + "^" + fieldRegion + "^" + registrationDate + "^" + archiveStatus;
            farmers.add(farmer);
            String[] array = farmers.toArray(new String[farmers.size()]);
            prefs.setValues("list-of-farmers", array);

            try {
                prefs.store();
            } catch (IOException ex) {
                Logger.getLogger(FarmerMVC.class.getName()).log(
                        Level.SEVERE, null, ex);
            } catch (ValidatorException ex) {
                Logger.getLogger(FarmerMVC.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        } catch (ReadOnlyException ex) {
            Logger.getLogger(FarmerMVC.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    @Override
    public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

        PortletPreferences prefs = renderRequest.getPreferences();
        String[] listOfFarmers = prefs.getValues("list-of-farmers", new String[1]);

        if (listOfFarmers != null) {
            List<Farmer> farmers = parseFarmers(listOfFarmers);
            renderRequest.setAttribute("farmers", farmers);
        }
        super.render(renderRequest, renderResponse);
    }

    private List<Farmer> parseFarmers (String[] listOfFarmers) {
        ArrayList<Farmer> farmers = new ArrayList();
        for (String farmer : listOfFarmers) {
            String[] parts = farmer.split("\\^", 9);
            Farmer gbFarmer = new Farmer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
            farmers.add(gbFarmer);
        }
        return farmers;
    }
}

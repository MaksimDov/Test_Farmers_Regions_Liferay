import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.farmerPortlet.model.Farmer;
import com.liferay.farmerPortlet.model.Region;
import com.liferay.farmerPortlet.service.FarmerLocalServiceUtil;
import com.liferay.farmerPortlet.service.RegionLocalServiceUtil;
import com.liferay.farmerPortlet.service.persistence.FarmerPersistence;
import com.liferay.farmerPortlet.service.persistence.FarmerPersistenceImpl;
import com.liferay.farmerPortlet.service.persistence.FarmerUtil;
import com.liferay.farmerPortlet.service.persistence.RegionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import entities.FarmerEntity;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmerMVC extends MVCPortlet {
    public void addFarmer(ActionRequest request, ActionResponse response) throws SystemException {
        String companyName = ParamUtil.getString(request, "CompanyName");
        String organizationForm = ParamUtil.getString(request, "OrganizationForm");
        String inn = ParamUtil.getString(request, "INN");
        String kpp = ParamUtil.getString(request, "KPP");
        String ogrn = ParamUtil.getString(request, "OGRN");
        long regionId = ParamUtil.getLong(request, "RegionId");
        String registrationDate = ParamUtil.getString(request, "RegistrationDate");
        String archiveStatus = ParamUtil.getString(request, "ArchiveStatus");

        try {
            Farmer farmer = FarmerLocalServiceUtil.createFarmer(companyName, organizationForm, inn, kpp, ogrn, regionId, registrationDate, archiveStatus);
            // Do whatever you want after creating new details
            long farmerId = farmer.getFarmerId();
            String fieldRegions = ParamUtil.getString(request, "FieldRegion");
            long[] regionsId = parseFields(fieldRegions);
            try {
                RegionLocalServiceUtil.addFarmerRegions(farmerId, regionsId);
            } catch (SystemException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteFarmer (ActionRequest request, ActionResponse response) {

        long farmerId = ParamUtil.getLong(request, "farmerId");

        try {

            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    Farmer.class.getName(), request);


            FarmerLocalServiceUtil.deleteFarmer(farmerId, serviceContext);

        } catch (Exception e) {

            SessionErrors.add(request, e.getClass().getName());
        }
    }

    public void updateFarmer(ActionRequest request, ActionResponse response)
            throws PortalException, SystemException {

        long farmerId = ParamUtil.getLong(request, "farmerId");




        String companyName = ParamUtil.getString(request, "CompanyName");
        String organizationForm = ParamUtil.getString(request, "OrganizationForm");
        String inn = ParamUtil.getString(request, "INN");
        String kpp = ParamUtil.getString(request, "KPP");
        String ogrn = ParamUtil.getString(request, "OGRN");
        long regionId = ParamUtil.getLong(request, "RegionId");
        String registrationDate = ParamUtil.getString(request, "RegistrationDate");
        String archiveStatus = ParamUtil.getString(request, "ArchiveStatus");

        try {
            // Do whatever you want after creating new details
            String fieldRegions = ParamUtil.getString(request, "FieldRegion");
            long[] regionsId = parseFields(fieldRegions);
            try {
                List<Region> farmerRegions = RegionLocalServiceUtil.getFarmerRegions(farmerId);
                RegionLocalServiceUtil.deleteFarmerRegions(farmerId, farmerRegions);
                RegionLocalServiceUtil.addFarmerRegions(farmerId, regionsId);
            } catch (SystemException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        FarmerLocalServiceUtil.updateFarmer(farmerId, companyName, organizationForm, inn, kpp, ogrn, regionId, registrationDate, archiveStatus);


        SessionMessages.add(request, "farmerUpdated");
    }



    private long[] parseFields(String fields) throws SystemException {
        String fieldsStr = fields.replaceAll("\\s","");
        String[] parts = fieldsStr.split(",");


        long[] regionsId = new long[parts.length];
        int i = 0;
        for(String field : parts){
            Region regionFormDB = RegionLocalServiceUtil.findFirstRegionByName(field);
            regionsId[i] = regionFormDB.getRegionId();
            ++i;
        }
        return regionsId;
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

        List<FarmerEntity> farmers = null;
        try {
            farmers = fillFarmersList();
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        renderRequest.setAttribute("farmers", farmers);

        super.render(renderRequest, renderResponse);
    }

    private List<FarmerEntity> fillFarmersList() throws SystemException, PortalException {
        ArrayList<FarmerEntity> farmers = new ArrayList();
        List<Farmer> farmersFormDB= FarmerLocalServiceUtil.findAllFarmers();
        for (Farmer farmer : farmersFormDB) {
            FarmerEntity newFarmer = new FarmerEntity();
            newFarmer.setCompanyName(farmer.getCompanyName());
            newFarmer.setOrganizationForm(farmer.getOrganizationForm());
            newFarmer.setInn(farmer.getInn());
            newFarmer.setKpp(farmer.getKpp());
            newFarmer.setOgrn(farmer.getOgrn());
            newFarmer.setRegionId(farmer.getRegionId());
            newFarmer.setRegistrationDate(farmer.getRegistrationDate());
            newFarmer.setArchiveStatus(farmer.getArchiveStatus());
            newFarmer.setFarmerId(farmer.getFarmerId());
            List<Region> fields = RegionLocalServiceUtil.getFarmerRegions(farmer.getFarmerId());
            String fieldsName = "";
            for (Region field : fields){
                fieldsName += RegionLocalServiceUtil.getRegion(field.getRegionId()).getRegionName();
                fieldsName += ", ";
            }
            if (fieldsName.length() > 2 && fieldsName.charAt(fieldsName.length() - 2) == ',') {
                fieldsName = (fieldsName.substring(0, fieldsName.length() - 2));
            }
            newFarmer.setFieldRegion(fieldsName);
            farmers.add(newFarmer);
        }
        return farmers;
    }


//        public void addFarmer(ActionRequest request, ActionResponse response) {
//
//        try {
//            PortletPreferences prefs = request.getPreferences();
//            String[] listOfFarmers = prefs.getValues("list-of-farmers", new String[1]);
//            ArrayList<String> farmers = new ArrayList<String>();
//
//            if (listOfFarmers != null) {
//                farmers = new ArrayList<String>(Arrays.asList(prefs.getValues(
//                        "list-of-farmers", new String[1])));
//            }
//
//            String companyName = ParamUtil.getString(request, "CompanyName");
//            String organizationForm = ParamUtil.getString(request, "OrganizationForm");
//            String inn = ParamUtil.getString(request, "INN");
//            String kpp = ParamUtil.getString(request, "KPP");
//            String ogrn = ParamUtil.getString(request, "OGRN");
//            String registrationForm = ParamUtil.getString(request, "RegionId");
//            String fieldRegion = ParamUtil.getString(request, "FieldRegion");
//            String registrationDate = ParamUtil.getString(request, "RegistrationDate");
//            String archiveStatus = ParamUtil.getString(request, "ArchiveStatus");
//            String farmer = companyName + "^" + organizationForm + "^" + inn + "^" + kpp + "^" + ogrn + "^" +
//                    registrationForm + "^" + fieldRegion + "^" + registrationDate + "^" + archiveStatus;
//            farmers.add(farmer);
//            String[] array = farmers.toArray(new String[farmers.size()]);
//            prefs.setValues("list-of-farmers", array);
//
//            try {
//                prefs.store();
//            } catch (IOException ex) {
//                Logger.getLogger(FarmerMVC.class.getName()).log(
//                        Level.SEVERE, null, ex);
//            } catch (ValidatorException ex) {
//                Logger.getLogger(FarmerMVC.class.getName()).log(
//                        Level.SEVERE, null, ex);
//            }
//        } catch (ReadOnlyException ex) {
//            Logger.getLogger(FarmerMVC.class.getName()).log(
//                    Level.SEVERE, null, ex);
//        }
//    }
//
//    @Override
//    public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
//
//        PortletPreferences prefs = renderRequest.getPreferences();
//        String[] listOfFarmers = prefs.getValues("list-of-farmers", new String[1]);
//
//        if (listOfFarmers != null) {
//            List<Farmer> farmers = parseFarmers(listOfFarmers);
//            renderRequest.setAttribute("farmers", farmers);
//        }
//        super.render(renderRequest, renderResponse);
//    }
//
//    private List<Farmer> parseFarmers (String[] listOfFarmers) {
//        ArrayList<Farmer> farmers = new ArrayList();
//        for (String farmer : listOfFarmers) {
//            String[] parts = farmer.split("\\^", 9);
//            Farmer gbFarmer = new Farmer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
//            farmers.add(gbFarmer);
//        }
//        return farmers;
//    }
}
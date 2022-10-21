package com.liferay.farmerPortlet.service.messaging;

import com.liferay.farmerPortlet.service.ClpSerializer;
import com.liferay.farmerPortlet.service.FarmerLocalServiceUtil;
import com.liferay.farmerPortlet.service.FarmerServiceUtil;
import com.liferay.farmerPortlet.service.RegionLocalServiceUtil;
import com.liferay.farmerPortlet.service.RegionServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            FarmerLocalServiceUtil.clearService();

            FarmerServiceUtil.clearService();
            RegionLocalServiceUtil.clearService();

            RegionServiceUtil.clearService();
        }
    }
}

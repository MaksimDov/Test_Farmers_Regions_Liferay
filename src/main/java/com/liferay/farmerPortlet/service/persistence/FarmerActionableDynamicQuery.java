package com.liferay.farmerPortlet.service.persistence;

import com.liferay.farmerPortlet.model.Farmer;
import com.liferay.farmerPortlet.service.FarmerLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Test Test
 * @generated
 */
public abstract class FarmerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FarmerActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FarmerLocalServiceUtil.getService());
        setClass(Farmer.class);

        setClassLoader(com.liferay.farmerPortlet.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("farmerId");
    }
}

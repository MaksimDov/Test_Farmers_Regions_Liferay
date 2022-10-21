package com.liferay.farmerPortlet.service.persistence;

import com.liferay.farmerPortlet.model.Region;
import com.liferay.farmerPortlet.service.RegionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Test Test
 * @generated
 */
public abstract class RegionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RegionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RegionLocalServiceUtil.getService());
        setClass(Region.class);

        setClassLoader(com.liferay.farmerPortlet.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("regionId");
    }
}

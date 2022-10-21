package com.liferay.farmerPortlet.service.base;

import com.liferay.farmerPortlet.model.Farmer;
import com.liferay.farmerPortlet.service.FarmerService;
import com.liferay.farmerPortlet.service.persistence.FarmerPersistence;
import com.liferay.farmerPortlet.service.persistence.RegionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the farmer remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.farmerPortlet.service.impl.FarmerServiceImpl}.
 * </p>
 *
 * @author Test Test
 * @see com.liferay.farmerPortlet.service.impl.FarmerServiceImpl
 * @see com.liferay.farmerPortlet.service.FarmerServiceUtil
 * @generated
 */
public abstract class FarmerServiceBaseImpl extends BaseServiceImpl
    implements FarmerService, IdentifiableBean {
    @BeanReference(type = com.liferay.farmerPortlet.service.FarmerLocalService.class)
    protected com.liferay.farmerPortlet.service.FarmerLocalService farmerLocalService;
    @BeanReference(type = com.liferay.farmerPortlet.service.FarmerService.class)
    protected com.liferay.farmerPortlet.service.FarmerService farmerService;
    @BeanReference(type = FarmerPersistence.class)
    protected FarmerPersistence farmerPersistence;
    @BeanReference(type = com.liferay.farmerPortlet.service.RegionLocalService.class)
    protected com.liferay.farmerPortlet.service.RegionLocalService regionLocalService;
    @BeanReference(type = com.liferay.farmerPortlet.service.RegionService.class)
    protected com.liferay.farmerPortlet.service.RegionService regionService;
    @BeanReference(type = RegionPersistence.class)
    protected RegionPersistence regionPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private FarmerServiceClpInvoker _clpInvoker = new FarmerServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.liferay.farmerPortlet.service.FarmerServiceUtil} to access the farmer remote service.
     */

    /**
     * Returns the farmer local service.
     *
     * @return the farmer local service
     */
    public com.liferay.farmerPortlet.service.FarmerLocalService getFarmerLocalService() {
        return farmerLocalService;
    }

    /**
     * Sets the farmer local service.
     *
     * @param farmerLocalService the farmer local service
     */
    public void setFarmerLocalService(
        com.liferay.farmerPortlet.service.FarmerLocalService farmerLocalService) {
        this.farmerLocalService = farmerLocalService;
    }

    /**
     * Returns the farmer remote service.
     *
     * @return the farmer remote service
     */
    public com.liferay.farmerPortlet.service.FarmerService getFarmerService() {
        return farmerService;
    }

    /**
     * Sets the farmer remote service.
     *
     * @param farmerService the farmer remote service
     */
    public void setFarmerService(
        com.liferay.farmerPortlet.service.FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    /**
     * Returns the farmer persistence.
     *
     * @return the farmer persistence
     */
    public FarmerPersistence getFarmerPersistence() {
        return farmerPersistence;
    }

    /**
     * Sets the farmer persistence.
     *
     * @param farmerPersistence the farmer persistence
     */
    public void setFarmerPersistence(FarmerPersistence farmerPersistence) {
        this.farmerPersistence = farmerPersistence;
    }

    /**
     * Returns the region local service.
     *
     * @return the region local service
     */
    public com.liferay.farmerPortlet.service.RegionLocalService getRegionLocalService() {
        return regionLocalService;
    }

    /**
     * Sets the region local service.
     *
     * @param regionLocalService the region local service
     */
    public void setRegionLocalService(
        com.liferay.farmerPortlet.service.RegionLocalService regionLocalService) {
        this.regionLocalService = regionLocalService;
    }

    /**
     * Returns the region remote service.
     *
     * @return the region remote service
     */
    public com.liferay.farmerPortlet.service.RegionService getRegionService() {
        return regionService;
    }

    /**
     * Sets the region remote service.
     *
     * @param regionService the region remote service
     */
    public void setRegionService(
        com.liferay.farmerPortlet.service.RegionService regionService) {
        this.regionService = regionService;
    }

    /**
     * Returns the region persistence.
     *
     * @return the region persistence
     */
    public RegionPersistence getRegionPersistence() {
        return regionPersistence;
    }

    /**
     * Sets the region persistence.
     *
     * @param regionPersistence the region persistence
     */
    public void setRegionPersistence(RegionPersistence regionPersistence) {
        this.regionPersistence = regionPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Farmer.class;
    }

    protected String getModelClassName() {
        return Farmer.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = farmerPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}

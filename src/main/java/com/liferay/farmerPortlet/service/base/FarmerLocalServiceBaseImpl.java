package com.liferay.farmerPortlet.service.base;

import com.liferay.farmerPortlet.model.Farmer;
import com.liferay.farmerPortlet.service.FarmerLocalService;
import com.liferay.farmerPortlet.service.persistence.FarmerPersistence;
import com.liferay.farmerPortlet.service.persistence.RegionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the farmer local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.farmerPortlet.service.impl.FarmerLocalServiceImpl}.
 * </p>
 *
 * @author Test Test
 * @see com.liferay.farmerPortlet.service.impl.FarmerLocalServiceImpl
 * @see com.liferay.farmerPortlet.service.FarmerLocalServiceUtil
 * @generated
 */
public abstract class FarmerLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements FarmerLocalService, IdentifiableBean {
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
    private FarmerLocalServiceClpInvoker _clpInvoker = new FarmerLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.liferay.farmerPortlet.service.FarmerLocalServiceUtil} to access the farmer local service.
     */

    /**
     * Adds the farmer to the database. Also notifies the appropriate model listeners.
     *
     * @param farmer the farmer
     * @return the farmer that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Farmer addFarmer(Farmer farmer) throws SystemException {
        farmer.setNew(true);

        return farmerPersistence.update(farmer);
    }

    /**
     * Creates a new farmer with the primary key. Does not add the farmer to the database.
     *
     * @param farmerId the primary key for the new farmer
     * @return the new farmer
     */
    @Override
    public Farmer createFarmer(long farmerId) {
        return farmerPersistence.create(farmerId);
    }

    /**
     * Deletes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer that was removed
     * @throws PortalException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Farmer deleteFarmer(long farmerId)
        throws PortalException, SystemException {
        return farmerPersistence.remove(farmerId);
    }

    /**
     * Deletes the farmer from the database. Also notifies the appropriate model listeners.
     *
     * @param farmer the farmer
     * @return the farmer that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Farmer deleteFarmer(Farmer farmer) throws SystemException {
        return farmerPersistence.remove(farmer);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Farmer.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return farmerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return farmerPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return farmerPersistence.findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return farmerPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return farmerPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Farmer fetchFarmer(long farmerId) throws SystemException {
        return farmerPersistence.fetchByPrimaryKey(farmerId);
    }

    /**
     * Returns the farmer with the primary key.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer
     * @throws PortalException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer getFarmer(long farmerId)
        throws PortalException, SystemException {
        return farmerPersistence.findByPrimaryKey(farmerId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return farmerPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the farmers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of farmers
     * @param end the upper bound of the range of farmers (not inclusive)
     * @return the range of farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> getFarmers(int start, int end)
        throws SystemException {
        return farmerPersistence.findAll(start, end);
    }

    /**
     * Returns the number of farmers.
     *
     * @return the number of farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getFarmersCount() throws SystemException {
        return farmerPersistence.countAll();
    }

    /**
     * Updates the farmer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param farmer the farmer
     * @return the farmer that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Farmer updateFarmer(Farmer farmer) throws SystemException {
        return farmerPersistence.update(farmer);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addRegionFarmer(long regionId, long farmerId)
        throws SystemException {
        regionPersistence.addFarmer(regionId, farmerId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addRegionFarmer(long regionId, Farmer farmer)
        throws SystemException {
        regionPersistence.addFarmer(regionId, farmer);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addRegionFarmers(long regionId, long[] farmerIds)
        throws SystemException {
        regionPersistence.addFarmers(regionId, farmerIds);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addRegionFarmers(long regionId, List<Farmer> Farmers)
        throws SystemException {
        regionPersistence.addFarmers(regionId, Farmers);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearRegionFarmers(long regionId) throws SystemException {
        regionPersistence.clearFarmers(regionId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void deleteRegionFarmer(long regionId, long farmerId)
        throws SystemException {
        regionPersistence.removeFarmer(regionId, farmerId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void deleteRegionFarmer(long regionId, Farmer farmer)
        throws SystemException {
        regionPersistence.removeFarmer(regionId, farmer);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void deleteRegionFarmers(long regionId, long[] farmerIds)
        throws SystemException {
        regionPersistence.removeFarmers(regionId, farmerIds);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void deleteRegionFarmers(long regionId, List<Farmer> Farmers)
        throws SystemException {
        regionPersistence.removeFarmers(regionId, Farmers);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> getRegionFarmers(long regionId)
        throws SystemException {
        return regionPersistence.getFarmers(regionId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> getRegionFarmers(long regionId, int start, int end)
        throws SystemException {
        return regionPersistence.getFarmers(regionId, start, end);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> getRegionFarmers(long regionId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return regionPersistence.getFarmers(regionId, start, end,
            orderByComparator);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getRegionFarmersCount(long regionId) throws SystemException {
        return regionPersistence.getFarmersSize(regionId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean hasRegionFarmer(long regionId, long farmerId)
        throws SystemException {
        return regionPersistence.containsFarmer(regionId, farmerId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean hasRegionFarmers(long regionId) throws SystemException {
        return regionPersistence.containsFarmers(regionId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setRegionFarmers(long regionId, long[] farmerIds)
        throws SystemException {
        regionPersistence.setFarmers(regionId, farmerIds);
    }

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

        PersistedModelLocalServiceRegistryUtil.register("com.liferay.farmerPortlet.model.Farmer",
            farmerLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.liferay.farmerPortlet.model.Farmer");
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
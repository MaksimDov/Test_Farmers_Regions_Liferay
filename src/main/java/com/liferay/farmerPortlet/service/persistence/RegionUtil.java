package com.liferay.farmerPortlet.service.persistence;

import com.liferay.farmerPortlet.model.Region;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the region service. This utility wraps {@link RegionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Test Test
 * @see RegionPersistence
 * @see RegionPersistenceImpl
 * @generated
 */
public class RegionUtil {
    private static RegionPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Region region) {
        getPersistence().clearCache(region);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Region update(Region region) throws SystemException {
        return getPersistence().update(region);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Region update(Region region, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(region, serviceContext);
    }

    /**
    * Returns all the regions where regionName = &#63;.
    *
    * @param regionName the region name
    * @return the matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionName(
        java.lang.String regionName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFindByRegionName(regionName);
    }

    /**
    * Returns a range of all the regions where regionName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param regionName the region name
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionName(
        java.lang.String regionName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFindByRegionName(regionName, start, end);
    }

    /**
    * Returns an ordered range of all the regions where regionName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param regionName the region name
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionName(
        java.lang.String regionName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFindByRegionName(regionName, start, end,
            orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where regionName = &#63;.
    *
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region findByFindByRegionName_First(
        java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFindByRegionName_First(regionName, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where regionName = &#63;.
    *
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region fetchByFindByRegionName_First(
        java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFindByRegionName_First(regionName, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where regionName = &#63;.
    *
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region findByFindByRegionName_Last(
        java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFindByRegionName_Last(regionName, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where regionName = &#63;.
    *
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region fetchByFindByRegionName_Last(
        java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFindByRegionName_Last(regionName, orderByComparator);
    }

    /**
    * Returns the regions before and after the current region in the ordered set where regionName = &#63;.
    *
    * @param regionId the primary key of the current region
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region[] findByFindByRegionName_PrevAndNext(
        long regionId, java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFindByRegionName_PrevAndNext(regionId, regionName,
            orderByComparator);
    }

    /**
    * Removes all the regions where regionName = &#63; from the database.
    *
    * @param regionName the region name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFindByRegionName(java.lang.String regionName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFindByRegionName(regionName);
    }

    /**
    * Returns the number of regions where regionName = &#63;.
    *
    * @param regionName the region name
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static int countByFindByRegionName(java.lang.String regionName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFindByRegionName(regionName);
    }

    /**
    * Returns all the regions where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @return the matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionCode(
        java.lang.String regionCode)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFindByRegionCode(regionCode);
    }

    /**
    * Returns a range of all the regions where regionCode = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param regionCode the region code
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionCode(
        java.lang.String regionCode, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFindByRegionCode(regionCode, start, end);
    }

    /**
    * Returns an ordered range of all the regions where regionCode = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param regionCode the region code
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionCode(
        java.lang.String regionCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFindByRegionCode(regionCode, start, end,
            orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region findByFindByRegionCode_First(
        java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFindByRegionCode_First(regionCode, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region fetchByFindByRegionCode_First(
        java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFindByRegionCode_First(regionCode, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region findByFindByRegionCode_Last(
        java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFindByRegionCode_Last(regionCode, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region fetchByFindByRegionCode_Last(
        java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFindByRegionCode_Last(regionCode, orderByComparator);
    }

    /**
    * Returns the regions before and after the current region in the ordered set where regionCode = &#63;.
    *
    * @param regionId the primary key of the current region
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region[] findByFindByRegionCode_PrevAndNext(
        long regionId, java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFindByRegionCode_PrevAndNext(regionId, regionCode,
            orderByComparator);
    }

    /**
    * Removes all the regions where regionCode = &#63; from the database.
    *
    * @param regionCode the region code
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFindByRegionCode(java.lang.String regionCode)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFindByRegionCode(regionCode);
    }

    /**
    * Returns the number of regions where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static int countByFindByRegionCode(java.lang.String regionCode)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFindByRegionCode(regionCode);
    }

    /**
    * Caches the region in the entity cache if it is enabled.
    *
    * @param region the region
    */
    public static void cacheResult(
        com.liferay.farmerPortlet.model.Region region) {
        getPersistence().cacheResult(region);
    }

    /**
    * Caches the regions in the entity cache if it is enabled.
    *
    * @param regions the regions
    */
    public static void cacheResult(
        java.util.List<com.liferay.farmerPortlet.model.Region> regions) {
        getPersistence().cacheResult(regions);
    }

    /**
    * Creates a new region with the primary key. Does not add the region to the database.
    *
    * @param regionId the primary key for the new region
    * @return the new region
    */
    public static com.liferay.farmerPortlet.model.Region create(long regionId) {
        return getPersistence().create(regionId);
    }

    /**
    * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param regionId the primary key of the region
    * @return the region that was removed
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region remove(long regionId)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(regionId);
    }

    public static com.liferay.farmerPortlet.model.Region updateImpl(
        com.liferay.farmerPortlet.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(region);
    }

    /**
    * Returns the region with the primary key or throws a {@link com.liferay.farmerPortlet.NoSuchRegionException} if it could not be found.
    *
    * @param regionId the primary key of the region
    * @return the region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region findByPrimaryKey(
        long regionId)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(regionId);
    }

    /**
    * Returns the region with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param regionId the primary key of the region
    * @return the region, or <code>null</code> if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.farmerPortlet.model.Region fetchByPrimaryKey(
        long regionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(regionId);
    }

    /**
    * Returns all the regions.
    *
    * @return the regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the regions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the regions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Region> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the regions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of regions.
    *
    * @return the number of regions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the farmers associated with the region.
    *
    * @param pk the primary key of the region
    * @return the farmers associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Farmer> getFarmers(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getFarmers(pk);
    }

    /**
    * Returns a range of all the farmers associated with the region.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the region
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of farmers associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Farmer> getFarmers(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getFarmers(pk, start, end);
    }

    /**
    * Returns an ordered range of all the farmers associated with the region.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the region
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of farmers associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.farmerPortlet.model.Farmer> getFarmers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getFarmers(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of farmers associated with the region.
    *
    * @param pk the primary key of the region
    * @return the number of farmers associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static int getFarmersSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getFarmersSize(pk);
    }

    /**
    * Returns <code>true</code> if the farmer is associated with the region.
    *
    * @param pk the primary key of the region
    * @param farmerPK the primary key of the farmer
    * @return <code>true</code> if the farmer is associated with the region; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsFarmer(long pk, long farmerPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsFarmer(pk, farmerPK);
    }

    /**
    * Returns <code>true</code> if the region has any farmers associated with it.
    *
    * @param pk the primary key of the region to check for associations with farmers
    * @return <code>true</code> if the region has any farmers associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsFarmers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsFarmers(pk);
    }

    /**
    * Adds an association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPK the primary key of the farmer
    * @throws SystemException if a system exception occurred
    */
    public static void addFarmer(long pk, long farmerPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addFarmer(pk, farmerPK);
    }

    /**
    * Adds an association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmer the farmer
    * @throws SystemException if a system exception occurred
    */
    public static void addFarmer(long pk,
        com.liferay.farmerPortlet.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addFarmer(pk, farmer);
    }

    /**
    * Adds an association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPKs the primary keys of the farmers
    * @throws SystemException if a system exception occurred
    */
    public static void addFarmers(long pk, long[] farmerPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addFarmers(pk, farmerPKs);
    }

    /**
    * Adds an association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmers the farmers
    * @throws SystemException if a system exception occurred
    */
    public static void addFarmers(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addFarmers(pk, farmers);
    }

    /**
    * Clears all associations between the region and its farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region to clear the associated farmers from
    * @throws SystemException if a system exception occurred
    */
    public static void clearFarmers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearFarmers(pk);
    }

    /**
    * Removes the association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPK the primary key of the farmer
    * @throws SystemException if a system exception occurred
    */
    public static void removeFarmer(long pk, long farmerPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeFarmer(pk, farmerPK);
    }

    /**
    * Removes the association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmer the farmer
    * @throws SystemException if a system exception occurred
    */
    public static void removeFarmer(long pk,
        com.liferay.farmerPortlet.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeFarmer(pk, farmer);
    }

    /**
    * Removes the association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPKs the primary keys of the farmers
    * @throws SystemException if a system exception occurred
    */
    public static void removeFarmers(long pk, long[] farmerPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeFarmers(pk, farmerPKs);
    }

    /**
    * Removes the association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmers the farmers
    * @throws SystemException if a system exception occurred
    */
    public static void removeFarmers(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeFarmers(pk, farmers);
    }

    /**
    * Sets the farmers associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPKs the primary keys of the farmers to be associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static void setFarmers(long pk, long[] farmerPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setFarmers(pk, farmerPKs);
    }

    /**
    * Sets the farmers associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmers the farmers to be associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static void setFarmers(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setFarmers(pk, farmers);
    }

    public static RegionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RegionPersistence) PortletBeanLocatorUtil.locate(com.liferay.farmerPortlet.service.ClpSerializer.getServletContextName(),
                    RegionPersistence.class.getName());

            ReferenceRegistry.registerReference(RegionUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(RegionPersistence persistence) {
    }
}

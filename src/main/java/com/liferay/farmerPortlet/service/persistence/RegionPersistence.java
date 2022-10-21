package com.liferay.farmerPortlet.service.persistence;

import com.liferay.farmerPortlet.model.Region;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Test Test
 * @see RegionPersistenceImpl
 * @see RegionUtil
 * @generated
 */
public interface RegionPersistence extends BasePersistence<Region> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RegionUtil} to access the region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the regions where regionName = &#63;.
    *
    * @param regionName the region name
    * @return the matching regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionName(
        java.lang.String regionName)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionName(
        java.lang.String regionName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionName(
        java.lang.String regionName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first region in the ordered set where regionName = &#63;.
    *
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region findByFindByRegionName_First(
        java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first region in the ordered set where regionName = &#63;.
    *
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region fetchByFindByRegionName_First(
        java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last region in the ordered set where regionName = &#63;.
    *
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region findByFindByRegionName_Last(
        java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last region in the ordered set where regionName = &#63;.
    *
    * @param regionName the region name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region fetchByFindByRegionName_Last(
        java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.farmerPortlet.model.Region[] findByFindByRegionName_PrevAndNext(
        long regionId, java.lang.String regionName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the regions where regionName = &#63; from the database.
    *
    * @param regionName the region name
    * @throws SystemException if a system exception occurred
    */
    public void removeByFindByRegionName(java.lang.String regionName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of regions where regionName = &#63;.
    *
    * @param regionName the region name
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public int countByFindByRegionName(java.lang.String regionName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the regions where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @return the matching regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionCode(
        java.lang.String regionCode)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionCode(
        java.lang.String regionCode, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Region> findByFindByRegionCode(
        java.lang.String regionCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first region in the ordered set where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region findByFindByRegionCode_First(
        java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first region in the ordered set where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region fetchByFindByRegionCode_First(
        java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last region in the ordered set where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region findByFindByRegionCode_Last(
        java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last region in the ordered set where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region fetchByFindByRegionCode_Last(
        java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.farmerPortlet.model.Region[] findByFindByRegionCode_PrevAndNext(
        long regionId, java.lang.String regionCode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the regions where regionCode = &#63; from the database.
    *
    * @param regionCode the region code
    * @throws SystemException if a system exception occurred
    */
    public void removeByFindByRegionCode(java.lang.String regionCode)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of regions where regionCode = &#63;.
    *
    * @param regionCode the region code
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public int countByFindByRegionCode(java.lang.String regionCode)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the region in the entity cache if it is enabled.
    *
    * @param region the region
    */
    public void cacheResult(com.liferay.farmerPortlet.model.Region region);

    /**
    * Caches the regions in the entity cache if it is enabled.
    *
    * @param regions the regions
    */
    public void cacheResult(
        java.util.List<com.liferay.farmerPortlet.model.Region> regions);

    /**
    * Creates a new region with the primary key. Does not add the region to the database.
    *
    * @param regionId the primary key for the new region
    * @return the new region
    */
    public com.liferay.farmerPortlet.model.Region create(long regionId);

    /**
    * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param regionId the primary key of the region
    * @return the region that was removed
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region remove(long regionId)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.farmerPortlet.model.Region updateImpl(
        com.liferay.farmerPortlet.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the region with the primary key or throws a {@link com.liferay.farmerPortlet.NoSuchRegionException} if it could not be found.
    *
    * @param regionId the primary key of the region
    * @return the region
    * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region findByPrimaryKey(
        long regionId)
        throws com.liferay.farmerPortlet.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the region with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param regionId the primary key of the region
    * @return the region, or <code>null</code> if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Region fetchByPrimaryKey(
        long regionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the regions.
    *
    * @return the regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Region> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Region> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Region> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the regions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of regions.
    *
    * @return the number of regions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the farmers associated with the region.
    *
    * @param pk the primary key of the region
    * @return the farmers associated with the region
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> getFarmers(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> getFarmers(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> getFarmers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmers associated with the region.
    *
    * @param pk the primary key of the region
    * @return the number of farmers associated with the region
    * @throws SystemException if a system exception occurred
    */
    public int getFarmersSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the farmer is associated with the region.
    *
    * @param pk the primary key of the region
    * @param farmerPK the primary key of the farmer
    * @return <code>true</code> if the farmer is associated with the region; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsFarmer(long pk, long farmerPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the region has any farmers associated with it.
    *
    * @param pk the primary key of the region to check for associations with farmers
    * @return <code>true</code> if the region has any farmers associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsFarmers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPK the primary key of the farmer
    * @throws SystemException if a system exception occurred
    */
    public void addFarmer(long pk, long farmerPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmer the farmer
    * @throws SystemException if a system exception occurred
    */
    public void addFarmer(long pk, com.liferay.farmerPortlet.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPKs the primary keys of the farmers
    * @throws SystemException if a system exception occurred
    */
    public void addFarmers(long pk, long[] farmerPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmers the farmers
    * @throws SystemException if a system exception occurred
    */
    public void addFarmers(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the region and its farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region to clear the associated farmers from
    * @throws SystemException if a system exception occurred
    */
    public void clearFarmers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPK the primary key of the farmer
    * @throws SystemException if a system exception occurred
    */
    public void removeFarmer(long pk, long farmerPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmer the farmer
    * @throws SystemException if a system exception occurred
    */
    public void removeFarmer(long pk,
        com.liferay.farmerPortlet.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPKs the primary keys of the farmers
    * @throws SystemException if a system exception occurred
    */
    public void removeFarmers(long pk, long[] farmerPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmers the farmers
    * @throws SystemException if a system exception occurred
    */
    public void removeFarmers(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the farmers associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmerPKs the primary keys of the farmers to be associated with the region
    * @throws SystemException if a system exception occurred
    */
    public void setFarmers(long pk, long[] farmerPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the farmers associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param farmers the farmers to be associated with the region
    * @throws SystemException if a system exception occurred
    */
    public void setFarmers(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws com.liferay.portal.kernel.exception.SystemException;
}

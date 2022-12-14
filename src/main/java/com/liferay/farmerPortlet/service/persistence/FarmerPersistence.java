package com.liferay.farmerPortlet.service.persistence;

import com.liferay.farmerPortlet.model.Farmer;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the farmer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Test Test
 * @see FarmerPersistenceImpl
 * @see FarmerUtil
 * @generated
 */
public interface FarmerPersistence extends BasePersistence<Farmer> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link FarmerUtil} to access the farmer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the farmers where companyName = &#63;.
    *
    * @param companyName the company name
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> findByFindByCompanyName(
        java.lang.String companyName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the farmers where companyName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyName the company name
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> findByFindByCompanyName(
        java.lang.String companyName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the farmers where companyName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyName the company name
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> findByFindByCompanyName(
        java.lang.String companyName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first farmer in the ordered set where companyName = &#63;.
    *
    * @param companyName the company name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Farmer findByFindByCompanyName_First(
        java.lang.String companyName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchFarmerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first farmer in the ordered set where companyName = &#63;.
    *
    * @param companyName the company name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Farmer fetchByFindByCompanyName_First(
        java.lang.String companyName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last farmer in the ordered set where companyName = &#63;.
    *
    * @param companyName the company name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Farmer findByFindByCompanyName_Last(
        java.lang.String companyName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchFarmerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last farmer in the ordered set where companyName = &#63;.
    *
    * @param companyName the company name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Farmer fetchByFindByCompanyName_Last(
        java.lang.String companyName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmers before and after the current farmer in the ordered set where companyName = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param companyName the company name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Farmer[] findByFindByCompanyName_PrevAndNext(
        long farmerId, java.lang.String companyName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.farmerPortlet.NoSuchFarmerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the farmers where companyName = &#63; from the database.
    *
    * @param companyName the company name
    * @throws SystemException if a system exception occurred
    */
    public void removeByFindByCompanyName(java.lang.String companyName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmers where companyName = &#63;.
    *
    * @param companyName the company name
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public int countByFindByCompanyName(java.lang.String companyName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the farmer in the entity cache if it is enabled.
    *
    * @param farmer the farmer
    */
    public void cacheResult(com.liferay.farmerPortlet.model.Farmer farmer);

    /**
    * Caches the farmers in the entity cache if it is enabled.
    *
    * @param farmers the farmers
    */
    public void cacheResult(
        java.util.List<com.liferay.farmerPortlet.model.Farmer> farmers);

    /**
    * Creates a new farmer with the primary key. Does not add the farmer to the database.
    *
    * @param farmerId the primary key for the new farmer
    * @return the new farmer
    */
    public com.liferay.farmerPortlet.model.Farmer create(long farmerId);

    /**
    * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer that was removed
    * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Farmer remove(long farmerId)
        throws com.liferay.farmerPortlet.NoSuchFarmerException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.farmerPortlet.model.Farmer updateImpl(
        com.liferay.farmerPortlet.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmer with the primary key or throws a {@link com.liferay.farmerPortlet.NoSuchFarmerException} if it could not be found.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer
    * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Farmer findByPrimaryKey(
        long farmerId)
        throws com.liferay.farmerPortlet.NoSuchFarmerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.farmerPortlet.model.Farmer fetchByPrimaryKey(
        long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the farmers.
    *
    * @return the farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the farmers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Farmer> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the farmers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmers.
    *
    * @return the number of farmers
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the regions associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @return the regions associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Region> getRegions(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the regions associated with the farmer.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the farmer
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of regions associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Region> getRegions(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the regions associated with the farmer.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.farmerPortlet.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the farmer
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of regions associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.farmerPortlet.model.Region> getRegions(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of regions associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @return the number of regions associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public int getRegionsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the region is associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @param regionPK the primary key of the region
    * @return <code>true</code> if the region is associated with the farmer; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the farmer has any regions associated with it.
    *
    * @param pk the primary key of the farmer to check for associations with regions
    * @return <code>true</code> if the farmer has any regions associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsRegions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the farmer and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param regionPK the primary key of the region
    * @throws SystemException if a system exception occurred
    */
    public void addRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the farmer and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param region the region
    * @throws SystemException if a system exception occurred
    */
    public void addRegion(long pk, com.liferay.farmerPortlet.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the farmer and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param regionPKs the primary keys of the regions
    * @throws SystemException if a system exception occurred
    */
    public void addRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the farmer and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param regions the regions
    * @throws SystemException if a system exception occurred
    */
    public void addRegions(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the farmer and its regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer to clear the associated regions from
    * @throws SystemException if a system exception occurred
    */
    public void clearRegions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the farmer and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param regionPK the primary key of the region
    * @throws SystemException if a system exception occurred
    */
    public void removeRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the farmer and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param region the region
    * @throws SystemException if a system exception occurred
    */
    public void removeRegion(long pk,
        com.liferay.farmerPortlet.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the farmer and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param regionPKs the primary keys of the regions
    * @throws SystemException if a system exception occurred
    */
    public void removeRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the farmer and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param regions the regions
    * @throws SystemException if a system exception occurred
    */
    public void removeRegions(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the regions associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param regionPKs the primary keys of the regions to be associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public void setRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the regions associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param regions the regions to be associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public void setRegions(long pk,
        java.util.List<com.liferay.farmerPortlet.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException;
}

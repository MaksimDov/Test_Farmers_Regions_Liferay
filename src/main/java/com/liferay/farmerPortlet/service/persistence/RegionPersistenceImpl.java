package com.liferay.farmerPortlet.service.persistence;

import com.liferay.farmerPortlet.NoSuchRegionException;
import com.liferay.farmerPortlet.model.Region;
import com.liferay.farmerPortlet.model.impl.RegionImpl;
import com.liferay.farmerPortlet.model.impl.RegionModelImpl;
import com.liferay.farmerPortlet.service.persistence.FarmerPersistence;
import com.liferay.farmerPortlet.service.persistence.RegionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Test Test
 * @see RegionPersistence
 * @see RegionUtil
 * @generated
 */
public class RegionPersistenceImpl extends BasePersistenceImpl<Region>
    implements RegionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RegionUtil} to access the region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RegionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYREGIONNAME =
        new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByRegionName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONNAME =
        new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByFindByRegionName", new String[] { String.class.getName() },
            RegionModelImpl.REGIONNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYREGIONNAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByFindByRegionName", new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_1 = "region.regionName IS NULL";
    private static final String _FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_2 = "region.regionName = ?";
    private static final String _FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_3 = "(region.regionName IS NULL OR region.regionName = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYREGIONCODE =
        new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByRegionCode",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONCODE =
        new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByFindByRegionCode", new String[] { String.class.getName() },
            RegionModelImpl.REGIONCODE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYREGIONCODE = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByFindByRegionCode", new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_1 = "region.regionCode IS NULL";
    private static final String _FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_2 = "region.regionCode = ?";
    private static final String _FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_3 = "(region.regionCode IS NULL OR region.regionCode = '')";
    private static final String _SQL_SELECT_REGION = "SELECT region FROM Region region";
    private static final String _SQL_SELECT_REGION_WHERE = "SELECT region FROM Region region WHERE ";
    private static final String _SQL_COUNT_REGION = "SELECT COUNT(region) FROM Region region";
    private static final String _SQL_COUNT_REGION_WHERE = "SELECT COUNT(region) FROM Region region WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "region.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Region exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Region exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RegionPersistenceImpl.class);
    private static Region _nullRegion = new RegionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Region> toCacheModel() {
                return _nullRegionCacheModel;
            }
        };

    private static CacheModel<Region> _nullRegionCacheModel = new CacheModel<Region>() {
            @Override
            public Region toEntityModel() {
                return _nullRegion;
            }
        };

    @BeanReference(type = FarmerPersistence.class)
    protected FarmerPersistence farmerPersistence;
    protected TableMapper<Region, com.liferay.farmerPortlet.model.Farmer> regionToFarmerTableMapper;

    public RegionPersistenceImpl() {
        setModelClass(Region.class);
    }

    /**
     * Returns all the regions where regionName = &#63;.
     *
     * @param regionName the region name
     * @return the matching regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Region> findByFindByRegionName(String regionName)
        throws SystemException {
        return findByFindByRegionName(regionName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Region> findByFindByRegionName(String regionName, int start,
        int end) throws SystemException {
        return findByFindByRegionName(regionName, start, end, null);
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
    @Override
    public List<Region> findByFindByRegionName(String regionName, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONNAME;
            finderArgs = new Object[] { regionName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYREGIONNAME;
            finderArgs = new Object[] { regionName, start, end, orderByComparator };
        }

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Region region : list) {
                if (!Validator.equals(regionName, region.getRegionName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_REGION_WHERE);

            boolean bindRegionName = false;

            if (regionName == null) {
                query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_1);
            } else if (regionName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_3);
            } else {
                bindRegionName = true;

                query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RegionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindRegionName) {
                    qPos.add(regionName);
                }

                if (!pagination) {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Region>(list);
                } else {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Region findByFindByRegionName_First(String regionName,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByFindByRegionName_First(regionName,
                orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("regionName=");
        msg.append(regionName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the first region in the ordered set where regionName = &#63;.
     *
     * @param regionName the region name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByFindByRegionName_First(String regionName,
        OrderByComparator orderByComparator) throws SystemException {
        List<Region> list = findByFindByRegionName(regionName, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Region findByFindByRegionName_Last(String regionName,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByFindByRegionName_Last(regionName,
                orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("regionName=");
        msg.append(regionName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the last region in the ordered set where regionName = &#63;.
     *
     * @param regionName the region name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByFindByRegionName_Last(String regionName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByFindByRegionName(regionName);

        if (count == 0) {
            return null;
        }

        List<Region> list = findByFindByRegionName(regionName, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Region[] findByFindByRegionName_PrevAndNext(long regionId,
        String regionName, OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = findByPrimaryKey(regionId);

        Session session = null;

        try {
            session = openSession();

            Region[] array = new RegionImpl[3];

            array[0] = getByFindByRegionName_PrevAndNext(session, region,
                    regionName, orderByComparator, true);

            array[1] = region;

            array[2] = getByFindByRegionName_PrevAndNext(session, region,
                    regionName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Region getByFindByRegionName_PrevAndNext(Session session,
        Region region, String regionName, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REGION_WHERE);

        boolean bindRegionName = false;

        if (regionName == null) {
            query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_1);
        } else if (regionName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_3);
        } else {
            bindRegionName = true;

            query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RegionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindRegionName) {
            qPos.add(regionName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(region);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Region> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the regions where regionName = &#63; from the database.
     *
     * @param regionName the region name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByFindByRegionName(String regionName)
        throws SystemException {
        for (Region region : findByFindByRegionName(regionName,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(region);
        }
    }

    /**
     * Returns the number of regions where regionName = &#63;.
     *
     * @param regionName the region name
     * @return the number of matching regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByFindByRegionName(String regionName)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYREGIONNAME;

        Object[] finderArgs = new Object[] { regionName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_REGION_WHERE);

            boolean bindRegionName = false;

            if (regionName == null) {
                query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_1);
            } else if (regionName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_3);
            } else {
                bindRegionName = true;

                query.append(_FINDER_COLUMN_FINDBYREGIONNAME_REGIONNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindRegionName) {
                    qPos.add(regionName);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the regions where regionCode = &#63;.
     *
     * @param regionCode the region code
     * @return the matching regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Region> findByFindByRegionCode(String regionCode)
        throws SystemException {
        return findByFindByRegionCode(regionCode, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Region> findByFindByRegionCode(String regionCode, int start,
        int end) throws SystemException {
        return findByFindByRegionCode(regionCode, start, end, null);
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
    @Override
    public List<Region> findByFindByRegionCode(String regionCode, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONCODE;
            finderArgs = new Object[] { regionCode };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYREGIONCODE;
            finderArgs = new Object[] { regionCode, start, end, orderByComparator };
        }

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Region region : list) {
                if (!Validator.equals(regionCode, region.getRegionCode())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_REGION_WHERE);

            boolean bindRegionCode = false;

            if (regionCode == null) {
                query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_1);
            } else if (regionCode.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_3);
            } else {
                bindRegionCode = true;

                query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RegionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindRegionCode) {
                    qPos.add(regionCode);
                }

                if (!pagination) {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Region>(list);
                } else {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Region findByFindByRegionCode_First(String regionCode,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByFindByRegionCode_First(regionCode,
                orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("regionCode=");
        msg.append(regionCode);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the first region in the ordered set where regionCode = &#63;.
     *
     * @param regionCode the region code
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByFindByRegionCode_First(String regionCode,
        OrderByComparator orderByComparator) throws SystemException {
        List<Region> list = findByFindByRegionCode(regionCode, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Region findByFindByRegionCode_Last(String regionCode,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByFindByRegionCode_Last(regionCode,
                orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("regionCode=");
        msg.append(regionCode);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the last region in the ordered set where regionCode = &#63;.
     *
     * @param regionCode the region code
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByFindByRegionCode_Last(String regionCode,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByFindByRegionCode(regionCode);

        if (count == 0) {
            return null;
        }

        List<Region> list = findByFindByRegionCode(regionCode, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Region[] findByFindByRegionCode_PrevAndNext(long regionId,
        String regionCode, OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = findByPrimaryKey(regionId);

        Session session = null;

        try {
            session = openSession();

            Region[] array = new RegionImpl[3];

            array[0] = getByFindByRegionCode_PrevAndNext(session, region,
                    regionCode, orderByComparator, true);

            array[1] = region;

            array[2] = getByFindByRegionCode_PrevAndNext(session, region,
                    regionCode, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Region getByFindByRegionCode_PrevAndNext(Session session,
        Region region, String regionCode, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REGION_WHERE);

        boolean bindRegionCode = false;

        if (regionCode == null) {
            query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_1);
        } else if (regionCode.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_3);
        } else {
            bindRegionCode = true;

            query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RegionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindRegionCode) {
            qPos.add(regionCode);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(region);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Region> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the regions where regionCode = &#63; from the database.
     *
     * @param regionCode the region code
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByFindByRegionCode(String regionCode)
        throws SystemException {
        for (Region region : findByFindByRegionCode(regionCode,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(region);
        }
    }

    /**
     * Returns the number of regions where regionCode = &#63;.
     *
     * @param regionCode the region code
     * @return the number of matching regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByFindByRegionCode(String regionCode)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYREGIONCODE;

        Object[] finderArgs = new Object[] { regionCode };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_REGION_WHERE);

            boolean bindRegionCode = false;

            if (regionCode == null) {
                query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_1);
            } else if (regionCode.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_3);
            } else {
                bindRegionCode = true;

                query.append(_FINDER_COLUMN_FINDBYREGIONCODE_REGIONCODE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindRegionCode) {
                    qPos.add(regionCode);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the region in the entity cache if it is enabled.
     *
     * @param region the region
     */
    @Override
    public void cacheResult(Region region) {
        EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey(), region);

        region.resetOriginalValues();
    }

    /**
     * Caches the regions in the entity cache if it is enabled.
     *
     * @param regions the regions
     */
    @Override
    public void cacheResult(List<Region> regions) {
        for (Region region : regions) {
            if (EntityCacheUtil.getResult(
                        RegionModelImpl.ENTITY_CACHE_ENABLED, RegionImpl.class,
                        region.getPrimaryKey()) == null) {
                cacheResult(region);
            } else {
                region.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all regions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RegionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RegionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the region.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Region region) {
        EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Region> regions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Region region : regions) {
            EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                RegionImpl.class, region.getPrimaryKey());
        }
    }

    /**
     * Creates a new region with the primary key. Does not add the region to the database.
     *
     * @param regionId the primary key for the new region
     * @return the new region
     */
    @Override
    public Region create(long regionId) {
        Region region = new RegionImpl();

        region.setNew(true);
        region.setPrimaryKey(regionId);

        return region;
    }

    /**
     * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param regionId the primary key of the region
     * @return the region that was removed
     * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region remove(long regionId)
        throws NoSuchRegionException, SystemException {
        return remove((Serializable) regionId);
    }

    /**
     * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the region
     * @return the region that was removed
     * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region remove(Serializable primaryKey)
        throws NoSuchRegionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Region region = (Region) session.get(RegionImpl.class, primaryKey);

            if (region == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(region);
        } catch (NoSuchRegionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Region removeImpl(Region region) throws SystemException {
        region = toUnwrappedModel(region);

        regionToFarmerTableMapper.deleteLeftPrimaryKeyTableMappings(region.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(region)) {
                region = (Region) session.get(RegionImpl.class,
                        region.getPrimaryKeyObj());
            }

            if (region != null) {
                session.delete(region);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (region != null) {
            clearCache(region);
        }

        return region;
    }

    @Override
    public Region updateImpl(com.liferay.farmerPortlet.model.Region region)
        throws SystemException {
        region = toUnwrappedModel(region);

        boolean isNew = region.isNew();

        RegionModelImpl regionModelImpl = (RegionModelImpl) region;

        Session session = null;

        try {
            session = openSession();

            if (region.isNew()) {
                session.save(region);

                region.setNew(false);
            } else {
                session.merge(region);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RegionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((regionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        regionModelImpl.getOriginalRegionName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYREGIONNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONNAME,
                    args);

                args = new Object[] { regionModelImpl.getRegionName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYREGIONNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONNAME,
                    args);
            }

            if ((regionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONCODE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        regionModelImpl.getOriginalRegionCode()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYREGIONCODE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONCODE,
                    args);

                args = new Object[] { regionModelImpl.getRegionCode() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYREGIONCODE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYREGIONCODE,
                    args);
            }
        }

        EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey(), region);

        return region;
    }

    protected Region toUnwrappedModel(Region region) {
        if (region instanceof RegionImpl) {
            return region;
        }

        RegionImpl regionImpl = new RegionImpl();

        regionImpl.setNew(region.isNew());
        regionImpl.setPrimaryKey(region.getPrimaryKey());

        regionImpl.setRegionId(region.getRegionId());
        regionImpl.setRegionName(region.getRegionName());
        regionImpl.setRegionCode(region.getRegionCode());
        regionImpl.setArchiveStatus(region.getArchiveStatus());

        return regionImpl;
    }

    /**
     * Returns the region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the region
     * @return the region
     * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region findByPrimaryKey(Serializable primaryKey)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByPrimaryKey(primaryKey);

        if (region == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return region;
    }

    /**
     * Returns the region with the primary key or throws a {@link com.liferay.farmerPortlet.NoSuchRegionException} if it could not be found.
     *
     * @param regionId the primary key of the region
     * @return the region
     * @throws com.liferay.farmerPortlet.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region findByPrimaryKey(long regionId)
        throws NoSuchRegionException, SystemException {
        return findByPrimaryKey((Serializable) regionId);
    }

    /**
     * Returns the region with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the region
     * @return the region, or <code>null</code> if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Region region = (Region) EntityCacheUtil.getResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                RegionImpl.class, primaryKey);

        if (region == _nullRegion) {
            return null;
        }

        if (region == null) {
            Session session = null;

            try {
                session = openSession();

                region = (Region) session.get(RegionImpl.class, primaryKey);

                if (region != null) {
                    cacheResult(region);
                } else {
                    EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                        RegionImpl.class, primaryKey, _nullRegion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                    RegionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return region;
    }

    /**
     * Returns the region with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param regionId the primary key of the region
     * @return the region, or <code>null</code> if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByPrimaryKey(long regionId) throws SystemException {
        return fetchByPrimaryKey((Serializable) regionId);
    }

    /**
     * Returns all the regions.
     *
     * @return the regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Region> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Region> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Region> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REGION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REGION;

                if (pagination) {
                    sql = sql.concat(RegionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Region>(list);
                } else {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the regions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Region region : findAll()) {
            remove(region);
        }
    }

    /**
     * Returns the number of regions.
     *
     * @return the number of regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_REGION);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the farmers associated with the region.
     *
     * @param pk the primary key of the region
     * @return the farmers associated with the region
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.liferay.farmerPortlet.model.Farmer> getFarmers(long pk)
        throws SystemException {
        return getFarmers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
    @Override
    public List<com.liferay.farmerPortlet.model.Farmer> getFarmers(long pk,
        int start, int end) throws SystemException {
        return getFarmers(pk, start, end, null);
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
    @Override
    public List<com.liferay.farmerPortlet.model.Farmer> getFarmers(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return regionToFarmerTableMapper.getRightBaseModels(pk, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of farmers associated with the region.
     *
     * @param pk the primary key of the region
     * @return the number of farmers associated with the region
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getFarmersSize(long pk) throws SystemException {
        long[] pks = regionToFarmerTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the farmer is associated with the region.
     *
     * @param pk the primary key of the region
     * @param farmerPK the primary key of the farmer
     * @return <code>true</code> if the farmer is associated with the region; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsFarmer(long pk, long farmerPK)
        throws SystemException {
        return regionToFarmerTableMapper.containsTableMapping(pk, farmerPK);
    }

    /**
     * Returns <code>true</code> if the region has any farmers associated with it.
     *
     * @param pk the primary key of the region to check for associations with farmers
     * @return <code>true</code> if the region has any farmers associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsFarmers(long pk) throws SystemException {
        if (getFarmersSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmerPK the primary key of the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addFarmer(long pk, long farmerPK) throws SystemException {
        regionToFarmerTableMapper.addTableMapping(pk, farmerPK);
    }

    /**
     * Adds an association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmer the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addFarmer(long pk, com.liferay.farmerPortlet.model.Farmer farmer)
        throws SystemException {
        regionToFarmerTableMapper.addTableMapping(pk, farmer.getPrimaryKey());
    }

    /**
     * Adds an association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmerPKs the primary keys of the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addFarmers(long pk, long[] farmerPKs) throws SystemException {
        for (long farmerPK : farmerPKs) {
            regionToFarmerTableMapper.addTableMapping(pk, farmerPK);
        }
    }

    /**
     * Adds an association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmers the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addFarmers(long pk,
        List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws SystemException {
        for (com.liferay.farmerPortlet.model.Farmer farmer : farmers) {
            regionToFarmerTableMapper.addTableMapping(pk, farmer.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the region and its farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region to clear the associated farmers from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearFarmers(long pk) throws SystemException {
        regionToFarmerTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmerPK the primary key of the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeFarmer(long pk, long farmerPK) throws SystemException {
        regionToFarmerTableMapper.deleteTableMapping(pk, farmerPK);
    }

    /**
     * Removes the association between the region and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmer the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeFarmer(long pk,
        com.liferay.farmerPortlet.model.Farmer farmer)
        throws SystemException {
        regionToFarmerTableMapper.deleteTableMapping(pk, farmer.getPrimaryKey());
    }

    /**
     * Removes the association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmerPKs the primary keys of the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeFarmers(long pk, long[] farmerPKs)
        throws SystemException {
        for (long farmerPK : farmerPKs) {
            regionToFarmerTableMapper.deleteTableMapping(pk, farmerPK);
        }
    }

    /**
     * Removes the association between the region and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmers the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeFarmers(long pk,
        List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws SystemException {
        for (com.liferay.farmerPortlet.model.Farmer farmer : farmers) {
            regionToFarmerTableMapper.deleteTableMapping(pk,
                farmer.getPrimaryKey());
        }
    }

    /**
     * Sets the farmers associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmerPKs the primary keys of the farmers to be associated with the region
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setFarmers(long pk, long[] farmerPKs) throws SystemException {
        Set<Long> newFarmerPKsSet = SetUtil.fromArray(farmerPKs);
        Set<Long> oldFarmerPKsSet = SetUtil.fromArray(regionToFarmerTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeFarmerPKsSet = new HashSet<Long>(oldFarmerPKsSet);

        removeFarmerPKsSet.removeAll(newFarmerPKsSet);

        for (long removeFarmerPK : removeFarmerPKsSet) {
            regionToFarmerTableMapper.deleteTableMapping(pk, removeFarmerPK);
        }

        newFarmerPKsSet.removeAll(oldFarmerPKsSet);

        for (long newFarmerPK : newFarmerPKsSet) {
            regionToFarmerTableMapper.addTableMapping(pk, newFarmerPK);
        }
    }

    /**
     * Sets the farmers associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param farmers the farmers to be associated with the region
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setFarmers(long pk,
        List<com.liferay.farmerPortlet.model.Farmer> farmers)
        throws SystemException {
        try {
            long[] farmerPKs = new long[farmers.size()];

            for (int i = 0; i < farmers.size(); i++) {
                com.liferay.farmerPortlet.model.Farmer farmer = farmers.get(i);

                farmerPKs[i] = farmer.getPrimaryKey();
            }

            setFarmers(pk, farmerPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_TESTTASK_FARMERS_REGIONS_NAME);
        }
    }

    /**
     * Initializes the region persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.farmerPortlet.model.Region")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Region>> listenersList = new ArrayList<ModelListener<Region>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Region>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        regionToFarmerTableMapper = TableMapperFactory.getTableMapper("TestTask_Farmers_Regions",
                "regionId", "farmerId", this, farmerPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RegionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("TestTask_Farmers_Regions");
    }
}

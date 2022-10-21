package com.liferay.farmerPortlet.service.persistence;

import com.liferay.farmerPortlet.NoSuchFarmerException;
import com.liferay.farmerPortlet.model.Farmer;
import com.liferay.farmerPortlet.model.impl.FarmerImpl;
import com.liferay.farmerPortlet.model.impl.FarmerModelImpl;
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
 * The persistence implementation for the farmer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Test Test
 * @see FarmerPersistence
 * @see FarmerUtil
 * @generated
 */
public class FarmerPersistenceImpl extends BasePersistenceImpl<Farmer>
    implements FarmerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FarmerUtil} to access the farmer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FarmerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYCOMPANYNAME =
        new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByCompanyName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPANYNAME =
        new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByFindByCompanyName", new String[] { String.class.getName() },
            FarmerModelImpl.COMPANYNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYCOMPANYNAME = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByFindByCompanyName", new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_1 = "farmer.companyName IS NULL";
    private static final String _FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_2 = "farmer.companyName = ?";
    private static final String _FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_3 = "(farmer.companyName IS NULL OR farmer.companyName = '')";
    private static final String _SQL_SELECT_FARMER = "SELECT farmer FROM Farmer farmer";
    private static final String _SQL_SELECT_FARMER_WHERE = "SELECT farmer FROM Farmer farmer WHERE ";
    private static final String _SQL_COUNT_FARMER = "SELECT COUNT(farmer) FROM Farmer farmer";
    private static final String _SQL_COUNT_FARMER_WHERE = "SELECT COUNT(farmer) FROM Farmer farmer WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "farmer.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Farmer exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Farmer exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FarmerPersistenceImpl.class);
    private static Farmer _nullFarmer = new FarmerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Farmer> toCacheModel() {
                return _nullFarmerCacheModel;
            }
        };

    private static CacheModel<Farmer> _nullFarmerCacheModel = new CacheModel<Farmer>() {
            @Override
            public Farmer toEntityModel() {
                return _nullFarmer;
            }
        };

    @BeanReference(type = RegionPersistence.class)
    protected RegionPersistence regionPersistence;
    protected TableMapper<Farmer, com.liferay.farmerPortlet.model.Region> farmerToRegionTableMapper;

    public FarmerPersistenceImpl() {
        setModelClass(Farmer.class);
    }

    /**
     * Returns all the farmers where companyName = &#63;.
     *
     * @param companyName the company name
     * @return the matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findByFindByCompanyName(String companyName)
        throws SystemException {
        return findByFindByCompanyName(companyName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Farmer> findByFindByCompanyName(String companyName, int start,
        int end) throws SystemException {
        return findByFindByCompanyName(companyName, start, end, null);
    }

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
    @Override
    public List<Farmer> findByFindByCompanyName(String companyName, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPANYNAME;
            finderArgs = new Object[] { companyName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYCOMPANYNAME;
            finderArgs = new Object[] { companyName, start, end, orderByComparator };
        }

        List<Farmer> list = (List<Farmer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Farmer farmer : list) {
                if (!Validator.equals(companyName, farmer.getCompanyName())) {
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

            query.append(_SQL_SELECT_FARMER_WHERE);

            boolean bindCompanyName = false;

            if (companyName == null) {
                query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_1);
            } else if (companyName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_3);
            } else {
                bindCompanyName = true;

                query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FarmerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCompanyName) {
                    qPos.add(companyName);
                }

                if (!pagination) {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Farmer>(list);
                } else {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first farmer in the ordered set where companyName = &#63;.
     *
     * @param companyName the company name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer
     * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByFindByCompanyName_First(String companyName,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByFindByCompanyName_First(companyName,
                orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyName=");
        msg.append(companyName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the first farmer in the ordered set where companyName = &#63;.
     *
     * @param companyName the company name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByFindByCompanyName_First(String companyName,
        OrderByComparator orderByComparator) throws SystemException {
        List<Farmer> list = findByFindByCompanyName(companyName, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last farmer in the ordered set where companyName = &#63;.
     *
     * @param companyName the company name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer
     * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByFindByCompanyName_Last(String companyName,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByFindByCompanyName_Last(companyName,
                orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyName=");
        msg.append(companyName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the last farmer in the ordered set where companyName = &#63;.
     *
     * @param companyName the company name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByFindByCompanyName_Last(String companyName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByFindByCompanyName(companyName);

        if (count == 0) {
            return null;
        }

        List<Farmer> list = findByFindByCompanyName(companyName, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Farmer[] findByFindByCompanyName_PrevAndNext(long farmerId,
        String companyName, OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = findByPrimaryKey(farmerId);

        Session session = null;

        try {
            session = openSession();

            Farmer[] array = new FarmerImpl[3];

            array[0] = getByFindByCompanyName_PrevAndNext(session, farmer,
                    companyName, orderByComparator, true);

            array[1] = farmer;

            array[2] = getByFindByCompanyName_PrevAndNext(session, farmer,
                    companyName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Farmer getByFindByCompanyName_PrevAndNext(Session session,
        Farmer farmer, String companyName, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FARMER_WHERE);

        boolean bindCompanyName = false;

        if (companyName == null) {
            query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_1);
        } else if (companyName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_3);
        } else {
            bindCompanyName = true;

            query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_2);
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
            query.append(FarmerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindCompanyName) {
            qPos.add(companyName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(farmer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Farmer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the farmers where companyName = &#63; from the database.
     *
     * @param companyName the company name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByFindByCompanyName(String companyName)
        throws SystemException {
        for (Farmer farmer : findByFindByCompanyName(companyName,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(farmer);
        }
    }

    /**
     * Returns the number of farmers where companyName = &#63;.
     *
     * @param companyName the company name
     * @return the number of matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByFindByCompanyName(String companyName)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYCOMPANYNAME;

        Object[] finderArgs = new Object[] { companyName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FARMER_WHERE);

            boolean bindCompanyName = false;

            if (companyName == null) {
                query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_1);
            } else if (companyName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_3);
            } else {
                bindCompanyName = true;

                query.append(_FINDER_COLUMN_FINDBYCOMPANYNAME_COMPANYNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCompanyName) {
                    qPos.add(companyName);
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
     * Caches the farmer in the entity cache if it is enabled.
     *
     * @param farmer the farmer
     */
    @Override
    public void cacheResult(Farmer farmer) {
        EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey(), farmer);

        farmer.resetOriginalValues();
    }

    /**
     * Caches the farmers in the entity cache if it is enabled.
     *
     * @param farmers the farmers
     */
    @Override
    public void cacheResult(List<Farmer> farmers) {
        for (Farmer farmer : farmers) {
            if (EntityCacheUtil.getResult(
                        FarmerModelImpl.ENTITY_CACHE_ENABLED, FarmerImpl.class,
                        farmer.getPrimaryKey()) == null) {
                cacheResult(farmer);
            } else {
                farmer.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all farmers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FarmerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FarmerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the farmer.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Farmer farmer) {
        EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Farmer> farmers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Farmer farmer : farmers) {
            EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                FarmerImpl.class, farmer.getPrimaryKey());
        }
    }

    /**
     * Creates a new farmer with the primary key. Does not add the farmer to the database.
     *
     * @param farmerId the primary key for the new farmer
     * @return the new farmer
     */
    @Override
    public Farmer create(long farmerId) {
        Farmer farmer = new FarmerImpl();

        farmer.setNew(true);
        farmer.setPrimaryKey(farmerId);

        return farmer;
    }

    /**
     * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer that was removed
     * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer remove(long farmerId)
        throws NoSuchFarmerException, SystemException {
        return remove((Serializable) farmerId);
    }

    /**
     * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer that was removed
     * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer remove(Serializable primaryKey)
        throws NoSuchFarmerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Farmer farmer = (Farmer) session.get(FarmerImpl.class, primaryKey);

            if (farmer == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFarmerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(farmer);
        } catch (NoSuchFarmerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Farmer removeImpl(Farmer farmer) throws SystemException {
        farmer = toUnwrappedModel(farmer);

        farmerToRegionTableMapper.deleteLeftPrimaryKeyTableMappings(farmer.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(farmer)) {
                farmer = (Farmer) session.get(FarmerImpl.class,
                        farmer.getPrimaryKeyObj());
            }

            if (farmer != null) {
                session.delete(farmer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (farmer != null) {
            clearCache(farmer);
        }

        return farmer;
    }

    @Override
    public Farmer updateImpl(com.liferay.farmerPortlet.model.Farmer farmer)
        throws SystemException {
        farmer = toUnwrappedModel(farmer);

        boolean isNew = farmer.isNew();

        FarmerModelImpl farmerModelImpl = (FarmerModelImpl) farmer;

        Session session = null;

        try {
            session = openSession();

            if (farmer.isNew()) {
                session.save(farmer);

                farmer.setNew(false);
            } else {
                session.merge(farmer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !FarmerModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((farmerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPANYNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        farmerModelImpl.getOriginalCompanyName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYCOMPANYNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPANYNAME,
                    args);

                args = new Object[] { farmerModelImpl.getCompanyName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYCOMPANYNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYCOMPANYNAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey(), farmer);

        return farmer;
    }

    protected Farmer toUnwrappedModel(Farmer farmer) {
        if (farmer instanceof FarmerImpl) {
            return farmer;
        }

        FarmerImpl farmerImpl = new FarmerImpl();

        farmerImpl.setNew(farmer.isNew());
        farmerImpl.setPrimaryKey(farmer.getPrimaryKey());

        farmerImpl.setFarmerId(farmer.getFarmerId());
        farmerImpl.setCompanyName(farmer.getCompanyName());
        farmerImpl.setOrganizationForm(farmer.getOrganizationForm());
        farmerImpl.setInn(farmer.getInn());
        farmerImpl.setKpp(farmer.getKpp());
        farmerImpl.setOgrn(farmer.getOgrn());
        farmerImpl.setRegionId(farmer.getRegionId());
        farmerImpl.setRegistrationDate(farmer.getRegistrationDate());
        farmerImpl.setArchiveStatus(farmer.getArchiveStatus());

        return farmerImpl;
    }

    /**
     * Returns the farmer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer
     * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByPrimaryKey(primaryKey);

        if (farmer == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFarmerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return farmer;
    }

    /**
     * Returns the farmer with the primary key or throws a {@link com.liferay.farmerPortlet.NoSuchFarmerException} if it could not be found.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer
     * @throws com.liferay.farmerPortlet.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByPrimaryKey(long farmerId)
        throws NoSuchFarmerException, SystemException {
        return findByPrimaryKey((Serializable) farmerId);
    }

    /**
     * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Farmer farmer = (Farmer) EntityCacheUtil.getResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                FarmerImpl.class, primaryKey);

        if (farmer == _nullFarmer) {
            return null;
        }

        if (farmer == null) {
            Session session = null;

            try {
                session = openSession();

                farmer = (Farmer) session.get(FarmerImpl.class, primaryKey);

                if (farmer != null) {
                    cacheResult(farmer);
                } else {
                    EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                        FarmerImpl.class, primaryKey, _nullFarmer);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                    FarmerImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return farmer;
    }

    /**
     * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByPrimaryKey(long farmerId) throws SystemException {
        return fetchByPrimaryKey((Serializable) farmerId);
    }

    /**
     * Returns all the farmers.
     *
     * @return the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Farmer> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Farmer> findAll(int start, int end,
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

        List<Farmer> list = (List<Farmer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FARMER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FARMER;

                if (pagination) {
                    sql = sql.concat(FarmerModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Farmer>(list);
                } else {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
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
     * Removes all the farmers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Farmer farmer : findAll()) {
            remove(farmer);
        }
    }

    /**
     * Returns the number of farmers.
     *
     * @return the number of farmers
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

                Query q = session.createQuery(_SQL_COUNT_FARMER);

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
     * Returns all the regions associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @return the regions associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.liferay.farmerPortlet.model.Region> getRegions(long pk)
        throws SystemException {
        return getRegions(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

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
    @Override
    public List<com.liferay.farmerPortlet.model.Region> getRegions(long pk,
        int start, int end) throws SystemException {
        return getRegions(pk, start, end, null);
    }

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
    @Override
    public List<com.liferay.farmerPortlet.model.Region> getRegions(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return farmerToRegionTableMapper.getRightBaseModels(pk, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of regions associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @return the number of regions associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getRegionsSize(long pk) throws SystemException {
        long[] pks = farmerToRegionTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the region is associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @param regionPK the primary key of the region
     * @return <code>true</code> if the region is associated with the farmer; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsRegion(long pk, long regionPK)
        throws SystemException {
        return farmerToRegionTableMapper.containsTableMapping(pk, regionPK);
    }

    /**
     * Returns <code>true</code> if the farmer has any regions associated with it.
     *
     * @param pk the primary key of the farmer to check for associations with regions
     * @return <code>true</code> if the farmer has any regions associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsRegions(long pk) throws SystemException {
        if (getRegionsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the farmer and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param regionPK the primary key of the region
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addRegion(long pk, long regionPK) throws SystemException {
        farmerToRegionTableMapper.addTableMapping(pk, regionPK);
    }

    /**
     * Adds an association between the farmer and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param region the region
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addRegion(long pk, com.liferay.farmerPortlet.model.Region region)
        throws SystemException {
        farmerToRegionTableMapper.addTableMapping(pk, region.getPrimaryKey());
    }

    /**
     * Adds an association between the farmer and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param regionPKs the primary keys of the regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addRegions(long pk, long[] regionPKs) throws SystemException {
        for (long regionPK : regionPKs) {
            farmerToRegionTableMapper.addTableMapping(pk, regionPK);
        }
    }

    /**
     * Adds an association between the farmer and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param regions the regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addRegions(long pk,
        List<com.liferay.farmerPortlet.model.Region> regions)
        throws SystemException {
        for (com.liferay.farmerPortlet.model.Region region : regions) {
            farmerToRegionTableMapper.addTableMapping(pk, region.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the farmer and its regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer to clear the associated regions from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearRegions(long pk) throws SystemException {
        farmerToRegionTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the farmer and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param regionPK the primary key of the region
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeRegion(long pk, long regionPK) throws SystemException {
        farmerToRegionTableMapper.deleteTableMapping(pk, regionPK);
    }

    /**
     * Removes the association between the farmer and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param region the region
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeRegion(long pk,
        com.liferay.farmerPortlet.model.Region region)
        throws SystemException {
        farmerToRegionTableMapper.deleteTableMapping(pk, region.getPrimaryKey());
    }

    /**
     * Removes the association between the farmer and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param regionPKs the primary keys of the regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeRegions(long pk, long[] regionPKs)
        throws SystemException {
        for (long regionPK : regionPKs) {
            farmerToRegionTableMapper.deleteTableMapping(pk, regionPK);
        }
    }

    /**
     * Removes the association between the farmer and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param regions the regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeRegions(long pk,
        List<com.liferay.farmerPortlet.model.Region> regions)
        throws SystemException {
        for (com.liferay.farmerPortlet.model.Region region : regions) {
            farmerToRegionTableMapper.deleteTableMapping(pk,
                region.getPrimaryKey());
        }
    }

    /**
     * Sets the regions associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param regionPKs the primary keys of the regions to be associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setRegions(long pk, long[] regionPKs) throws SystemException {
        Set<Long> newRegionPKsSet = SetUtil.fromArray(regionPKs);
        Set<Long> oldRegionPKsSet = SetUtil.fromArray(farmerToRegionTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeRegionPKsSet = new HashSet<Long>(oldRegionPKsSet);

        removeRegionPKsSet.removeAll(newRegionPKsSet);

        for (long removeRegionPK : removeRegionPKsSet) {
            farmerToRegionTableMapper.deleteTableMapping(pk, removeRegionPK);
        }

        newRegionPKsSet.removeAll(oldRegionPKsSet);

        for (long newRegionPK : newRegionPKsSet) {
            farmerToRegionTableMapper.addTableMapping(pk, newRegionPK);
        }
    }

    /**
     * Sets the regions associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param regions the regions to be associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setRegions(long pk,
        List<com.liferay.farmerPortlet.model.Region> regions)
        throws SystemException {
        try {
            long[] regionPKs = new long[regions.size()];

            for (int i = 0; i < regions.size(); i++) {
                com.liferay.farmerPortlet.model.Region region = regions.get(i);

                regionPKs[i] = region.getPrimaryKey();
            }

            setRegions(pk, regionPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(FarmerModelImpl.MAPPING_TABLE_TESTTASK_FARMERS_REGIONS_NAME);
        }
    }

    /**
     * Initializes the farmer persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.farmerPortlet.model.Farmer")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Farmer>> listenersList = new ArrayList<ModelListener<Farmer>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Farmer>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        farmerToRegionTableMapper = TableMapperFactory.getTableMapper("TestTask_Farmers_Regions",
                "farmerId", "regionId", this, regionPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FarmerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("TestTask_Farmers_Regions");
    }
}

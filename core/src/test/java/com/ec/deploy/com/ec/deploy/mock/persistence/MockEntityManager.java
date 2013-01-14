package com.ec.deploy.com.ec.deploy.mock.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

import com.ec.deploy.model.core.tenancy.Tenant;

@SuppressWarnings("unchecked")
public class MockEntityManager implements EntityManager
{

    private Random idGenerator;
    private Map<Long, Tenant> repository;
    private Map<String, Query> namedQueries;
    private Map<String, Query> knownQueries;


    class ListQuery extends QueryAdapter {
        @Override
        public List getResultList()
        {
            return new ArrayList(repository.values());
        }
    }



    public MockEntityManager() {
        repository = new HashMap<>();
        idGenerator = new Random();
        namedQueries = new HashMap<>();
        knownQueries = new HashMap<>();
        registerDefaultQueries();
    }



    public MockEntityManager registerQuery(
        String name,
        Query query)
    {
        namedQueries.put(name, query);
        return this;
    }

    @Override
    public void persist(Object entity)
    {
        final Tenant toSave = (Tenant) entity;
        toSave.setId(idGenerator.nextLong());
        repository.put(toSave.getId(), toSave);
    }

    @Override
    public <T> T merge(T entity)
    {
        final Tenant toSave = (Tenant) entity;
        if(toSave.getId() != null) {
            Tenant saved = repository.get(toSave.getId());
            saved.setDescription(toSave.getDescription());
            saved.setName(toSave.getName());
        } else {
            toSave.setId(idGenerator.nextLong());
            repository.put(toSave.getId(), toSave);
        }
        return (T) toSave;
    }

    @Override
    public void remove(Object entity)
    {
        final Tenant other = (Tenant) entity;
        repository.remove(other.getId());
    }

    @Override
    public <T> T find(
        Class<T> entityClass,
        Object primaryKey)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T find(
        Class<T> entityClass,
        Object primaryKey,
        Map<String, Object> properties)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T find(
        Class<T> entityClass,
        Object primaryKey,
        LockModeType lockMode)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T find(
        Class<T> entityClass,
        Object primaryKey,
        LockModeType lockMode,
        Map<String, Object> properties)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T getReference(
        Class<T> entityClass,
        Object primaryKey)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void flush()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setFlushMode(FlushModeType flushMode)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FlushModeType getFlushMode()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void lock(
        Object entity,
        LockModeType lockMode)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void lock(
        Object entity,
        LockModeType lockMode,
        Map<String, Object> properties)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void refresh(Object entity)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void refresh(
        Object entity,
        Map<String, Object> properties)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void refresh(
        Object entity,
        LockModeType lockMode)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void refresh(
        Object entity,
        LockModeType lockMode,
        Map<String, Object> properties)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void clear()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void detach(Object entity)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(Object entity)
    {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LockModeType getLockMode(Object entity)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setProperty(
        String propertyName,
        Object value)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, Object> getProperties()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query createQuery(String qlString)
    {
        return knownQueries.get(qlString);
    }

    @Override
    public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> TypedQuery<T> createQuery(
        String qlString,
        Class<T> resultClass)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query createNamedQuery(String name)
    {
        return namedQueries.get(name);
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(
        String name,
        Class<T> resultClass)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query createNativeQuery(String sqlString)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query createNativeQuery(
        String sqlString,
        Class resultClass)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query createNativeQuery(
        String sqlString,
        String resultSetMapping)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void joinTransaction()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T unwrap(Class<T> cls)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getDelegate()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void close()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isOpen()
    {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EntityTransaction getTransaction()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Metamodel getMetamodel()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected void registerDefaultQueries() {
        registerQuery("list", new ListQuery());
    }
}

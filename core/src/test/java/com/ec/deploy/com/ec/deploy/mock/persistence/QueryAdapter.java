package com.ec.deploy.com.ec.deploy.mock.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/13/13 Time: 10:43 PM To
 * change this template use File | Settings | File Templates.
 */
public class QueryAdapter implements Query
{
    @Override
    public List getResultList()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getSingleResult()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int executeUpdate()
    {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setMaxResults(int maxResult)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMaxResults()
    {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setFirstResult(int startPosition)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getFirstResult()
    {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setHint(
        String hintName,
        Object value)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, Object> getHints()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> Query setParameter(
        Parameter<T> param,
        T value)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setParameter(
        Parameter<Calendar> param,
        Calendar value,
        TemporalType temporalType)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setParameter(
        Parameter<Date> param,
        Date value,
        TemporalType temporalType)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setParameter(
        String name,
        Object value)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setParameter(
        String name,
        Calendar value,
        TemporalType temporalType)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setParameter(
        String name,
        Date value,
        TemporalType temporalType)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setParameter(
        int position,
        Object value)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setParameter(
        int position,
        Calendar value,
        TemporalType temporalType)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setParameter(
        int position,
        Date value,
        TemporalType temporalType)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Parameter<?>> getParameters()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Parameter<?> getParameter(String name)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> Parameter<T> getParameter(
        String name,
        Class<T> type)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Parameter<?> getParameter(int position)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> Parameter<T> getParameter(
        int position,
        Class<T> type)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBound(Parameter<?> param)
    {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T getParameterValue(Parameter<T> param)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getParameterValue(String name)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getParameterValue(int position)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setFlushMode(FlushModeType flushMode)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FlushModeType getFlushMode()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query setLockMode(LockModeType lockMode)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LockModeType getLockMode()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T unwrap(Class<T> cls)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

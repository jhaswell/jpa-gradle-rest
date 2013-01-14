package com.ec.deploy.service.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.ec.deploy.model.core.tenancy.Tenant;
import com.ec.deploy.service.core.tenancy.TenantService;

@Stateless
@Local(TenantService.class)
public class DefaultTenantService implements TenantService
{

    @PersistenceContext
    protected EntityManager entityManager;

    public DefaultTenantService() {

    }

    @Override
    public List<Tenant> list()
    {
        return entityManager.createNamedQuery("list").getResultList();
    }


    @Override
    public Tenant save(Tenant tenant) {
        return entityManager.merge(tenant);
    }

    @Override
    public Tenant delete(Tenant tenant)
    {
        entityManager.remove(tenant);
        return tenant;
    }
}

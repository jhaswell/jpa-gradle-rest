package com.ec.deploy.service.core.tenancy;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ec.deploy.service.test.ServiceDeployment;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class DefaultTenantServiceIntegrationTest
    extends TenantServiceTest
{
    @Override
    public void setUp()
        throws Exception
    {
        clearData();
        beginTransaction();
    }

    @After
    public void tearDown()
        throws Exception
    {
        endTransaction();
    }

    @PersistenceContext
    EntityManager entityManager;
    @Inject
    UserTransaction userTransaction;

    @Deployment
    public static Archive<?> createDeployment()
    {
        return ServiceDeployment.getInstance().getDeployment()
             .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
             .addAsManifestResource("persistence.xml",
                 "persistence.xml")
             .addAsManifestResource("jbossas-ds.xml", "jbossas-ds.xml");
    }

    @Inject
    public void setService(TenantService service)
    {
        this.service = service;
    }

    @Test
    public void ensureServiceIsInjected()
    {
        assertThat(service, is(not(nullValue())));
    }

    private void clearData() throws Exception
    {
        userTransaction.begin();
        entityManager.joinTransaction();
        entityManager.createQuery("delete from Tenant")
                     .executeUpdate();
        userTransaction.commit();
    }

    private void beginTransaction() throws Exception
    {
        userTransaction.begin();
        entityManager.joinTransaction();
    }

    private void endTransaction()
        throws Exception
    {
        userTransaction.commit();
    }
}

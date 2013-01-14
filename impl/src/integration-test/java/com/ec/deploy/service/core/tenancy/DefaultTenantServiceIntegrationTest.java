package com.ec.deploy.service.core.tenancy;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ec.deploy.model.core.tenancy.Tenant;
import com.ec.deploy.service.core.DefaultTenantService;

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
        return ShrinkWrap.create(WebArchive.class, "impl.war")
             .addPackage(Tenant.class.getPackage())
             .addPackage(TenantService.class.getPackage())
             .addPackage(DefaultTenantService.class.getPackage())
             .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
             .addAsResource("META-INF/persistence.xml")
             .addAsWebInfResource("jbossas-ds.xml");
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
        System.out
              .println("SERVICE: " + service);
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

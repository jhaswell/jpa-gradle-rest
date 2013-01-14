package com.ec.deploy.service.core.tenancy;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.ec.deploy.model.core.tenancy.Tenant;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public abstract class TenantServiceTestCase
{

    @Inject
    protected TenantService service;

    @Before
    public void setUp()
        throws Exception
    {
        setService(createService());
    }


    @Test
    public void ensureEmptyServiceListReturnsEmptyList() {
        assertTrue(service.list()
                          .isEmpty());


    }

    @Test
    public void ensureAddingEntityDoesNotReturnNull() {
        final Tenant tenant = createValidTenant();
        assertThat(
            service.save(tenant),
            is(not(nullValue()))
        );
    }

    private Tenant createValidTenant()
    {
        String name = "coke";
        String description = "coca-cola";
        return new Tenant(name, description);
    }

    @Test
    public void ensureAddingEntityReturnsCorrectTenant() {
        final Tenant tenant = createValidTenant();
        assertThat(
            service.save(tenant),
            is(equalTo(tenant))
        );
    }

    @Test
    public void ensureAddingEntityIncrementsListCount() {
        final Tenant tenant = createValidTenant();
        service.save(tenant);
        assertThat(1, is(equalTo(service.list().size())));
    }
    
    @Test
    public void ensureDeletingEntityDoesNotReturnNull() {
        final Tenant tenant = createValidTenant();
        service.save(tenant);
        assertThat(service.delete(tenant), is(not(nullValue())));
    }

    @Test
    public void ensureDeletingEntityDecrementsListCount() {
        final Tenant tenant = createValidTenant();
        final Tenant saved = service.save(tenant);
        service.delete(saved);
        assertThat(service.list().isEmpty(), is(true));
    }

    public void setService(TenantService service) {
        this.service = service;
    }


    protected abstract TenantService createService();
}

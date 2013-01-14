package com.ec.deploy.model.core.tenancy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TenantTest
{

    @Test
    public void ensureTenantConstructedWithNameHasCorrectName() {
        final String name = "Coke";
        assertThat(new Tenant(name,  null).getName(), is(equalTo(name)));
    }

    @Test
    public void ensureTenantsWithSameIdAreEqual() {
        final Tenant p1 = new Tenant("coke", "just coke");
        final Tenant p2 = new Tenant("coke", "just coke");
        final Long id = 1l;
        p1.setId(id);
        p2.setId(id);
        assertThat(p1, is(equalTo(p2)));

    }
}

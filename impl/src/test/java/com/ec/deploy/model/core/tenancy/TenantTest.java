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
}

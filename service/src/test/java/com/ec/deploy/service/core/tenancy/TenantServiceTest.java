package com.ec.deploy.service.core.tenancy;

import javax.persistence.EntityManager;

import com.ec.deploy.com.ec.deploy.mock.persistence.MockEntityManager;
import com.ec.deploy.service.core.DefaultTenantService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TenantServiceTest extends TenantServiceTestCase
{
    @Override
    protected TenantService createService()
    {
        return new DefaultTenantService() {{
                entityManager = new MockEntityManager();
            }};
    }
}

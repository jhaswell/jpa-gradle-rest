package com.ec.deploy.service.core.tenancy;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.ec.deploy.model.core.tenancy.Tenant;

public interface TenantService
{

    List<Tenant> list();

    Tenant save(Tenant tenant);

    Tenant delete(Tenant tenant);


}

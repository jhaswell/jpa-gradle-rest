package com.ec.deploy.web.core.tenancy;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.ec.deploy.model.core.tenancy.Tenant;
import com.ec.deploy.service.core.tenancy.TenantService;

@Path("/tenant")
public class TenantEndpoint
{

    @Inject
    private TenantService tenantService;

    @POST
    @Path("/save")
    public Tenant save(Tenant tenant) {
        return tenantService.save(tenant);
    }

    @GET
    @Path("/list")
    public List<Tenant> list() {
        return tenantService.list();
    }

    @DELETE
    @Path("/delete")
    public Tenant delete(Tenant tenant) {
        return tenantService.delete(tenant);
    }

}

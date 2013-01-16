package com.ec.deploy.web.core.tenancy;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ec.deploy.model.core.tenancy.Tenant;
import com.ec.deploy.service.core.tenancy.TenantService;

@Stateless
@Path("/tenant")
public class TenantEndpoint
{

    @Inject
    protected TenantService tenantService;

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tenant save(Tenant tenant) {
        return tenantService.save(tenant);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_XML)
    public List<Tenant> list() {
        return tenantService.list();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Tenant get() {
        return new Tenant("Coke", "Coca-Cola");
    }

    @DELETE
    @Path("/delete")
    public Tenant delete(Tenant tenant) {
        return tenantService.delete(tenant);
    }

    @GET
    @Path("/hi/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@PathParam("name") String name) {
        return String.format("Hello %s", name);
    }
}

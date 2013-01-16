package com.ec.deploy.web.core.tenancy;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.container.test.api.RunAsClient;

import com.ec.deploy.model.core.tenancy.Tenant;
import com.ec.deploy.service.core.DefaultTenantService;
import com.ec.deploy.service.core.tenancy.TenantService;
import com.ec.deploy.service.core.tenancy.TenantServiceTest;
import com.ec.deploy.service.core.tenancy.TenantServiceTestCase;
import com.ec.deploy.web.activation.RestActivator;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class TenantEndpointIntegrationTest extends TenantEndpointTest
{

    private static final String RESOURCE_PREFIX = RestActivator.class.getAnnotation(
        ApplicationPath.class).value().substring(1);

    @ArquillianResource
    URL deploymentUrl;


    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "web.war")
            .addPackage(Tenant.class.getPackage())
            .addPackage(TenantService.class.getPackage())
            .addPackage(DefaultTenantService.class.getPackage())
            .addPackage(TenantEndpoint.class.getPackage())
            .addPackage(TenantServiceTestCase.class.getPackage())
            .addPackage(TenantServiceTest.class.getPackage())
            .addPackage(RestActivator.class.getPackage())
            .addAsResource("persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsWebInfResource("jbossas-ds.xml", "jbossas-ds.xml")
            .setWebXML("web.xml");
    }

    @Test
    @RunAsClient
    public void ensureWhatever()
        throws Exception
    {

        final Tenant tenant = new Tenant();
        tenant.setName("Coke");
        tenant.setDescription("Coca-cola");
        ClientRequest request = new ClientRequest(deploymentUrl + "rest/tenant/save");
        request.accept(MediaType.APPLICATION_JSON_TYPE);
        request.body(MediaType.APPLICATION_JSON_TYPE, tenant);
        ClientResponse tresp = request.post(Tenant.class);
        tresp.
        assertEquals(tresp.getEntity(),"Joe");
    }

}

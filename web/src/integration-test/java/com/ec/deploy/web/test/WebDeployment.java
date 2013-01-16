package com.ec.deploy.web.test;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.ec.deploy.service.test.DeploymentDescriptor;
import com.ec.deploy.service.test.ServiceDeployment;
import com.ec.deploy.web.core.tenancy.TenantEndpoint;

public class WebDeployment implements DeploymentDescriptor<WebArchive>
{
    @Override
    public WebArchive getDeployment()
    {
        return ShrinkWrap.create(WebArchive.class, "web.war")
            .addPackage(TenantEndpoint.class.getPackage())
            .add(ServiceDeployment.getInstance()
            .getDeployment(), "lib/service.jar",
                ZipExporter.class);


    }
}

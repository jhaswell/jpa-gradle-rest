package com.ec.deploy.service.test;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import com.ec.deploy.model.core.tenancy.Tenant;
import com.ec.deploy.service.core.DefaultTenantService;
import com.ec.deploy.service.core.tenancy.TenantService;

public class ServiceDeployment
    implements DeploymentDescriptor<JavaArchive>
{

    final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "service.jar")
        .addPackage(Tenant.class.getPackage())
        .addPackage(TenantService.class.getPackage())
        .addPackage(DefaultTenantService.class.getPackage());


    static final DeploymentDescriptor<JavaArchive> INSTANCE =
        new ServiceDeployment();


    public JavaArchive getDeployment() {
        return ((ServiceDeployment)INSTANCE).archive;
    }

    public static DeploymentDescriptor<JavaArchive> getInstance() {
        return INSTANCE;
    }



}

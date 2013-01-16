package com.ec.deploy.service.test;

import org.jboss.shrinkwrap.api.Archive;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/14/13 Time: 2:43 PM To
 * change this template use File | Settings | File Templates.
 */
public interface DeploymentDescriptor<T extends Archive<T>>
{

    public T getDeployment();

}

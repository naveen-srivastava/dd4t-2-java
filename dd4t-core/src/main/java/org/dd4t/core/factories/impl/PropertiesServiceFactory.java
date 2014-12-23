package org.dd4t.core.factories.impl;

import org.dd4t.core.services.PropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mihai Cadariu
 */
public class PropertiesServiceFactory {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesServiceFactory.class);
    private static final PropertiesServiceFactory INSTANCE = new PropertiesServiceFactory();
    private PropertiesService propertiesService;

    private PropertiesServiceFactory() {
        LOG.debug("Create new instance");
    }

    public static PropertiesServiceFactory getInstance() {
        return INSTANCE;
    }

    public PropertiesService getPropertiesService() {
        return propertiesService;
    }

    @Autowired
    private void setPropertiesService(PropertiesService propertiesService) {
        LOG.debug("Set PropertiesService " + propertiesService);
        this.propertiesService = propertiesService;
    }
}
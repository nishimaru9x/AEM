package com.adobe.aem.mock.tuannt49.core.models.impl;

import com.adobe.aem.mock.tuannt49.core.models.HeroBanner;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { HeroBanner.class }, resourceType = {
        HeroBannerImpl.RESOUCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeroBannerImpl implements HeroBanner {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeroBannerImpl.class);

    protected static final String RESOUCE_TYPE = "tuannt49/components/herobanner";
    private final String LABEL_DISCOVER = "Discover";

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String subtitle;

    @ValueMapValue
    private String label;

    @ValueMapValue
    private String newTab;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String linkURL;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public String getLabel() {
        return StringUtils.isNotBlank(label) ? label : LABEL_DISCOVER;
    }

    @Override
    public String isNewTab() {
        return newTab;
    }

    @Override
    public String getFileReference() {
        return fileReference;
    }

    @Override
    public Boolean isEmpty() {
        return StringUtils.isBlank(title) || StringUtils.isBlank(fileReference) || StringUtils.isBlank(linkURL);
    }

    @Override
    public String getLinkURL() {
        return linkURL;
    }

}

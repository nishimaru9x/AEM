package com.adobe.aem.mock.tuannt49.core.WCMPojo;

import com.adobe.cq.sightly.WCMUsePojo;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageText extends WCMUsePojo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageText.class);
    private final String LABEL_DISCOVER = "Discover";

    private String title;
    private String description;

    private String label;
    private String linkURL;
    private String fileReference;

    @Override
    public void activate() throws Exception {
        ValueMap properties = getProperties();
        title = properties.get("title", String.class);
        description = properties.get("description", String.class);
        label = properties.get("label", String.class);
        linkURL = properties.get("linkURL", String.class);
        fileReference = properties.get("fileReference", String.class);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return StringUtils.isNotBlank(label) ? label : LABEL_DISCOVER;
    }

    /**
     * @return the linkURL
     */
    public String getLinkURL() {
        return linkURL;
    }

    /**
     * @return the fileReference
     */
    public String getFileReference() {
        return fileReference;
    }

    public boolean isActive() {
        return StringUtils.isNotBlank(title) && StringUtils.isNotBlank(linkURL)
                && StringUtils.isNotBlank(fileReference);
    }
}

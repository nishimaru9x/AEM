package com.adobe.aem.mock.tuannt49.core.WCMPojo;

import com.adobe.cq.sightly.WCMUsePojo;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageText extends WCMUsePojo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageText.class);
    private final String LABEL_DISCOVER = "Discover";

    private String title;
    private String subtitle;
    private String description;

    private String label;
    private String linkURL;
    private String fileReference;

    @Override
    public void activate() throws Exception {
        title = getProperties().get("title", "");
        subtitle = getProperties().get("subtitle", "");
        description = getProperties().get("description", "");
        label = getProperties().get("label", "");
        linkURL = getProperties().get("linkURL", "");
        fileReference = getProperties().get("fileReference", "");
        LOGGER.info("\n{}\n{}\n{}\n{}\n{}\n{}", title, subtitle, description, label, linkURL, fileReference);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the subtitle
     */
    public String getSubtitle() {
        return subtitle;
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
        return StringUtils.isNotBlank(title) && StringUtils.isNotBlank(subtitle) && StringUtils.isNotBlank(linkURL)
                && StringUtils.isNotBlank(fileReference);
    }
}

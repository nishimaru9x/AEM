package com.adobe.aem.mock.tuannt49.core.models.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import com.adobe.aem.mock.tuannt49.core.models.MyBreadcrumb;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.designer.Style;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {
        MyBreadcrumb.class }, resourceType = MyBreadcrumbImpl.RESOURC_TYPE)
public class MyBreadcrumbImpl implements MyBreadcrumb {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBreadcrumbImpl.class);
    protected static final String RESOURC_TYPE = "tuannt49/components/mybreadcrumb";

    protected static final boolean HIDE_CURRENT_DEFAULT = false;
    protected static final int START_LEVEL_DEFAULT = 4;

    @ScriptVariable
    private ValueMap properties;

    @ScriptVariable
    private Style currentStyle;

    @ScriptVariable
    private Page currentPage;

    @Self
    private SlingHttpServletRequest request;

    private boolean hideCurrent;
    private int startLevel;
    private List<Page> items;

    @PostConstruct
    private void initModel() {
        startLevel = properties.get(START_LEVEL, currentStyle.get(START_LEVEL, START_LEVEL_DEFAULT));
        hideCurrent = properties.get(HIDE_CURRENT, currentStyle.get(HIDE_CURRENT, HIDE_CURRENT_DEFAULT));
    }

    @Override
    public Collection<Page> getItems() {
        if (items == null) {
            items = createItems();
        }

        return Collections.unmodifiableList(items);
    }

    private List<Page> createItems() {
        List<Page> items = new ArrayList<>();
        int currentLevel = currentPage.getDepth();
        while (startLevel < currentLevel) {
            Page page = currentPage.getAbsoluteParent(startLevel);
            LOGGER.info("Current Page: {}", page.getName());
            items.add(page);
            startLevel++;
        }
        return items;
    }

}

package com.adobe.aem.mock.tuannt49.core.models;

import java.util.Collection;

import com.day.cq.wcm.api.Page;

public interface MyBreadcrumb {
    String HIDE_CURRENT = "hideCurrent";
    String START_LEVEL = "startLevel";

    default Collection<Page> getItems() {
        return null;
    }
}

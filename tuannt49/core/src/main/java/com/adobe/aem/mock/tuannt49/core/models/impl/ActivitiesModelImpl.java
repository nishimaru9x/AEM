package com.adobe.aem.mock.tuannt49.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import com.adobe.aem.mock.tuannt49.core.models.ActivitiesModel;
import com.adobe.aem.mock.tuannt49.core.service.SearchPage;
import com.day.cq.wcm.api.Page;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, adapters = ActivitiesModel.class, resourceType = {
        ActivitiesModelImpl.RESOUCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ActivitiesModelImpl implements ActivitiesModel {
    protected static final String RESOUCE_TYPE = "tuannt49/components/activities";
    private static final String ACTIVITY_DETAIL_TEMPLATE = "activity-detail-page";
    private static final int MAX_RESULT = 6;

    private List<Page> items = new ArrayList<Page>();

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitiesModelImpl.class);

    @OSGiService
    SearchPage searchPage;

    @Override
    public List<Page> getItems() {
        LOGGER.info("List pages");
        items = searchPage.searchByTemplate(ACTIVITY_DETAIL_TEMPLATE, 0, MAX_RESULT);
        return items;
    }

}

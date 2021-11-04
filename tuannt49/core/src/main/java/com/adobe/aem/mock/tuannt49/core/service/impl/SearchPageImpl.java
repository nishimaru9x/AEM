package com.adobe.aem.mock.tuannt49.core.service.impl;

import com.adobe.aem.mock.tuannt49.core.service.SearchPage;
import com.day.cq.wcm.api.Page;

import org.osgi.service.component.annotations.Component;

@Component(service = SearchPage.class, immediate = true)
public class SearchPageImpl implements SearchPage {

    @Override
    public Page searchByTemplate(String template, int pageStart, int resultPerPage) {
        // TODO Auto-generated method stub
        return null;
    }

}

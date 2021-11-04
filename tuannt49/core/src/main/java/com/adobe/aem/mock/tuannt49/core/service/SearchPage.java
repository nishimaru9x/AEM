package com.adobe.aem.mock.tuannt49.core.service;

import com.day.cq.wcm.api.Page;

public interface SearchPage {
    Page searchByTemplate(String template, int pageStart, int resultPerPage);
}

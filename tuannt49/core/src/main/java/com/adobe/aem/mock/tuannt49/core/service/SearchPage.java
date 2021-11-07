package com.adobe.aem.mock.tuannt49.core.service;

import java.util.List;

import com.day.cq.wcm.api.Page;

public interface SearchPage {
    List<Page> searchByTemplate(String template, int pageStart, int resultPerPage);
}

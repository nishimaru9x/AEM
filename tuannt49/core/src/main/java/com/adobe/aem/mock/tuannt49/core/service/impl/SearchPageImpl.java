package com.adobe.aem.mock.tuannt49.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import com.adobe.aem.mock.tuannt49.core.service.SearchPage;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = SearchPage.class, immediate = true)
public class SearchPageImpl implements SearchPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchPageImpl.class);

    @Reference
    QueryBuilder queryBuilder;

    @Reference
    ResourceResolverFactory resolverFactory;

    @Activate
    public void activate() {
    }

    public Map<String, String> createTemplateSearchQuery(String template, int startPage, int resultNumbers) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("type", "cq:Page");
        queryMap.put("path", "/content/tuannt49/");
        queryMap.put("property", "jcr:content/cq:template");
        queryMap.put("property.value", "/conf/tuannt49/settings/wcm/templates/" + template);
        queryMap.put("p.offset", Long.toString(startPage));
        queryMap.put("p.limit", Long.toString(resultNumbers));
        return queryMap;
    }

    @Override
    public List<Page> searchByTemplate(String template, int pageStart, int resultPerPage) {
        List<Page> pages = new ArrayList<>();
        try {
            ResourceResolver resolver = resolverFactory.getServiceResourceResolver(new HashMap<String, Object>() {
                {
                    put(ResourceResolverFactory.SUBSERVICE, "tuannt49services");
                }
            });
            Session session = resolver.adaptTo(Session.class);
            Query query = queryBuilder.createQuery(
                    PredicateGroup.create(createTemplateSearchQuery(template, pageStart, resultPerPage)), session);
            SearchResult result = query.getResult();
            List<Hit> hits = result.getHits();
            for (Hit hit : hits) {
                Page page = hit.getResource().adaptTo(Page.class);
                pages.add(page);
            }

        } catch (LoginException | RepositoryException e) {
            LOGGER.info("\n ----ERROR ----- {}", e.getMessage());
        }
        return pages;
    }

}

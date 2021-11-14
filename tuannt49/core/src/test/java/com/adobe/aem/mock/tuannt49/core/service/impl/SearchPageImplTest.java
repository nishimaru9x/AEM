package com.adobe.aem.mock.tuannt49.core.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class SearchPageImplTest {
    public AemContext context = new AemContext();
    List<Page> pages;

    @Mock
    private QueryBuilder queryBuilder;

    @Mock
    private ResourceResolverFactory resolverFactory;

    @Mock
    private ResourceResolver resolver;

    @Mock
    private Session session;

    @Mock
    private Resource resource;

    @Mock
    private Query query;

    @Mock
    private List<Hit> hits;

    @Mock
    private SearchResult searchResult;

    @Mock
    private Hit hit;

    @Mock
    private Page page;

    @InjectMocks
    private SearchPageImpl searchPageImpl;

    final String TEMPLATE = "template";
    final int startPage = 0;
    final int resultNumbers = 2;

    @BeforeEach
    void setUp() {
        pages = new ArrayList<>();
        hits = new ArrayList<>();
        searchPageImpl.resolverFactory = resolverFactory;
        searchPageImpl.queryBuilder = queryBuilder;
    }

    @Test
    void testSearchByTemplate() throws LoginException, RepositoryException {
        hits.add(hit);
        when(resolver.adaptTo(any())).thenReturn(session);
        when(resolverFactory.getServiceResourceResolver(anyMap())).thenReturn(resolver);
        when(queryBuilder.createQuery(any(), any())).thenReturn(query);
        when(query.getResult()).thenReturn(searchResult);
        when(searchResult.getHits()).thenReturn(hits);
        when(hit.getResource()).thenReturn(resource);
        when(resource.adaptTo(Page.class)).thenReturn(page);

        List<Page> actual = searchPageImpl.searchByTemplate(TEMPLATE, startPage, resultNumbers);
        assertEquals(1, actual.size());
    }

    @Test
    void testSearchByTemplateEmpty() throws LoginException, RepositoryException {
        when(resolver.adaptTo(any())).thenReturn(session);
        when(resolverFactory.getServiceResourceResolver(anyMap())).thenReturn(resolver);
        when(queryBuilder.createQuery(any(), any())).thenReturn(query);
        when(query.getResult()).thenReturn(searchResult);
        when(searchResult.getHits()).thenReturn(hits);

        List<Page> actual = searchPageImpl.searchByTemplate(TEMPLATE, startPage, resultNumbers);
        assertTrue(actual.isEmpty());
    }

}

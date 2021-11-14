package com.adobe.aem.mock.tuannt49.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;

import org.apache.sling.api.resource.LoginException;
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

    @InjectMocks
    private SearchPageImpl searchPageImpl;

    @BeforeEach
    void setUp() {
        pages = new ArrayList<>();
        Page page = context.create().page("/content/tuannt49/path1", "/conf/tuannt49/settings/wcm/templates/template",
                "title1");
        pages.add(page);
        page = context.create().page("/content/tuannt49/path2", "/conf/tuannt49/settings/wcm/templates/template",
                "title2");
        pages.add(page);

        context.registerService(QueryBuilder.class, queryBuilder);
        context.registerService(ResourceResolverFactory.class, resolverFactory);
    }

    @Test
    void testSearchByTemplate() throws LoginException {
        // resolver = context.resourceResolver();
        // session = resolver.adaptTo(Session.class);

        // when(resolverFactory.getResourceResolver(anyMap())).thenReturn(resolver);

        // List<Page> actual = searchPageImpl.searchByTemplate("template", 0, 2);
    }
}

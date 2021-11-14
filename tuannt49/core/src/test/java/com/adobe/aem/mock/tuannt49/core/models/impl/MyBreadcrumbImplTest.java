package com.adobe.aem.mock.tuannt49.core.models.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class MyBreadcrumbImplTest {
    private final AemContext context = new AemContext();

    @BeforeEach
    public void setUp() throws Exception {
        context.addModelsForClasses(HeroBannerImpl.class);
        context.load().json("/com/adobe/aem/mock/tuannt49/core/models/impl/MyBreadcrumbImplTest.json", "/content");
    }

    @Test
    void testGetItems() {

    }
}

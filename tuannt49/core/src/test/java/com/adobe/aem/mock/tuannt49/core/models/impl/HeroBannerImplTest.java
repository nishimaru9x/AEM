package com.adobe.aem.mock.tuannt49.core.models.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adobe.aem.mock.tuannt49.core.models.HeroBanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class HeroBannerImplTest {
    private final AemContext context = new AemContext();

    @BeforeEach
    public void setUp() throws Exception {
        context.addModelsForClasses(HeroBannerImpl.class);
        context.load().json("/com/adobe/aem/mock/tuannt49/core/models/impl/HeroBannerImplTest.json", "/content");
    }

    @Test
    void testGetFileReference() {
        final String expected = "some/link/to/file.jpg";
        context.currentResource("/content/herobanner");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        String actual = heroBanner.getFileReference();
        assertEquals(expected, actual);
    }

    @Test
    void testGetLabel() {
        final String expected = "Label here";
        context.currentResource("/content/herobanner");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        String actual = heroBanner.getLabel();
        assertEquals(expected, actual);
    }

    @Test
    void testGetLinkURL() {
        final String expected = "link/to/URL";
        context.currentResource("/content/herobanner");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        String actual = heroBanner.getLinkURL();
        assertEquals(expected, actual);
    }

    @Test
    void testGetSubtitle() {
        final String expected = "Subtitle here";
        context.currentResource("/content/herobanner");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        String actual = heroBanner.getSubtitle();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTitle() {
        final String expected = "Title here";
        context.currentResource("/content/herobanner");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        String actual = heroBanner.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void testIsEmpty() {
        context.currentResource("/content/empty");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        assertTrue(heroBanner.isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        context.currentResource("/content/herobanner");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        assertFalse(heroBanner.isEmpty());
    }

    @Test
    void testIsEmptyWithoutTitle() {
        context.currentResource("/content/without-title");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        assertTrue(heroBanner.isEmpty());
    }

    @Test
    void testIsEmptyWithoutFileReference() {
        context.currentResource("/content/without-filereference");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        assertTrue(heroBanner.isEmpty());
    }

    @Test
    void testIsEmptyWithoutLinkURL() {
        context.currentResource("/content/without-linkURL");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        assertTrue(heroBanner.isEmpty());
    }

    @Test
    void testIsNewTab() {
        final String expected = "_blank";
        context.currentResource("/content/herobanner");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        String actual = heroBanner.isNewTab();
        assertEquals(expected, actual);
    }

    @Test
    void testIsNewTabFalse() {
        final String expected = "_self";
        context.currentResource("/content/newtab-false");
        HeroBanner heroBanner = context.request().adaptTo(HeroBanner.class);

        String actual = heroBanner.isNewTab();
        assertEquals(expected, actual);
    }
}

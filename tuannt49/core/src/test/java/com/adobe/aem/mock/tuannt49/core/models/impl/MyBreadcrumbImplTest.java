package com.adobe.aem.mock.tuannt49.core.models.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.designer.Style;

import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class MyBreadcrumbImplTest {
    private final AemContext context = new AemContext();
    protected static final boolean HIDE_CURRENT_DEFAULT = false;
    protected static final int START_LEVEL_DEFAULT = 4;
    String HIDE_CURRENT = "hideCurrent";
    String START_LEVEL = "startLevel";

    @Mock
    ValueMap properties;

    @Mock
    Style currentStyle;

    @Mock
    Page currentPage;

    @Mock
    Page page;

    @InjectMocks
    MyBreadcrumbImpl myBreadcrumbImpl;

    @BeforeEach
    public void setUp() throws Exception {
        PrivateAccessor.setField(myBreadcrumbImpl, "properties", properties);
        PrivateAccessor.setField(myBreadcrumbImpl, "currentStyle", currentStyle);
        PrivateAccessor.setField(myBreadcrumbImpl, "currentPage", currentPage);
        when(currentStyle.get(START_LEVEL, START_LEVEL_DEFAULT)).thenReturn(START_LEVEL_DEFAULT);
        when(properties.get(START_LEVEL, START_LEVEL_DEFAULT)).thenReturn(START_LEVEL_DEFAULT);

    }

    @Test
    void testGetItemsEmpty() {
        when(currentStyle.get(HIDE_CURRENT, HIDE_CURRENT_DEFAULT)).thenReturn(HIDE_CURRENT_DEFAULT);
        when(properties.get(HIDE_CURRENT, HIDE_CURRENT_DEFAULT)).thenReturn(HIDE_CURRENT_DEFAULT);
        when(currentPage.getDepth()).thenReturn(START_LEVEL_DEFAULT);
        myBreadcrumbImpl.initModel();
        assertEquals(0, myBreadcrumbImpl.getItems().size());
    }

    @Test
    void testGetItemsNotEmptyShowCurrent() {
        when(currentStyle.get(HIDE_CURRENT, HIDE_CURRENT_DEFAULT)).thenReturn(HIDE_CURRENT_DEFAULT);
        when(properties.get(HIDE_CURRENT, HIDE_CURRENT_DEFAULT)).thenReturn(HIDE_CURRENT_DEFAULT);
        when(currentPage.getDepth()).thenReturn(5);
        when(currentPage.getAbsoluteParent(4)).thenReturn(page);
        myBreadcrumbImpl.initModel();
        assertEquals(1, myBreadcrumbImpl.getItems().size());
    }

    @Test
    void testGetItemsNotEmptyHideCurrent() {
        when(currentStyle.get(HIDE_CURRENT, HIDE_CURRENT_DEFAULT)).thenReturn(true);
        when(properties.get(HIDE_CURRENT, true)).thenReturn(true);
        when(currentPage.getDepth()).thenReturn(5);
        when(currentPage.getAbsoluteParent(4)).thenReturn(currentPage);
        myBreadcrumbImpl.initModel();
        assertEquals(0, myBreadcrumbImpl.getItems().size());
    }

    @Test
    void testGetItemsNotEmptyHideCurrent2() {
        when(currentStyle.get(HIDE_CURRENT, HIDE_CURRENT_DEFAULT)).thenReturn(true);
        when(properties.get(HIDE_CURRENT, true)).thenReturn(true);
        when(currentPage.getDepth()).thenReturn(6);
        when(currentPage.getAbsoluteParent(4)).thenReturn(page);
        when(currentPage.getAbsoluteParent(5)).thenReturn(currentPage);
        myBreadcrumbImpl.initModel();
        assertEquals(1, myBreadcrumbImpl.getItems().size());
    }
}

package com.adobe.aem.mock.tuannt49.core.models.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.adobe.aem.mock.tuannt49.core.service.SearchPage;
import com.day.cq.wcm.api.Page;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ActivitiesModelImplTest {

    @InjectMocks
    ActivitiesModelImpl activitiesModelImpl;

    @Mock
    SearchPage searchPage;

    @Mock
    List<Page> pages;

    @Mock
    Page page;

    @BeforeEach
    void setUp() {
        pages = new ArrayList<>();
        // activitiesModelImpl = new ActivitiesModelImpl();
        activitiesModelImpl.searchPage = searchPage;
    }

    @Test
    void testGetItemsNull() {
        when(searchPage.searchByTemplate(anyString(), anyInt(), anyInt())).thenReturn(pages);
        assertTrue(activitiesModelImpl.getItems().isEmpty());
    }

    @Test
    void testGetItemsWithResult() {
        pages.add(page);
        when(searchPage.searchByTemplate(anyString(), anyInt(), anyInt())).thenReturn(pages);
        assertEquals(1, activitiesModelImpl.getItems().size());
    }
}

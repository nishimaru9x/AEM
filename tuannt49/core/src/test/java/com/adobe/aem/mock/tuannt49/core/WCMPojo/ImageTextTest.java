package com.adobe.aem.mock.tuannt49.core.WCMPojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;

import javax.script.Bindings;

import com.day.cq.wcm.scripting.WCMBindingsConstants;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ImageTextTest {

    private final AemContext context = new AemContext(ResourceResolverType.RESOURCERESOLVER_MOCK);
    private final String CPM_MOCK_JSON = "/com/adobe/aem/mock/tuannt49/core/WCMPojo/ImageText.json";
    private final String CPM_CONTENT_PATH = "/component";
    private final String LABEL_DISCOVER = "Discover";
    private ImageText imageText;

    @Mock
    private Bindings bindings;

    @BeforeEach
    public void setUp() throws Exception {
        context.load().json(CPM_MOCK_JSON, CPM_CONTENT_PATH);
        imageText = new ImageText();
    }

    @Test
    void testGetDescription() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/imageText");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        String actual = imageText.getDescription();
        String expected = "description";
        assertEquals(expected, actual);
    }

    @Test
    void testGetFileReference() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/imageText");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        String actual = imageText.getFileReference();
        String expected = "fileReference";
        assertEquals(expected, actual);
    }

    @Test
    void testGetLabel() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/without-label");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        String actual = imageText.getLabel();
        String expected = LABEL_DISCOVER;
        assertEquals(expected, actual);
    }

    @Test
    void testGetLinkURL() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/imageText");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        String actual = imageText.getLinkURL();
        String expected = "linkURL";
        assertEquals(expected, actual);
    }

    @Test
    void testGetTitle() throws Exception {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/imageText");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        String actual = imageText.getTitle();
        String expected = "Title";
        assertEquals(expected, actual);
    }

    @Test
    void testIsActive() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/imageText");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        assertTrue(imageText.isActive());
    }

    @Test
    void testIsActiveWithoutTitle() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/without-title");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        assertFalse(imageText.isActive());
    }

    @Test
    void testIsActiveWithoutLinkURL() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/without-linkURL");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        assertFalse(imageText.isActive());
    }

    @Test
    void testIsActiveWithoutFileReference() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH + "/without-filereference");
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        assertFalse(imageText.isActive());
    }
}

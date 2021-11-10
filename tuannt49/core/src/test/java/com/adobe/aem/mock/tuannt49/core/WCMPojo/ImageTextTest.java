package com.adobe.aem.mock.tuannt49.core.WCMPojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    private final String CPM_CONTENT_PATH = "/page/some-page/jcr:content/root/responsivegrid/imageText";
    private final String PAGE_MOCK_JSON = "/com/adobe/aem/mock/tuannt49/core/WCMPojo/pageContent.json";
    private final String PAGE_CONTENT_PATH = "/page/sample";
    private ImageText imageText;

    @Mock
    private Bindings bindings;

    @BeforeEach
    public void setUp() throws Exception {
        context.load().json(CPM_MOCK_JSON, CPM_CONTENT_PATH);
        context.load().json(PAGE_MOCK_JSON, PAGE_CONTENT_PATH);
        imageText = new ImageText();
    }

    @Test
    void testGetDescription() {
        Resource cpmResource = context.currentResource(CPM_CONTENT_PATH);
        ValueMap properties = cpmResource.getValueMap();

        lenient().when(bindings.get(WCMBindingsConstants.NAME_PROPERTIES)).thenReturn(properties);

        imageText.init(bindings);
        String actual = imageText.getDescription();
        String expected = "description";
        assertEquals(expected, actual);
    }

    @Test
    void testGetFileReference() {

    }

    @Test
    void testGetLabel() {

    }

    @Test
    void testGetLinkURL() {

    }

    @Test
    void testGetSubtitle() {

    }

    @Test
    void testGetTitle() throws Exception {

    }

    @Test
    void testIsActive() {

    }
}

package apps.tuannt49.components.activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivitiesModel extends WCMUsePojo {
    private List<Page> items = new ArrayList<Page>();
    private Page rootPage;
    private PageManager pageManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitiesModel.class);

    // Initializes the navigation
    @Override
    public void activate() throws Exception {
        SearchResult rootPage = getCurrentPage();
        pageManager = getPageManager();

        // LOGGER.info(pageManager);
        LOGGER.info("=================Logging==============");
        Iterator<Page> childPages = rootPage.listChildren(null, false);
        while (childPages.hasNext()) {
            Page child = childPages.next();
            items.add(child);
        }

        // LOGGER.info(items.size() + " size");
    }

    // Returns the navigation items
    public List<Page> getItems() {
        LOGGER.info("List pages");
        return items;
    }

    // Returns the navigation root
    public Page getRoot() {
        return rootPage;
    }

}

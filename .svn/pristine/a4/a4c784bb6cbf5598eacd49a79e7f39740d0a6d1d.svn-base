package pt.ist.rest.presentation.client.page;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.presentation.client.panel.SearchByNamePanel;
import pt.ist.rest.presentation.client.panel.SearchByTypePanel;
import pt.ist.rest.presentation.client.panel.SearchResultsListPanel;
import pt.ist.rest.presentation.client.panel.SelectSearchPanel;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SearchPlatesDto;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchPlatesPage.
 */
public class SearchPlatesPage extends
        Composite {

    
    private SelectSearchPanel selectSearch;
    
    /**
     * The search by type.
     */
    private SearchByTypePanel searchByType;

    /**
     * The search by name.
     */
    private SearchByNamePanel searchByName;
    
    /**
     * The search list panel.
     */
    private SearchResultsListPanel searchListPanel;

    /**
     * The rpc service.
     */
    private RestServletAsync rpcService;

    /**
     * The root page.
     */
    private RestGWT rootPage;

    /**
     * Instantiates a new search plates page.
     * 
     * @param rpcService the rpc service
     * @param rootPage the root page
     */
    public SearchPlatesPage(RestServletAsync rpcService, RestGWT rootPage) {
        selectSearch = new SelectSearchPanel(rootPage, this, rpcService);
        searchByType = new SearchByTypePanel(rootPage, this, rpcService);
        searchByName = new SearchByNamePanel(rootPage, this, rpcService);
        searchListPanel = new SearchResultsListPanel(rpcService, rootPage);
        this.rpcService = rpcService;
        this.rootPage = rootPage;
    }

    /**
     * Show search results.
     * 
     * @param result the result
     */
    public void showSearchResults(SearchPlatesDto result) {
        searchListPanel.clearSearchResultsList();
        searchListPanel.addHeader();
        for (PlateDto p : result.getMatchingPlates()) {
            searchListPanel.add(p);
        }
        searchListPanel.hideIDColumn();
    }

    /**
     * Show search results failure.
     */
    public void showSearchResultsFailure() {
        searchListPanel.clearSearchResultsList();
        searchListPanel.showSearchResultsFailure();
    }

    /**
     * Show page.
     */
    public void showPage() {
        RootPanel divSearch = RootPanel.get("search");
        divSearch.add(selectSearch);
    }
    
    public void showPage(String searchType) {
        RootPanel divSearchByType = RootPanel.get("searchByType");
        RootPanel divSearchByName = RootPanel.get("searchByToken");
        if(searchType.equals("Tipo")) {
            divSearchByName.clear();
            divSearchByType.add(searchByType);
            RootPanel divResult = RootPanel.get("searchResult");
            divResult.add(searchListPanel);
        }
        else if(searchType.equals("Nome")) {
            divSearchByType.clear();
            divSearchByName.add(searchByName);
            RootPanel divResult = RootPanel.get("searchResult");
            divResult.add(searchListPanel);
        }
    }

}

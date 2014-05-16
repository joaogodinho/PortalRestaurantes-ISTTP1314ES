package pt.ist.rest.presentation.client.panel;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.presentation.client.page.SearchPlatesPage;
import pt.ist.rest.service.dto.SearchPlatesDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;

/**
 * The Class SearchByNamePanel.
 */
public class SearchByNamePanel extends
        FlexTable {
    /**
     * Instantiates a new search by type panel.
     * 
     * @param rootPage the root page
     * @param parent the parent
     * @param rpcService the rpc service
     */
    public SearchByNamePanel(final RestGWT rootPage,
                             final SearchPlatesPage parent,
                             final RestServletAsync rpcService) {
        GWT.log("presentation.client.view.SearchByNamePanel::constructor()");

        final TextBox txtSearch = new TextBox();

        this.setWidget(0, 0, txtSearch);

        Button btnSearch = new Button("Procurar");
        btnSearch.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                String search = txtSearch.getText();
                GWT.log("presentation.client.view.SearchByNamePanel::OnClick(ClickEvent) - searching plates with name "
                        + search);

                rpcService.searchPlatesByName(search, new AsyncCallback<SearchPlatesDto>() {

                    @Override
                    public void onSuccess(SearchPlatesDto result) {
                        if(!result.getMatchingPlates().isEmpty()) {
                            parent.showSearchResults(result);
                        } else {
                            parent.showSearchResultsFailure();
                        }
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        rootPage.showErrorMessage("Nao foi possivel realizar a procura.");
                    }
                });
            }
        });

        this.setWidget(0, 1, btnSearch);
    }
}

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

// DOJAVADOC: Auto-generated Javadoc
/**
 * The Class SearchByTypePanel.
 */
public class SelectSearchPanel extends
        FlexTable {



    /**
     * Instantiates a new search by type panel.
     * 
     * @param rootPage the root page
     * @param parent the parent
     * @param rpcService the rpc service
     */
    public SelectSearchPanel(final RestGWT rootPage,
                             final SearchPlatesPage parent,
                             final RestServletAsync rpcService) {
        GWT.log("presentation.client.view.SearchByTypePanel::constructor()");
        
        Label title = new Label("Tabuleiro");
        title.setStyleName("h1-label");
        this.setWidget(0, 0, title);

        final ListBox lbTypeSelection = new ListBox();
        lbTypeSelection.addItem("Tipo");
        lbTypeSelection.addItem("Nome");

        lbTypeSelection.setVisibleItemCount(1);

        this.setWidget(1, 0, lbTypeSelection);

        Button btnSearch = new Button("Procurar");
        btnSearch.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                String type = lbTypeSelection.getItemText(lbTypeSelection.getSelectedIndex());
                GWT.log("presentation.client.view.SearchByTypePanel::OnClick(ClickEvent) - selecting search type "
                        + type);

                
                parent.showPage(type);
            }
        });

        this.setWidget(1, 1, btnSearch);
    }

}

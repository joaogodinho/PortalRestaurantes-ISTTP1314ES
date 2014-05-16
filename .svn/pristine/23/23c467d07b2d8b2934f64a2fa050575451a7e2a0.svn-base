package pt.ist.rest.presentation.client.panel;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.service.dto.PlateDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuListPanel.
 */
public class SearchResultsListPanel extends
        FlexTable {

    /**
     * The rpc service.
     */
    private RestServletAsync rpcService;

    /**
     * The root page.
     */
    private final RestGWT rootPage;

    /**
     * Instantiates a new menu list panel.
     * 
     * @param rpcService the rpc service
     * @param rootPage the root page
     */
    public SearchResultsListPanel(RestServletAsync rpcService, RestGWT rootPage) {
        GWT.log("presentation.client.view.PlateListPanel::constructor()");
        // set RPC service
        this.rpcService = rpcService;

        final int colSpan = 7;
        this.getFlexCellFormatter().setColSpan(0, 0, colSpan);

        Label title = new Label("Resultado da Procura");
        title.setStyleName("h1-label");
        this.setWidget(0, 0, title);

        this.rootPage = rootPage;
    }

    /**
     * Adds the header.
     */
    public void addHeader() {

        // add header row:
        final int lineName = 1;

        final int colPrato = 0;

        final int colRest = 1;

        final int colTipo = 2;
        final int colCalorias = 3;
        final int colPreco = 4;
        final int colClassPrato = 5;

        final int colId = 7;

        setText(lineName, colPrato, "Prato");

        setText(lineName, colRest, "Restaurante");

        setText(lineName, colTipo, "Tipo");
        setText(lineName, colCalorias, "Calorias");
        setText(lineName, colPreco, "Preco");
        setText(lineName, colClassPrato, "Classificacao do Prato");

        setText(lineName, colId, "ID"); // Hidden field
    }

    /**
     * Clear search results list.
     */
    public void clearSearchResultsList() {
        GWT.log("presentation.client.view.PlateListPanel::clearMenuList()");
        int rowCount = getRowCount();
        for (int i = rowCount - 1; i > 0; i--) {
            removeRow(i);
        }
    }

    /**
     * Adds the click handler to plate button.
     * 
     * @param plate the plate
     * @return the click handler
     */
    private ClickHandler addClickHandlerToPlateButton(final PlateDto plate) {
        return new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                rpcService.addPlateToCart(rootPage.getActiveUser(), plate, 1,
                        new AsyncCallback<Void>() {

                            @Override
                            public void onFailure(Throwable caught) {
                                GWT.log("presentation.client.view.PlateListPanel::add(" + plate
                                        + ") failed to add plate to cart");
                            }

                            @Override
                            public void onSuccess(Void result) {
                                GWT.log("presentation.client.view.PlateListPanel::add(" + plate
                                        + ") added plate to cart");

                                rootPage.getOpenCartPage().refreshOpenCart();
                            }
                        });
            }
        };
    }

    /**
     * Adds the plate.
     * 
     * @param plate the plate
     */
    public void add(final PlateDto plate) {
        GWT.log("presentation.client.view.SearchResultsListPanel::add(" + plate + ")");
        // get the number of the next row:
        int row = getRowCount() + 1;


        final int colPrato = 0;

        final int colRest = 1;

        final int colTipo = 2;
        final int colCalorias = 3;
        final int colPreco = 4;

        final int colClassPrato = 5;

        final int colId = 7;


        setText(row, colPrato, plate.getName());

        setText(row, colRest, plate.getRestaurantDto().getName());


        setText(row, colTipo, plate.getType());
        setText(row, colCalorias, String.valueOf(plate.getCalories()));
        setText(row, colPreco, String.valueOf(plate.getPrice()));

        setText(row, colClassPrato, String.valueOf(plate.getClassification()));


        setText(row, colId, String.valueOf(plate.getId()));

        final Button addToCartButton = new Button("Adicionar");

        addToCartButton.addClickHandler(addClickHandlerToPlateButton(plate));

        final int colAdd = 6;
        setWidget(row, colAdd, addToCartButton);
    }

    /**
     * Show search results failure.
     */
    public void showSearchResultsFailure() {
        setWidget(1, 0, new Label("Nao foram encontrados quaisquer pratos."));
    }


    /**
     * Hide id column.
     */
    public void hideIDColumn() {
        for (int i = 0; i < getRowCount(); i++) {
            final int colId = 7;
            getCellFormatter().setVisible(i, colId, false);
        }
    }
}

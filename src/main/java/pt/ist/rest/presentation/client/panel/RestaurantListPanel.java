package pt.ist.rest.presentation.client.panel;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

/**
 * The Class RestaurantListPanel.
 */
public class RestaurantListPanel extends
        FlexTable {

    /**
     * The root page.
     */
    private RestGWT rootPage = null;

    /**
     * Instantiates a new restaurant list panel.
     * 
     * @param rootPage the root page
     */
    public RestaurantListPanel(RestGWT rootPage) {
        GWT.log("presentation.client.view.RestaurantListPanel::constructor()");
        
        final int colSpan = 4;
        this.getFlexCellFormatter().setColSpan(0, 0, colSpan);
        Label title = new Label("Restaurantes");
        title.setStyleName("h1-label");
        this.setWidget(0, 0, title);
        
        // format table main features:
        this.addStyleName("restaurantsTable");
        // add header row:
        int row = 1;
        setText(row, 0, "Nome");
        setText(row, 1, "Morada");
        setText(row, 2, "Classificacao");
        // add style to row:
        //getRowFormatter().addStyleName(0, "restaurantsTableHeader");
        this.rootPage = rootPage;
    }

    /**
     * Clear restaurants list.
     */
    public final void clearRestaurantsList() {
        GWT.log("presentation.client.view.RestaurantListPanel::clearRestaurantList()");
        int rowCount = getRowCount();
        for (int i = rowCount - 1; i > 1; i--) { removeRow(i); }
    }

    /**
     * Adds the.
     * 
     * @param restaurant the restaurant
     */
    public void add(final SimpleRestaurantDto restaurant) {
        GWT.log("presentation.client.view.ContactListPanel::add(" + restaurant + ")");
        // get the number of the next row:
        int row = getRowCount() + 1;

        // add name and phone number (and set style from CSS)
        setText(row, 0, restaurant.getName());
        setText(row, 1, restaurant.getAddress());
        setText(row, 2, String.valueOf(restaurant.getClassification()));

        // if we want styles across columns (and data type):
//        getCellFormatter().addStyleName(row, 0, "restaurantsTableNameCell");
//        getCellFormatter().addStyleName(row, 1, "restaurantsTablePhoneCell");
//
//        // if we want alternate colored rows:
//        if ((row % 2) == 0) {
//            getRowFormatter().addStyleName(row, "restaurantsTableCellEven");
//        } else {
//            getRowFormatter().addStyleName(row, "restaurantsTableCellOdd");
//        }

        // set show menu button
        Button showMenuButton = new Button("Mostrar Menu");
        final int colButton = 3;
        setWidget(row, colButton, showMenuButton);

        // add handlers for clicks
        showMenuButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                rootPage.showRestaurantMenuPage(restaurant);
            }
        });
    }
}

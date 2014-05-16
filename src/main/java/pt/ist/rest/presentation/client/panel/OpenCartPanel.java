package pt.ist.rest.presentation.client.panel;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.presentation.client.page.OpenCartPage;
import pt.ist.rest.service.dto.PlateQuantityDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

/**
 * The Class OpenCartPanel.
 */
public class OpenCartPanel extends
        FlexTable {

    /**
     * The parent.
     */
    private OpenCartPage parent;
    private RestServletAsync rpcService;
    private RestGWT rootPage;

    /**
     * Instantiates a new open cart panel.
     * 
     * @param rootPage the root page
     * @param parent the parent
     * @param rpcService the rpc service
     */
    public OpenCartPanel(final RestGWT rootPage,
                         final OpenCartPage parent,
                         final RestServletAsync rpcService) {
        GWT.log("presentation.client.view.OpenCartPanel::constructor()");

        this.parent = parent;
        this.rpcService = rpcService;
        this.rootPage = rootPage;
        
        final int colSpan = 1;
        this.getFlexCellFormatter().setColSpan(0, 0, colSpan);
        
        Label title = new Label("Tabuleiro");
        title.setStyleName("h1-label");
        this.setWidget(0, 0, title);

    }

    /**
     * Clear open cart table.
     */
    public final void clearOpenCartTable() {
        GWT.log("presentation.client.view.OpenCartPanel::clearOpenCartTable()");
        int rowCount = getRowCount();
        for (int i = rowCount - 1; i > 0; i--) {
            removeRow(i);
        }
    }

    /**
     * Adds the new plate to table.
     * 
     * @param plateQ the plate q
     */
    public void addNewPlateToTable(final PlateQuantityDto plateQ) {
        int row = getRowCount();
        
        Label lblNamePlate = new Label(plateQ.getPlateDto().getName());
        lblNamePlate.setStyleName("label");
        setWidget(row, 0, lblNamePlate);

        Label lblRestPlate = new Label(plateQ.getPlateDto().getRestaurantDto().getName());
        lblRestPlate.setStyleName("label");
        setWidget(row, 1, lblRestPlate);
        
        Label lblPricePlate = new Label(String.valueOf(plateQ.getPlateDto().getPrice()));
        lblPricePlate.setStyleName("label");
        setWidget(row, 2, lblPricePlate);
        
        Label lblQuantPlate = new Label(String.valueOf(plateQ.getQuantity()));
        lblQuantPlate.setStyleName("label");
        final int colQuant = 3;
        setWidget(row, colQuant, lblQuantPlate);


        Button btnMinus = new Button("-");
        btnMinus.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                rpcService.addPlateToCart(rootPage.getActiveUser(), plateQ.getPlateDto(), -1,
                        new AsyncCallback<Void>() {

                            /**
                             * On success.
                             * 
                             * @param result the result
                             */
                            @Override
                            public void onSuccess(Void result) {
                                parent.refreshOpenCart();
                            }

                            /*
                             * (non-Javadoc)
                             * 
                             * @see
                             * com.google.gwt.user.client.rpc.AsyncCallback#onFailure(
                             * java.lang.Throwable)
                             */
                            @Override
                            public void onFailure(Throwable caught) {
                                // TODO mensagem de erro
                            }
                        });
            }
        });
        final int colMinus = 4; 
        setWidget(row, colMinus, btnMinus);

        Button btnPlus = new Button("+");
        btnPlus.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                rpcService.addPlateToCart(rootPage.getActiveUser(), plateQ.getPlateDto(), 1,
                        new AsyncCallback<Void>() {
                    
                    /**
                     * On success.
                     * 
                     * @param result the result
                     */
                    @Override
                    public void onSuccess(Void result) {
                        parent.refreshOpenCart();
                    }
                    
                    /*
                     * (non-Javadoc)
                     * 
                     * @see
                     * com.google.gwt.user.client.rpc.AsyncCallback#onFailure(
                     * java.lang.Throwable)
                     */
                    @Override
                    public void onFailure(Throwable caught) {
                        // TODO mensagem de erro
                    }
                });

            }
        });
        final int colPlus = 5; 
        setWidget(row, colPlus, btnPlus);
    }
    
    public void addTotal(double value) {
        int row = getRowCount();
        
        Label lblTotal = new Label("Total:");
        lblTotal.setStyleName("label");
        setWidget(row, 0, lblTotal);
        
        Label lblValue = new Label(String.valueOf(value));
        lblValue.setStyleName("label");
        setWidget(row + 1, 0, lblValue);
        
    }

    public void addHeader() {
        Label lblPrato = new Label("Prato");
        lblPrato.setStyleName("label");
        setWidget(1, 0, lblPrato);
        
        Label lblRest = new Label("Restaurante");
        lblRest.setStyleName("label");
        setWidget(1, 1, lblRest);
        
        Label lblPreco = new Label("Preço p/ Uni.");
        lblPreco.setStyleName("label");
        setWidget(1, 2, lblPreco);
        
        Label lblQuant = new Label("Quantidade");
        lblQuant.setStyleName("label");
        final int colQuant = 3;
        setWidget(1, colQuant, lblQuant);
    }

    public void showEmptyCartMessage() {
        setWidget(1, 0, new Label("O carrinho esta vazio"));
    }

}

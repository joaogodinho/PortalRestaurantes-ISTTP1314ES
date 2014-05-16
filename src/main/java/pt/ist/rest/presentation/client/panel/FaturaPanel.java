package pt.ist.rest.presentation.client.panel;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.service.dto.FaturaDto;
import pt.ist.rest.service.dto.ItemFaturaDto;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class FaturaPanel extends DialogBox {

    /**
     * The rpc service.
     */
    private RestServletAsync rpcService;

    /**
     * The root page.
     */
    private final RestGWT rootPage;

    private final FaturaDto fatura;

    public FaturaPanel(FaturaDto fatura, RestGWT rootPage,
            RestServletAsync rpcService) {
        setText("Fatura");
        setAnimationEnabled(false);
        setGlassEnabled(true);
        setTitle("Fatura");
        this.rpcService = rpcService;
        this.rootPage = rootPage;
        this.fatura = fatura;

        FlexTable table = new FlexTable();
        table.setStyleName("fatura");
        String space = " - - - ";

        int row = 0;

        String message = "Data:";

        table.setWidget(row, 0, new Label("Data:"));
        table.setWidget(row, 1, new Label(space));
        table.setWidget(row, 2, new Label(fatura.getData()));
        message += fatura.getData() + "|Emissor:";
        row += 1;

        table.setWidget(row, 0, new Label("Emissor:"));
        table.setWidget(row, 1, new Label(space));
        table.setWidget(row, 2, new Label(fatura.getNomeEmissor()));
        message += fatura.getNomeEmissor() + "|NifEmissor:";
        row += 1;

        table.setWidget(row, 0, new Label("NIF Emissor:"));
        table.setWidget(row, 1, new Label(space));
        table.setWidget(row, 2, new Label("" + fatura.getNifEmissor()));
        message += fatura.getNifEmissor() + "|NifCliente:";
        row += 1;

        table.setWidget(row, 0, new Label("NIF Cliente:"));
        table.setWidget(row, 1, new Label(space));
        table.setWidget(row, 2, new Label("" + fatura.getNifCliente()));
        message += fatura.getNifCliente() + "|Total:";
        row += 1;
        GWT.log("itens: " + fatura.getItens());
        for (ItemFaturaDto i : fatura.getItens()) {
            GWT.log("item: Prato:" + i.getDescricao() + "|preco:"
                    + i.getPreco() + "|quantidade:" + i.getQuantidade());
            table.setWidget(row, 0, new Label("Prato:"));
            table.setWidget(row, 1, new Label(space));
            table.setWidget(row, 2, new Label(i.getDescricao()));
            row += 1;
            table.setWidget(row, 0, new Label(space));
            table.setWidget(row, 1, new Label("preco total:"));
            table.setWidget(row, 2, new Label("" + i.getPreco()));
            row += 1;
            table.setWidget(row, 0, new Label(space));
            table.setWidget(row, 1, new Label("quantidade:"));
            table.setWidget(row, 2, new Label("" + i.getQuantidade()));
            row += 1;
        }

        table.setWidget(row, 0, new Label("Total:"));
        table.setWidget(row, 1, new Label(space));
        table.setWidget(row, 2, new Label("" + fatura.getTotal()));
        message += fatura.getTotal() + "|Iva:";
        row += 1;

        table.setWidget(row, 0, new Label("Iva pago:"));
        table.setWidget(row, 1, new Label(space));
        table.setWidget(row, 2, new Label("" + fatura.getIva()));
        message += fatura.getIva();
        row += 1;

        GWT.log("fatura: " + message);

        Button ok = new Button("OK");
        ok.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                FaturaPanel.this.hide();
            }
        });
        table.setWidget(row, 2, ok);

        setWidget(table);
        center();
    }

}

package pt.ist.rest.presentation.client.page;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.service.dto.SimpleClientDto;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class ShowClientData.
 * 
 * @deprecated
 */
public class ClientDataPage extends Composite {

    private FlexTable clientData;

    private Label clientSaldo;
    private Label clientName;
    private Label clientAddress;
    private Label clientEmail;

    private RestServletAsync rpcService;
    public ClientDataPage(final RestGWT rootPage, final RestServletAsync rpcService) {
        this.rpcService = rpcService;
        clientData = new FlexTable();
        Label title = new Label("Dados do cliente");
        Label nome = new Label("Nome:");
        clientName = new Label();
        Label morada = new Label("Morada:");
        clientAddress = new Label();
        Label email = new Label("Email:");
        clientEmail = new Label();
        Label saldo = new Label("Saldo:");
        
        // TODO: Saldo cliente
        // Imprimir aqui o saldo do cliente
        //
        clientSaldo = new Label("Nao implementado");
        
        clientData.setWidget(0, 0, title);
        clientData.setWidget(1, 0, nome);
        clientData.setWidget(1, 1, clientName);
        clientData.setWidget(2, 0, morada);
        clientData.setWidget(2, 1, clientAddress);
        clientData.setWidget(3, 0, email);
        clientData.setWidget(3, 1, clientEmail);
        clientData.setWidget(4, 0, saldo);
        clientData.setWidget(4, 1, clientSaldo);
        
        initWidget(clientData);
    }
    
    public void setActiveUser(SimpleClientDto activeUser) {
        clientAddress.setText(activeUser.getAddress());
        clientName.setText(activeUser.getName());
        clientEmail.setText(activeUser.getEmail());
    }
    
    public void setSaldo(String saldo) {
        // TODO: Saldo cliente
        // Imprimir aqui o saldo do cliente
        //
        clientSaldo.setText(saldo);
    }
    
    public void showPage() {
        RootPanel divClient = RootPanel.get("client");
        divClient.add(this);
    }
}

package pt.ist.rest.presentation.client.page;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.UserDto;
import pt.ist.rest.service.exception.UnknownUserException;
import pt.ist.rest.service.exception.WrongPasswordException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 * The Class LoginPage.
 */
public class LoginPage extends Composite {

    /**
     * The btn login.
     */
    private Button btnLogin;

    /**
     * The username box.
     */
    private TextBox usernameBox;

    /**
     * The password box.
     */
    private TextBox passwordBox;

    /**
     * Instantiates a new login page.
     * 
     * @param rootPage
     *            the root page
     * @param rpcService
     *            the rpc service
     */
    public LoginPage(final RestGWT rootPage, final RestServletAsync rpcService) {
        FlexTable flexTable = new FlexTable();

        flexTable.getFlexCellFormatter().setColSpan(0, 0, 2);
        Label title = new Label("Login");
        title.setStyleName("h1-label");
        flexTable.setWidget(0, 0, title);

        Label lblPerson = new Label("Username:");
        lblPerson.setStyleName("label");
        flexTable.setWidget(1, 0, lblPerson);

        usernameBox = new TextBox();
        flexTable.setWidget(1, 1, usernameBox);

        usernameBox.addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    doLogin(rootPage, rpcService);
                }
            }
        });

        Label lblPassword = new Label("Password:");
        lblPassword.setStyleName("label");
        flexTable.setWidget(2, 0, lblPassword);

        passwordBox = new TextBox();
        flexTable.setWidget(2, 1, passwordBox);

        passwordBox.addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    doLogin(rootPage, rpcService);
                }
            }
        });

        btnLogin = new Button("login");
        final int row = 3;
        flexTable.setWidget(row, 1, btnLogin);

        btnLogin.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                doLogin(rootPage, rpcService);
            }
        });

        initWidget(flexTable);
    }

    /**
     * Do login.
     * 
     * @param rootPage
     *            the root page
     * @param rpcService
     *            the rpc service
     */
    private void doLogin(final RestGWT rootPage,
            final RestServletAsync rpcService) {
        rootPage.clearErrorMessage();
        // if any of the fields is empty, show warning:
        if ("".equals(this.usernameBox.getText())) {
            rootPage.showErrorMessage("Please fill the username field.");
            GWT.log("presentation.client.page.LoginPage::doLogin() - empty Username");
            return;
        }
        if ("".equals(this.passwordBox.getText())) {
            rootPage.showErrorMessage("Please fill the password field.");
            GWT.log("presentation.client.page.LoginPage::doLogin() - empty Password");
            return;
        }

        final UserDto dto = new UserDto(this.usernameBox.getText(),
                this.passwordBox.getText());

        rpcService.login(dto, new AsyncCallback<SimpleClientDto>() {
            public void onSuccess(SimpleClientDto client) {
                rootPage.setActiveUser(client);
                rootPage.hideAll();
                rootPage.showRestaurantsPage();
                rootPage.showOpenCartPage();
                rootPage.showSearchPlatesPage();
                // NOBIG: dados do cliente
                // rootPage.showClientDataPage();
            }

            public void onFailure(Throwable caught) {
                rootPage.showErrorMessage("Wrong username or password!");
                if (caught instanceof UnknownUserException) {
                    rootPage.showErrorMessage("Utilizador nao encontrado");
                } else if (caught instanceof WrongPasswordException) {
                    rootPage.showErrorMessage("Password nao encontrada");
                }
                GWT.log("presentation.client.page.LoginPage::doLogin() - wrong username or password");
            }
        });
    }

}

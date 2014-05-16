package pt.ist.rest.presentation.client;

import pt.ist.rest.presentation.client.page.ListMenuPage;
import pt.ist.rest.presentation.client.page.ListRestaurantsPage;
import pt.ist.rest.presentation.client.page.LoginPage;
import pt.ist.rest.presentation.client.page.OpenCartPage;
import pt.ist.rest.presentation.client.page.SearchPlatesPage;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RestGWT implements EntryPoint {

    // /**
    // * The Constant SERVER_ERROR.
    // */
    // private static final String SERVER_ERROR = "An error occurred while "
    // + "attempting to contact the server. Please check your network "
    // + "connection and try again.";

    private SimpleClientDto activeUser = null;

    /**
     * The error message.
     */
    private final Label errorMessage = new Label("");

    /**
     * The add plate page.
     */
    private ListMenuPage listMenuPage;

    /**
     * The list restaurants page.
     */
    private ListRestaurantsPage listRestaurantsPage;

    /**
     * The login page.
     */
    private LoginPage loginPage;

    private OpenCartPage openCartPage;
    
    private SearchPlatesPage searchPlatesPage;

    // NOBIG: dados do cliente
    // private ClientDataPage clientDataPage;

    /**
     * The rpc service.
     */
    private final RestServletAsync rpcService = GWT.create(RestServlet.class);

    /**
     * Clear error message.
     */
    public void clearErrorMessage() {
        RootPanel.get("errorLabelContainer").clear();
    }

    public SimpleClientDto getActiveUser() {
        return activeUser;
    }

    public OpenCartPage getOpenCartPage() {
        return openCartPage;
    }

    // NOBIG: dados do cliente
    // public ClientDataPage getShowClientDataPage() {
    // return clientDataPage;
    // }

    /**
     * Hide all.
     */
    public void hideAll() {
        RootPanel.get("login").clear();
        RootPanel.get("restaurants").clear();
        RootPanel.get("restaurantMenu").clear();
        RootPanel.get("cart").clear();
        RootPanel.get("client").clear();
        RootPanel.get("searchByType").clear();
        RootPanel.get("searchResult").clear();
    }

    public void onModuleLoad() {
        GWT.log("presentation.client.Rest::onModuleLoad() - begin");

        rpcService.initServer(new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                GWT.log("presentation.client.Rest::onModuleLoad()::rpcService.initBridge");
                GWT.log("-- Throwable: '" + caught.getClass().getName() + "'");
                showErrorMessage("Not able to init aplication server bridge: "
                        + caught.getMessage());
            }

            @Override
            public void onSuccess(Void result) {
                GWT.log("presentation.client.Rest::onModuleLoad() - initServer successful");
            }
        });

        loginPage = new LoginPage(this, rpcService);
        listRestaurantsPage = new ListRestaurantsPage(this, rpcService);
        listMenuPage = new ListMenuPage(this, rpcService);
        searchPlatesPage = new SearchPlatesPage(rpcService, this);
        // NOBIG: dados do cliente
        // clientDataPage = new ClientDataPage(this, rpcService);
        showLoginPage();
    }

    public void setActiveUser(SimpleClientDto activeUser) {
        this.activeUser = activeUser;
        // NOBIG: dados do cliente
        // clientDataPage.setActiveUser(activeUser);
    }

    /**
     * Show restaurants page.
     */
    public void showRestaurantsPage() {
        listRestaurantsPage.showPage();

        errorMessage.setText("");
    }

    public void showOpenCartPage() {
        if (openCartPage == null) {
            openCartPage = new OpenCartPage(this, rpcService);
        }
        openCartPage.showPage();

    }
    
    public void showSearchPlatesPage() {
        searchPlatesPage.showPage();

        errorMessage.setText("");
    }

    /**
     * Show error message.
     * 
     * @param message
     *            the message
     */
    public void showErrorMessage(String message) {
        clearErrorMessage();
        RootPanel.get("errorLabelContainer").add(new Label(message));
    }

    // NOBIG: dados do cliente
    // public void showClientDataPage() {
    // clientDataPage.showPage();
    // }

    /**
     * Show login page.
     */
    public void showLoginPage() {
        this.hideAll();

        RootPanel.get("login").add(loginPage);

        errorMessage.setText("");
    }

    public void showRestaurantMenuPage(SimpleRestaurantDto restaurant) {
        RootPanel.get("restaurantMenu").clear();
        listMenuPage.setSelectedRestaurant(restaurant);
        listMenuPage.showPage();
    }

}

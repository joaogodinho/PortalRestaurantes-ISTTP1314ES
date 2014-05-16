package pt.ist.rest.presentation.client.page;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.presentation.client.panel.RestaurantListPanel;
import pt.ist.rest.service.dto.RestaurantsOnPortalDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class ListRestaurantsPage.
 */
public class ListRestaurantsPage extends
        Composite {
    
    /**
     * The restaurant list panel.
     */
    private final RestaurantListPanel restaurantListPanel;
    
    /**
     * The rpc service.
     */
    private RestServletAsync rpcService = null;

    /**
     * Instantiates a new list restaurants page.
     *
     * @param rootPage the root page
     * @param rpcService the rpc service
     */
    public ListRestaurantsPage(final RestGWT rootPage, final RestServletAsync rpcService) {
        this.rpcService = rpcService;

        restaurantListPanel = new RestaurantListPanel(rootPage);
    }
    
    public void hidePage() {
        RootPanel.get("restaurants").clear();
    }

    /**
     * List restaurants.
     *
     * @param result the result
     */
    public final void listRestaurants(RestaurantsOnPortalDto result) {
        restaurantListPanel.clearRestaurantsList();
        for (SimpleRestaurantDto dto : result.getRestaurants()) {
            restaurantListPanel.add(dto);
        }
    }

    /**
     * Refresh restaurant list.
     */
    private void refreshRestaurantList() {
       
        rpcService.getRestaurants(new AsyncCallback<RestaurantsOnPortalDto>() {
            @Override
            public void onFailure(Throwable caught) {
                caught.printStackTrace();
                GWT.log("presentation.client.RestGWT::onModuleLoad()::rpcService.getRestaurants");
                GWT.log("-- Throwable: '" + caught.getClass().getName() + "'");
                Window.alert("ERROR: Cannot list restaurants: " + caught.getMessage());
            }

            @Override
            public void onSuccess(RestaurantsOnPortalDto result) {
                listRestaurants(result);
            }
        });
    }

    /**
     * Show page.
     *
     */
    public void showPage() {
        RootPanel divRestaurants = RootPanel.get("restaurants");
        divRestaurants.add(restaurantListPanel);
        refreshRestaurantList();
    }
}

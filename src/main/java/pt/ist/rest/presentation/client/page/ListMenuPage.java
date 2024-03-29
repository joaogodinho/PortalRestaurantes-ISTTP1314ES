package pt.ist.rest.presentation.client.page;

import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.presentation.client.panel.MenuListPanel;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.RestaurantMenuDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ListMenuPage.
 */
public class ListMenuPage extends Composite {
    
    /**
     * The menu list panel.
     */
    private final MenuListPanel menuListPanel;
    
    /**
     * The rpc service.
     */
    private RestServletAsync rpcService;
    
    /**
     * The selected restaurant.
     */
    private SimpleRestaurantDto selectedRestaurant;
    
    /**
     * The old menu.
     */
    private RestaurantMenuDto oldMenu;
    
    /**
     * Instantiates a new list menu page.
     *
     * @param rootPage the root page
     * @param rpcService the rpc service
     */
    public ListMenuPage(final RestGWT rootPage, final RestServletAsync rpcService) {
        this.rpcService = rpcService;
        menuListPanel = new MenuListPanel(rpcService, rootPage);
    }
    
    /**
     * Gets the selected restaurant.
     *
     * @return the selected restaurant
     */
    public SimpleRestaurantDto getSelectedRestaurant() {
        return selectedRestaurant;
    }
    
    /**
     * Sets the selected restaurant.
     *
     * @param restaurantDto the new selected restaurant
     */
    public void setSelectedRestaurant(SimpleRestaurantDto restaurantDto) {
        selectedRestaurant = restaurantDto;
    }
    
    /**
     * List menu.
     *
     * @param result the result
     */
    public final void listMenu(RestaurantMenuDto result) {
        menuListPanel.clearMenuList();
        for (PlateDto plate : result.getAvailablePlates()) {
            menuListPanel.add(plate);
        }
        hideIDColumn();
        oldMenu = result;
    }
    
    /**
     * Refresh menu list.
     */
    private void refreshMenuList() {
        rpcService.getMenu(selectedRestaurant, new AsyncCallback<RestaurantMenuDto>() {
            @Override
            public void onSuccess(RestaurantMenuDto result) {
                listMenu(result);
            }
            
            @Override
            public void onFailure(Throwable caught) {
                caught.printStackTrace();
                GWT.log("presentation.client.RestGWT::onModuleLoad()::rpcService.getMenu");
                GWT.log("-- Throwable: '" + caught.getClass().getName() + "'");
                Window.alert("ERROR: Cannot list menu: " + caught.getMessage());
            }
        });
    }
    
    /**
     * Show page.
     */
    public void showPage() {
        RootPanel divRestaurantMenu = RootPanel.get("restaurantMenu");
        divRestaurantMenu.add(menuListPanel);
        refreshMenuList();
    }
    
    /**
     * Hide id column.
     */
    private void hideIDColumn() {
        for (int i = 0; i < menuListPanel.getRowCount(); i++) {
            final int colId = 6;
            menuListPanel.getCellFormatter().setVisible(i, colId, false);
        }
    }

    /**
     * Refresh.
     */
    public void refresh() {
        listMenu(oldMenu);
    }
}

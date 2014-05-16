package pt.ist.rest.presentation.server;

import static pt.ist.rest.Utilities.Constants.IVA_INCREMENT;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import pt.ist.chequerefeicao.local.ChequeRefeicaoLocal;
import pt.ist.chequerefeicao.remote.ChequeRefeicaoClient;
import pt.ist.registofatura.local.RegistoFaturaLocal;
import pt.ist.registofatura.remote.RegistoFaturaClient;
import pt.ist.rest.DatabaseBootstrap;
import pt.ist.rest.invoiceregistry.InvoiceRegistry;
import pt.ist.rest.invoiceregistry.exception.InvoiceRegistryException;
import pt.ist.rest.mealcheck.MealCheck;
import pt.ist.rest.mealcheck.exception.CheckAlreadyUsedException;
import pt.ist.rest.mealcheck.exception.CheckNotExistsException;
import pt.ist.rest.mealcheck.exception.InvalidCheckException;
import pt.ist.rest.mealcheck.exception.UserNotFoundException;
import pt.ist.rest.presentation.client.RestServlet;
import pt.ist.rest.service.AddPlateToClientCartService;
import pt.ist.rest.service.CloseClientCartService;
import pt.ist.rest.service.GetPortalFaturaInfoService;
import pt.ist.rest.service.ListMenuService;
import pt.ist.rest.service.ListRestaurantsService;
import pt.ist.rest.service.LoginClientService;
import pt.ist.rest.service.SearchPlateByNameService;
import pt.ist.rest.service.SearchPlateByTypeService;
import pt.ist.rest.service.SearchPlateService;
import pt.ist.rest.service.UpdateClientCreditService;
import pt.ist.rest.service.UserCartService;
import pt.ist.rest.service.VerifyPlateOnCartService;
import pt.ist.rest.service.dto.FaturaDto;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.PlateQuantityDto;
import pt.ist.rest.service.dto.RestaurantMenuDto;
import pt.ist.rest.service.dto.RestaurantPortalDto;
import pt.ist.rest.service.dto.RestaurantsOnPortalDto;
import pt.ist.rest.service.dto.SearchPlatesDto;
import pt.ist.rest.service.dto.ShoppingCartDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.dto.UserDto;
import pt.ist.rest.service.exception.ServiceException;
import pt.registofatura.ws.Fatura;
import pt.registofatura.ws.ItemFatura;
import pt.registofatura.ws.Serie;
import ws.security.context.ActualContext;
import ws.security.context.exceptions.UserKeysNotFoundException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class RestServletImpl extends
        RemoteServiceServlet
        implements RestServlet {

    /**
     * Todays date.
     * 
     * @return the XML gregorian calendar
     */
    private static XMLGregorianCalendar todaysDate() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date());
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (DatatypeConfigurationException e) {
            System.out.println("Error: todaysDate()");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * The invoice registry.
     */
    private InvoiceRegistry invoiceRegistry = new InvoiceRegistry(new RegistoFaturaLocal());

    /**
     * The meal check.
     */
    private MealCheck mealCheck;

    {
        if ("y".equals(System.getProperty("remote", "n"))) {
            String uddiURL = System.getProperty("uddiurl", "http://localhost:8081");
            
            String nameCR = System.getProperty("chequerefeicaoname", "ChequeRefeicao");
            ChequeRefeicaoClient clientCR = new ChequeRefeicaoClient(uddiURL, nameCR);
            this.mealCheck = new MealCheck(clientCR);
            try {
                ActualContext.getInstance().setSendToUser(nameCR);
            } catch (UserKeysNotFoundException e) {
                System.out.println("Failed to get server keys");
            }

            String nameRF = System.getProperty("registofaturaname", "registofatura");
            RegistoFaturaClient clientRF = new RegistoFaturaClient(uddiURL, nameRF);
            this.invoiceRegistry = new InvoiceRegistry(clientRF);
        } else {
            this.mealCheck = new MealCheck(new ChequeRefeicaoLocal());
            invoiceRegistry = new InvoiceRegistry(new RegistoFaturaLocal());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.presentation.client.RestServlet#addPlateToCart(pt.ist.rest
     * .service. dto.SimpleClientDto, pt.ist.rest.service.dto.PlateDto, int)
     */
    @Override
    public void addPlateToCart(SimpleClientDto client, PlateDto plate, int quant) throws ServiceException {
        AddPlateToClientCartService addService = new AddPlateToClientCartService(client, plate,
                quant);
        addService.execute();
    }

    // /**
    // * Escape an html string. Escaping data received from the client helps to
    // prevent
    // * cross-site script vulnerabilities.
    // *
    // * @param html the html string to escape
    // * @return the escaped string
    // */
    // private String escapeHtml(String html) {
    // if (html == null) {
    // return null;
    // }
    // return html.replaceAll("&", "&amp;").replaceAll("<",
    // "&lt;").replaceAll(">", "&gt;");
    // }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.presentation.client.RestServlet#confirmCart(pt.ist.rest.service
     * .dto .SimpleClientDto, java.util.List)
     */
    @Override
    public FaturaDto confirmCart(SimpleClientDto clientDto, List<String> checks) throws InvalidCheckException,
            CheckAlreadyUsedException,
            CheckNotExistsException,
            UserNotFoundException,
            ServiceException,
            InvoiceRegistryException {
        // TODO Trocar para ChequeRefeicao remoto
        double sum = mealCheck.sacar(clientDto.getUsername(), checks);

        (new UpdateClientCreditService(clientDto, sum)).execute();

        UserCartService cartService = new UserCartService(clientDto);
        cartService.execute();
        ShoppingCartDto cart = cartService.getResult();

        FaturaDto fatura = invoiceRegistry(clientDto, cart.getPlateQuantities());

        (new CloseClientCartService(clientDto)).execute();

        return fatura;
    }

    /**
     * Generate data.
     * 
     * @param data the data
     * @return the string
     */
    public String generateData(XMLGregorianCalendar data) {
        return String.format("%02d:%02d:%02d %02d/%02d/%04d", data.getHour(), data.getMinute(),
                data.getSecond(), data.getDay(), data.getMonth(), data.getYear());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.presentation.client.RestServlet#getMenu(pt.ist.rest.service
     * .dto. SimpleRestaurantDto)
     */
    @Override
    public RestaurantMenuDto getMenu(SimpleRestaurantDto restaurant) throws ServiceException {
        RestaurantMenuDto result = null;
        ListMenuService menu = new ListMenuService(restaurant);
        menu.execute();
        result = menu.getResult();
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.presentation.client.RestServlet#getOpenCart(pt.ist.rest.service
     * .dto .SimpleClientDto)
     */
    @Override
    public ShoppingCartDto getOpenCart(SimpleClientDto clientDto) throws ServiceException {
        UserCartService userCart = new UserCartService(clientDto);
        userCart.execute();
        ShoppingCartDto cart = userCart.getResult();

        return cart;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.presentation.client.RestServlet#getRestaurants()
     */
    @Override
    public RestaurantsOnPortalDto getRestaurants() throws ServiceException {
        RestaurantsOnPortalDto restaurantsOnPortalDto = null;
        ListRestaurantsService listRestaurantsService = new ListRestaurantsService();

        listRestaurantsService.execute();
        restaurantsOnPortalDto = listRestaurantsService.getResult();

        if (restaurantsOnPortalDto == null) {
            System.out.println("The restaurant Dto is null!");
        }
        return restaurantsOnPortalDto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.presentation.client.RestServlet#initServer()
     */
    @Override
    public void initServer() {
        DatabaseBootstrap.init();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.presentation.client.RestServlet#invoiceRegistry(pt.ist.rest
     * .service.dto.SimpleClientDto, java.util.List)
     */
    /**
     * Invoice registry.
     * 
     * @param clientDto the client dto
     * @param itens the itens
     * @return the fatura dto
     * @throws InvoiceRegistryException the invoice registry exception
     */
    public FaturaDto invoiceRegistry(SimpleClientDto clientDto, List<PlateQuantityDto> itens) throws InvoiceRegistryException {
        // TODO Trocar para ChequeRefeicao remoto
        GetPortalFaturaInfoService infoService = new GetPortalFaturaInfoService();

        try {
            infoService.execute();
        } catch (ServiceException e1) {
            e1.printStackTrace();
        }

        RestaurantPortalDto portal = infoService.getResult();

        Fatura fatura = new Fatura();
        FaturaDto ret = new FaturaDto();
        XMLGregorianCalendar today = todaysDate();
        fatura.setData(today);
        System.out.println("data da fatura: " + generateData(today));
        ret.setData(generateData(today));
        fatura.setNifCliente(clientDto.getNif());
        ret.setNifCliente(clientDto.getNif());
        fatura.setNifEmissor(portal.getNif());
        ret.setNifEmissor(portal.getNif());
        fatura.setNomeEmissor(portal.getName());
        ret.setNomeEmissor(portal.getName());
        int total = 0;
        for (PlateQuantityDto p : itens) {
            ItemFatura item = new ItemFatura();
            String descricao = p.getPlateDto().getName();
            item.setDescricao(descricao);
            int preco = (int) p.getPlateDto().getPrice() * p.getQuantity();
            item.setPreco(preco);
            int quantidade = p.getQuantity();
            item.setQuantidade(quantidade);
            ret.addItem(descricao, preco, quantidade);
            total += preco;
        }
        System.out.println("iva inc: " + IVA_INCREMENT + " iva: " + (total * IVA_INCREMENT));
        int iva = (int) (total * IVA_INCREMENT);
        fatura.setIva(iva);
        ret.setIva(iva);

        fatura.setTotal(total);
        ret.setTotal(total);

        Serie serie = null;
        //FIXME nao pode pedir uma serie nova
        serie = invoiceRegistry.pedirSerie(portal.getNif());

        fatura.setNumSerie(serie.getNumSerie());
        ret.setNumSerie(serie.getNumSerie());
        fatura.setNumSeqFatura(1);
        ret.setNumSeqFatura(1);

        invoiceRegistry.comunicarFatura(fatura);

        return ret;
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.presentation.client.RestServlet#isPlateOnCart(SimpleClientDto, PlateDto)
     */
    @Override
    public Boolean isPlateOnCart(SimpleClientDto client, PlateDto plate) throws ServiceException {
        Boolean result = false;
        VerifyPlateOnCartService verify = new VerifyPlateOnCartService(client, plate);
        verify.execute();
        result = verify.getResult();
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.presentation.client.RestServlet#login(pt.ist.rest.service
     * .dto.UserDto)
     */
    @Override
    public SimpleClientDto login(UserDto person) throws ServiceException {
        LoginClientService service = new LoginClientService(person);
        service.execute();

        return service.getResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.presentation.client.RestServlet#searchPlatesByName(java.lang
     * .String)
     */
    @Override
    public SearchPlatesDto searchPlatesByName(String name) throws ServiceException {
        SearchPlatesDto result = null;
        SearchPlateService search = new SearchPlateByNameService(name);
        search.execute();
        result = search.getResult();
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.presentation.client.RestServlet#searchPlatesByType(java.lang
     * .String)
     */
    @Override
    public SearchPlatesDto searchPlatesByType(String type) throws ServiceException {
        SearchPlatesDto result = null;
        SearchPlateService search = new SearchPlateByTypeService(type);
        search.execute();
        result = search.getResult();
        return result;
    }
}

package pt.ist.rest.presentationserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pt.ist.chequerefeicao.local.ChequeRefeicaoLocal;
import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.mealcheck.MealCheck;
import pt.ist.rest.mealcheck.exception.CheckAlreadyUsedException;
import pt.ist.rest.mealcheck.exception.InvalidCheckException;
import pt.ist.rest.service.AddALikeToAPlateService;
import pt.ist.rest.service.AddPlateToClientCartService;
import pt.ist.rest.service.CloseClientCartService;
import pt.ist.rest.service.CreateNewRestaurantService;
import pt.ist.rest.service.ListMenuService;
import pt.ist.rest.service.ListRestaurantsService;
import pt.ist.rest.service.ListUsersService;
import pt.ist.rest.service.ManagerAddsNewPlateService;
import pt.ist.rest.service.UpdateClientCreditService;
import pt.ist.rest.service.UserCartService;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.PlateQuantityDto;
import pt.ist.rest.service.dto.RestaurantsOnPortalDto;
import pt.ist.rest.service.dto.ShoppingCartDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimplePlateDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.dto.UserDto;
import pt.ist.rest.service.exception.ServiceException;
import pt.ist.rest.service.exception.UnknownUserException;
import pt.ist.rest.service.exception.UserException;

/**
 * The Class PresentationServer.
 */
public final class PresentationServer {

    /**
     * 
     */
    private PresentationServer() {
    }

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
        FenixFramework.initialize(new Config() {
            {
                dbUsername = "rest";
                dbPassword = "r3st";
                dbAlias = "//localhost:3306/restdb";
                domainModelPath = "src/main/dml/rest.dml";
                rootClass = RestaurantPortal.class;

            }
        });

        System.out.println("\nPresentation Point 1");
        presentationPoint01();
        System.out.println("\nPresentation Point 2");
        presentationPoint02();
        System.out.println("\nPresentation Point 3");
        presentationPoint03();
        System.out.println("\nPresentation Point 4");
        presentationPoint04();
        System.out.println("\nPresentation Point 5");
        presentationPoint05();
        System.out.println("\nPresentation Point 6");
        presentationPoint06();
        System.out.println("\nPresentation Point 7");
        presentationPoint07();
        System.out.println("\nPresentation Point 8");
        presentationPoint08();
        System.out.println("\nPresentation Point 9");
        presentationPoint09();
        System.out.println("\nPresentation Point 10");
        presentationPoint10();
        System.out.println("\nPresentation Point 11");
        presentationPoint11();
        System.out.println("\nChequeRefeicaoLocal");
        chequeRefeicaoLocal();
    }

    /**
     * Cheque refeicao local.
     */
    private static void chequeRefeicaoLocal() {
        Random rand = new Random();
        MealCheck check = new MealCheck(new ChequeRefeicaoLocal());
        ListUsersService listUsers = new ListUsersService();
        UserCartService cartService;
        SimpleClientDto client;
        ShoppingCartDto shoppingCart;
        List<String> checks = new ArrayList<String>();

        try {
            listUsers.execute();
            client = listUsers.getClientByUsername("zeze");
            cartService = new UserCartService(client);
            cartService.execute();
            shoppingCart = cartService.getResult();
        } catch (ServiceException e1) {
            System.err.println(e1.getMessage());
            return;
        }
        // Generate random checks
        System.out.println("A gerar cheques ...");
        for (int i = 0; i < shoppingCart.getPlateQuantities().size(); i++) {
            checks.add(String.valueOf(rand.nextInt()));
        }

        // Incrementa o credito do cliente
        System.out.println("A actualizar o valor do saldo do cliente ...");
        try {
            int credit = check.sacar(client.getUsername(), checks);
            System.out.println("Adicionado o credito: " + credit);
            (new UpdateClientCreditService(client, credit)).execute();
        } catch (InvalidCheckException | CheckAlreadyUsedException | ServiceException e) {
            System.err.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        // Fecha o carrinho
        System.out.println("A realizar a encomenda ...");
        try {
            (new CloseClientCartService(client)).execute();
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.println("Encomenda realizada com sucesso.");

//        System.out.println("<<REGISTO FATURA>>");
    }

    /**
     * Presentation point01.
     * 
     * @throws ServiceException
     */
    private static void presentationPoint01() {
        ListUsersService listUsers = new ListUsersService();
        try {
            listUsers.execute();
        } catch (ServiceException e) {
            System.out.println("Nao foi possivel recolher os Utilizadores: " + e.getMessage());
            return;
        }
        SimpleManagerDto managerDto;
        try {
            managerDto = listUsers.getManagerByUsername("pp");
        } catch (ServiceException e) {
            System.out.println("Nao foi possivel recolher o Gestor: " + e.getMessage());
            return;
        }

        SimpleRestaurantDto restaurantDto = new SimpleRestaurantDto("Barriga Cheia",
                "Porto, Portugal");
        CreateNewRestaurantService createRestaurantService = new CreateNewRestaurantService(
                restaurantDto, managerDto);
        try {
            createRestaurantService.execute();
            System.out
                    .println("Restaurante com o nome " + restaurantDto.getName() + " foi criado.");
        } catch (ServiceException e) {
            System.out.println("Nao foi possivel criar o restaurante: " + e.getMessage());
            return;
        }
    }

    /**
     * Presentation point02.
     * 
     * @throws ServiceException
     */
    private static void presentationPoint02() {
        try {
            ListUsersService userList = new ListUsersService();
            userList.execute();

            if (userList.getResult().getUsers().isEmpty()) {
                System.out.println("Nao foram encontrados utilizadores");
                return;
            }
            for (UserDto user : userList.getResult().getUsers()) {
                System.out.println(user.toString());
            }
        } catch (ServiceException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        }
    }

    /**
     * Presentation point03.
     * 
     * @throws ServiceException
     */
    private static void presentationPoint03() {
        try {
            ListRestaurantsService restaurantList = new ListRestaurantsService();
            restaurantList.execute();

            if (restaurantList.getResult().getRestaurants().isEmpty()) {
                System.out.println("Nao foram encontrados Restaurantes.");
                return;
            }
            for (SimpleRestaurantDto r : restaurantList.getResult().getRestaurants()) {
                System.out.printf("Restaurante [%s]\n", r.toString());

                try {
                    ListMenuService menuList = new ListMenuService(r);
                    menuList.execute();

                    if (menuList.getResult().getAvailablePlates().isEmpty()) {
                        System.out.println("\tNao foram encontrados Pratos.");
                        break;
                    }
                    for (SimplePlateDto plate : menuList.getResult().getAvailablePlates()) {
                        System.out.printf("\tPrato: %s\n", plate.toString());
                    }
                } catch (ServiceException e) {
                    System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
                }
            }
        } catch (ServiceException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        }
    }

    /**
     * Presentation point04.
     * 
     * @throws ServiceException
     */
    private static void presentationPoint04() {
        /* Presentation Point 04 */
        ListUsersService listUsers = new ListUsersService();
        try {
            listUsers.execute();
        } catch (ServiceException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
            return;
        }

        SimpleManagerDto managerDto;
        try {
            managerDto = listUsers.getManagerByUsername("pp");
        } catch (UnknownUserException e) {
            System.out.println("Nao foi encontrado o Gestor: " + e.getMessage());
            return;
        }

        SimpleRestaurantDto restaurantDto;
        try {
            ListRestaurantsService listRestaurants = new ListRestaurantsService();
            listRestaurants.execute();
            restaurantDto = listRestaurants.getRestaurantByName("Barriga Cheia");
        } catch (ServiceException e) {
            System.out.println("Nao foi encontrado o restaurante: " + e.getMessage());
            return;
        }

        try {
            ManagerAddsNewPlateService addPlateService = new ManagerAddsNewPlateService(
                    new PlateDto("Bitoque", "Carne", 0, 0, restaurantDto), managerDto);
            addPlateService.execute();
            System.out.println("O prato foi adicionado.");
        } catch (ServiceException e) {
            System.out.println("Nao foi possivel adicionar o prato: " + e.getMessage());
            return;
        }
    }

    /**
     * Presentation point05.
     * 
     * @throws ServiceException
     */
    private static void presentationPoint05() {
        /* Presentation Point 05 */
        try {
            ListRestaurantsService listRestaurants = new ListRestaurantsService();
            listRestaurants.execute();
            RestaurantsOnPortalDto restaurants = listRestaurants.getResult();
            if (restaurants.getRestaurants().isEmpty()) {
                System.out.println("Nao existe restaurantes com classificacoes validas.");
                return;
            }
            for (SimpleRestaurantDto r : restaurants.getRestaurants()) {
                System.out.printf("Restaurante %s = %f%n", r.getName(), r.getClassification());
            }
        } catch (ServiceException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        }
    }

    /**
     * Presentation point06.
     * 
     * @throws ServiceException
     */
    private static void presentationPoint06() {
        try {
            ListRestaurantsService listRestaurants = new ListRestaurantsService();
            listRestaurants.execute();
            SimpleRestaurantDto restaurantDto = listRestaurants
                    .getRestaurantByName("Barriga Feliz");

            ListMenuService listMenu = new ListMenuService(restaurantDto);
            listMenu.execute();
            PlateDto canja = listMenu.getPlateByName("Canja de Galinha");
            PlateDto bacalhau = listMenu.getPlateByName("Bacalhau com batatas");

            ListUsersService listUsers = new ListUsersService();
            listUsers.execute();
            SimpleClientDto client = listUsers.getClientByUsername("zeze");
            AddALikeToAPlateService addLike;
            try {
                PlateDto bitoque = listMenu.getPlateByName("Bitoque");
                addLike = new AddALikeToAPlateService(bitoque, client);
                addLike.execute();
                System.out.println("O Cliente com o nome " + client.getName()
                        + " gostou do prato com o nome " + bitoque.getName() + " com sucesso");
            } catch (ServiceException e) {
                System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
            }
            try {
                addLike = new AddALikeToAPlateService(canja, client);
                addLike.execute();
                System.out.println("O Cliente com o nome " + client.getName()
                        + " gostou do prato com o nome " + canja.getName() + " com sucesso");
            } catch (ServiceException e) {
                System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
            }
            try {
                addLike = new AddALikeToAPlateService(bacalhau, client);
                addLike.execute();
                System.out.println("O Cliente com o nome " + client.getName()
                        + " gostou do prato com o nome " + bacalhau.getName() + " com sucesso");
            } catch (ServiceException e) {
                System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
            }
        } catch (ServiceException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        }
    }

    /**
     * Presentation point07.
     * 
     * @throws ServiceException
     */
    private static void presentationPoint07() {
        try {
            ListRestaurantsService listRestaurants = new ListRestaurantsService();
            listRestaurants.execute();
            SimpleRestaurantDto restaurantDto = listRestaurants
                    .getRestaurantByName("Barriga Feliz");

            ListMenuService listMenu = new ListMenuService(restaurantDto);
            listMenu.execute();
            PlateDto canja = listMenu.getPlateByName("Canja de Galinha");

            ListUsersService listUsers = new ListUsersService();
            listUsers.execute();
            SimpleClientDto client = listUsers.getClientByUsername("mariazinha");

            AddALikeToAPlateService addLike = new AddALikeToAPlateService(canja, client);
            addLike.execute();
            System.out.println("O Cliente com o nome " + client.getName()
                    + " gostou do prato com o nome " + canja.getName() + " com sucesso");
        } catch (UnknownUserException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        } catch (ServiceException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        }
    }

    /**
     * Presentation point08.
     * 
     * @throws ServiceException
     */
    private static void presentationPoint08() {
        presentationPoint05();
    }

    private static void presentationPoint09() {
        try {
            ListRestaurantsService listRestaurants = new ListRestaurantsService();
            listRestaurants.execute();
            SimpleRestaurantDto restaurantDto = listRestaurants
                    .getRestaurantByName("Barriga Feliz");

            ListMenuService listMenu = new ListMenuService(restaurantDto);
            listMenu.execute();
            PlateDto canja = listMenu.getPlateByName("Canja de Galinha");

            ListUsersService listUsers = new ListUsersService();
            listUsers.execute();
            SimpleClientDto client = listUsers.getClientByUsername("zeze");

            final int quantity = 3;

            AddPlateToClientCartService addPlate = new AddPlateToClientCartService(client, canja,
                    quantity);
            addPlate.execute();
            System.out.println("O Cliente com o nome " + client.getName()
                    + " adicionou o prato com o nome " + canja.getName()
                    + " ao tabuleiro com sucesso");
        } catch (UnknownUserException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        } catch (ServiceException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        }
    }

    private static void presentationPoint10() {
        try {
            ListRestaurantsService listRestaurants = new ListRestaurantsService();
            listRestaurants.execute();
            SimpleRestaurantDto restaurantDto = listRestaurants
                    .getRestaurantByName("Barriga Feliz");

            ListMenuService listMenu = new ListMenuService(restaurantDto);
            listMenu.execute();
            PlateDto bacalhau = listMenu.getPlateByName("Bacalhau com batatas");

            ListUsersService listUsers = new ListUsersService();
            listUsers.execute();
            SimpleClientDto client = listUsers.getClientByUsername("zeze");

            AddPlateToClientCartService addPlate = new AddPlateToClientCartService(client,
                    bacalhau, 2);
            addPlate.execute();
            System.out.println("O Cliente com o nome " + client.getName()
                    + " adicionou o prato com o nome " + bacalhau.getName()
                    + " ao tabuleiro com sucesso");
        } catch (UnknownUserException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        } catch (ServiceException e) {
            System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
        }
    }

    private static void presentationPoint11() {
        ListUsersService listUsers = new ListUsersService();
        try {
            listUsers.execute();
        } catch (ServiceException e) {
            System.out
                    .println("Nao conseguiu ir buscar a lista de utilizadores: " + e.getMessage());
        }

        String[] names = { "zeze", "mariazinha" };

        for (String name : names) {
            try {
                SimpleClientDto client = listUsers.getClientByUsername(name);
                UserCartService userCart = new UserCartService(client);
                userCart.execute();
                System.out.printf("Tabuleiro do Utilizador %s:%n", client.getUsername());
                for (PlateQuantityDto plateQuantity : userCart.getResult().getPlateQuantities()) {
                    System.out.printf("\tPrato: %s | Quantity: %d%n", plateQuantity.getPlateDto()
                            .getName(), plateQuantity.getQuantity());
                }
            } catch (UnknownUserException e) {
                System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
            } catch (UserException e) {
                System.out.println(e.getMessage());
            } catch (ServiceException e) {
                System.out.println("Excepcao de Servico Apanhada: " + e.getMessage());
            }
        }
    }
}

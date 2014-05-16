package pt.ist.rest;

import pt.ist.rest.Utilities.Constants;
import pt.ist.rest.Utilities.FoodType;
import pt.ist.rest.service.AddNewFoodToPlateService;
import pt.ist.rest.service.CreateNewClientService;
import pt.ist.rest.service.CreateNewManagerService;
import pt.ist.rest.service.CreateNewRestaurantService;
import pt.ist.rest.service.ManagerAddsNewPlateService;
import pt.ist.rest.service.SetPortalMaxPriceService;
import pt.ist.rest.service.SetPortalNameService;
import pt.ist.rest.service.SetPortalNifService;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleFoodDto;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * Adds default information to database.
 */
public final class RestSetup {

    /**
     * Instantiates a new rest setup.
     */
    private RestSetup() {

    }

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
        DatabaseBootstrap.init();
        populateDomain();
    }

    /**
     * Populate domain.
     */
    public static void populateDomain() {
        try {

            (new SetPortalNameService("PortalRest")).execute();
            final int portalNif = 1234;
            (new SetPortalNifService(portalNif)).execute();

            final int maxPrice = 7;
            (new SetPortalMaxPriceService(maxPrice)).execute();

            SimpleManagerDto passosLebre = new SimpleManagerDto("mng", "mn8", "Passos Lebre");
            new CreateNewManagerService(passosLebre).execute();

            SimpleManagerDto pauloPortao = new SimpleManagerDto("pp", "pp", "Paulo Port\u00E3o");
            new CreateNewManagerService(pauloPortao).execute();

            final int nif = 1111;
            SimpleClientDto zeNinguem = new SimpleClientDto("zeze", "z3z3", "Z\u00E9 ningu\u00E9m",
                    "ze.ninguem@ist.utl.pt", "Lisboa, Portugal", nif);
            new CreateNewClientService(zeNinguem).execute();

            final int nif2 = 2222;
            SimpleClientDto maria = new SimpleClientDto("mariazinha", "****", "Maria Silva",
                    "silva@ist.utl.pt", "Porto, Portugal", nif2);
            new CreateNewClientService(maria).execute();

            final int nif3 = 1001;
            SimpleClientDto alice = new SimpleClientDto("alice", "aaa", "Alice Alves",
                    "alice.alves@sonet.pt", "Aveiro, Portugal", nif3);
            new CreateNewClientService(alice).execute();

            final int nif4 = 1002;
            SimpleClientDto bruno = new SimpleClientDto("bruno", "bbb", "Bruno Bento",
                    "bruno.bento@sonet.pt", "Beja, Portugal", nif4);
            new CreateNewClientService(bruno).execute();

            final int nif5 = 1003;
            SimpleClientDto carlos = new SimpleClientDto("carlos", "ccc", "Carlos Calado",
                    "carlos.calado@sonet.pt", "Coimbra, Portugal", nif5);
            new CreateNewClientService(carlos).execute();

            SimpleRestaurantDto barrigaCheia = new SimpleRestaurantDto("Barriga Cheia",
                    "Lisboa, Portugal");
            new CreateNewRestaurantService(barrigaCheia, passosLebre).execute();

            SimpleRestaurantDto barrigaFeliz = new SimpleRestaurantDto("Barriga Feliz",
                    "Lisboa, Portugal");
            new CreateNewRestaurantService(barrigaFeliz, pauloPortao).execute();

            // Adding plates
            PlateDto bacalhauComBatatas = new PlateDto("Bacalhau com batatas", 0.0,
                    Constants.DEFAULT_PRICE, barrigaCheia);
            new ManagerAddsNewPlateService(bacalhauComBatatas, passosLebre).execute();

            PlateDto bacalhauComBatatasBarrigaFeliz = new PlateDto("Bacalhau com batatas", "Peixe",
                    0.0, Constants.DEFAULT_PRICE, barrigaFeliz);
            new ManagerAddsNewPlateService(bacalhauComBatatasBarrigaFeliz, pauloPortao).execute();

            PlateDto bitoque = new PlateDto("Bitoque", "Carne", 0.0, Constants.DEFAULT_PRICE,
                    barrigaFeliz);
            new ManagerAddsNewPlateService(bitoque, pauloPortao).execute();

            PlateDto canjaDeGalinha = new PlateDto("Canja de Galinha", "Carne", 0.0,
                    Constants.DEFAULT_PRICE, barrigaFeliz);
            new ManagerAddsNewPlateService(canjaDeGalinha, pauloPortao).execute();

            //Adding foods
            SimpleFoodDto bacalhau = new SimpleFoodDto("Bacalhau", FoodType.Peixe);
            new AddNewFoodToPlateService(bacalhau, bacalhauComBatatas).execute();
            new AddNewFoodToPlateService(bacalhau, bacalhauComBatatasBarrigaFeliz).execute();
            
            SimpleFoodDto batata = new SimpleFoodDto("Batata", FoodType.Vegetariano);
            new AddNewFoodToPlateService(batata, bacalhauComBatatas).execute();
            new AddNewFoodToPlateService(batata, bacalhauComBatatasBarrigaFeliz).execute();

            SimpleFoodDto bife = new SimpleFoodDto("Bife", FoodType.Carne);
            new AddNewFoodToPlateService(bife, bitoque).execute();
            
            SimpleFoodDto galinha = new SimpleFoodDto("Galinha", FoodType.Carne);
            new AddNewFoodToPlateService(galinha, canjaDeGalinha).execute();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e);
        }
    }
}

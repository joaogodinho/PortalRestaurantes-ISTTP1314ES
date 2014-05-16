package pt.ist.rest;

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.RestaurantPortal;

/**
 * The Class DatabaseBootstrap.
 */
public final class DatabaseBootstrap {
    
    /**
     * The notInitialized.
     */
    private static boolean notInitialized = true;
    
    private DatabaseBootstrap() { }
    
    /**
     * Inits the database connection.
     */
    public static synchronized void init() {
        if (notInitialized) {
            FenixFramework.initialize(new Config() {
                {
                    domainModelPath = "src/main/dml/rest.dml";
                    dbAlias = "//localhost:3306/restdb";
                    dbUsername = "rest";
                    dbPassword = "r3st";
                    rootClass = RestaurantPortal.class;
                }
            });
        }

        notInitialized = false;
    }

    /**
     * Setup.
     */
    public static void setup() {
        try {
            pt.ist.rest.RestSetup.populateDomain();
        } catch (pt.ist.rest.domain.exception.RestException ex) {
            System.out.println("Error while populating rest application: " + ex);
        }
    }
}

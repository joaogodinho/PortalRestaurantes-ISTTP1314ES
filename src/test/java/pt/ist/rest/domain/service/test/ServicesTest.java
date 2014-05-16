package pt.ist.rest.domain.service.test;

import static org.junit.Assert.assertNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Assert;
import org.junit.Test;

import pt.ist.chequerefeicao.local.ChequeRefeicaoLocal;
import pt.ist.registofatura.local.RegistoFaturaLocal;
import pt.ist.rest.invoiceregistry.InvoiceRegistry;
import pt.ist.rest.mealcheck.MealCheck;
import pt.ist.rest.mealcheck.exception.InvalidCheckException;
import pt.ist.rest.presentation.server.RestServletImpl;
import pt.ist.rest.service.dto.FaturaDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.registofatura.ws.Fatura;
import pt.registofatura.ws.Serie;

/**
 * The Class RegistoFaturaTest.
 */
public class ServicesTest {

    /** The Constant RESTAURANT_NAME. */
    private static final String CLIENT_USERNAME = "zeze";
    
    /**
     * The Constant CLIENT_PASSWORD.
     */
    private static final String CLIENT_PASSWORD = "z3z3";
    
    /**
     * The Constant CLIENT_NAME.
     */
    private static final String CLIENT_NAME = "Z\u00E9 ningu\u00E9m";
    
    /**
     * The Constant CLIENT_EMAIL.
     */
    private static final String CLIENT_EMAIL = "ze.ninguem@ist.utl.pt";
    
    /**
     * The Constant CLIENT_ADRESS.
     */
    private static final String CLIENT_ADRESS = "Lisboa, Portugal";
    
    /**
     * The Constant CLIENT_NIF.
     */
    private static final int CLIENT_NIF = 1111;

    /**
     * The invoice registry.
     */
    @Mocked
    private InvoiceRegistry invoiceRegistry = new InvoiceRegistry(new RegistoFaturaLocal());

    /**
     * The meal check.
     */
    @Mocked
    private MealCheck mealCheck = new MealCheck(new ChequeRefeicaoLocal());

    /**
     * Pagar compra test.
     *
     * @throws Exception the exception
     */
    @Test
    public void pagarCompraTest() throws Exception {
        RestServletImpl restServlet = new RestServletImpl();
        final List<String> checks = new ArrayList<String>();
//        final Fatura fatura = new Fatura();
        final SimpleClientDto clientDto = new SimpleClientDto(CLIENT_USERNAME, CLIENT_PASSWORD,
                CLIENT_NAME, CLIENT_EMAIL, CLIENT_ADRESS, CLIENT_NIF);

        new Expectations() {
            {
                mealCheck.sacar(CLIENT_USERNAME, checks);
                result = new InvalidCheckException();
//                invoiceRegistry.comunicarFatura(fatura);
//                result = new TotaisIncoerentes_Exception("Os totais sao incoerentes",
//                        new TotaisIncoerentes());
            }
        };

        FaturaDto factura = null;
        try {
            factura = restServlet.confirmCart(clientDto, checks);
            Assert.fail();
        } catch (InvalidCheckException e) {
            assertNull(factura);
        }
    }
    
    /**
     * Registo fatura test.
     *
     * @throws Exception the exception
     */
    @Test
    public void registoFaturaTest() throws Exception {
        RestServletImpl restServlet = new RestServletImpl();
        final List<String> checks = new ArrayList<String>();
        final Fatura fatura = new Fatura();
        final SimpleClientDto clientDto = new SimpleClientDto(CLIENT_USERNAME, CLIENT_PASSWORD,
                CLIENT_NAME, CLIENT_EMAIL, CLIENT_ADRESS, CLIENT_NIF);

        new Expectations() {
            {
                //TODO falta fazer a fatura
                invoiceRegistry.pedirSerie(1234);
                result = new Serie();
                invoiceRegistry.comunicarFatura((Fatura)any);
                result = null;
            }
        };

        FaturaDto factura = null;
        try {
            factura = restServlet.confirmCart(clientDto, checks);
            //TODO falta fazer os testes a fatura
        } catch (Exception e) {
            Assert.fail();
        }
    }
}

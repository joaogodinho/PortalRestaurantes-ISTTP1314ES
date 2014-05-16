package pt.ist.registofatura.remote;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import pt.ist.rest.invoiceregistry.InvoiceRegistryImplementor;
import pt.ist.rest.invoiceregistry.exception.InvoiceRegistryException;
import pt.registofatura.ws.ClienteInexistente_Exception;
import pt.registofatura.ws.EmissorInexistente_Exception;
import pt.registofatura.ws.Fatura;
import pt.registofatura.ws.FaturaInvalida_Exception;
import pt.registofatura.ws.RegistoFaturaPortType;
import pt.registofatura.ws.Serie;
import pt.registofatura.ws.TotaisIncoerentes_Exception;
import pt.registofatura.ws.cli.FrontEnd;

/**
 * The Class RegistoFaturaClient.
 */
public class RegistoFaturaClient implements InvoiceRegistryImplementor {

    /**
     * The port.
     */
    private RegistoFaturaPortType port;

    public RegistoFaturaClient(String uddiURL, String serverName) {
        if (uddiURL == null || serverName == null) {
            throw new IllegalArgumentException("Argument(s) missing!");
        }

        port = (RegistoFaturaPortType) new FrontEnd(serverName, uddiURL);
    }

    @Override
    public Serie pedirSerie(int nifEmissor) throws InvoiceRegistryException {
        try {
            return port.pedirSerie(nifEmissor);
        } catch (EmissorInexistente_Exception e) {
            throw new InvoiceRegistryException(e.getMessage());
        }
    }

    @Override
    public void comunicarFatura(Fatura fatura) throws InvoiceRegistryException {

        try {
            port.comunicarFatura(fatura);
        } catch (ClienteInexistente_Exception | EmissorInexistente_Exception
                | FaturaInvalida_Exception | TotaisIncoerentes_Exception e) {
            throw new InvoiceRegistryException(e.getMessage());
        }
    }

    @Override
    public List<Fatura> listarFacturas(Integer nifEmissor, Integer nifCliente)
            throws InvoiceRegistryException {
        try {
            return port.listarFacturas(nifEmissor, nifCliente);
        } catch (ClienteInexistente_Exception | EmissorInexistente_Exception e) {
            throw new InvoiceRegistryException(e.getMessage());
        }
    }

    @Override
    public int consultarIVADevido(int nifEmissor, XMLGregorianCalendar ano)
            throws InvoiceRegistryException {
        try {
            return port.consultarIVADevido(nifEmissor, ano);
        } catch (EmissorInexistente_Exception e) {
            throw new InvoiceRegistryException(e.getMessage());
        }
    }
}

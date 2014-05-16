package pt.ist.rest.invoiceregistry;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import pt.ist.rest.invoiceregistry.exception.InvoiceRegistryException;
import pt.registofatura.ws.Fatura;
import pt.registofatura.ws.Serie;


/**
 * The Class InvoiceRegistry.
 */
public class InvoiceRegistry {

    /**
     * The invoice registry.
     */
    private final InvoiceRegistryImplementor invoiceRegistry;

    /**
     * Instantiates a new invoice registry.
     *
     * @param invoiceRegistry the invoice registry
     */
    public InvoiceRegistry(InvoiceRegistryImplementor invoiceRegistry) {
        this.invoiceRegistry = invoiceRegistry;
    }

    /**
     * Pedir serie.
     *
     * @param nifEmissor the nif emissor
     * @return the serie
     * @throws InvoiceRegistryException the invoice registry exception
     */
    public Serie pedirSerie(int nifEmissor) throws InvoiceRegistryException {
        return invoiceRegistry.pedirSerie(nifEmissor);
    }

    /**
     * Comunicar fatura.
     *
     * @param fatura the fatura
     * @throws InvoiceRegistryException the invoice registry exception
     */
    public void comunicarFatura(Fatura fatura) throws InvoiceRegistryException {
        invoiceRegistry.comunicarFatura(fatura);
    }

    /**
     * Listar facturas.
     *
     * @param nifEmissor the nif emissor
     * @param nifCliente the nif cliente
     * @return the list
     * @throws InvoiceRegistryException the invoice registry exception
     */
    public List<Fatura> listarFacturas(Integer nifEmissor, Integer nifCliente) throws InvoiceRegistryException {
        return invoiceRegistry.listarFacturas(nifEmissor, nifCliente);
    }

    /**
     * Consultar iva devido.
     *
     * @param nifEmissor the nif emissor
     * @param ano the ano
     * @return the int
     * @throws InvoiceRegistryException the invoice registry exception
     */
    public int consultarIVADevido(int nifEmissor, XMLGregorianCalendar ano) throws InvoiceRegistryException {
        return invoiceRegistry.consultarIVADevido(nifEmissor, ano);
    }
}

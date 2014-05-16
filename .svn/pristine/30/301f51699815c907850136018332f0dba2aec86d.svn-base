package pt.ist.rest.invoiceregistry;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import pt.ist.rest.invoiceregistry.exception.InvoiceRegistryException;
import pt.registofatura.ws.Fatura;
import pt.registofatura.ws.Serie;

/**
 * The Interface InvoiceRegistryImplementor.
 */
public interface InvoiceRegistryImplementor {

    /**
     * Pedir serie.
     *
     * @param nifEmissor the nif emissor
     * @return the serie
     * @throws InvoiceRegistryException the invoice registry exception
     */
    Serie pedirSerie(int nifEmissor) throws InvoiceRegistryException;

    /**
     * Comunicar fatura.
     *
     * @param fatura the fatura
     * @throws InvoiceRegistryException the invoice registry exception
     */
    void comunicarFatura(Fatura fatura) throws InvoiceRegistryException;

    /**
     * Listar facturas.
     *
     * @param nifEmissor the nif emissor
     * @param nifCliente the nif cliente
     * @return the list
     * @throws InvoiceRegistryException the invoice registry exception
     */
    List<Fatura> listarFacturas(Integer nifEmissor, Integer nifCliente) throws InvoiceRegistryException;

    /**
     * Consultar iva devido.
     *
     * @param nifEmissor the nif emissor
     * @param ano the ano
     * @return the int
     * @throws InvoiceRegistryException the invoice registry exception
     */
    int consultarIVADevido(int nifEmissor, XMLGregorianCalendar ano) throws InvoiceRegistryException;
}

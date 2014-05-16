package pt.ist.registofatura.local;

/**
 * Esta classe é uma concretização muito simples da interface RegistoFaturaPortType.
 * Esta interface representa o serviço externo RegistoFatura.
 * Apenas se verifica se o nif do emissor é um nif registado previamente e que o número de serie
 * da fatura corresponde a uma serie já fornecida pelo serviço.
 **/

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import pt.ist.rest.invoiceregistry.InvoiceRegistryImplementor;
import pt.ist.rest.invoiceregistry.exception.InvoiceRegistryException;
import pt.registofatura.ws.EmissorInexistente_Exception;
import pt.registofatura.ws.Fatura;
import pt.registofatura.ws.FaturaInvalida_Exception;
import pt.registofatura.ws.Serie;


// TODO: Auto-generated Javadoc
/**
 * The Class RegistoFaturaLocal.
 */
public class RegistoFaturaLocal implements InvoiceRegistryImplementor {

    /**
     * The numero serie.
     */
    private int numeroSerie = 1;
    
    /**
     * The Nif emissor registado.
     */
    private int NifEmissorRegistado[] = { 1212, 1234 };

    /**
     * Instantiates a new registo fatura local.
     */
    public RegistoFaturaLocal() {
    }

    /**
     * Check valid nif emissor.
     *
     * @param nif the nif
     * @throws EmissorInexistente_Exception the emissor inexistente_ exception
     */
    private void checkValidNifEmissor(int nif)
            throws EmissorInexistente_Exception {
        for (int n : this.NifEmissorRegistado) {
            if (n == nif)
                return;
        }

        throw new EmissorInexistente_Exception("NIF do emissor inválido", null);
    }

    /**
     * Pedir serie.
     *
     * @param nifEmissor the nif emissor
     * @return returns pt.registofatura.ws.Serie
     * @throws InvoiceRegistryException the invoice registry exception
     */
    public Serie pedirSerie(int nifEmissor) throws InvoiceRegistryException {
        Serie serie;

        try {
            checkValidNifEmissor(nifEmissor);
        } catch (EmissorInexistente_Exception e) {
            throw new InvoiceRegistryException(e.getMessage());
        }
        serie = new Serie();
        serie.setNumSerie(this.numeroSerie++);
        serie.setValidoAte(null); // nao vai correr bem
        return serie;
    }

    /**
     * Listar facturas.
     *
     * @param nifEmissor the nif emissor
     * @param nifCliente the nif cliente
     * @return returns java.util.List<pt.registofatura.ws.Fatura>
     * @throws InvoiceRegistryException the invoice registry exception
     */
    public List<Fatura> listarFacturas(Integer nifEmissor, Integer nifCliente)
            throws InvoiceRegistryException {
        try {
            checkValidNifEmissor(nifEmissor);
        } catch (EmissorInexistente_Exception e) {
            throw new InvoiceRegistryException(e.getMessage());
        }
        return new ArrayList<Fatura>();
    }

    /**
     * Consultar iva devido.
     *
     * @param nifEmissor the nif emissor
     * @param ano the ano
     * @return returns int
     * @throws InvoiceRegistryException the invoice registry exception
     */
    public int consultarIVADevido(int nifEmissor, XMLGregorianCalendar ano)
            throws InvoiceRegistryException {
        try {
            checkValidNifEmissor(nifEmissor);
        } catch (EmissorInexistente_Exception e) {
            throw new InvoiceRegistryException(e.getMessage());
        }
        return 0;
    }

    // WTF! o que esta aqui a fazer um main
    // public static void main(String[] args) {
    // RegistoFaturaLocal registo = new RegistoFaturaLocal();
    //
    // Serie serie = null;
    //
    // try {
    // serie = registo.pedirSerie(0);
    // System.err.println("Erro a pedir uma serie de facturas com um nif não registado!");
    // } catch (EmissorInexistente_Exception eie) {
    // System.out.println("Verificação correcta de nif inválido em pedirSerie");
    // }
    //
    // try {
    // serie = registo.pedirSerie(1212);
    // if (serie.getNumSerie() != 1)
    // System.err.println("Erro a pedir uma serie de de facturas. Número de serie não é 1: "
    // +
    // serie.getNumSerie());
    // else
    // System.out.println("Serie emitida correctamente em pedirSerie");
    // } catch (EmissorInexistente_Exception eie) {
    // System.err.println("Erro a pedir uma serie de de facturas!");
    // System.exit(-1);
    // }
    //
    //
    // }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.invoiceregistry.InvoiceRegistryImplementor#comunicarFatura
     * (pt.ist.rest.invoiceregistry.exception.Fatura)
     */
    @Override
    public void comunicarFatura(Fatura fatura)
            throws InvoiceRegistryException {
        if (fatura.getNumSerie() >= this.numeroSerie
                || fatura.getNumSerie() <= 0)
            try {
                throw new FaturaInvalida_Exception(
                        "Número de série de fatura inválido", null);
            } catch (FaturaInvalida_Exception e) {
                throw new InvoiceRegistryException(e.getMessage());
            }
    }
}

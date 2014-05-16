
package pt.ist.registofatura.local.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RegistoFaturaPortType", targetNamespace = "urn:pt:registofatura:ws")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RegistoFaturaPortType {


    /**
     * 
     * @param nifEmissor
     * @return
     *     returns pt.registofatura.ws.Serie
     * @throws EmissorInexistente_Exception
     */
    @WebMethod
    @WebResult(name = "serie", targetNamespace = "")
    @RequestWrapper(localName = "pedirSerie", targetNamespace = "urn:pt:registofatura:ws", className = "pt.registofatura.ws.PedirSerie")
    @ResponseWrapper(localName = "pedirSerieResponse", targetNamespace = "urn:pt:registofatura:ws", className = "pt.registofatura.ws.PedirSerieResponse")
    public Serie pedirSerie(
        @WebParam(name = "nifEmissor", targetNamespace = "")
        int nifEmissor)
        throws EmissorInexistente_Exception
    ;

    /**
     * 
     * @param parameters
     * @throws FaturaInvalida_Exception
     * @throws EmissorInexistente_Exception
     * @throws TotaisIncoerentes_Exception
     * @throws ClienteInexistente_Exception
     */
    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public void comunicarFatura(
        @WebParam(name = "comunicarFatura", targetNamespace = "urn:pt:registofatura:ws", partName = "parameters")
        Fatura parameters)
        throws ClienteInexistente_Exception, EmissorInexistente_Exception, FaturaInvalida_Exception, TotaisIncoerentes_Exception
    ;

    /**
     * 
     * @param nifEmissor
     * @param nifCliente
     * @return
     *     returns java.util.List<pt.registofatura.ws.Fatura>
     * @throws EmissorInexistente_Exception
     * @throws ClienteInexistente_Exception
     */
    @WebMethod
    @WebResult(name = "fatura", targetNamespace = "")
    @RequestWrapper(localName = "listarFacturas", targetNamespace = "urn:pt:registofatura:ws", className = "pt.registofatura.ws.ListarFacturas")
    @ResponseWrapper(localName = "listarFacturasResponse", targetNamespace = "urn:pt:registofatura:ws", className = "pt.registofatura.ws.ListarFacturasResponse")
    public List<Fatura> listarFacturas(
        @WebParam(name = "nifEmissor", targetNamespace = "")
        Integer nifEmissor,
        @WebParam(name = "nifCliente", targetNamespace = "")
        Integer nifCliente)
        throws ClienteInexistente_Exception, EmissorInexistente_Exception
    ;

    /**
     * 
     * @param nifEmissor
     * @param ano
     * @return
     *     returns int
     * @throws EmissorInexistente_Exception
     */
    @WebMethod
    @WebResult(name = "ivaDevido", targetNamespace = "")
    @RequestWrapper(localName = "consultarIVADevido", targetNamespace = "urn:pt:registofatura:ws", className = "pt.registofatura.ws.ConsultarIVADevido")
    @ResponseWrapper(localName = "consultarIVADevidoResponse", targetNamespace = "urn:pt:registofatura:ws", className = "pt.registofatura.ws.ConsultarIVADevidoResponse")
    public int consultarIVADevido(
        @WebParam(name = "nifEmissor", targetNamespace = "")
        int nifEmissor,
        @WebParam(name = "ano", targetNamespace = "")
        XMLGregorianCalendar ano)
        throws EmissorInexistente_Exception
    ;

}
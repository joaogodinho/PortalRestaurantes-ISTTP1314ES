
package pt.ist.registofatura.local.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ClienteInexistente", targetNamespace = "urn:pt:registofatura:ws")
public class ClienteInexistente_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ClienteInexistente faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ClienteInexistente_Exception(String message, ClienteInexistente faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ClienteInexistente_Exception(String message, ClienteInexistente faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: pt.registofatura.ws.ClienteInexistente
     */
    public ClienteInexistente getFaultInfo() {
        return faultInfo;
    }

}

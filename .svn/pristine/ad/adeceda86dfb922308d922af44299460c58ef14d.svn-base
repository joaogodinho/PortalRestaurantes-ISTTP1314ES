package pt.ist.rest.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class FaturaDto.
 */
public class FaturaDto implements Serializable {
    
    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -4544544341579906997L;
    
    /**
     * The data.
     */
    private String data;
    
    /**
     * The itens.
     */
    private List<ItemFaturaDto> itens = new ArrayList<ItemFaturaDto>();
    
    /**
     * The iva.
     */
    private int iva;
    
    /**
     * The nif cliente.
     */
    private int nifCliente;
    
    /**
     * The nif emissor.
     */
    private int nifEmissor;
    
    /**
     * The nome emissor.
     */
    private String nomeEmissor;

    /**
     * The num seq fatura.
     */
    private int numSeqFatura;

    /**
     * The num serie.
     */
    private int numSerie;
    
    /**
     * The total.
     */
    private int total;

    /**
     * Instantiates a new fatura dto.
     */
    public FaturaDto() {
    }

    /**
     * Adds the item.
     *
     * @param descricao the descricao
     * @param preco the preco
     * @param quantidade the quantidade
     */
    public void addItem(String descricao, int preco, int quantidade) {
        ItemFaturaDto item = new ItemFaturaDto(descricao, preco, quantidade);
        itens.add(item);
    }
    
    /**
     * Gets the itens.
     *
     * @return the itens
     */
    public List<ItemFaturaDto> getItens() {
        return itens;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Gets the iva.
     *
     * @return the iva
     */
    public int getIva() {
        return iva;
    }

    /**
     * Gets the nif cliente.
     *
     * @return the nif cliente
     */
    public int getNifCliente() {
        return nifCliente;
    }

    /**
     * Gets the nif emissor.
     *
     * @return the nif emissor
     */
    public int getNifEmissor() {
        return nifEmissor;
    }

    /**
     * Gets the nome emissor.
     *
     * @return the nome emissor
     */
    public String getNomeEmissor() {
        return nomeEmissor;
    }

    /**
     * Gets the num seq fatura.
     *
     * @return the num seq fatura
     */
    public int getNumSeqFatura() {
        return numSeqFatura;
    }

    /**
     * Gets the num serie.
     *
     * @return the num serie
     */
    public int getNumSerie() {
        return numSerie;
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Sets the iva.
     *
     * @param iva the new iva
     */
    public void setIva(int iva) {
        this.iva = iva;
    }

    /**
     * Sets the nif cliente.
     *
     * @param nifCliente the new nif cliente
     */
    public void setNifCliente(int nifCliente) {
        this.nifCliente = nifCliente;
    }

    /**
     * Sets the nif emissor.
     *
     * @param nifEmissor the new nif emissor
     */
    public void setNifEmissor(int nifEmissor) {
        this.nifEmissor = nifEmissor;
    }
    
    /**
     * Sets the nome emissor.
     *
     * @param nomeEmissor the new nome emissor
     */
    public void setNomeEmissor(String nomeEmissor) {
        this.nomeEmissor = nomeEmissor;
    }
    
    /**
     * Sets the num seq fatura.
     *
     * @param numSeqFatura the new num seq fatura
     */
    public void setNumSeqFatura(int numSeqFatura) {
        this.numSeqFatura = numSeqFatura;
    }
    
    /**
     * Sets the num serie.
     *
     * @param numSerie the new num serie
     */
    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }
    
    /**
     * Sets the total.
     *
     * @param total the new total
     */
    public void setTotal(int total) {
        this.total = total;
    }
}

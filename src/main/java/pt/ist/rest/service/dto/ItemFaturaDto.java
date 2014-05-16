package pt.ist.rest.service.dto;

import java.io.Serializable;

/**
 * The Class ItemFaturaDto.
 */
public class ItemFaturaDto implements Serializable {
    private static final long serialVersionUID = -299613145098643209L;
    private String descricao;
    private int preco;
    private int quantidade;

    public ItemFaturaDto() {
    }

    public ItemFaturaDto(String descricao, int preco, int quantidade) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
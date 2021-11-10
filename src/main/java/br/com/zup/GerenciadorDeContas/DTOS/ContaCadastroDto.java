package br.com.zup.GerenciadorDeContas.DTOS;

import br.com.zup.GerenciadorDeContas.Enums.Tipo;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ContaCadastroDto {
    @NotBlank
    private String nome;
    @NotBlank
    private double valor;
    @NotBlank
    private Tipo tipo;
    @NotBlank
    private LocalDate dataDeVencimento;

    public ContaCadastroDto() {

    }

    public ContaCadastroDto(String nome, double valor, Tipo tipo, LocalDate dataDeVencimento) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.dataDeVencimento = dataDeVencimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }
}

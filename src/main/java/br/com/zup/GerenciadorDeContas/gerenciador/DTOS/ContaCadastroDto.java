package br.com.zup.GerenciadorDeContas.gerenciador.DTOS;

import br.com.zup.GerenciadorDeContas.gerenciador.Enums.Tipo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ContaCadastroDto {
    @NotBlank(message = "O nome debe ser preenchido")
    @Size(min = 2, max = 30, message = "O nome debe conter entre 2 e 30 caracteres")
    private String nome;
    @Positive(message = "O valor debe ser positivo")
    private double valor;
    @NotNull(message = "O tipo precisa ser preenchido")
    private Tipo tipo;
    @NotNull(message = "A Data de Vencimento debe ser prenchida")
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

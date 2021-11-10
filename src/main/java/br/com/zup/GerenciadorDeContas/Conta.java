package br.com.zup.GerenciadorDeContas;

import br.com.zup.GerenciadorDeContas.Enums.Status;
import br.com.zup.GerenciadorDeContas.Enums.Tipo;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double valor;
    private LocalDate dataDeVencimento;
    @Column(nullable = true)
    private LocalDateTime dataDePagamento;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Conta() {
    }

    public Conta(int id, Tipo tipo, String nome, double valor, LocalDate dataDeVencimento,
                 LocalDateTime dataDePagamento, Status status) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}

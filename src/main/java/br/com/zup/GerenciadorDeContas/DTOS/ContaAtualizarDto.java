package br.com.zup.GerenciadorDeContas.DTOS;

import br.com.zup.GerenciadorDeContas.Enums.Status;

public class ContaAtualizarDto {
    private Status status;

    public ContaAtualizarDto() {

    }

    public ContaAtualizarDto(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

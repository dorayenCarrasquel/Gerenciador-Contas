package br.com.zup.GerenciadorDeContas.DTOS;

import br.com.zup.GerenciadorDeContas.Enums.Status;

import javax.validation.constraints.NotEmpty;

public class ContaAtualizarDto {
    @NotEmpty(message = "O campo de Estatus debe ser preenchido para realizar o PAGO")
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

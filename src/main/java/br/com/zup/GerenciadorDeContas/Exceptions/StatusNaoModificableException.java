package br.com.zup.GerenciadorDeContas.Exceptions;

public class StatusNaoModificableException extends RuntimeException {
    public StatusNaoModificableException(String message) {
        super(message);
    }

}

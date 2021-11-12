package br.com.zup.GerenciadorDeContas.gerenciador.Exceptions;

public class StatusNaoModificableException extends RuntimeException {
    public StatusNaoModificableException(String message) {
        super(message);
    }

}

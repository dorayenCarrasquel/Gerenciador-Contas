package br.com.zup.GerenciadorDeContas.Exceptions;

public class ImpossivelPoisJaEstaPagoException extends RuntimeException{
    public ImpossivelPoisJaEstaPagoException(String message) {
        super(message);
    }
}

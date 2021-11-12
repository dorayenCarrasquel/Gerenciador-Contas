package br.com.zup.GerenciadorDeContas.gerenciador.Exceptions;

public class ImpossivelPoisJaEstaPagoException extends RuntimeException{
    public ImpossivelPoisJaEstaPagoException(String message) {
        super(message);
    }
}

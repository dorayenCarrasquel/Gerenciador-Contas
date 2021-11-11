package br.com.zup.GerenciadorDeContas.config;

import br.com.zup.GerenciadorDeContas.Exceptions.IdNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControladorAdvisor {

    @ExceptionHandler(IdNaoEncontradoException.class)//busqueda de um id nao registrado o deletado
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularIdNaoEncontrado(IdNaoEncontradoException exception){
        return new MensagemDeErro(exception.getMessage());
    }


}

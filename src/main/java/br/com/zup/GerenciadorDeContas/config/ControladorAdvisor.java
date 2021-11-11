package br.com.zup.GerenciadorDeContas.config;

import br.com.zup.GerenciadorDeContas.Exceptions.IdNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControladorAdvisor {

    @ExceptionHandler(IdNaoEncontradoException.class)//busqueda de um id nao registrado o deletado
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularIdNaoEncontrado(IdNaoEncontradoException exception){
        return new MensagemDeErro(exception.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularExcecoesDeValidacao(MethodArgumentNotValidException exception){
        List<MensagemDeErro> listamensagen = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()){
            listamensagen.add(new MensagemDeErro(fieldError.getDefaultMessage()));
        }

        return listamensagen;
    }

}

package br.com.zup.GerenciadorDeContas.config;

import br.com.zup.GerenciadorDeContas.Exceptions.IdNaoEncontradoException;
import br.com.zup.GerenciadorDeContas.Exceptions.ImpossivelPoisJaEstaPagoException;
import br.com.zup.GerenciadorDeContas.Exceptions.StatusNaoModificableException;
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

    @ExceptionHandler(StatusNaoModificableException.class)//Erro digitaçao do Status fora do esperado, "PAGO"
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExceptionComOStatusNaoPermitido(StatusNaoModificableException exception){
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(ImpossivelPoisJaEstaPagoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularPagojaAtualizado(ImpossivelPoisJaEstaPagoException exception){
        return new MensagemDeErro(exception.getMessage());
    }

}

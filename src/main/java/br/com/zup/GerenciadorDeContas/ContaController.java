package br.com.zup.GerenciadorDeContas;

import br.com.zup.GerenciadorDeContas.DTOS.ContaCadastroDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;



}

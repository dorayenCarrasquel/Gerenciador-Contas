package br.com.zup.GerenciadorDeContas;

import br.com.zup.GerenciadorDeContas.DTOS.ContaCadastroDto;
import br.com.zup.GerenciadorDeContas.DTOS.ContaRespostaDto;
import br.com.zup.GerenciadorDeContas.DTOS.ResumoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaRespostaDto CadastrarConta(@RequestBody ContaCadastroDto contaCadastroDto){
        Conta conta = modelMapper.map(contaCadastroDto, Conta.class);
        contaService.salvarConta(conta);
        ContaRespostaDto contaRespostaDto = modelMapper.map(conta, ContaRespostaDto.class);
        return contaRespostaDto;
    }

    @GetMapping
    public List<ResumoDto> exibirLista(){
        List<ResumoDto>listaDeExibicao = new ArrayList<>();
        for(Conta conta:contaService.exibirTodasAsContas()){
            listaDeExibicao.add(new ResumoDto(conta.getId(),conta.getNome(),conta.getValor(),conta.getStatus()));
        }
        return listaDeExibicao;

    }





}

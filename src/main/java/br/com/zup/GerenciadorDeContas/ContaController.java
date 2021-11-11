package br.com.zup.GerenciadorDeContas;

import br.com.zup.GerenciadorDeContas.DTOS.ContaAtualizarDto;
import br.com.zup.GerenciadorDeContas.DTOS.ContaCadastroDto;
import br.com.zup.GerenciadorDeContas.DTOS.ContaRespostaDto;
import br.com.zup.GerenciadorDeContas.DTOS.ResumoDto;
import br.com.zup.GerenciadorDeContas.Enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaRespostaDto CadastrarConta(@RequestBody @Valid ContaCadastroDto contaCadastroDto) {
        Conta conta = modelMapper.map(contaCadastroDto, Conta.class);
        contaService.salvarConta(conta);
        ContaRespostaDto contaRespostaDto = modelMapper.map(conta, ContaRespostaDto.class);
        return contaRespostaDto;
    }

    @GetMapping
    public List<ResumoDto> exibirLista() {
        List<ResumoDto> listaDeExibicao = new ArrayList<>();
        for (Conta conta : contaService.exibirTodasAsContas()) {
            listaDeExibicao.add(new ResumoDto(conta.getId(), conta.getNome(), conta.getValor(), conta.getStatus()));
        }
        return listaDeExibicao;

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContaRespostaDto atualizarConta(@PathVariable int id, @RequestBody ContaAtualizarDto contaAtualizarDto) {
        if (contaAtualizarDto.getStatus() == Status.PAGO) {
            ContaRespostaDto contaRespostaDto = modelMapper.map(contaService.atualizarConta(id), ContaRespostaDto.class);

            return contaRespostaDto;
        }
            throw new RuntimeException("Impossivel modificar");

    }


}

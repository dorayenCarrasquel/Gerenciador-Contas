package br.com.zup.GerenciadorDeContas.gerenciador;

import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.ContaAtualizarDto;
import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.ContaCadastroDto;
import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.ContaRespostaDto;
import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.ResumoDto;
import br.com.zup.GerenciadorDeContas.gerenciador.Enums.Status;
import br.com.zup.GerenciadorDeContas.gerenciador.Enums.Tipo;
import br.com.zup.GerenciadorDeContas.gerenciador.Exceptions.StatusNaoModificableException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
@Api(value = "Gerenciador de contas")
@CrossOrigin(origins = "*")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Método para cadastrar uma conta")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaRespostaDto CadastrarConta(@RequestBody @Valid ContaCadastroDto contaCadastroDto) {
        Conta conta = modelMapper.map(contaCadastroDto, Conta.class);
        contaService.salvarConta(conta);
        ContaRespostaDto contaRespostaDto = modelMapper.map(conta, ContaRespostaDto.class);
        return contaRespostaDto;
    }

    @GetMapping
    @ApiOperation(value = "Método Utilizzado para mapear as busquedas com o sem parámetro")
    public List<ResumoDto> exibirLista(@RequestParam(required = false) Status status, @RequestParam(required = false)Tipo tipo, @RequestParam(required = false) Double valor) {
        List<ResumoDto> listaDeExibicao = new ArrayList<>();

        for (Conta conta : contaService.exibirTodasAsContas(status, tipo, valor)) {
            ResumoDto resumoDto = modelMapper.map(conta, ResumoDto.class);
            listaDeExibicao.add(resumoDto);
        }
        return listaDeExibicao;

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Método para atualizar uma conta por id")
    @ResponseStatus(HttpStatus.OK)
    public ContaRespostaDto atualizarConta(@Valid @PathVariable int id, @RequestBody ContaAtualizarDto contaAtualizarDto) {
        if (contaAtualizarDto.getStatus() == Status.PAGO) {
            ContaRespostaDto contaRespostaDto = modelMapper.map(contaService.atualizarConta(id), ContaRespostaDto.class);

            return contaRespostaDto;
        }
            throw new StatusNaoModificableException("Campo Impossivel de modificar");

    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Método para exibir por id")
    public ContaRespostaDto exibirContaPorId(@PathVariable int id){
        ContaRespostaDto contaRespostaDto = modelMapper.map(contaService.buscarporId(id), ContaRespostaDto.class);

        return contaRespostaDto;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Método para deletar uma conta usando como parámentro o id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConta(@PathVariable int id){
        contaService.deletarConta(id);
    }




}

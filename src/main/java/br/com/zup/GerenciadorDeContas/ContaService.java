package br.com.zup.GerenciadorDeContas;

import br.com.zup.GerenciadorDeContas.Enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        LocalDate dataCadastro = LocalDate.now();
        if (conta.getDataDeVencimento().isBefore(dataCadastro)) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }

        return contaRepository.save(conta);
    }

    public List<Conta> exibirTodasAsContas() {
        List<Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;
    }

    public Conta BuscarporId(int id){
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if(contaOptional.isEmpty()){
            throw new RuntimeException("Id não encontrado");
        }
        return contaOptional.get();
    }





//https://www.baeldung.com/spring-optional-path-variables

    /* @GetMapping("/{id}")

    public PersonDTO findById(@PathVariable Long id)

     throws PersonNotFoundExcepition {

        return personService.findById(id);

    }*/
}

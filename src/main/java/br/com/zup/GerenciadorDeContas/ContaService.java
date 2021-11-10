package br.com.zup.GerenciadorDeContas;

import br.com.zup.GerenciadorDeContas.Enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta){
        LocalDate dataCadastro = LocalDate.now();
        if (conta.getDataDeVencimento().isBefore(dataCadastro)){
            conta.setStatus(Status.VENCIDA);

        }
        else {
            conta.setStatus(Status.AGUARDANDO);
        }

        return contaRepository.save(conta);
    }

}

package br.com.zup.GerenciadorDeContas;

import br.com.zup.GerenciadorDeContas.Enums.Status;
import br.com.zup.GerenciadorDeContas.Exceptions.IdNaoEncontradoException;
import br.com.zup.GerenciadorDeContas.Exceptions.ImpossivelPoisJaEstaPagoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        verificarConta(conta);
        return contaRepository.save(conta);
    }

    public void verificarConta(Conta conta) {
        LocalDate dataCadastro = LocalDate.now();
        if (conta.getDataDeVencimento().isBefore(dataCadastro)) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }
    }
    public void verificarContaPaga(Conta conta){
        if (conta.getStatus()== Status.PAGO){
            throw new ImpossivelPoisJaEstaPagoException("Impossivel continuar, o Pago de essa conta já foi efetivado");
        }
        conta.setStatus(Status.PAGO);
    }

    public List<Conta> exibirTodasAsContas(Status status) {
        if (status != null){
            return buscarPorStatus(status);
        }
        List<Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;
    }

    public Conta buscarporId(int id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isEmpty()) {
            throw new IdNaoEncontradoException("Id não encontrado");
        }
        return contaOptional.get();
    }

    public Conta atualizarConta(int id) {
        Conta conta = buscarporId(id);
        verificarContaPaga(conta);
        conta.setDataDePagamento(LocalDateTime.now());
        contaRepository.save(conta);

        return conta;
    }

    public List<Conta> buscarPorStatus(Status status){
        return contaRepository.findAllByStatus(status);
    }

}
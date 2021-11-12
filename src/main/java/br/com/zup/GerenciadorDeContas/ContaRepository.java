package br.com.zup.GerenciadorDeContas;

import br.com.zup.GerenciadorDeContas.Enums.Status;
import br.com.zup.GerenciadorDeContas.Enums.Tipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ContaRepository extends CrudRepository<Conta,Integer> {

    List<Conta> findAllByStatus(Status status);

    List<Conta> findAllByTipo(Tipo tipo);

    @Query(value = "SELECT * FROM contas c WHERE c.valor >= ?1 ", nativeQuery = true)
    List<Conta> findContasByValor(Double valor);



}


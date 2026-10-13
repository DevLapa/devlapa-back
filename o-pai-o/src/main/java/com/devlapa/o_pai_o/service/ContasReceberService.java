package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.contas.ContasReceber;
import com.devlapa.o_pai_o.domain.contas.DadosCadastroContaReceber;
import com.devlapa.o_pai_o.domain.contas.StatusConta;
import com.devlapa.o_pai_o.repositories.ContasReceberRepository;
import com.devlapa.o_pai_o.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContasReceberService {

    @Autowired
    private ContasReceberRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ContasReceber> listarTodas() {
        return repository.findAll();
    }

    @Transactional
    public ContasReceber salvar(DadosCadastroContaReceber dados) {
        var usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));

        var conta = new ContasReceber();
        conta.setCliente(dados.cliente());
        conta.setDescricao(dados.descricao());
        conta.setValor(dados.valor());
        conta.setDataVencimento(dados.dataVencimento());
        conta.setDataRecebimento(dados.dataRecebimento());
        conta.setDatacriacao(dados.dataCriacao());
        conta.setStatus(StatusConta.PENDENTE);
        conta.setUserCriacao(usuario);

        return repository.save(conta);
    }


    @Transactional
    public ContasReceber atualizar(Long id, DadosCadastroContaReceber dados){
        var conta = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada!"));

        conta.setCliente(dados.cliente());
        conta.setDescricao(dados.descricao());
        conta.setValor(dados.valor());
        conta.setDataVencimento(dados.dataVencimento());

        if (dados.dataRecebimento() != null) {
            conta.setDataRecebimento(dados.dataRecebimento());
            conta.setStatus(StatusConta.PAGA);
        }

        return repository.save(conta);
    }
    @Transactional
    public void marcarComoRecebida(Long id){
        var conta = buscarPorId(id);

        if (conta.getStatus() == StatusConta.RECEBIDO) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Está conta já foi paga");
        }
        if (conta.getStatus() == StatusConta.CANCELADA) {
            throw  new ResponseStatusException(HttpStatus.CONFLICT, "Uma conta cancelada não pode ser marcada como recebida");
        }

        conta.setStatus(StatusConta.RECEBIDO);
        conta.setDataRecebimento(LocalDate.now());

        repository.save(conta);

    }

    private ContasReceber buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada"));
    }

    @Transactional
    public void deletar(Long id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada!");
        }
        repository.deleteById(id);
    }
}

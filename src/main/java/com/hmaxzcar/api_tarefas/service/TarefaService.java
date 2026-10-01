package com.hmaxzcar.apitarefas.service;

import com.hmaxzcar.apitarefas.dto.TarefaRequest;
import com.hmaxzcar.apitarefas.exception.RecursoNaoEncontradoException;
import com.hmaxzcar.apitarefas.model.StatusTarefa;
import com.hmaxzcar.apitarefas.model.Tarefa;
import com.hmaxzcar.apitarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listarTodos() {
        return repository.findAll();
    }

    public Tarefa buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Tarefa não encontrada: " + id
                        )
                );
    }

    public Tarefa criar(TarefaRequest request) {

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(request.getTitulo());
        tarefa.setDescricao(request.getDescricao());
        tarefa.setPrioridade(request.getPrioridade());
        tarefa.setStatus(StatusTarefa.PENDENTE);

        return repository.save(tarefa);
    }

    public Tarefa atualizar(Long id, TarefaRequest request) {

        Tarefa tarefa = buscarPorId(id);

        tarefa.setTitulo(request.getTitulo());
        tarefa.setDescricao(request.getDescricao());
        tarefa.setPrioridade(request.getPrioridade());

        return repository.save(tarefa);
    }

    public Tarefa concluir(Long id) {

        Tarefa tarefa = buscarPorId(id);

        tarefa.setStatus(StatusTarefa.CONCLUIDA);
        tarefa.setDataConclusao(LocalDateTime.now());

        return repository.save(tarefa);
    }

    public void excluir(Long id) {

        Tarefa tarefa = buscarPorId(id);

        repository.delete(tarefa);
    }

    public List<Tarefa> listarPorStatus(StatusTarefa status) {

        return repository.findByStatus(status);
    }
}
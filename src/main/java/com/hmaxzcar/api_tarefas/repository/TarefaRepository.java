package com.hmaxzcar.apitarefas.repository;

import com.hmaxzcar.apitarefas.model.StatusTarefa;
import com.hmaxzcar.apitarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByStatus(StatusTarefa status);
}
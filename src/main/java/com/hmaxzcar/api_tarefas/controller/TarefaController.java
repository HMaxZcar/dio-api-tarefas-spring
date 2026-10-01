package com.hmaxzcar.apitarefas.controller;

import com.hmaxzcar.apitarefas.dto.TarefaRequest;
import com.hmaxzcar.apitarefas.model.StatusTarefa;
import com.hmaxzcar.apitarefas.model.Tarefa;
import com.hmaxzcar.apitarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(
            @Valid @RequestBody TarefaRequest request
    ) {

        Tarefa tarefa = service.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody TarefaRequest request
    ) {

        return ResponseEntity.ok(
                service.atualizar(id, request)
        );
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Tarefa> concluir(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.concluir(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id
    ) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Tarefa>> listarPorStatus(
            @PathVariable StatusTarefa status
    ) {

        return ResponseEntity.ok(
                service.listarPorStatus(status)
        );
    }
}
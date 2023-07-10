package br.ufrn.imd.gestaogastosfamiliar.controller;

import br.ufrn.imd.gestaogastosfamiliar.model.Despesa;
import br.ufrn.imd.gestaogastosfamiliar.model.IDespesa;
import br.ufrn.imd.gestaogastosfamiliar.model.IMembro;
import br.ufrn.imd.gestaogastosfamiliar.model.Visibilidade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/despesa")
public class DespesaController {

    private final IMembro service;
    private final IDespesa serviceDespesa;

    record DespesaDto(String descricao, Double valor, Date dataVencimento, String visibilidade, UUID idMembro, UUID idDespesa){}

    @PostMapping(value = "/inserir", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> inserirDespesa(@RequestBody DespesaDto dto) {
        Despesa despesa = getDespesa(dto);
        boolean resultado = service.adicionarDespesa(despesa, dto.idMembro);
        return new ResponseEntity<>(resultado, resultado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/editar", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> editarDespesa(@RequestBody DespesaDto dto) {
        Despesa despesa = getDespesa(dto);
        despesa.setId(dto.idDespesa);
        boolean resultado = serviceDespesa.editar(despesa);
        return new ResponseEntity<>(resultado, resultado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/listar-por-membro/{idMembro}")
    public ResponseEntity<List<Despesa>> listarDespesasPorMembro(@PathVariable UUID idMembro){
        List<Despesa> lista = serviceDespesa.listarPorMembro(idMembro);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping(value = "/listar-por-familia/{idFamilia}")
    public ResponseEntity<List<Despesa>> listarDespesasPorFamilia(@PathVariable UUID idFamilia){
        List<Despesa> lista = serviceDespesa.listarPorFamilia(idFamilia);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping(value = "/remover/{idDespesa}")
    public ResponseEntity<Boolean> removerDespesa(@PathVariable UUID idDespesa){
        boolean resultado = service.removerDespesa(idDespesa);
        return new ResponseEntity<>(resultado,resultado ? HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    private Despesa getDespesa(DespesaDto dto) {
        Despesa despesa = new Despesa();
        despesa.setDescricao(dto.descricao);
        despesa.setValor(dto.valor);
        despesa.setDataVencimento(dto.dataVencimento);
        if(Objects.nonNull(dto.visibilidade)){
            despesa.setVisibilidade(Visibilidade.valueOf(dto.visibilidade));
        }
        return despesa;
    }
}

package br.ufrn.imd.gestaogastosfamiliar.controller;

import br.ufrn.imd.gestaogastosfamiliar.model.Despesa;
import br.ufrn.imd.gestaogastosfamiliar.model.IMembro;
import br.ufrn.imd.gestaogastosfamiliar.model.Visibilidade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/despesa")
public class DespesaController {

    private final IMembro service;

    record DespesaDto(String descricao, Double valor, Date dataVencimento, String visibilidade, UUID idMembro){}

    @PostMapping(value = "/inserir", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> inserirDespesa(@RequestBody DespesaDto dto) {
        Despesa despesa = getDespesa(dto);
        boolean resultado = service.adicionarDespesa(despesa, dto.idMembro);
        return new ResponseEntity<>(resultado, resultado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    private Despesa getDespesa(DespesaDto dto) {
        Despesa despesa = new Despesa();
        despesa.setDescricao(dto.descricao);
        despesa.setValor(dto.valor);
        despesa.setDataVencimento(dto.dataVencimento);
        despesa.setVisibilidade(Visibilidade.valueOf(dto.visibilidade));
        return despesa;
    }
}

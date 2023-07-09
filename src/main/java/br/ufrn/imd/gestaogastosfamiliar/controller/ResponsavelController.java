package br.ufrn.imd.gestaogastosfamiliar.controller;

import br.ufrn.imd.gestaogastosfamiliar.model.IResponsavel;
import br.ufrn.imd.gestaogastosfamiliar.model.Membro;
import br.ufrn.imd.gestaogastosfamiliar.model.Perfil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/familia")
public class ResponsavelController {

    private final IResponsavel service;

    record MembroDto(String nome, String email, Date dataNascimento, String perfil, String senha, String sobreNomeFamilia, UUID idFamilia){
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> cadastrarResponsavel(@RequestBody MembroDto dto){
        Membro responsavel = getMembro(dto);
        boolean resultado = service.cadastroFamilia(dto.sobreNomeFamilia, responsavel);
        return new ResponseEntity<>(resultado, resultado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/adicionar-membro", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> adicionarMembroNaFamilia(@RequestBody MembroDto dto){
        Membro membro = getMembro(dto);
        boolean resultado = service.adicionarMembro(membro, dto.idFamilia);
        return new ResponseEntity<>(resultado, resultado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @GetMapping(value = "/listar-membros/{idFamilia}")
    public ResponseEntity<List<Membro>> listarMembrosFamilia(@PathVariable UUID idFamilia){
        List<Membro> membros = service.listarMembros(idFamilia);
        return new ResponseEntity<>(membros, HttpStatus.OK );
    }


    private Membro getMembro(MembroDto dto) {
        Membro responsavel = new Membro();
        responsavel.setPerfil(Perfil.valueOf(dto.perfil));
        responsavel.setEmail(dto.email);
        responsavel.setNome(dto.nome);
        responsavel.setDataNascimento(dto.dataNascimento);
        responsavel.setSenha(dto.senha);
        return responsavel;
    }

}

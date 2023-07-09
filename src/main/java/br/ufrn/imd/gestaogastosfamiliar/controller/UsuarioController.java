package br.ufrn.imd.gestaogastosfamiliar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    record UsuarioDto(String nome, String email, Date dataNascimento, String perfil, String senha, String nomeFamilia){
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> salvar(@RequestBody UsuarioDto dto){
        Boolean resultado = false;

        return new ResponseEntity<>(resultado, resultado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> remover(@PathVariable UUID id){
        Boolean resultado = false;
        return new ResponseEntity<>(resultado, resultado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}

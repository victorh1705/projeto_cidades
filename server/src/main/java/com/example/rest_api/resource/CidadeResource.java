package com.example.rest_api.resource;

import java.util.List;

import com.example.rest_api.model.Cidade;
import com.example.rest_api.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("cidades")
public class CidadeResource {

  @Autowired
  private CidadeRepository cidadeRepository;

  @GetMapping()
  public ResponseEntity<List<Cidade>> olaMundo() {

    List<Cidade> cidades = cidadeRepository.listar();

    return ResponseEntity.ok(cidades);
  }

  @GetMapping(value = "/{nome}")
  public ResponseEntity<Cidade> getMethodName(@PathVariable String nome) {
    Cidade cidade = cidadeRepository.buscarPorNome(nome);

    return ResponseEntity.ok(cidade);
  }

  @PostMapping()
  public ResponseEntity<Cidade> postMethodName(@RequestBody Cidade cidade) {

    cidadeRepository.inserir(cidade);

    return ResponseEntity.ok(cidade);
  }


  @PutMapping(value = "/{nome}")
  public ResponseEntity<Cidade> atualizar(@PathVariable String nome, @RequestBody Cidade cidade) {

    Cidade cidadeAtualizada = cidadeRepository.atualizar(nome, cidade);

    return ResponseEntity.ok(cidadeAtualizada);
  }

  @DeleteMapping("/{nome}")
  public ResponseEntity<String> remover(@PathVariable String nome){

    cidadeRepository.remove(nome);

    return ResponseEntity.ok("Removido com sucesso");
  }

}

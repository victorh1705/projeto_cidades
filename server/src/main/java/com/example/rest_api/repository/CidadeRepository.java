package com.example.rest_api.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.rest_api.model.Cidade;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CidadeRepository {

  private List<Cidade> cidades;

  public CidadeRepository() {
    this.cidades = new ArrayList<>();
    this.cidades.add(new Cidade("Juiz de Fora", "Brasil", "21.4120", "21.4120"));
  }

  public List<Cidade> listar() {
    return this.cidades;
  }

  public Cidade buscarPorNome(String nome) {
    return this.cidades.stream().filter(cidade -> cidade.getNome().equals(nome)).findFirst().orElse(null);
  }

  public void inserir(Cidade cidade) {
    this.cidades.add(cidade);
  }

  public Cidade atualizar(String nome, Cidade cidade) {
    Cidade cidadePersistida = buscarPorNome(nome);

    int index = this.cidades.indexOf(cidadePersistida);

    BeanUtils.copyProperties(cidade, cidadePersistida, "nome");

    this.cidades.set(index, cidadePersistida);

    return cidadePersistida;
  }

  public void remove(String nome){
    Cidade cidadePersistida = this.cidades.stream().filter(item -> item.getNome().equals(nome)).findFirst()
        .orElse(null);

    this.cidades.remove(cidadePersistida);
  }

}

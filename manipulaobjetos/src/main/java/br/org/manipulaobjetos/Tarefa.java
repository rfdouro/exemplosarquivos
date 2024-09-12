package br.org.manipulaobjetos;

import java.io.Serializable;

/**
 *
 * @author rfdouro
 */
public class Tarefa implements Serializable {

 private String descricao;

 public Tarefa(String descricao) {
  this.descricao = descricao;
 }

 public String getDescricao() {
  return descricao;
 }

 public void setDescricao(String descricao) {
  this.descricao = descricao;
 }

 @Override
 public String toString() {
  return this.descricao;
 }

}

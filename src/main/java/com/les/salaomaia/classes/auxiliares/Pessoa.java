/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.les.salaomaia.classes.auxiliares;

import java.time.LocalDate;

/**
 *
 * @author marco
 */
public class Pessoa {

   private LocalDate dataNascimento;
   private String[] telefones;
   private String nome;
   private String cpf;
   private String email;
   private String senha;
   private char sexo;
   private int nivelAcesso;
   private int id;

   /**
    *
    * @param dataNascimento
    * @param nome
    * @param cpf
    */
   public Pessoa(LocalDate dataNascimento, String nome, String cpf) {
      this.dataNascimento = dataNascimento;
      this.nome = nome;
      if (Controle.isCPFValido(cpf)) {
         this.cpf = cpf;
      }
   }

   public boolean setTelefones(String[] telefones) {
      if (telefones.length == 0) {
         return false;
      }
      this.telefones = telefones;
      return true;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

   public void setSexo(char sexo) {
      this.sexo = sexo;
   }

   public void setNivelAcesso(int nivelAcesso) {
      this.nivelAcesso = nivelAcesso;
   }

   public void setId(int id) {
      this.id = id;
   }

   public LocalDate getDataNascimento() {
      return dataNascimento;
   }

   public String[] getTelefones() {
      return telefones;
   }

   public String getNome() {
      return nome;
   }

   public String getCpf() {
      return cpf;
   }

   public String getEmail() {
      return email;
   }

   public String getSenha() {
      return senha;
   }

   public char getSexo() {
      return sexo;
   }

   public int getNivelAcesso() {
      return nivelAcesso;
   }

   public int getId() {
      return id;
   }

}

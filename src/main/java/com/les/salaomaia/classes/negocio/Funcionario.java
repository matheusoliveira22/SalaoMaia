/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.les.salaomaia.classes.negocio;

import com.les.salaomaia.classes.auxiliares.Controle;
import com.les.salaomaia.classes.auxiliares.Pessoa;
import java.time.LocalDate;

/**
 *
 * @author marco
 */
public class Funcionario extends Pessoa {

   private String rg;
   private int    status;
   
   public Funcionario(LocalDate dataNascimento, String nome, String cpf, String rg) {
      super(dataNascimento, nome, cpf);
      this.rg = rg;
   }
   
   public void setRG(String rg) {
      if (rg.matches(rg)) {
         throw new IllegalArgumentException("RG com caracteres inválidos");
      }
      this.rg = rg;
   }
   
}

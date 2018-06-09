/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.les.salaomaia.classes.auxiliares;

import com.les.salaomaia.constantes.Imagem;
import com.les.salaomaia.constantes.Sistema;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Classe que contém todos os serviços relativos aos emails.
 *
 * @version 1.0
 */
public class ServicoEmail 
{
   /**
    * Método que configura e retorna o servilo de enviar email.
    *
    * @param e Email que será enviado.
    * @return Servico de email.
    */
   public static Service<Boolean> enviarEmail(Email e) 
   {
      // Criando o serviço
      Service<Boolean> servico = new Service<Boolean>() {
         @Override
         protected Task<Boolean> createTask()
         {
            return new Task<Boolean>() 
            {
               @Override
               protected Boolean call() throws Exception 
               {
                  return e.enviarEmail();
               }
            };
         }
      };

      // Verificar se o email foi enviado.
      servico.setOnSucceeded(h ->
      {
         Mensagem msgInformacao = new Mensagem(Mensagem.AlertType.NONE, Imagem.M, Mensagem.BOTAO_OK);
         msgInformacao.setTitle(Sistema.APP_NOME);
         if (!servico.getValue())
         {
            msgInformacao.setAlertType(Mensagem.AlertType.ERROR);
            msgInformacao.setContentText("Não foi possível enviar o email. Verifique os dados ou a conexão e Tente novamente.");
            msgInformacao.show();
         } 
         else 
         {
            msgInformacao.setAlertType(Mensagem.AlertType.INFORMATION);
            msgInformacao.setContentText("O email foi enviado com sucesso.");
            msgInformacao.show();
         }
      });
      return servico;
   }
}

package com.les.salaomaia.classes.auxiliares;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * Classe usada para criar caixas de mensagens.
 *
 * @version 1.0
 */
public class Mensagem extends Alert {

   // Tipos de botões para a caixa de texto.
   public static final ButtonType BOTAO_CANCELAR = new ButtonType("Cancelar");
   public static final ButtonType BOTAO_SIM = new ButtonType("Sim");
   public static final ButtonType BOTAO_NAO = new ButtonType("Não");
   public static final ButtonType BOTAO_OK = new ButtonType("Ok");

   /**
    * Cria um determinado tipo de mensagem com os botões configurados.
    *
    * @param t Tipo de mensagem.
    * @param i Icone da caixa de mensagem.
    * @param b Botões da mensagem.
    * @throws IllegalArgumentException Caso nenhum botão seja passado.
    */
   public Mensagem(AlertType t, Image i, ButtonType... b) {
      // Se nenhum botão for passado, lançar exceção.
      super(t);
      if (b == null) {
         throw new IllegalArgumentException("Nenhum botão configurado");
      }

      // Aplicando as configurações necessárias.
      getDialogPane().getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
      ((Stage) getDialogPane().getScene().getWindow()).getIcons().add(i);
      setHeaderText(null);
      getButtonTypes().setAll(b);
      configurarBotoes();
   }

   /**
    * Método interno para adicionar aos botões a funcionalidade KeyPress.
    */
   private void configurarBotoes() {
      getButtonTypes().forEach(botao -> {
         Button b = (Button) getDialogPane().lookupButton(botao);
         b.setOnKeyPressed(keyPress -> {
            if (keyPress.getCode() == KeyCode.ENTER) {
               b.fire();
            }
         });
      });
   }
}

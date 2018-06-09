package com.les.salaomaia.controladores;

import com.les.salaomaia.classes.auxiliares.Email;
import com.les.salaomaia.classes.auxiliares.Mensagem;
import com.les.salaomaia.classes.auxiliares.ServicoEmail;
import com.les.salaomaia.constantes.Imagem;
import com.les.salaomaia.constantes.Sistema;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable 
{
   @FXML
   private TextField txtEmail;
   @FXML
   private PasswordField txtSenha;
   @FXML
   private Label lblEsqueciSenha;
   @FXML
   private Button btnEntrar;
   @FXML
   private Button btnCancelar;

   @FXML
   private void cancelarEntrada(ActionEvent event) 
   {
      // Criando e configurando a mensagem de confirmação.
      // Caso o usuário escolha "Sim", cancelar o login e encerrar a aplicação.
      Mensagem msg = new Mensagem(Mensagem.AlertType.CONFIRMATION, Imagem.M, Mensagem.BOTAO_SIM, Mensagem.BOTAO_NAO);
      msg.setTitle("Salão Maia");
      msg.setContentText("Deseja realmente sair da aplicação?");
      if (msg.showAndWait().get() == Mensagem.BOTAO_SIM) 
      {
         Platform.exit();
      }
   }

   @FXML
   private void entrarAplicacao(ActionEvent event) throws Exception
   {
      // Criando e exibindo a janela do menu principal
      Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
      Scene scene = new Scene(root);
      Stage stage = new Stage();
      stage.setTitle("Salão Maia");
      stage.getIcons().add(Imagem.M);
      stage.setMaximized(true);
      stage.setScene(scene);
      stage.show();

      // Fechando a janela antiga.
      btnEntrar.getScene().getWindow().hide();
   }
   
   @FXML
   private void enviarSenha(MouseEvent event) 
   {
      Mensagem msgInformacao = new Mensagem(Mensagem.AlertType.NONE, Imagem.M, Mensagem.BOTAO_OK);
      msgInformacao.setTitle(Sistema.APP_NOME);
      if (txtEmail.getText().trim().isEmpty()) 
      {
         msgInformacao.setAlertType(Mensagem.AlertType.ERROR);
         msgInformacao.setContentText("Digite seu email na caixa de email.");
         msgInformacao.show();
         txtEmail.setText("");
         txtEmail.requestFocus();
      } 
      else 
      {
         Email emailSenha = new Email("salaomaia2@hotmail.com", "salaomaia123");
         emailSenha.setAssunto("Recuperação se senha");
         emailSenha.setConteudo("Sua senha é salaomaia124");
         emailSenha.setDestinatarios("marcosvmpego@hotmail.c.b");
         ServicoEmail.enviarEmail(emailSenha).start();
      }  
   }

   @Override
   public void initialize(URL url, ResourceBundle rb) 
   {
   }
}

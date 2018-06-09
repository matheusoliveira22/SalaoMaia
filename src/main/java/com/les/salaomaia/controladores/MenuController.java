/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.les.salaomaia.controladores;

import com.les.salaomaia.constantes.Imagem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marco
 */
public class MenuController implements Initializable 
{
   @FXML
   private Button btnServicos;
   @FXML
   private Button btnAgendamentos;
   @FXML
   private Button btnCadastros;
   
   @FXML
   private void telaServicos(ActionEvent e) throws IOException
   {
      // Criando e exibindo a janela do menu principal
      Parent root = FXMLLoader.load(getClass().getResource("/fxml/Servicos.fxml"));
      Scene scene = new Scene(root);
      Stage stage = new Stage();
      stage.setTitle("Salão Maia");
      stage.getIcons().add(Imagem.M);
      stage.setScene(scene);
      stage.show();
   }
   
   @FXML
   private void telaCadastros(ActionEvent e) throws IOException
   {
      // Criando e exibindo a janela do menu principal
      Parent root = FXMLLoader.load(getClass().getResource("/fxml/CadServicos.fxml"));
      Scene scene = new Scene(root);
      Stage stage = new Stage();
      stage.setTitle("Salão Maia");
      stage.getIcons().add(Imagem.M);
      stage.setScene(scene);
      stage.show();
   }

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) 
   {
      // TODO
   }

}

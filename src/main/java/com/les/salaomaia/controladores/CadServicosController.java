/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.les.salaomaia.controladores;

import com.les.salaomaia.constantes.Imagem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author marco
 */
public class CadServicosController implements Initializable 
{
   @FXML
   private Button btnNovo;
   @FXML
   private Button btnAlterar;
   @FXML
   private Button btnExcluir;
   
   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) 
   {
      btnNovo.setGraphic(new ImageView(Imagem.CHECK));
      btnAlterar.setGraphic(new ImageView(Imagem.REFRESH));
      btnExcluir.setGraphic(new ImageView(Imagem.X));
   }   
}

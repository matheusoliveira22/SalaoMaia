package com.les.salaomaia;

import com.les.salaomaia.constantes.Imagem;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application 
{
   @Override
   public void start(Stage stage) throws Exception
   {
      // Criando e configurando  a janela
      Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
      Scene scene = new Scene(root);
      scene.getStylesheets().add("/styles/Styles.css");
      stage.setTitle("Salao Maia");
      stage.getIcons().add(Imagem.M);
      stage.initStyle(StageStyle.UNDECORATED);
      stage.setScene(scene);
      stage.show();
      centralizarStage(stage);
   }

   /**
    * Função para centralizar tela no meio da pagina
    * @param s 
    */
   private static void centralizarStage(Stage s) 
   {
      Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
      s.setX((primScreenBounds.getWidth() - s.getWidth()) / 2);
      s.setY((primScreenBounds.getHeight() - s.getHeight()) / 2);
   }

   /**
    * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the application can not be launched through deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores main().
    *
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {
      launch(args);
   }
}

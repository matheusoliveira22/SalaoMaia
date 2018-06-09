/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.les.salaomaia.constantes;

import com.les.salaomaia.MainApp;
import javafx.scene.image.Image;

/**
 *
 * @author mathe
 */
public interface Imagem {
   Image LOGO    = new Image(MainApp.class.getResource("/imagens/logoMaia.png").toString());
   Image M       = new Image(MainApp.class.getResource("/imagens/M.png").toString());
   Image CHECK   = new Image(MainApp.class.getResource("/imagens/check.png").toString(), 20, 20, false, false);
   Image REFRESH = new Image(MainApp.class.getResource("/imagens/refresh.png").toString(), 20, 20, false, false);
   Image X       = new Image(MainApp.class.getResource("/imagens/x.png").toString(), 20, 20, false, false);
}

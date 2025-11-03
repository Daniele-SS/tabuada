package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Definir tamanho da tela (stage)
        stage.setWidth(500);
        stage.setHeight(500);

        //Componente da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);

        //Cabeçalho da tela
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10; -fx-background-color: #14e8ae");

        //Colocar o header no root
        root.getChildren().addAll(header);

        //Adicionar um label ao header
        Label labelTitulo = new Label("Tabuada");
        header.getChildren().add(labelTitulo);

        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.setResizable(false);
        stage.show();


    }
}

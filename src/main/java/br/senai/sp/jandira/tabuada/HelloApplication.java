package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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

        //Criar o multiplicando
        HBox multiplicandoBox = new HBox();
        multiplicandoBox.setStyle("-fx-label-padding: 10;");
        Label labelMultiplicando = new Label("Multiplicando");
        TextField textFieldMultiplicando = new TextField();

        multiplicandoBox.getChildren().addAll(labelMultiplicando, textFieldMultiplicando);

        //Colocamos o multiplicandoBox no root
        root.getChildren().addAll(multiplicandoBox);


        //Adicionar um label ao header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 25; -fx-font-weight: Bold");
        Label labelSubtitulo = new Label("Construa tabuadas sem limites!");
        labelSubtitulo.setStyle("-fx-text-fill: white");

        header.getChildren().add(labelTitulo);
        header.getChildren().add(labelSubtitulo);


        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.setResizable(false);
        stage.show();


    }
}

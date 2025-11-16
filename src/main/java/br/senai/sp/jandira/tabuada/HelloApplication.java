package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {

    TextField textFieldMultiplicando;
    TextField textFieldMenorMultiplicador;
    TextField textFieldMaiorMultiplicador;
    ListView listaTabuada;

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
        labelSubtitulo.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15");

        header.getChildren().add(labelTitulo);
        header.getChildren().add(labelSubtitulo);

        // criar o multiplicando
        GridPane gridFormulario = new GridPane();
        labelMultiplicando = new Label("Multiplicando:");
        textFieldMultiplicando = new TextField();

        Label labelMenorMultiplicador = new Label("Menor Multiplicador:");
        textFieldMenorMultiplicador = new TextField();

        Label labelMaiorMultiplicador = new Label("Maior Multiplicador:");
        textFieldMaiorMultiplicador = new TextField();

        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldMultiplicando, 1, 0);
        gridFormulario.add(labelMenorMultiplicador, 0, 1);
        gridFormulario.add(textFieldMenorMultiplicador, 1, 1);
        gridFormulario.add(labelMaiorMultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiorMultiplicador, 1, 2);

        labelMultiplicando.setPadding(new Insets(10));
        labelMenorMultiplicador.setPadding(new Insets(10));
        labelMaiorMultiplicador.setPadding(new Insets(10));

        // criar o componente de botões
        HBox boxBotoes = new HBox();
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(e -> {
            calcularTabuada();
        });

        Button btnLimpar = new Button("Limpar");
        btnLimpar.setOnAction(e -> {});

        Button btnSair = new Button("Sair");
        btnSair.setOnAction(e -> {});

        boxBotoes.setSpacing(15);
        boxBotoes.setPadding(new Insets(10));
        btnCalcular.setPrefSize(60, 30);
        btnLimpar.setPrefSize(60, 30);
        btnSair.setPrefSize(60, 30);

        // adicionar os botões na boxBotões
        boxBotoes.getChildren().addAll(btnCalcular, btnLimpar, btnSair);

        // adicionar o componente ListView
        VBox boxResultado = new VBox(boxBotoes);
        Label labelResultado = new Label("Resultado:");
        labelResultado.setStyle("-fx-text-fill: #000000; -fx-font-size: 12; -fx-font-weight: 700");
        labelResultado.setPadding(new Insets(10));

        // adicionar o ListView
        listaTabuada = new ListView();

        // adicionar o labelResultado no boxResultado
        boxResultado.getChildren().add(labelResultado);
        boxResultado.getChildren().add(listaTabuada);

        // adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultado);

        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.show();
    }

    public void calcularTabuada() {
        int multiplicando = Integer.parseInt(textFieldMultiplicando.getText());
        int menorMultiplicador = Integer.parseInt(textFieldMenorMultiplicador.getText());
        int maiorMultiplicador = Integer.parseInt(textFieldMaiorMultiplicador.getText());

        if (menorMultiplicador > maiorMultiplicador) {
            int auxiliar = menorMultiplicador;
            menorMultiplicador = maiorMultiplicador;
            maiorMultiplicador = auxiliar;
        }

        int tamanho = maiorMultiplicador - menorMultiplicador + 1; // começa no 0
        String[] tabuada = new String[tamanho];

        int contador = 0;
        while (contador < tamanho) {
            double produto = multiplicando * menorMultiplicador;
            tabuada[contador] = multiplicando + " x " + menorMultiplicador + " = " + produto;
            contador++;
            menorMultiplicador ++;
        }

        listaTabuada.getItems().clear();
        listaTabuada.getItems().addAll(tabuada);

    }
}

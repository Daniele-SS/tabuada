package main.java.br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {

    TextField textFieldMultiplicando;
    TextField textFieldMenorMultiplicador;
    TextField textFieldMaiorMultiplicador;
    ListView listaTabuada;

    @Override
    public void start(Stage stage) throws IOException {

        //Definir o tamanho da tela (Stage)
        stage.setHeight(600);

        //Controlando o fechamento ao clicar no fechar da janela
        stage.setOnCloseRequest(e -> {
            fechar();
            e.consume();
        });

        //Bloquear o redimensionamento da janela
        stage.setResizable(false);

        //Componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);

        //Cabeçalho da tela
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10;-fx-background-color: #ff33cc;");

        //Adicionando um label ao header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 22; -fx-font-weight: bold");

        Label labelSubTitulo = new Label("Contrua tabuadas sem limites!");
        labelSubTitulo.setStyle("-fx-text-fill: #ffff");

        header.getChildren().add(labelTitulo);
        header.getChildren().add(labelSubTitulo);

        //Criar o multiplicando, menor multiplicador e o maior multiplicador
        GridPane gridFormulario = new GridPane();
        gridFormulario.setPadding(new Insets(20));
        gridFormulario.setHgap(15);
        gridFormulario.setVgap(15);

        Label labelMultiplicando = new Label("Multiplicando:");
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

        //Criar o componente de botões
        HBox boxBotoes = new HBox();
        boxBotoes.setAlignment(Pos.BASELINE_CENTER);
        boxBotoes.setSpacing(15);
        boxBotoes.setPadding(new Insets(0, 20, 20, 20));
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setPrefWidth(80);
        btnCalcular.setOnAction(e -> {
            calcularTabuada();
        });

        Button btnLimpar = new Button("Limpar");
        btnLimpar.setPrefWidth(80);

        btnLimpar.setOnAction(e -> {
            limparTabuada();
        });

        Button btnSair = new Button("Sair");
        btnSair.setPrefWidth(80);
        btnSair.setOnAction(e ->{
            fechar();
        });

        //Adicionar os botões na boxBotoes
        boxBotoes.getChildren().addAll(btnCalcular, btnLimpar, btnSair);

        //Adicionar um componente ListView
        VBox boxResultado = new VBox();
        boxResultado.setPadding(new Insets(15));
        Label labelResultado = new Label("Resultado:");
        labelResultado.setStyle("-fx-text-fill: #ff33cc;-fx-font-size: 18; -fx-font-weight: bold");

        //Adicionar o ListView
        listaTabuada = new ListView();

        //Adicionar o label ao boxResultado
        boxResultado.getChildren().add(labelResultado);
        boxResultado.getChildren().add(listaTabuada);

        //Adicionar componentes ao root
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

        if (menorMultiplicador > maiorMultiplicador){
            int auxiliar = maiorMultiplicador;
            maiorMultiplicador = menorMultiplicador;
            menorMultiplicador = auxiliar;
        }

        int tamanho =maiorMultiplicador - menorMultiplicador + 1;
        String[] tabuada = new String[tamanho];


        int contador = 0;
        while (contador < tamanho) {
            double produto = multiplicando * menorMultiplicador;
            tabuada[contador] = multiplicando + " x " + menorMultiplicador + " = " + produto;
            contador++;
            menorMultiplicador++;
        }

        listaTabuada.getItems().clear();
        listaTabuada.getItems().addAll(tabuada);
    }

    public void fechar(){
        Alert alertaFechar = new Alert(Alert.AlertType.CONFIRMATION,
                "Confirma a saída do sistema?",
                ButtonType.YES,
                ButtonType.NO
        );
        Optional <ButtonType> resposta = alertaFechar.showAndWait();

        if (resposta.isPresent() && resposta.get() == ButtonType.YES){
            Platform.exit();
        }
    }

    public void limparTabuada() {
        textFieldMultiplicando.setText("");
        textFieldMenorMultiplicador.setText("");
        textFieldMaiorMultiplicador.setText("");
        listaTabuada.getItems().clear();
    }
}

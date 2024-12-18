package test;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class graphic extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Boîte de gauche avec les boutons fixes, alignés verticalement
        VBox boite_gauche = new VBox(10);
        boite_gauche.setAlignment(Pos.CENTER);
        boite_gauche.setPrefWidth(200);  // Largeur initiale de la boîte gauche

        Button bouton_attaquer = new Button("Attaquer");
        Button bouton_inventaire = new Button("Inventaire");
        Button bouton_sorts = new Button("Sorts");
        Button bouton_objet = new Button("Objet");
        

        // Agrandir les boutons de la boîte gauche
        bouton_attaquer.setPrefHeight(150);
        bouton_inventaire.setPrefHeight(150);
        bouton_sorts.setPrefHeight(150);
        bouton_objet.setPrefHeight(150);

        boite_gauche.getChildren().addAll(bouton_attaquer, bouton_inventaire, bouton_sorts, bouton_objet);

        // Boîte de droite avec 4 cases vides dans chaque coin
        GridPane boite_droite = new GridPane();
        boite_droite.setHgap(10);
        boite_droite.setVgap(10);

        // Définir des tailles dynamiques pour les boutons dans la boîte droite
        Button b1 = new Button("Case 1");
        Button b2 = new Button("Case 2");
        Button b3 = new Button("Case 3");
        Button b4 = new Button("Case 4");

        // Agrandir les boutons dans la boîte droite
        setButtonSize(b1, boite_droite);
        setButtonSize(b2, boite_droite);
        setButtonSize(b3, boite_droite);
        setButtonSize(b4, boite_droite);

        // Ajouter les boutons à la grille
        boite_droite.add(b1, 0, 0);
        boite_droite.add(b2, 1, 0);
        boite_droite.add(b3, 0, 1);
        boite_droite.add(b4, 1, 1);

        // Contenu qui apparaît lorsque les boutons de gauche sont cliqués
        bouton_attaquer.setOnAction(e -> {
            boite_droite.getChildren().clear();
            Button attaque1 = new Button("valeur recuperer grace au dao");
            Button attaque2 = new Button("Attaque");
            Button attaque3 = new Button("Attaque");
            Button attaque4 = new Button("Attaque");
            setButtonSize(attaque1, boite_droite);
            setButtonSize(attaque2, boite_droite);
            setButtonSize(attaque3, boite_droite);
            setButtonSize(attaque4, boite_droite);
            boite_droite.add(attaque1, 0, 0);
            boite_droite.add(attaque2, 1, 0);
            boite_droite.add(attaque3, 0, 1);
            boite_droite.add(attaque4, 1, 1);
        });
        
        bouton_sorts.setOnAction(e -> {
            boite_droite.getChildren().clear();
            Button sort1 = new Button("valeur recuperer grace au dao");
            Button sort2 = new Button("Sort");
            Button sort3 = new Button("Sort");
            Button sort4 = new Button("Sort");
            setButtonSize(sort1, boite_droite);
            setButtonSize(sort2, boite_droite);
            setButtonSize(sort3, boite_droite);
            setButtonSize(sort4, boite_droite);
            boite_droite.add(sort1, 0, 0);
            boite_droite.add(sort2, 1, 0);
            boite_droite.add(sort3, 0, 1);
            boite_droite.add(sort4, 1, 1);
        });

        bouton_inventaire.setOnAction(e -> {
            boite_droite.getChildren().clear();
            Button inv1 = new Button("valeur recuperer grace au dao");
            Button inv2 = new Button("Inventaire");
            Button inv3 = new Button("Inventaire");
            Button inv4 = new Button("Inventaire");
            setButtonSize(inv1, boite_droite);
            setButtonSize(inv2, boite_droite);
            setButtonSize(inv3, boite_droite);
            setButtonSize(inv4, boite_droite);
            boite_droite.add(inv1, 0, 0);
            boite_droite.add(inv2, 1, 0);
            boite_droite.add(inv3, 0, 1);
            boite_droite.add(inv4, 1, 1);
        });


        bouton_objet.setOnAction(e -> {
            boite_droite.getChildren().clear();
            Button obj1 = new Button("valeur recuperer grace au dao");
            Button obj2 = new Button("Objet");
            Button obj3 = new Button("Objet");
            Button obj4 = new Button("Objet");
            setButtonSize(obj1, boite_droite);
            setButtonSize(obj2, boite_droite);
            setButtonSize(obj3, boite_droite);
            setButtonSize(obj4, boite_droite);
            boite_droite.add(obj1, 0, 0);
            boite_droite.add(obj2, 1, 0);
            boite_droite.add(obj3, 0, 1);
            boite_droite.add(obj4, 1, 1);
        });

        HBox boite_principal = new HBox(20);
        boite_principal.setAlignment(Pos.CENTER);
        boite_principal.getChildren().addAll(boite_gauche, boite_droite);

        // Adaptation des tailles des boîtes pour qu'elles prennent l'espace proportionnellement
        boite_gauche.prefWidthProperty().bind(boite_principal.widthProperty().multiply(0.25));  // 25% de la largeur totale
        boite_droite.prefWidthProperty().bind(boite_principal.widthProperty().multiply(0.75));  // 75% de la largeur totale
        boite_droite.prefHeightProperty().bind(boite_principal.heightProperty());  // Prendre toute la hauteur disponible

        // Mise en proportion des boutons pour qu'ils soient plus grands (boîte gauche)
        bouton_attaquer.prefWidthProperty().bind(boite_gauche.widthProperty().subtract(20)); // Largeur ajustée selon la boîte
        bouton_inventaire.prefWidthProperty().bind(boite_gauche.widthProperty().subtract(20));
        bouton_sorts.prefWidthProperty().bind(boite_gauche.widthProperty().subtract(20));
        bouton_objet.prefWidthProperty().bind(boite_gauche.widthProperty().subtract(20));

        // Scène et affichage
        Scene scene = new Scene(boite_principal, 900, 650); // Taille initiale de la fenêtre
        primaryStage.setTitle("graphic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode pour lier la taille des boutons à la taille de la boîte droite
    private void setButtonSize(Button button, GridPane gridPane) {
        button.prefWidthProperty().bind(gridPane.widthProperty().subtract(20));
        button.prefHeightProperty().bind(gridPane.heightProperty().divide(1).subtract(20)); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}

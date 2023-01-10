//Importation des classes de javafx

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//Importation des classes crées

public class Main extends Application {
    private final int WINDOW_HEIGHT = 400;
    private final int WINDOW_WIDTH = 700; //Max 800 (799)



    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Runner");
        Group root = new Group();
        Pane pane = new Pane(root);
        Camera camera = new Camera(0,0,0,0, 0, 0);
        GameScene scene = new GameScene(pane, WINDOW_HEIGHT,WINDOW_WIDTH,camera);
        //System.out.println(camera.toString());
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args){
        launch(args);
    }
}

//Il reste à :
//Faire varier la trame et la position du hero
//Créer la physique du jeu
//Faire l'animation
//Ajouter des énemis
//Ajouter de la musique
//Programmer des énemis "plus intéligents"
//...

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    Camera camera;
    private final String BACKGROUND_FILENAME;
    private final double BACKGROUND_WIDTH;
    private final double BACKGROUND_HEIGHT;
    private final String HERO_FILENAME;
    private StaticThing background_left;
    private StaticThing background_right;
    private Hero hero;
    protected final int HERO_HEIGHT = 100;
    protected final int HERO_WIDTH = 80;
    private final int[] HERO_LIST_FRAME_STATE1 = {10, 90, 170, 270, 345, 425};
    private final int[] HERO_LIST_FRAME_STATE2 = {20, 95};
    //On cré une list_frame pour chaque state et on en fait un seul tableau à deux dim :
    //{HERO_LIST_FRAME_STATE1, HERO_LIST_FRAME_STATE2, HERO_LIST_FRAME_STATE3,...}
    private final int[][] HERO_ARRAY_FRAME = {HERO_LIST_FRAME_STATE1, HERO_LIST_FRAME_STATE2};
    private final int[] HERO_LIST_STATE = {0, 160, 325, 490};
    protected int height;
    protected int width;

    public GameScene(Pane pane, int height, int width, Camera camera) {
        super(pane, width, height);
        this.camera = camera;
        this.height = height;
        this.width = width;
        BACKGROUND_FILENAME = "desert.png";
        BACKGROUND_WIDTH = (new Image("img\\" + BACKGROUND_FILENAME)).getWidth();
        BACKGROUND_HEIGHT = (new Image("img\\" + BACKGROUND_FILENAME)).getHeight();
        //On enregistre les dimentions de l'image de background
        HERO_FILENAME = "heros.png";
        this.background_left = new StaticThing(0, 0, BACKGROUND_FILENAME);
        this.background_right = new StaticThing(0, 0, BACKGROUND_FILENAME);
        this.hero = new Hero(200, 250, 200, 0, 0, 0, HERO_FILENAME, HERO_HEIGHT, HERO_WIDTH, HERO_LIST_FRAME_STATE1, HERO_LIST_STATE);
        //On charge l'image est on définit la position initiale du heros.

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                hero.update(now);
                camera.update(now, hero.getX());
                update(now);
            }
        };

        pane.getChildren().add(background_left.getImageView());
        pane.getChildren().add(background_right.getImageView());
        //On ajoute au pane (la partie à afficher) les deux images de background (sans ça, les images ne s'affichent pas au moment du .show() )
        pane.getChildren().add(hero.getImageView());
        //On ajoute l'image du hero
        timer.start();
        //On lance le compteur de temps. Il va appeller la methode handler tout les x pas de temps
        //x est définit en interne du programme
    }

    public void update(long now) {
        background_left.getImageView().setViewport(new Rectangle2D(camera.getX() % BACKGROUND_WIDTH, camera.getY(), width, height));
        background_right.getImageView().setViewport(new Rectangle2D(camera.getX() % BACKGROUND_WIDTH - BACKGROUND_WIDTH, camera.getY(), width, height));
        //hero.getImageView().setViewport(new Rectangle2D(0,0,hero.getHero_width(),hero.getHero_height())); //hero.getHeroWidth() et hero.getHeroHeight() sont définis dans le constructeur de Hero.
        //Utilise le getImageView de AnimatedThing
    }


    EventHandler <KeyEvent> pressedhandler = event -> {
        hero.move(event.getCode());
    };
}

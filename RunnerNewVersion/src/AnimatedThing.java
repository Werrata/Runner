import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import java.lang.*;


public abstract class AnimatedThing {
    protected double x;
    protected double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;

    protected final ImageView imageView;
    protected int HEIGHT;
    protected int WIDTH;
    private final int HEIGHT_FRAME;
    private final int WIDTH_FRAME;
    private final int[] LIST_FRAME;
    private final int[] LIST_STATE;
    protected int numFrame = 1;
    private int state = 0;
    private long lastNow = 0;
    private int compt = 0;
    //Durée d'un changement d'image (frame) des animatedThing en ms.

    public AnimatedThing(double x, double y, double vx, double vy, double ax, double ay, String fileName, int width_frame, int height_frame, int[] list_frame, int[] list_state) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        WIDTH = (int) (new Image("img\\" + fileName)).getWidth();
        HEIGHT = (int) (new Image("img\\" + fileName)).getHeight();
        this.imageView = new ImageView("img\\" + fileName);
        this.imageView.setX(x);
        this.imageView.setY(y);

        this.HEIGHT_FRAME = height_frame;
        this.WIDTH_FRAME = width_frame;
        this.LIST_FRAME = list_frame;
        this.LIST_STATE = list_state;
    }

    public void update(long now) {
        compt++; //Ca marche mieux avec un compteur parce que la periode d'appel de handle se stabilise
        if(compt % LIST_FRAME.length == 0) {
            imageView.setViewport(new Rectangle2D(LIST_FRAME[numFrame], LIST_STATE[state], HEIGHT_FRAME, WIDTH_FRAME));
            numFrame = (numFrame + 1) % LIST_FRAME.length;
        }
        System.out.printf("Hero : " + String.valueOf(vx) + "\n");

        vx += 0.02*ax;
        vy += 0.02*ay;
        x += 0.02*vx;
        y += 0.02*vy;
        //Lois de dérivation des vitesses et accélération (il y a un +=)

        //imageView.setX(x);
        //imageView.setY(y);
    }


    public double getX() {return x;}
    public double getY() {return y;}
    public ImageView getImageView() {return imageView;}
}
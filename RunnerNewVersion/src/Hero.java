import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Hero extends AnimatedThing {
    protected double x;
    protected double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    protected ImageView imageView;
    protected int hero_height;
    protected int hero_width;
    private final int[] hero_list_frame_state1;
    private final int[] hero_list_state;
    protected int heroFrame;

    public Hero(double x, double y, double vx, double vy, double ax, double ay, String fileName, int height_frame, int width_frame, int[] list_frame, int[] list_state) {
        super(x, y, vx, vy, ax, ay, fileName, height_frame, width_frame, list_frame, list_state);
        this.hero_height = hero_height;
        this.hero_width = hero_width;
        this.hero_list_state = list_state;
        this.hero_list_frame_state1 = list_frame;
    }

    public void move(KeyCode e) {
        System.out.printf("Move\n");
        switch (e) {
            case RIGHT:
                if (x < 600) {
                    vx += 100;
                }
                break;
            case LEFT:
                if (x>0) {
                    vx -= 100;
                }
                break;
        }
    }


    public int getHero_height() {
        return hero_height;
    }

    public int getHero_width() {
        return hero_width;
    }
}

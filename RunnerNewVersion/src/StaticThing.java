import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class StaticThing {
    private int sizeX;
    private int sizeY;
    private double x;
    private double y;
    private ImageView imageView = new ImageView();


    public StaticThing(double x, double y, String fileName) {
        this.x = x;
        this.y = y;
        imageView = new ImageView(new Image("img\\"+fileName));
        imageView.setX(x);
        imageView.setY(y);
        //imageView.setViewport(new Rectangle2D(x_view,y_view,length,width));
    }

    public ImageView getImageView() {
        return imageView;
    }
}

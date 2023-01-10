public class Camera {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private final double km = 1;
    // coef d'attraction vers le héros
    private final double fm = 2;
    // coef de frottement

    public Camera(double x, double y, double vx, double vy, double ax, double ay) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
    }

    public void update(long now, double xHero) {
        ax = km*(xHero - this.x) - fm*vx;
        ay = 0;
        System.out.printf("Camera : "+ String.valueOf(vx) + "\n");

        vx += ax*0.02;
        vy += ay*0.02;

        x += vx*0.02;
        y += vy*0.02;
    }


    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
    public String toString() {
        return "Camera : " +
                "x=" + x +
                ", y=" + y;
    }
}

package ch.hslu.ad.sw05;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author cyrill
 */
public final class Ball {

    private String[] colors = {"red", "black", "blue", "yellow", "green", "magenta"};
    private String color;
    private int radius;
    private int x;
    private int y;

    public Ball() {

        int randomColor = ThreadLocalRandom.current().nextInt(0, 6);
        int randomRadius = ThreadLocalRandom.current().nextInt(30, 70 + 1); // nextInt is normally exclusive of top value, so add 1 to make inclusive
        this.color = colors[randomColor];
        this.radius = randomRadius;

        int randomYPosition = ThreadLocalRandom.current().nextInt(50, 551);
        int randomXPosition = ThreadLocalRandom.current().nextInt(30, 100);
        this.y = randomYPosition;
        this.x = randomXPosition;
    }

    public void startRandomBall() {

        Circle circle = new Circle(radius, y, x, color);
        circle.makeVisible();

        int i = 0;
        while (circle.getY() < 360) {
            circle.moveVertical(1);
            i++;
        }
    }


}

package ch.hslu.ad.sw05;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author cyrill
 */

public final class Ball {

    private String[] colors = {"blue", "black", "green", "red", "yellow", "brown", "pink"};
    private String color;
    private int radius;
    private int x;
    private int y = 20;

    public Ball() {
        
  
        int randomColor = ThreadLocalRandom.current().nextInt(0, 7); // 7 is exclusive
        int randomRadius = ThreadLocalRandom.current().nextInt(30, 70 + 1); // nextInt is normally exclusive of top value, so add 1 to make inclusive
        int randomYPosition = ThreadLocalRandom.current().nextInt(50, 551);
        this.color = colors[randomColor];
        this.radius = randomRadius;
        this.y = randomYPosition;
    }

    public void startRandomBall() {
        
        Circle circle = new Circle(radius, y, x, color);
        circle.makeVisible();
        
        int i = 0;
        while (i < 360) {
            circle.slowMoveVertical(1);
            i++;
        }
    }

}

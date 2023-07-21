import java.util.Arrays;
import java.awt.*;

public class Spider {

    private int x;
    private int y;
    private String direction; //direction is north, east, south, west
    private String s[] = {"north", "east", "south", "west"};

    public Spider(int x, int y, String direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX(){return this.x;}

    public int getY(){return this.y;}

    public void turn(){
        int size = 4;
        Arrays.asList(this.s).indexOf(this.direction);
        int index = (size + 1) % 4;
        this.direction = s[index];
    }

    public void move(){
        if(this.direction == "north"){
            this.y -= 50;
        }
        if(this.direction == "east"){
            this.x += 50;
        }
        if(this.direction == "south"){
            this.y += 50;
        }
        if(this.direction == "west"){
            this.x -= 50;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 10, 10);
        g.setColor(Color.RED);
        int leftEyeX = this.x + 3;
        int leftEyeY = this.y + 3;
        g.fillOval(leftEyeX, leftEyeY, 2, 2);
        int rightEyeX = this.x + 7;
        int rightEyeY = this.y + 3;
        g.fillOval(rightEyeX, rightEyeY, 2, 2);
        g.setColor(Color.BLACK);
        int legStartY = this.y + 10;
        int legSpacing = 2;
        int legLength = 10;
        for (int i = 0; i < 4; i++) {
            int legX = this.x - 2 - i * legSpacing;
            g.drawLine(legX, legStartY, legX - legLength, legStartY + legLength);
        }
        for (int i = 0; i < 4; i++) {
            int legX = this.x + 12 + i * legSpacing;
            g.drawLine(legX, legStartY, legX + legLength, legStartY + legLength);
        }
    }
}
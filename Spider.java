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
            this.y -= Cell.pixelSize;
        }
        if(this.direction == "east"){
            this.x += Cell.pixelSize;
        }
        if(this.direction == "south"){
            this.y += Cell.pixelSize;
        }
        if(this.direction == "west"){
            this.x -= Cell.pixelSize;
        }
    }

    public void draw(Graphics g){
        // g.setColor(Color.WHITE);
        // g.drawOval(this.x, this.y,8,8);

        g.setColor(Color.YELLOW);
        g.fillOval(this.x, this.y, 10, 10);
        g.setColor(Color.BLACK);
        int leftEyeX = this.x + 6;
        int leftEyeY = this.y + 6;
        g.fillOval(leftEyeX, leftEyeY, 3, 3);
        int rightEyeX = this.x + 11;
        int rightEyeY = this.y + 6;
        g.fillOval(rightEyeX, rightEyeY, 3, 3);
        g.drawArc(this.x + 5, this.y + 7, 10, 6, 0, -180);
    }
}
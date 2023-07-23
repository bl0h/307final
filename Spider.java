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
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.BLACK);
        int leftEyeX = this.x + 7;
        int leftEyeY = this.y + 9;
        g.fillOval(leftEyeX, leftEyeY, 6, 6);
        int rightEyeX = this.x + 18;
        int rightEyeY = this.y + 9;
        g.fillOval(rightEyeX, rightEyeY, 6, 6);
        g.setColor(Color.BLACK);
        int mouthStartX = this.x + 9;
        int mouthStartY = this.y + 20;
        g.drawArc(mouthStartX, mouthStartY, 12, 6, 0, -180);
    }

    public void paintCell(World w){
    }
}
import java.util.Arrays;
import java.awt.*;

public class Spider {

    private int x;
    private int y;
    private int cellId;
    private String direction; //direction is north, east, south, west
    private String s[] = {"north", "east", "south", "west"};

    public Spider(){
        this.x = 25;
        this.y = 25;
        this.direction = "north";
    }

    public int getX(){return this.x;}

    public int getY(){return this.y;}

    public int getCellId(){
        return this.cellId;
    }


    public void setPosition(int row, int col){
        int x = 25;
        int y = 25;
        x += 80 * col;
        y += 80 * row;
        this.x = x;
        this.y = y;
        this.cellId = (row * 5) + col;
    }

    public void turn(){
        int size = 4;
        Arrays.asList(this.s).indexOf(this.direction);
        int index = (size + 1) % 4;
        this.direction = s[index];
    }

    public void move(){
        if(this.direction == "north"){
            this.y -= 80;
            this.cellId -= 5;
        }
        if(this.direction == "east"){
            this.x += 80;
            this.cellId ++;
        }
        if(this.direction == "south"){
            this.y += 80;
            this.cellId += 5;
        }
        if(this.direction == "west"){
            this.x -= 80;
            this.cellId --;
        }
    }

    public void draw(Graphics g){
        System.out.println("Drawing spider");
        // g.setColor(Color.WHITE);
        // g.fillOval(x, y, 30, 30);
        // g.setColor(Color.BLACK);
        // int leftEyeX = this.x + 7;
        // int leftEyeY = this.y + 9;
        // g.fillOval(leftEyeX, leftEyeY, 6, 6);
        // int rightEyeX = this.x + 18;
        // int rightEyeY = this.y + 9;
        // g.fillOval(rightEyeX, rightEyeY, 6, 6);
        // g.setColor(Color.BLACK);
        // int mouthStartX = this.x + 9;
        // int mouthStartY = this.y + 20;
        // g.drawArc(mouthStartX, mouthStartY, 12, 6, 0, -180);

        g.setColor(Color.WHITE);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.BLACK);

        // Draw the eyes and mouth based on the spider's direction
        switch (direction) {
            case "north":
                drawEyesAndMouth(g, 7, 9, 18, 9, 9, 20, 12, 6, 0, -180);
                break;
            case "east":
                drawEyesAndMouth(g, 9, 7, 9, 18, 20, 9, 6, 12, -90, -180);
                break;
            case "south":
                drawEyesAndMouth(g, 7, 21, 18, 21, 9, 13, 12, 6, 0, 180);
                break;
            case "west":
                drawEyesAndMouth(g, 21, 7, 21, 18, 20, 9, 6, 12, -90, 180);
                break;
            default:
                drawEyesAndMouth(g, 7, 9, 18, 9, 9, 20, 12, 6, 0, -180);
                break;
        }
    }


    private void drawEyesAndMouth(Graphics g, int leftEyeX, int leftEyeY, int rightEyeX, int rightEyeY, int mouthStartX, int mouthStartY, int mouthWidth, int mouthHeight, int startAngle, int arcAngle) {
        g.fillOval(this.x + leftEyeX, this.y + leftEyeY, 6, 6);
        g.fillOval(this.x + rightEyeX, this.y + rightEyeY, 6, 6);
        g.drawArc(this.x + mouthStartX, this.y + mouthStartY, mouthWidth, mouthHeight, startAngle, arcAngle);
    }
}
import java.util.Arrays;

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
}
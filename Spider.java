public class Spider {

    private int x;
    private int y;
    private String direction; //direction is north, east, south, west

    public Spider(int x, int y, String direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String getDirection(){
        return this.direction;
    }

    public void setDirection(String s){
        this.direction = s;
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
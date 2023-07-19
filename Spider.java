enum DIRECTION {
    NORTH,
    EAST,
    SOUTH,
    WEST
}

public class Spider {

    private int x;
    private int y;
    private DIRECTION direction; //direction is north, east, south, west



    public Spider(int x, int y, DIRECTION direction){
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

    public DIRECTION getDirection(){
        return this.direction;
    }

    public void turn(){
        if(this.direction == DIRECTION.NORTH){
            this.direction = DIRECTION.EAST;
        }
        else if(this.direction == DIRECTION.EAST){
            this.direction = DIRECTION.SOUTH;
        }
        else if(this.direction == DIRECTION.SOUTH){
            this.direction = DIRECTION.WEST;
        }
        else if(this.direction == DIRECTION.WEST){
            this.direction = DIRECTION.NORTH;
        }
    }

    public void setDirection(DIRECTION s){
        this.direction = s;
    }

    public void move(){
        if(this.direction == DIRECTION.NORTH){
            this.y -= Cell.pixelSize;
        }
        if(this.direction == DIRECTION.EAST){
            this.x += Cell.pixelSize;
        }
        if(this.direction == DIRECTION.SOUTH){
            this.y += Cell.pixelSize;
        }
        if(this.direction == DIRECTION.WEST){
            this.x -= Cell.pixelSize;
        }
    }
}
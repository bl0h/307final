import java.awt.*;
import java.util.LinkedList;

public class ProblemHelper {
    private Spider spider;
  //  private World world;

    public ProblemHelper(Spider spider){
        this.spider = spider;
        //this.world = world;
    }

    public LinkedList<Cell> getLevel(int level) {
        LinkedList<Cell> cells = new LinkedList<Cell>();
        for(int i = 0; i < 25; i++){
            cells.add(new Cell(i / 5, i % 5, Color.BLACK));
        }   

        if(level == 1){
            //world.setMatrixSize(5, 5);
            spider.setDirection("north");
            Cell cell = cells.get(6);
            cell.setDiamond(true, Color.RED);
            cell = cells.get(8);
            cell.setDiamond(true, Color.BLUE);
            cell = cells.get(11);
            cell.setDiamond(true, Color.GREEN);
            spider.setPosition(3, 1);
            cell.setSpider(true);
        }

        else if(level == 2) {
            spider.setDirection("north");
            Cell cell = cells.get(6);
            cell.setDiamond(true, Color.GREEN);
            cell = cells.get(8);
            cell.setDiamond(true, Color.BLUE);
            cell = cells.get(16);
            cell.setDiamond(true, Color.RED);
            spider.setPosition(3, 3);
        }

        else if(level == 3) {
            spider.setDirection("north");
            Cell cell = cells.get(6);
            cell.setDiamond(true, Color.RED);
            cell = cells.get(7);
            cell.setDiamond(true, Color.BLUE);
            cell = cells.get(8);
            cell.setDiamond(true, Color.RED);
            cell = cells.get(12);
            cell.setDiamond(true, Color.BLUE);
            spider.setPosition(3, 2);
            
        }
        
        else if(level == 4) {
            spider.setDirection("south");
            Cell cell = cells.get(6);
            cell.setDiamond(true, Color.BLUE);
            cell = cells.get(8);
            cell.setDiamond(true, Color.BLUE);
            spider.setPosition(0, 2);
        }

        else if(level == 5) {
            spider.setDirection("south");
            Cell cell = cells.get(19);
            cell.setDiamond(true, Color.BLUE);
            cell = cells.get(22);
            cell.setDiamond(true, Color.GREEN);
            cell = cells.get(24);
            cell.setDiamond(true, Color.GREEN);
            spider.setPosition(2, 4);
        }

        else if(level == 6) {
            spider.setDirection("east");
            spider.setPosition(0, 0);
            Cell cell = cells.get(1);
            cell.setDiamond(true, Color.RED);
            cell = cells.get(3);
            cell.setDiamond(true, Color.GREEN);
            cell = cells.get(6);
            cell.setDiamond(true, Color.RED);
            cell = cells.get(8);
            cell.setDiamond(true, Color.GREEN);
            cell = cells.get(11);
            cell.setDiamond(true, Color.BLUE);
            cell = cells.get(12);
            cell.setDiamond(true, Color.BLUE);
            cell = cells.get(13);
            cell.setDiamond(true, Color.BLUE);

        }

        else if(level == 7) {
            spider.setDirection("east");
            
        }

        else if(level == 8) {

            
        }

        else if(level == 9) {

            
        }

        else if(level == 10) {

            
        }
        return cells;
    }

}
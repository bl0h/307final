import java.awt.*;
import java.util.LinkedList;

public class ProblemHelper {
    private Spider spider;

    public ProblemHelper(Spider spider){
        this.spider = spider;
    }

    public LinkedList<Cell> getLevel(int level) {
        LinkedList<Cell> cells = new LinkedList<Cell>();
        for(int i = 0; i < 25; i++){
            cells.add(new Cell(i / 5, i % 5, Color.BLACK));
        }   

        if(level == 1){
            spider.setDirection("north");
            Cell cell = cells.get(6);
            cell.setDiamond(true, Color.RED);
            cell = cells.get(8);
            cell.setDiamond(true, Color.BLUE);
            cell = cells.get(11);
            cell.setDiamond(true, Color.GREEN);
            //cell = cells.get(16);
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

            
        }
        
        else if(level == 4) {

            
        }

        else if(level == 5) {

            
        }

        else if(level == 6) {

            
        }

        else if(level == 7) {

            
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
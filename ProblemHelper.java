import java.awt.*;
import java.util.LinkedList;

public class ProblemHelper {
    private Spider spider;
    private World world;

    public ProblemHelper(Spider spider){
        this.spider = spider;
    }

    public void setWorld(World world) {
        this.world = world;
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
            Cell cell = cells.get(1);
            cell.setDiamond(true, Color.RED);
            
        }
        else if(level == 8) {
            int matrixSize = world.getSpiderCols();
        }
        else if(level == 9) {
            int matrixSize = world.getSpiderCols();

            for (int i = 0; i < matrixSize; i++) {
                Cell cell = cells.get(i * matrixSize + (matrixSize - 1 - i));
                cell.setDiamond(true, Color.RED);
            }

        }
        else if(level == 10) {
            int matrixSize = world.getMatrixSize();
            int row = 0;
            int col = 0;

            int[] dx = { 0, 1, 1 };
            int[] dy = { 1, 0, 1 };

            for (int i = 0; i < dx.length; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                if (newRow >= 0 && newRow < matrixSize && newCol >= 0 && newCol < matrixSize) {
                    Cell cell = cells.get(newRow * matrixSize + newCol);
                    cell.setDiamond(true, Color.RED);
                }
            }

        }
        return cells;
    }

}
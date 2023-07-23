import java.util.LinkedList;

public class Datasource {
    private static Datasource datasource = null;
    private LinkedList<Cell> cellList = new LinkedList<Cell>();
    private LinkedList<Block> program = new LinkedList<Block>();

    private Datasource(){}

    public static Datasource getInstance()
    {
        if (datasource == null)
            datasource = new Datasource();
  
        return datasource;
    }

    public LinkedList<Cell> getCellList(){
        return this.cellList;
    }

    public void setCellList(LinkedList<Cell> l){
        this.cellList = l;
    }

    public void addCell(Cell c){
        this.cellList.add(c);
    }

    public void clearCellList(){
        this.cellList.removeAll(this.cellList);
    }

    public void addBlock(Block b){
        this.program.add(b);
    }

    public void clearProgram(){
        this.program.removeAll(this.program);
    }

    public LinkedList<Block> getProgram(){
        return this.program;
    }

}

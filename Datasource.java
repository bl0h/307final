import java.util.LinkedList;

public class Datasource {
    private static Datasource datasource = null;
    private LinkedList<Cell> cellList = new LinkedList<Cell>();

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


}

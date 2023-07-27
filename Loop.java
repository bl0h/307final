import java.util.LinkedList;

public class Loop{

    private int loops;
    private LinkedList<Block> blockList = new LinkedList<Block>();

    public Loop(int loops){
        this.loops = loops;
    }

    public void addBlock(Block b){
        blockList.add(b);
    }

    public LinkedList<Block> getBlockList(){
        return this.blockList;
    }

    public int getLoops(){
        return this.loops;
    }

}

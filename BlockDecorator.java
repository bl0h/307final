import java.util.ArrayList;

public class BlockDecorator extends ParentBlock{

    protected Block decoratedBlock;
    private ArrayList<Block> blocks;

    public BlockDecorator(Block b){
        this.decoratedBlock = b;
        blocks = new ArrayList<Block>();
    }

    public void addBlock(Block b){
        this.blocks.add(b);
    }
}
 
import java.util.LinkedList;
import java.awt.*;

public class Loop extends Block{

    private LinkedList<Block> blockList = new LinkedList<Block>();
    private int rectWidth = 105;
    private int rectHeight = 80;

    public Loop(int x, int y, String text){
        super(text, x, y);
    }

    public void addBlock(Block b){
        blockList.add(b);
        this.rectHeight += 40;
    }

    public LinkedList<Block> getBlockList(){
        return this.blockList;
    }
    @Override
    public boolean contains(int x, int y) {
        // Check if x and y are within the bounds of the block's rectangle
        return x >= getX() && x <= getX() + rectWidth &&
               y >= getY() && y <= getY() + rectHeight;
    }



    @Override
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        FontMetrics fontMetrics = g.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(super.getText());
        int textHeight = fontMetrics.getHeight();
        Color pastelRed = new Color(255, 105, 97);
        g.setColor(pastelRed);
        g.fillRect(super.getX(), super.getY(), this.rectWidth, this.rectHeight);
        int textX = super.getX() + (this.rectWidth - textWidth) / 2;
        int textY = super.getY() + (35 - textHeight) / 2 + fontMetrics.getAscent();
        g.setColor(Color.BLACK);
        g.drawString(super.getText(), textX, textY);
    }

}

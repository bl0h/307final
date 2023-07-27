import java.util.LinkedList;
import java.awt.*;

public class Loop{

    private int loops;
    private LinkedList<Block> blockList = new LinkedList<Block>();
    private String text;

    public Loop(int loops){
        this.loops = loops;
        this.text = "Loop of " + this.loops;
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


    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        FontMetrics fontMetrics = g.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(this.text);
        int textHeight = fontMetrics.getHeight();
        int rectWidth = 75; // Add some padding for the rectangle
        int rectHeight = 25; // Add some padding for the rectangle
        Color lightPastelGreen = new Color(144, 238, 144);
        g.setColor(lightPastelGreen);
        g.fillRect(this.x, this.y, rectWidth, rectHeight);
        int textX = this.x + (rectWidth - textWidth) / 2;
        int textY = this.y + (rectHeight - textHeight) / 2 + fontMetrics.getAscent();
        g.setColor(Color.BLACK);
        g.drawString(this.text, textX, textY);
    }

}

import java.util.LinkedList;
import java.awt.*;

public class Loop extends Block{

    private LinkedList<Block> blockList = new LinkedList<Block>();
    private String text;
    private int x;
    private int y;
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

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        FontMetrics fontMetrics = g.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(this.text);
        int textHeight = fontMetrics.getHeight();
        Color pastelRed = new Color(255, 105, 97);
        g.setColor(pastelRed);
        g.fillRect(this.x, this.y, rectWidth, rectHeight);
        int textX = this.x + (rectWidth - textWidth) / 2;
        int textY = this.y + (35 - textHeight) / 2 + fontMetrics.getAscent();
        g.setColor(Color.BLACK);
        g.drawString(this.text, textX, textY);
    }

}

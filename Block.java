import java.awt.*;

public class Block extends ParentBlock{

    private String text;
    private int x;
    private int y;

    public Block(String text, int x, int y){
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public String getText(){
        return this.text;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        FontMetrics fontMetrics = g.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(this.text);
        int textHeight = fontMetrics.getHeight();
        int rectWidth = textWidth + 20; // Add some padding for the rectangle
        int rectHeight = textHeight + 10; // Add some padding for the rectangle
        g.drawRect(this.x, this.y, rectWidth, rectHeight);
        int textX = this.x + (rectWidth - textWidth) / 2;
        int textY = this.y + (rectHeight - textHeight) / 2 + fontMetrics.getAscent();
        g.drawString("this.text", textX, textY);
    }
}

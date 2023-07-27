import java.awt.*;

public class Block{

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

    public int getX(){
        return x;
    }

    public int getY(){
       return y;
    }
    public String getText(){
        return this.text;
    }

    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= this.x && mouseX <= this.x + 75 &&
               mouseY >= this.y && mouseY <= this.y + 25;
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

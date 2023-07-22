import java.awt.*;

public class Cell {
    private int row;
    private int col;
    private Color color;
    private boolean hasDiamond;
    private boolean hasSpider;
    private Color diamondColor;

    public Cell(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.hasDiamond = false;
        this.hasSpider = false;
        this.diamondColor = Color.BLACK;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean hasDiamond() {
        return hasDiamond;
    }

    public void setHasDiamond(boolean hasDiamond) {
        this.hasDiamond = hasDiamond;
    }

    public boolean hasSpider() {
        return hasSpider;
    }

    public void setSpider() {
        this.hasSpider = true;
    }

    public void setHasSpider(boolean hasSpider) {
        this.hasSpider = hasSpider;
    }

    public Color getColor() {
        return color;
    }

    public Color getDiamondColor() {
        return diamondColor;
    }

    public void setDiamond(boolean hasDiamond, Color color) {
        this.hasDiamond = hasDiamond;
        this.diamondColor = color;
    }

    public void drawDiamond(Graphics g, int cellSize) {
        if (hasDiamond) {
            int halfCellSize = cellSize / 2;
            int x = col * cellSize + halfCellSize;
            int y = row * cellSize + halfCellSize;

            int[] xPoints = {x, x - halfCellSize, x, x + halfCellSize};
            int[] yPoints = {y - halfCellSize, y, y + halfCellSize, y};

            g.setColor(diamondColor);
            g.fillPolygon(new Polygon(xPoints, yPoints, 4));
        }
    }

    public void draw(Graphics g, int cellSize) {
        g.setColor(color);
        g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
        drawDiamond(g, cellSize);
    }
}


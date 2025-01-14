package org.hbrs.se1.ws24.exercises.uebung10;



public class MyPrettyRectangle {
    private final int x1, y1, x2, y2;

    public MyPrettyRectangle(int x1, int y1, int x2, int y2) {
        if (x1 >= x2 || y1 >= y2) {
            throw new IllegalArgumentException("Ungültige Koordinaten für ein Rechteck.");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean contains(MyPrettyRectangle other) {
        return this.x1 <= other.x1 && this.y1 <= other.y1 &&
                this.x2 >= other.x2 && this.y2 >= other.y2;
    }

    public Point getMidpoint() {
        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;
        return new Point(midX, midY);
    }

    public int getArea() {
        return (x2 - x1) * (y2 - y1);
    }

    public MyPrettyRectangle getBoundingBox(MyPrettyRectangle other) {
        int minX = Math.min(this.x1, other.x1);
        int minY = Math.min(this.y1, other.y1);
        int maxX = Math.max(this.x2, other.x2);
        int maxY = Math.max(this.y2, other.y2);
        return new MyPrettyRectangle(minX, minY, maxX, maxY);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyPrettyRectangle that = (MyPrettyRectangle) obj;
        return x1 == that.x1 && y1 == that.y1 &&
                x2 == that.x2 && y2 == that.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
}

class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

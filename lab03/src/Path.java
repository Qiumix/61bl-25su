/** A class that represents a path via pursuit curves. */
public class Path {
    private Point curr;
    private Point next;

    public Path(double x, double y) {
        next = new Point(x, y);
        curr = new Point();
    }

    public double getCurrX() {
        return curr.getX();
    }

    public double getCurrY() {
        return curr.getY();
    }

    public double getNextX() {
        return next.getX();
    }

    public double getNextY() {
        return next.getY();
    }

    public Point getCurrPoint() {
        return curr;
    }

    public void setCurrPoint(Point point) {
        curr = point;
    }

    public void iterate(double dx, double dy) {
        curr = new Point(next);
        next.setX(dx + next.getX());
        next.setY(dy + next.getY());
    }
    // TODO

}

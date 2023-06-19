package Employee;
import java.util.Objects;
        class Point {
        private final int x;
        private final int y;

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
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    class Line implements Comparable<Line> {
        private final Point startPoint;
        private final Point endPoint;

        public Line(Point startPoint, Point endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        public Point getStartPoint() {
            return startPoint;
        }

        public Point getEndPoint() {
            return endPoint;
        }

        public double getLength() {
            int xDiff = endPoint.getX() - startPoint.getX();
            int yDiff = endPoint.getY() - startPoint.getY();
            return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Line other = (Line) obj;
            return startPoint.equals(other.startPoint) && endPoint.equals(other.endPoint);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startPoint, endPoint);
        }

        @Override
        public int compareTo(Line other) {
            double thisLength = getLength();
            double otherLength = other.getLength();
            if (thisLength < otherLength) {
                return -1;
            } else if (thisLength > otherLength) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public class LineComparison {
        public static void main(String[] args) {
            Point startPoint1 = new Point(1, 2);
            Point endPoint1 = new Point(4, 6);
            Line line1 = new Line(startPoint1, endPoint1);

            Point startPoint2 = new Point(3, 4);
            Point endPoint2 = new Point(7, 10);
            Line line2 = new Line(startPoint2, endPoint2);

            System.out.println("Length of line 1: " + line1.getLength());
            System.out.println("Length of line 2: " + line2.getLength());

            if (line1.equals(line2)) {
                System.out.println("Line 1 and Line 2 are equal.");
            } else if (line1.compareTo(line2) < 0) {
                System.out.println("Line 1 is shorter than Line 2.");
            } else {
                System.out.println("Line 1 is longer than Line 2.");
            }
        }
    }


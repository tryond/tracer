package tracer.sequence;

import java.awt.*;
import java.util.ArrayList;

public class TraceFormatter
{

    public static String getPoints(ArrayList<Point> points)
    {
        if (points.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < points.size()-1; ++i) {
            sb.append("(" + points.get(i).x + "," + points.get(i).y + "),");
        }

        // append last element
        sb.append("(" + points.get(points.size()-1).x + "," + points.get(points.size()-1).y + ")]");
        return sb.toString();
    }

    // returns position of cursor along path at every poll_rate ms
    public static ArrayList<Point> normalizeTime(ArrayList<Point> points, ArrayList<Integer> timesMS, Double poll_rate)
    {
        ArrayList<Point> newPoints = new ArrayList<Point>();
        double delta = 0.0;

        ArrayList<Double> timesS = new ArrayList<Double>();
        for (Integer i : timesMS)
        {
            timesS.add((i * 1.0) / 1000.0);
        }

        // difference between pt1 and pt2 along path
        int diffX, diffY;

        // distance to move for each iteration along path p1 to p2
        double distX, distY;

        // points and times to be referenced for interpolation
        if (points.isEmpty()) return newPoints;

        // add initial point to the array to be returned
        newPoints.add(points.get(0));

        int taper = 2;

        // begin linear interpolation
        for (int i = taper + 1; i < points.size()-taper; ++i) {

            // make sure delta is positive
            delta += timesS.get(i) >= 0 ? timesS.get(i) : 0;

            // System.out.println("Delta: " + delta);

            if (delta >= poll_rate) {

                // distance between endpoints
                diffX = points.get(i).x - points.get(i-1).x;
                diffY = points.get(i).y - points.get(i-1).y;

                // distance moved in poll_rate
                distX = (diffX * poll_rate) / delta;
                distY = (diffY * poll_rate) / delta;

                // add points along line
                for (int j = 1; j <= (int)(delta / poll_rate); ++j) {

                    // linearly interpolated point along the path (rounded)
                    int newX = points.get(i-1).x + (int)(distX * j + 0.5);
                    int newY = points.get(i-1).y + (int)(distY * j + 0.5);

                    newPoints.add(new Point(newX, newY));
                }
                // carry only the remaining distance to the next round
                delta -= (int)(delta / poll_rate) * poll_rate;
            }
        }
        return newPoints;
    }

}

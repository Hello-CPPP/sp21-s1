package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    /**
     * Your times should be in seconds.
     * You should use the Stopwatch class. See stopwatchDemo for an example. */
    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<String> test = new AList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int maxN = 128000;
        int basis = 1000;
        String numberToAdd = "1";

        Stopwatch sw = new Stopwatch();

        for (int i = 1; i <= maxN; i++) {
            test.addLast(numberToAdd);
            if (i == basis) {
                basis *= 2;

                Ns.addLast(i);
                opCounts.addLast(i);

                double timeInSecond = sw.elapsedTime();
                times.addLast(timeInSecond);
            }
        }

        printTimingTable(Ns, times, opCounts);

    }
}

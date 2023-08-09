package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int basis = 1000;
        int numberToAdd = 1;
        final int OPS = 10000;
        for (int i = 0; i < 8; i++) {
            SLList<Integer> test = new SLList<>();
            for (int j = 0; j < basis; j++) {
                test.addLast(numberToAdd);
            }

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < OPS; j++) {
                test.getLast();
            }
            double timeInSecond = sw.elapsedTime();
            times.addLast(timeInSecond);
            Ns.addLast(basis);
            opCounts.addLast(OPS);

            basis *= 2;
        }

        printTimingTable(Ns, times, opCounts);
    }

}

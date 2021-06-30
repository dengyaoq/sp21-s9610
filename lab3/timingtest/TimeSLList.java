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

    public static double timeUsed(int numberOfcalls) {

        SLList timeRecording = new SLList();

        for (int x = 0; x < numberOfcalls; x += 1) {
            timeRecording.addLast(0);
        }
        Stopwatch sw = new Stopwatch();
        for (int i=0; i<10000; i+=1) {
            timeRecording.getLast();
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int size = 256000;
        AList N = new AList();
        for (int i = 1000; i < size; i = i * 2) {
            N.addLast(i);
        }
        AList timeRecorder = new AList();
        for (int i = 0; i < N.size(); i += 1) {
            //need to cast the N.get method since it returns objects (cast it into integer)
            timeRecorder.addLast(timeUsed((Integer) N.get(i)));
        }
        AList ops = new AList();
        for (int i=1000; i<size; i=i*2){
            ops.addLast(10000);
        }

        printTimingTable(N, timeRecorder, ops);


    }
}















        /*
        //step 1 and step 2
        SLList lst = new SLList();
        int size = 256000;
        for (int i = 1000; i < size; i = i * 2) {
            lst.addLast(0);
        }
        // step3, create an array and store the timing results
        AList timeRecording = new AList();
        for (int i = 0; i < size; i = i * 2) {
            Stopwatch sw = new Stopwatch();
            lst.getLast();
            double timeInSeconds = sw.elapsedTime();
            timeRecording.addLast(timeInSeconds);
        }

        AList forTable = new AList();
        for (int i = 1000; i < size; i = i * 2) {
            forTable.addLast(i);
        }
        printTimingTable(forTable, timeRecording, forTable);
    }
    //input a number x, return a SLlist with x items;
    public TimeSLList(int x){
        SLList lst = new SLList();
        for (int i = 0; i < x; i+=1) {
            lst.addLast(0);
        }
    }
*/



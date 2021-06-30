package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;

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

    //return the time taken to produce the new list timeUsed with length numberOfcalls;
    public static double timeUsed (int numberOfcalls){
        Stopwatch sw = new Stopwatch();
        AList timeRecording = new AList();
        for (int x = 0; x < numberOfcalls; x+=1){
             timeRecording.addLast(x);
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }
    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int size = 100000000;
    AList N = new AList();
    for (int i=1000;i<size; i=i*2){
        N.addLast(i);
    }
    AList timeRecorder = new AList();
    for (int i=0; i<N.size(); i+=1){
        //need to cast the N.get method since it returns objects (cast it into integer)
        timeRecorder.addLast(timeUsed((Integer) N.get(i)));
    }

    printTimingTable(N, timeRecorder, N);


    }
}

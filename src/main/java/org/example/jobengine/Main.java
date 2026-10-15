package org.example.jobengine;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() throws InterruptedException {

        BlockingQueue<Job> queue =  new LinkedBlockingDeque<>(10);

        Thread worker1  =  new Thread(new Worker(queue), "worker-1");
        Thread worker2  =  new Thread(new Worker(queue), "worker-2");

        worker1.start();
        worker2.start();

        for(int i =1; i <= 10; i++){
            queue.put(new Job(i));
        }
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        IO.println(String.format("Hello and welcome!"));
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            IO.println("i = " + i);
//        }
    }
}

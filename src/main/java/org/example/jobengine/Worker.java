package org.example.jobengine;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable{
    private final BlockingQueue<Job> queue;

    public Worker(BlockingQueue<Job> queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try{
                Job job = queue.take();
                job.execute();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

    }

}

package org.example.jobengine;

public class Job {

    private final int id;

    public Job(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + "processing" + id);

        try {
            Thread.sleep(1000);

        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + "finisheed" + id);

    }
}

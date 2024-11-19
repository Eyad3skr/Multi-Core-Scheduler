public class SlaveCore extends Thread {
    private MasterCore masterCore;
    private ProcessManager currentProcess;
    private Memory m;
    //gpt recommendation for thread termination:
    private volatile boolean running = true;

    public SlaveCore(Memory m, MasterCore masterCore) {
        this.m = m;
        this.masterCore = masterCore;
    }

    public boolean execute(ProcessManager p, int timeQuantum) {
        int remainingTime = p.getRemainingTime();

        if (remainingTime <= timeQuantum) {
            System.out.println("Process " + p.getPid() + " finished execution.");
            p.setRemainingTime(0);
            return true; // Process 5lst
        } else {
            System.out.println("Process " + p.getPid() + " executed for " + timeQuantum + " units.");
            p.setRemainingTime(remainingTime - timeQuantum);
            return false; // Process m5lst4
        }
    }

    public void stopExecution() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            if (currentProcess != null) {
                boolean isFinished = execute(currentProcess, masterCore.getQuantum());
                if (!isFinished) {
                    masterCore.addProcess(currentProcess);
                }
                currentProcess = null;
            }
            try {
                Thread.sleep(100); // Avoid tight loop
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

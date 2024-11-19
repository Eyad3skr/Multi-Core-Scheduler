import java.util.Queue;

public class MasterCore {
    private Queue<ProcessManager> ReadyQueue;
    private SlaveCore[] slaveCores;
    private Memory m;
    private int quantum;

    public MasterCore(Queue<ProcessManager> ReadyQueue, SlaveCore[] slaveCores, Memory m, int quantum) {
        this.ReadyQueue = ReadyQueue;
        this.slaveCores = slaveCores;
        this.m = m;
        this.quantum = quantum;
    }

    public Queue<ProcessManager> getReadyQueue() {
        return ReadyQueue;
    }

    public SlaveCore getSlaveCore(int i) {
        return slaveCores[i];
    }

    public int getQuantum() {
        return quantum;
    }

    public void addProcess(ProcessManager p) {
        try {
            ReadyQueue.add(p);
        } catch (Exception e) {
            System.err.println("Failed to add process: " + e.getMessage());
        }
    }

    public void scheduleTasks() {
        // Round Robin scheduling
        int i = 0;
        while (!ReadyQueue.isEmpty()) {
            ProcessManager p = ReadyQueue.poll();
            boolean isFinished = slaveCores[i].execute(p, getQuantum());
            if (!isFinished) {
                ReadyQueue.add(p);
            }
            i = (i + 1) % slaveCores.length;
        }
    }

    public void start() {
        for (SlaveCore slaveCore : slaveCores) {
            slaveCore.start();
        }
    }

    public void monitorExecution() {
        System.out.println("Monitoring Execution:");
        m.printState();
        System.out.println("Ready Queue Size: " + ReadyQueue.size());
    }
}

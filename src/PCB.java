public class PCB {
    private final int pid;
    private int programCounter;
    private final MemoryBoundaries memoryBoundaries;

    public PCB(int pid, int programCounter, MemoryBoundaries memoryBoundaries) {
        this.pid = pid;
        this.programCounter = programCounter;
        this.memoryBoundaries = memoryBoundaries;
    }

    public int getProcessId() {
        return pid;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public MemoryBoundaries getMemoryBoundaries() {
        return memoryBoundaries;
    }
}

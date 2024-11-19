public class ProcessManager {
    private int pid;
    private String instructions;
    private int programCounter;
    private PCB pcb;
    private int remainingTime;

    public ProcessManager(int pid, String instructions, int programCounter, PCB pcb) {
        this.pid = pid;
        this.instructions = instructions;
        this.programCounter = programCounter;
        this.pcb = pcb;
    }

    public void incrementProgramCounter() {
        programCounter++;
    }

    public int getPid() {
        return pid;
    }

    public PCB getPcb() {
        return pcb;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setPcb(PCB pcb) {
        this.pcb = pcb;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String toString() {
        return "ProcessManager{" + "pid=" + pid + ", instructions=" + instructions + ", programCounter=" + programCounter + ", pcb=" + pcb + '}';
    }

    public String nextInstruction() {
        String[] instructs = instructions.split("\n");
        if (programCounter < instructs.length) {
            return instructs[programCounter];
        }
        return null;
    }
    public boolean isCompleted() {
        return programCounter >= instructions.split("\n").length;
    }
}

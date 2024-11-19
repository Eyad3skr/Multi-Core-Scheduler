public class MemoryBoundaries {
    private final int startAddress;
    private final int endAddress;

    public MemoryBoundaries(int startAddress, int endAddress) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public int getEndAddress() {
        return endAddress;
    }
}

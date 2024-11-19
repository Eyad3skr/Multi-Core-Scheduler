import java.util.concurrent.ConcurrentHashMap;

public class Memory {
    private final ConcurrentHashMap<String, Integer> variables;

    public Memory() {
        this.variables = new ConcurrentHashMap<>();
    }

    public int get(String k) {
        return variables.getOrDefault(k, 0); // gpt recommendation: Return 0 if key is not found
    }

    public void set(String k, int v) {
        variables.put(k, v);
    }

    public void printState() {
        System.out.println("Current Memory State: ");
        for (String k : variables.keySet()) {
            System.out.println(k + " = " + variables.get(k));
        }
    }

    public boolean contains(String k) {
        return variables.containsKey(k);
    }
}

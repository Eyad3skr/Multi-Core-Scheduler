public class Main {
    public static void main(String[] args) {
        Memory memory = new Memory();

        String[] instructions = {
                "assign a 10",        // Assign 10 to variable a
                "assign b 5",         // Assign 5 to variable b
                "assign z add a b",   // z = a + b
                "print z",            // Print value of z
                "assign x multiply a b", // x = a * b
                "print x",            // Print value of x
                "assign y divide a b",   // y = a / b
                "print y",            // Print value of y
                "assign p subtract a b", // p = a - b
                "print p"
        };

        for (String instruction : instructions) {
            InstructionParser parser = new InstructionParser(instruction, memory);
            parser.parseInstruction();
        }

        System.out.println("\nTest Complete. Verifying final values in memory:");
        System.out.println("Final Memory State:");
        memory.printState();  // Print the final state of memory after execution
    }
}

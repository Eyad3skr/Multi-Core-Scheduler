public class InstructionParser {
    private String instruction;
    private Memory memory;

    public InstructionParser(String instruction, Memory memory) {
        this.instruction = instruction;
        this.memory = memory;
    }

    public void parseInstruction() {
        String[] instructionParts = instruction.split(" ");
        String command = instructionParts[0];

        // Handle "assign" command
        if (command.equals("assign")) {
            String varName = instructionParts[1];
            String operation = instructionParts[2];
            if (operation.equals("add") || operation.equals("subtract") || operation.equals("multiply") || operation.equals("divide")) {
                // lw fe operations, dwr 3la el values w switch 3la el operation
                String var1 = instructionParts[3];
                String var2 = instructionParts[4];

                // check lw mawgodeen asln 3shan mttsw7sh
                int value1 = memory.contains(var1) ? memory.get(var1) : Integer.parseInt(var1);
                int value2 = memory.contains(var2) ? memory.get(var2) : Integer.parseInt(var2);

                int result = 0;
                switch (operation) {
                    case "add":
                        result = value1 + value2;
                        break;
                    case "subtract":
                        result = value1 - value2;
                        break;
                    case "multiply":
                        result = value1 * value2;
                        break;
                    case "divide":
                        if (value2 == 0) {
                            System.out.println("Cannot divide by zero.");
                            return;
                        }
                        result = value1 / value2;
                        break;
                }

                // Store result f el memory
                memory.set(varName, result);
                System.out.println(varName + " = " + result);  // Print el result bta3t el operation
            } else {
                // Handle direct assignment l el variable
                int value = Integer.parseInt(instructionParts[2]);
                memory.set(varName, value);
                System.out.println(varName + " = " + value); //3shan at2kd eno b y get assigned
            }
        } else if (command.equals("print")) { //print command handling brdo 3shan n3rf el value bta3t el variable
            String varName = instructionParts[1];
            if (memory.contains(varName)) {
                System.out.println(varName + " = " + memory.get(varName));
            } else {
                System.out.println("Variable " + varName + " not found.");
            }
        }
    }
}

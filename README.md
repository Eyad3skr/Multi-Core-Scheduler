[Program_1.txt](https://github.com/user-attachments/files/17814228/Program_1.txt)# Multi-Core-Scheduler
## Overview
This project is a basic round-robin scheduling system. It simulates a CPU scheduler in a multi-core environment, where tasks are processed in a round-robin manner across available cores.

## Project Architecture
- `MasterCore`: Manages the overall scheduling of tasks and communicates with the slave cores.
- `SlaveCore`: Executes tasks and reports the status of processes.
- `Memory`: Represents shared memory for storing process variables.
- `PCB`: Represents Process Control Blocks with relevant metadata like program counters.

MasterCore
  |
  |---> ReadyQueue
  |---> Scheduler
  |---> Memory
         |
         |---> Variable Map
  |
  |---> SlaveCore (Thread)
         |
         |---> Process
                 |
                 |---> PCB


## Round-Robin Scheduling Algorithm
- The algorithm runs each process for a fixed time quantum. If the process completes in the time quantum, it finishes execution; otherwise, it's re-added to the queue for the next round.
- The processes are executed on multiple slave cores in a round-robin manner.

  ## Example Usage:
- Assign variable `a` with value `10`
- Assign variable `b` with value `5`
- Add `a` and `b`, assign the result to `z`
- Output the result of `z`

  
**Output:**
a = 10
b = 5
z = 15
z = 15
x = 50
x = 50
y = 2
y = 2
p = 5
p = 5

Test Complete. Verifying final values in memory:
Final Memory State:
Current Memory State: 
p = 5
a = 10
b = 5
x = 50
y = 2
z = 15


  ## Instructions are passed in an array in the main.java class



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
- Assign variable `z` the sum of `a` and `b` (i.e., `z = a + b`)
- Print the value of `z`
- Assign variable `x` the product of `a` and `b` (i.e., `x = a * b`)
- Print the value of `x`
- Assign variable `y` the quotient of `a` divided by `b` (i.e., `y = a / b`)
- Print the value of `y`
- Assign variable `p` the difference between `a` and `b` (i.e., `p = a - b`)
- Print the value of `p`
  
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


![Untitled](https://github.com/user-attachments/assets/1d37e01d-37a5-4ac9-b70b-b9bcb5e471f7)


  > **Disclaimer:** Instructions are passed in an array in the Main.java class.



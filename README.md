# CountingSort
Comparison and distribution count sorting algorithm implementation

This repository includes a simple Python and Scala implementation of the comparison and distribution sorting algorithms. It includes a test run that also measures the execution time of each algorithm.

The measurement results using random array samples can be found below.

## Algorithm Speed Measurements

| n       | ccs-py  | dcs-py  | ccs-sc | dcs-sc |
|---------|---------|---------|--------|--------|
| 100     | 0.798ms | 0.063ms | 3ms    | 2ms    |
| 10000   | 10.56s  | 7.51ms  | 436ms  | 16ms   |
| 50000   | 16.1s   | 111ms   | 11.9s  | 26ms   |
| 1000000 | N/A     | 2s      | N/A    | 186ms  |

**n** - Array Length

**ccs-py** - Comparison Count Sort in Python

**dcs-py** - Distribution Count Sort in Python

**ccs-sc** - Comparison Count Sort in Scala

**dcs-sc** - Comparison Count Sort in Scala
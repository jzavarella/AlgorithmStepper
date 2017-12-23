# Algorithm Stepper
_Created by [Jackson Zavarella](https://www.linkedin.com/in/jackson-zavarella-040183133/)_

This package provides the basic tools to be able to run any algorithm forward or backwards one step at a time.

### [Algorithm Interface](https://github.com/jzavarella/AlgorithmStepper/blob/master/src/main/java/algorithm/Algorithm.java)
This is the interface for an algorithm which can be executed one step/cycle at a time.
The interface has two main functions:
 1. Stepping the algorithm being implemented forward once
 2. Stepping the algorithm being implemented backward once

A single step of the algorithm being implemented follows the following lifecycle (Note that all of these methods exist for each next and previous step functions):
 *  First the pre-step method is executed.
 *  Then the step method is executed.
 *  Finally the post-step method is executed.

If there is an exception in any of the above stages, the corresponding exception method is executed and the user can choose whether to continue through the lifecycle by returning true or false from the exception method.

An example implementation for the fibonacci algorithm can be found [here](https://github.com/jzavarella/AlgorithmStepper/blob/master/src/main/java/algorithm/implementations/Fibonacci.java).

### [Algorithm Stepper](https://github.com/jzavarella/AlgorithmStepper/blob/master/src/main/java/algorithm/stepper/AlgorithmStepper.java)
This class handles the life cycle of an algorithm. It has two main functions, stepping forward and backwards in the algorithm. While stepping forward or backward, the appropriate the algorithm's pre and post steps are called and in the event of an exception, the appropriate exception method is called
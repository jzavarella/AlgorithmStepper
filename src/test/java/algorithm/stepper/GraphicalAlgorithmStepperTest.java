package algorithm.stepper;

import algorithm.implementations.fibonacci.GraphicalFibonacci;

/**
 * This class contains a simple main method that will allow the testing of the GraphicalAlgorithmStepper
 */
public class GraphicalAlgorithmStepperTest {
    /**
     * Instantiates a new AlgorithmStepperUI with a fibonacci Algorithm implementation
     * @param args not used
     */
    public static void main(String[] args) {
        GraphicalAlgorithmStepper gas = new GraphicalAlgorithmStepper(new GraphicalFibonacci());
        gas.setVisible(true);
    }
}

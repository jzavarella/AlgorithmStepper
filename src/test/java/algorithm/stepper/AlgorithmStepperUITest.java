package algorithm.stepper;

import algorithm.implementations.fibonacci.Fibonacci;

/**
 * This class contains a simple main method that will allow the testing of the AlgorithmStepperUI
 */
public class AlgorithmStepperUITest {

    /**
     * Instantiates a new AlgorithmStepperUI with a fibonacci Algorithm implementation
     * @param args not used
     */
    public static void main(String[] args) {
        AlgorithmStepperUI ui = new AlgorithmStepperUI(new Fibonacci());
        ui.setVisible(true);
    }
}

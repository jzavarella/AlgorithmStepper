package algorithmUI;

import algorithm.implementations.Fibonacci;
import algorithm.stepper.AlgorithmStepperUI;

/**
 * This class contains a simple main method that will allow the testing of the AlgorithmStepperUI
 */
public class SimpleAlgorithmUITest {

    /**
     * Instantiates a new AlgorithmStepperUI with a fibonacci Algorithm implementation
     * @param args not used
     */
    public static void main(String[] args) {
        AlgorithmStepperUI ui = new AlgorithmStepperUI(new Fibonacci());
        ui.setVisible(true);
    }
}

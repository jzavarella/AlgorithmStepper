package algorithm.stepper;

import algorithm.Algorithm;

/**
 * Created by Jackson Zavarella
 *
 * This class handles the life cycle of an algorithm. It has two main functions, stepping forward and backwards in the algorithm.
 * While stepping forward or backward, the appropriate the algorithm's pre and post steps are called and in the event of an exception, the appropriate exception method is called
 */
public class AlgorithmStepper {

    protected final Algorithm algorithm;

    /**
     * Constructor for the algorithm stepper.
     * @param algorithm the algorithm that this instance of the algorithm stepper will manipulate. Algorithm is private and final
     */
    public AlgorithmStepper(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * The stepForward method steps the algorithm forward one step.
     * The algorithm methods are called in this order: preNextStep, nextStep, postNextStep.
     * If there is an exception at any of the stages during execution, the appropriate algorithm exception method is called.
     * If the exception method returns true, the method continues where it left off in the lifecycle otherwise the method returns.
     */
    public void stepForward() {
        try {
            algorithm.preNextStep();
        } catch (Exception preNextException) { // Catch any exception thrown by the preNextStepMethod
            if (!algorithm.preNextStepException(preNextException)) {
                return; // If the preNextStepException method returned false, break out of the method
            }
        }
        try {
            algorithm.nextStep();
        } catch (Exception nextException) { // Catch any exception thrown by the nextStepMethod
            if (!algorithm.nextStepException(nextException)) {
                return; // If the nextStepException method returned false, break out of the method
            }
        }
        try {
            algorithm.postNextStep();
        } catch (Exception postNextException) { // Catch any exception thrown by the postNextStepMethod
            if (!algorithm.postNextStepException(postNextException)) {
                return; // If the postNextStepException method returned false, break out of the method
            }
        }
    }

    /**
     * The stepBackward method steps the algorithm backward one step.
     * The algorithm methods are called in this order: prePreviousStep, previousStep, postPreviousStep.
     * If there is an exception at any of the stages during execution, the appropriate algorithm exception method is called.
     * If the exception method returns true, the method continues where it left off in the lifecycle otherwise the method returns at that point.
     */
    public void stepBackward() {
        try {
            algorithm.prePreviousStep();
        } catch (Exception prePreviousException) { // Catch any exception thrown by the preNextStepMethod
            if (!algorithm.prePreviousStepException(prePreviousException)) {
                return; // If the prePreviousStepException method returned false, break out of the method
            }
        }
        try {
            algorithm.previousStep();
        } catch (Exception previousException) { // Catch any exception thrown by the nextStepMethod
            if (!algorithm.previousStepException(previousException)) {
                return; // If the previousStepException method returned false, break out of the method
            }
        }
        try {
            algorithm.postPreviousStep();
        } catch (Exception postPreviousException) { // Catch any exception thrown by the nextStepMethod
            if (!algorithm.postPreviousStepException(postPreviousException)) {
                return; // If the postPreviousStepException method returned false, break out of the method
            }
        }
    }

    /**
     *
     * @return a String representation of the current state of the algorithm
     */
    public String getAlgorithmToString() {
        return algorithm.toString();
    }
}

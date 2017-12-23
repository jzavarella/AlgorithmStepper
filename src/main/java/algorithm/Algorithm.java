package algorithm;

/**
 * Created by Jackson Zavarella
 *
 * This is the interface for an algorithm which can be executed one step/cycle at a time.
 * The interface has two main functions:
 *  1. Stepping the algorithm being implemented forward once
 *  2. Stepping the algorithm being implemented backward once
 *
 * A single step of the algorithm being implemented follows the following lifecycle (Note that all of these methods exist for each next and previous step functions):
 *  First the pre-step method is executed.
 *  Then the step method is executed.
 *  Finally the post-step method is executed.
 *
 *  If there is an exception in any of the above stages, the corresponding exception method is executed and the user can choose whether to continue through the lifecycle by returning true or false from the exception method.
 */
public interface Algorithm {

    /**
     * This method should be run before the nextStep method.
     */
    void preNextStep();

    /**
     * If there was an exception in the preNextStep method, this method should run.
     * @param preNextException The exception that was thrown in the preNextStep method
     * @return true if this should continue to the nextStep method or false if we should not continue
     */
    boolean preNextStepException(Exception preNextException);

    /**
     * This is the main functionality of the algorithm being implemented.
     * It should increment the algorithm being implemented forward once.
     * This method should run after the preNextStep method has finished execution.
     * This method should not run if the preNextStep method threw an exception and the preNextStepException method did not return true.
     */
    void nextStep();

    /**
     * If there was an exception in the nextStep method, this method should run.
     * @param nextException The exception that was thrown in the nextStep method
     * @return true if this should continue to the postNextStep method or false if we should not continue
     */
    boolean nextStepException(Exception nextException);

    /**
     * This method should run after the nextStep method has finished.
     * This method should not run if the nextStep method threw an exception and the nextStepException method did not return true.
     */
    void postNextStep();

    /**
     * If there was an exception in the postNextStep method, this method should run.
     * @param postNextStepException The exception that was thrown in the nextStep method
     * @return the boolean returned here will likely be a flag for the implementation of the interface as there are no other methods that will run after this method terminates
     */
    boolean postNextStepException(Exception postNextStepException);

    /**
     * This method should be run before the previousStep method.
     */
    void prePreviousStep();

    /**
     * If there was an exception in the prePreviousStep method, this method should run.
     * @param prePreviousException The exception that was thrown in the prePreviousStep method
     * @return true if this should continue to the previousStep method or false if we should not continue
     */
    boolean prePreviousStepException(Exception prePreviousException);

    /**
     * This is the main functionality of the algorithm being implemented.
     * It should decrement the algorithm being implemented backwards once.
     * This method should run after the prePreviousStep method has finished execution.
     * This method should not run if the prePreviousStep method threw an exception and the prePreviousStepException method did not return true.
     */
    void previousStep();

    /**
     * If there was an exception in the previousStep method, this method should run.
     * @param previousException The exception that was thrown in the previousStep method
     * @return true if this should continue to the postPreviousStep method or false if we should not continue
     */
    boolean previousStepException(Exception previousException);

    /**
     * This method should run after the previousStep method has finished execution.
     * This method should not run if the previousStep method threw an exception and the previousStepException method did not return true.
     */
    void postPreviousStep();

    /**
     * If there was an exception in the postPreviousStep method, this method should run.
     * @param postPreviousException The exception that was thrown in the previousStep method
     * @return the boolean returned here will likely be a flag for the implementation of the interface as there are no other methods that will run after this method terminates
     */
    boolean postPreviousStepException(Exception postPreviousException);

    /**
     * This method returns some valuable information about the current state of the algorithm
     * @return a string representation describing the current state of the algorithm
     */
    String toString();
}

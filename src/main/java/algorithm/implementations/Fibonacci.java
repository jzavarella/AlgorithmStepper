package algorithm.implementations;

import algorithm.Algorithm;

import java.util.ArrayList;

/**
 * Created by Jackson Zavarella
 *
 * This is a basic implementation of the Algorithm interface.
 * Each step of the algorithm calculates and outputs the next/ previous element in the fibonacci sequence.
 */
public class Fibonacci implements Algorithm {

    private ArrayList<Long> fibonacciNumbers; // Stores all of the generate fibonacci numbers in sequence
    private long currentFibonacciNumber; // Stores the current fibonacci number
    private boolean isOne; // Flag that sores if the current fibonacci number is a 1

    public Fibonacci() {
        fibonacciNumbers = new ArrayList<>();

    }

    /**
     * Checks to see if we actually need to calculate the next fibonacci number.
     * If not sets the isOne flag to false which will notify the nextStep method if we need to calculate the next number.
     */
    @Override
    public void preNextStep() {
        // The first two elements of the sequence are 1
        isOne = fibonacciNumbers.size() < 2;
    }

    /**
     * This should not occur in this implementation but if it does we print the exception stack trace and terminate execution.
     * @param preNextException The exception that was thrown in the preNextStep method
     * @return false to terminate execution of this step in the algorithm step life cycle
     */
    @Override
    public boolean preNextStepException(Exception preNextException) {
        preNextException.printStackTrace();
        return false;
    }

    /**
     * Calculates the next element in the fibonacci sequence and outputs it.
     * If the next element it 1 there is no need to calculate it and 1 is outputted.
     */
    @Override
    public void nextStep() {
        if (!isOne) {
            currentFibonacciNumber = fibonacciNumbers.get(fibonacciNumbers.size() - 1) + fibonacciNumbers.get(fibonacciNumbers.size() - 2); // Calculate the sum last two elements
        } else {
            currentFibonacciNumber = 1;
        }
        System.out.println(currentFibonacciNumber); // Output it

    }

    /**
     * This should not occur in this implementation but if it does we print the exception stack trace and terminate execution.
     * @param nextException The exception that was thrown in the nextStep method
     * @return false to terminate execution of this step in the algorithm step life cycle
     */
    @Override
    public boolean nextStepException(Exception nextException) {
        nextException.printStackTrace();
        return false;
    }

    /**
     * Adds the most recently calculated fibonacci number to the list of fibonacci numbers
     */
    @Override
    public void postNextStep() {
        fibonacciNumbers.add(currentFibonacciNumber);
    }

    /**
     * This should not occur in this implementation but if it does we print the exception stack trace and terminate execution.
     * @param postNextException The exception that was thrown in the postNextStep method
     * @return false to terminate execution of this step in the algorithm step life cycle
     */
    @Override
    public boolean postNextStepException(Exception postNextException) {
        postNextException.printStackTrace();
        return false;
    }

    /**
     * Removes the last number in the fibonacci sequence so the new last number will be the desired previous number.
     */
    @Override
    public void prePreviousStep() {
        fibonacciNumbers.remove(fibonacciNumbers.size() - 1);
    }

    /**
     * This method will be called if the prePreviousStep method attempts to remove the last element of an empty list.
     * This method will notify the user that there are no previous fibonacci numbers via System.out.println
     * @param prePreviousException The exception that was thrown in the prePreviousStep method
     * @return false to terminate execution of this step in the algorithm step life cycle
     */
    @Override
    public boolean prePreviousStepException(Exception prePreviousException) {
        System.out.println("There are no previous elements in the fibonacci sequence");
        return false;
    }

    /**
     * Gets the previous fibonacci number in the sequence and outputs it.
     */
    @Override
    public void previousStep() {
        currentFibonacciNumber = fibonacciNumbers.get(fibonacciNumbers.size() - 1);
        System.out.println(currentFibonacciNumber);
    }

    /**
     * This method will be called if the previousStep method attempts to get the last element of an empty list.
     * This method will notify the user that there are no previous fibonacci numbers via System.out.println.
     * @param previousStepException The exception that was thrown in the previousStep method
     * @return false to terminate execution of this step in the algorithm step life cycle
     */
    @Override
    public boolean previousStepException(Exception previousStepException) {
        System.out.println("There are no previous elements in the fibonacci sequence");
        return false;
    }

    /**
     * This method is empty because no action is needed after the previousStep method executes.
     */
    @Override
    public void postPreviousStep() {

    }

    /**
     * This should not occur in this implementation but if it does we print the exception stack trace and terminate execution.
     * @param postPreviousException The exception that was thrown in the postPreviousStep method
     * @return false to notify the user that there was an error in this stage of the algorithm step lifecycle
     */
    @Override
    public boolean postPreviousStepException(Exception postPreviousException) {
        postPreviousException.printStackTrace();
        return false;
    }

    /**
     *
     * @return a string of all of the fibonacci numbers that have been calculated
     */
    @Override
    public String toString() {
        return fibonacciNumbers.toString();
    }
}

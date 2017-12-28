package algorithm.implementations.fibonacci;

import algorithm.GraphicalAlgorithm;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class provides a graphical representation for the Fibonacci algorithm to be used with the GraphicalAlgorithmStepper
 */
public class GraphicalFibonacci extends Fibonacci implements GraphicalAlgorithm {

    private ArrayList<Shape> rectangles; // Keep track of the rectangles
    int index;

    /**
     * New constructor to keep track of the rectangles
     */
    public GraphicalFibonacci() {
        super();
        rectangles = new ArrayList<>();
        index = 0;
    }

    /**
     * Adds a rectangle to the rectangles ArrayList so it will be painted when draw() is called
     */
    @Override
    public void postNextStep() {
        super.postNextStep();
        rectangles.add(new Rectangle(2,10 * index, Integer.parseInt(fibonacciNumbers.get(fibonacciNumbers.size() - 1) + ""),5));
        index ++;
    }

    /**
     * Removes the last rectangle in the rectangles ArrayList so it will not be painted when draw() is called
     */
    @Override
    public void postPreviousStep() {
        super.postPreviousStep();
        rectangles.remove(rectangles.size() - 1);
        index --;
    }

    /**
     * Draws all of the rectangles currently in the rectangles ArrayList
     * @param g2 The graphics context of where this algorithm is being displayed
     */
    @Override
    public void draw(Graphics2D g2) {
        rectangles.forEach((shape -> g2.draw(shape)));
    }
}

package algorithm;

import java.awt.*;

/**
 * This interface is the graphical implementation for an Algorithm object
 */
public interface GraphicalAlgorithm extends Algorithm {

    /**
     * This method will be used to draw a graphical representation of the algorithm and should be called after the postNextStep() and postPreviousStep() methods
     * @param g2 The graphics context of where this algorithm is being displayed
     */
    void draw(Graphics2D g2);
}

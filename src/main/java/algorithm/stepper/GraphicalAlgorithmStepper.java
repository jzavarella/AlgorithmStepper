package algorithm.stepper;

import algorithm.GraphicalAlgorithm;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * This object extends the AlgorithmStepperUI to include a canvas panel which is a JPanel than can show a graphical representation of the algorithm being manipulated.
 * This will automatically call the GraphicalAlgorithm draw method after the postNextStep() and postPreviousStep() methods found in Algorithm.
 */
public class GraphicalAlgorithmStepper extends AlgorithmStepperUI {

    protected JPanel canvasPanel;
    private GraphicalAlgorithm graphicalAlgorithm;

    /**
     * The constructor for the GraphicalAlgorithmStepper
     *
     * @param graphicalAlgorithm the algorithm that will be manipulated
     */
    public GraphicalAlgorithmStepper(GraphicalAlgorithm graphicalAlgorithm) {
        super(graphicalAlgorithm);
        this.graphicalAlgorithm = graphicalAlgorithm;
        extendUI();
    }

    /**
     * The constructor for the GraphicalAlgorithmStepper
     *
     * @param graphicalAlgorithm the algorithm that will be manipulated
     * @param title the title of the swing
     */
    public GraphicalAlgorithmStepper(GraphicalAlgorithm graphicalAlgorithm, String title) {
        this(graphicalAlgorithm);
        setTitle(title);
    }

    /**
     * Extends the interface from the AlgorithmStepperUI to include the canvasPanel
     */
    private void extendUI() {
        setLocationRelativeTo(null);

        buttonPanel.setBorder(new BevelBorder(1));

        canvasPanel = new AlgorithmCanvas(graphicalAlgorithm);
        canvasPanel.repaint();
        canvasPanel.setBorder(new BevelBorder(1));
        add(canvasPanel);

        pack();
    }

    /**
     * Override the default implementation of stepBackward() so the draw method of the algorithm is called
     */
    @Override
    protected void stepBackward() {
        super.stepBackward();
        canvasPanel.repaint();
    }

    /**
     * Override the default implementation of stepForward() so the draw method of the algorithm is called
     */
    @Override
    protected void stepForward() {
        super.stepForward();
        canvasPanel.repaint();
    }

    /**
     * JPanel that is aware of the GraphicalAlgorithm
     */
    private class AlgorithmCanvas extends JPanel {

        GraphicalAlgorithm graphicalAlgorithm;

        public AlgorithmCanvas(GraphicalAlgorithm graphicalAlgorithm) {
            super();
            this.graphicalAlgorithm = graphicalAlgorithm;
            setPreferredSize(new Dimension(500, 650));
            setMinimumSize(new Dimension(500, 650));
        }

        /**
         * Override the paint component so the draw method of the GraphicalAlgorithm is called
         * @param g
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            graphicalAlgorithm.draw((Graphics2D) g);
        }
    }
}

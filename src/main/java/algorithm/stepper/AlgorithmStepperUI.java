package algorithm.stepper;

import algorithm.Algorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Jackson Zavarella
 *
 * This class is a thin UI wrapper for the AlgorithmStepper providing the user the ability to use an AlgorithmStepper in the form of a forward and backward button.
 * This extends JFrame.
 */
public class AlgorithmStepperUI extends JFrame {

    private final Algorithm algorithm;
    private final AlgorithmStepper algorithmStepper;

    /**
     * The constructor for the AlgorithmStepperUI
     * @param algorithm the algorithm that will be manipulated
     */
    public AlgorithmStepperUI(Algorithm algorithm) {
        super("Stepper");

        this.algorithm = algorithm;
        this.algorithmStepper = new AlgorithmStepper(this.algorithm);

        createUI();

    }

    /**
     * Positions all of the JFrame components on the swing as well as sets the functionality of the back and forward buttons.
     */
    private void createUI() {
        setSize(new Dimension(300, 100));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setResizable(false);

        // Create a back button and add the stepBackward functionality to it
        JButton previousStepButton = new JButton("<-");
        previousStepButton.addActionListener((ActionEvent e) -> algorithmStepper.stepBackward());
        add(previousStepButton);

        // Create a forward button and add the stepForward functionality to it
        JButton nextStepButton = new JButton("->");
        nextStepButton.addActionListener((ActionEvent e) -> algorithmStepper.stepForward());
        add(nextStepButton);

        pack();
    }
}

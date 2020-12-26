import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MagicSquareController implements ActionListener {

    private final MagicSquareModel msm;
    private final ArrayList<Integer> inputValues;

    public MagicSquareController(MagicSquareModel msm) {
        this.msm = msm;
        inputValues = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String [] coordinates = e.getActionCommand().split(" ");
        String value = JOptionPane.showInputDialog("Number between 1 and " + (int) Math.pow(msm.getSIZE(), 2));
        if(Integer.parseInt(value) >= 1 && Integer.parseInt(value) <= (int) Math.pow(msm.getSIZE(), 2) && !inputValues.contains(Integer.parseInt(value))) {
            inputValues.add(Integer.parseInt(value));
            msm.play(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), Integer.parseInt(value));
        } else {
            actionPerformed(e);
        }
    }
}

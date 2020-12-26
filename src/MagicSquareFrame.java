import javax.swing.*;
import java.awt.*;

public class MagicSquareFrame extends JFrame implements MagicSquareView {

    private final JButton[][] buttons;

    public MagicSquareFrame() {
        super("Magic Square!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MagicSquareModel msm = new MagicSquareModel(3);
        this.setLayout(new GridLayout(msm.getSIZE(), msm.getSIZE()));
        msm.addMagicSquareView(this);
        MagicSquareController msc = new MagicSquareController(msm);
        buttons = new JButton[msm.getSIZE()][msm.getSIZE()];
        for (int i = 0; i < msm.getSIZE(); i++) {
            for (int j = 0; j < msm.getSIZE(); j++) {
                JButton b = new JButton(" ");
                buttons[i][j] = b;
                b.addActionListener(msc);
                b.setActionCommand(i + " " + j);
                this.add(b);
            }
        }
        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void handleMagicSquareUpdate(MagicSquareEvent e) {
        int x = e.getX();
        int y = e.getY();
        buttons[x][y].setText(e.getValue() + "");
        decideWinner(e.getStatus());
    }

    public void decideWinner(MagicSquareModel.Status e) {
        if (e == MagicSquareModel.Status.MAGIC_SQUARE) {
            JOptionPane.showMessageDialog(this, "WINNER! MAGIC SQUARE!");
        } else if (e == MagicSquareModel.Status.NONMAGIC_SQUARE) {
            JOptionPane.showMessageDialog(this, "LOSER! NON MAGIC SQUARE!");
        }
    }

    public static void main(String[] args) {
        new MagicSquareFrame();
    }
}

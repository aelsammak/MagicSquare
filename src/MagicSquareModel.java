import java.util.ArrayList;
import java.util.List;

public class MagicSquareModel {

    private int SIZE;
    private int[][] grid;
    private Status status;
    private List<MagicSquareView> MagicSquareViews;
    public enum Status {MAGIC_SQUARE, NONMAGIC_SQUARE, UNDECIDED}

    public MagicSquareModel(int size) {
        this.SIZE = size;
        grid = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        status = Status.UNDECIDED;
        MagicSquareViews = new ArrayList<>();
    }

    public void addMagicSquareView(MagicSquareView msv) {
        MagicSquareViews.add(msv);
    }

    public void removeMagicSquareView(MagicSquareView msv) {
        MagicSquareViews.remove(msv);
    }

    public int getSIZE() { return SIZE; }

    public Status getStatus() { return status; }

    private Status updateStatus() {
        int sum = (int) ((SIZE * (Math.pow(SIZE, 2) + 1)) / 2);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(grid[i][j] == ' ') {
                    return Status.UNDECIDED;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            int tempRows = 0;
            int tempCols = 0;
            for (int j = 0; j < SIZE; j++) {
                tempRows += grid[i][j];
                tempCols += grid[j][i];
                if(j == SIZE-1 && (tempRows != sum || tempCols != sum)) {
                    return Status.NONMAGIC_SQUARE;
                }
            }
        }

        int tempDia = 0;
        for(int i = 0; i < SIZE; i++) {
            tempDia += grid[i][i];
            if(i == SIZE-1 && tempDia != sum) {
                return Status.NONMAGIC_SQUARE;
            }
        }

        return Status.MAGIC_SQUARE;
    }

    public void play(int x,int y, int value) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = value;
        status = updateStatus();
        for(MagicSquareView msv : MagicSquareViews) msv.handleMagicSquareUpdate(new MagicSquareEvent(this, status, x, y, value));
    }
}

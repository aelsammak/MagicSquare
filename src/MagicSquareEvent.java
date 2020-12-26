import java.util.EventObject;

public class MagicSquareEvent extends EventObject {

    private final MagicSquareModel.Status status;
    private final int x;
    private final int y;
    private final int value;

    public MagicSquareEvent(MagicSquareModel msm, MagicSquareModel.Status status, int x, int y, int value) {
        super(msm);
        this.status = status;
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getValue() { return value; }

    public MagicSquareModel.Status getStatus() { return status; }

}

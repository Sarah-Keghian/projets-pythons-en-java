package classeDe;
import java.util.Random;

public class De {
    private int position;
    public De(int startPosition) {
        this.position = startPosition;
    }
    public De(){
        this.position = 1;
    }
    public int getPosition() {
        return this.position;
    }
    public De lancer(){
        var random = new Random();
        this.position = random.nextInt(1,7);
        return this;
    }
}

import java.util.List;

public class Douane extends Thread {
    private List<Vrachtwagen> wachtrij;

    public Douane(List<Vrachtwagen> wachtrij) {
        this.wachtrij = wachtrij;
    }
    @Override
    public void run() {
        for (Vrachtwagen v : wachtrij) {
            if (check(v.getContainer())) {
                System.out.println("Geweigerd door de douane: " + v.getContainer().getInhoud());
            }
        }
    }

    public boolean check(Container c) {
        String inhoud = c.getInhoud();
        int som = 0;
        for (char ch : inhoud.toCharArray()) {
            som += (int) ch;
        }
        return (som % 17 < 2); // All hail the magic number
    }
}

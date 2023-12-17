public class App {
    public static void main(String[] args) {
        int jackpot = 10;
        long wingeld = 0;  // int, long, double of float?
        for (int i = 0; i < LotteryNumbers.winningNumbers.length; i++) {
            for (int j = 0; j < LotteryNumbers.lotteryTickets.length; j++) {
                // We zitten 2 tabs diep en hebben nog meer loops nodig
                // Zet die loops weg in een losse functie om de code leesbaar te houden
                wingeld +=   checkLot(LotteryNumbers.winningNumbers[i], 
                                      LotteryNumbers.lotteryTickets[j])
                           * jackpot; 
            }
            jackpot *= 100;
        }
        System.out.println("Totaal wingeld: "+wingeld/50+" euro.");
        // vergeet de 1/50 niet :^)
        // int:    -40567080
        // float:  2.17130928E8
        // long:   217130957
        // double: 2.1713095708E8
    }

    // Returnt int tussen 0 en 5 om te bepalen welk deel van de jackpot je krijgt
    public static int checkLot(int[] win, int[] lot) {
        int count = 0;
        for(int i = 0; i < win.length; i++) {
            for(int j = 0; j < lot.length; j++) {
                if (win[i] == lot[j]) count++;
            }
        }
        return count;
    }
}
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Twnety-One. The game that is NOT Blackjack, but exactly like it!");
        //player cards dealt
        int playerFirstCard = dealCard();
        int playerSecondCard = dealCard();
        int playerTotal = (playerFirstCard + playerSecondCard);
        System.out.println("You were dealt a " + playerFirstCard + " and a " + playerSecondCard + ".");
        System.out.println("Your total is " + playerTotal);
        //dealer cards dealt
        int dealerFirstCard = dealCard();
        int dealerSecondCard = dealCard();
        int dealerTotal = (dealerFirstCard + dealerSecondCard);
        System.out.println("The dealer has a  " + dealerFirstCard + " and a hidden card..");
        System.out.println("The dealer's total is also hidden");
        System.out.println("Would you like to \"hit\" or \"stand\"");
        String hitOrMiss = scanner.nextLine();
        //player getting more cards
        while (hitOrMiss.equals("hit")) {
            int playerAddCard = dealCard();
            playerTotal = (playerTotal + playerAddCard);
            if (playerTotal > 21) {
                System.out.println("Sorry mate, you busted at " + playerTotal + " so you lost immediately.");
                System.exit(0);
            } else {
                System.out.println("Your total is " + playerTotal);
                hitOrMiss = scanner.next();
            }
        }
        System.out.println("Ok now it's the dealers turn.\nThe dealer has flipped over the hidden card.");
        System.out.println("The hidden card is " + dealerSecondCard + ".");
        System.out.println("The dealer's total is " + dealerTotal + ".");
        while (dealerTotal < 17) {
            int dealerAddCard = dealCard();
            System.out.println("The dealer is dealt a " + dealerAddCard + ".");
            dealerTotal = (dealerTotal + dealerAddCard);
            System.out.println("The dealer's total is " + dealerTotal + ".");
        }
            if (dealerTotal > 21){
                System.out.println("The dealer busted at " + dealerTotal +" so you win automatically.");
            }else if (dealerTotal >= playerTotal){
                System.out.println("The dealer wins! I knew you couldn't do it.");
            }else{
                System.out.println("You win! Good job... I guess. To be honest I didn't think you would win.");
            }
    }
    static int dealCard () {
        final int MIN = 2;
        final int MAX = 11;
        Random randNumGenerator = new Random();
        return randNumGenerator.nextInt(MAX - 1) + MIN;
    }
}
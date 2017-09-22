import java.util.*;

public class BlackJack {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random cardGenerator = new Random();

        int gameNumber = 0;
        double gamesPlayed = 0;
        int playerCardNumber = 0;
        int handValue = 0; // player's hand value
        int handValueAugmented = 0; // reserves hand value from previous turn to add to value gained next turn
        int dealersHandValue = 0;
        int dealerWins = 0;
        double playerWins = 0;
        int tieGames = 0;
        double percentageWins = 0;
        String menuChoice = "menu";

        while (!menuChoice.equals("4")) {

            if (menuChoice.equals("3")) {
                gameNumber = gameNumber - 1;

            }
                if (handValue > 21 || handValue == 0) {
                    System.out.println("START GAME #" + (gameNumber + 1) +"\n");

                    gameNumber = gameNumber + 1;


                    playerCardNumber = cardGenerator.nextInt(13) + 1;


                    if (playerCardNumber == 1) {
                        System.out.println("Your card is an ACE!");

                    } else if (playerCardNumber >= 2 && playerCardNumber <= 10) {
                        System.out.println("Your card is a " + playerCardNumber + "!");

                    } else if (playerCardNumber == 11) {
                        System.out.println("Your card is a JACK!");

                    } else if (playerCardNumber == 12) {
                        System.out.println("Your card is a QUEEN!");

                    } else {
                        System.out.println("Your card is a KING!");
                    }

                    if (playerCardNumber >= 1 && playerCardNumber <= 10) {
                        handValue = playerCardNumber;
                    } else {
                        handValue = 10;
                    }
                    handValueAugmented = handValue;
                    System.out.println("Your hand is: " + handValue + "\n");

                }

                System.out.println("1. Get another card\n2. Hold hand\n3. Print game statistics\n4. Exit\n");
                System.out.print("Choose an option: ");
                menuChoice = scnr.nextLine();

                switch (menuChoice) {
                    case "1":

                        playerCardNumber = cardGenerator.nextInt(13) + 1;

                        if (playerCardNumber == 1) {
                            System.out.println("\nYour card is an ACE!");

                        } else if (playerCardNumber >= 2 && playerCardNumber <= 10) {
                            System.out.println("\nYour card is a " + playerCardNumber + "!");

                        } else if (playerCardNumber == 11) {
                            System.out.println("\nYour card is a JACK!");

                        } else if (playerCardNumber == 12) {
                            System.out.println("\nYour card is a QUEEN!");

                        } else {
                            System.out.println("\nYour card is a KING!");
                        }

                        if (playerCardNumber >= 1 && playerCardNumber <= 10) {
                            handValue = handValueAugmented + playerCardNumber;
                        } else {
                            handValue = handValueAugmented + 10;
                        }

                        handValueAugmented = handValue;

                        System.out.println("Your hand is: " + handValue + "\n");

                        if (handValue >= 21) {         //puts dealer statement first, allows for more than one round
                            dealersHandValue = cardGenerator.nextInt(11) + 16;
                            if (handValue == 21 && dealersHandValue != 21) {
                                System.out.println("Dealer's hand: " + dealersHandValue);
                                System.out.println("Your hand is: " + handValue + "\n");
                                System.out.println("You win!\n");
                                playerWins = playerWins + 1;

                            } else if (dealersHandValue == 21 && handValue != 21 ) {
                                System.out.println("Dealer's hand: " + dealersHandValue);
                                System.out.println("Your hand is: " + handValue + "\n");
                                System.out.println("Dealer wins!\n");
                                dealerWins = dealerWins + 1;

                            } else if (dealersHandValue > 21 && handValue <= 21){
                                System.out.println("Dealer's hand: " + dealersHandValue);
                                System.out.println("Your hand is: " + handValue + "\n");
                                System.out.println("You win!\n");
                                playerWins = playerWins + 1;
                            } else if (handValue > 21 && dealersHandValue <= 21) {
                                System.out.println("You exceeded 21! You lose :(\n");
                                dealerWins = dealerWins + 1;
                            } else if ((handValue == dealersHandValue) || ( handValue > 21 && dealersHandValue > 21 ) ) {
                                System.out.println("Dealer's hand: " + dealersHandValue);
                                System.out.println("Your hand is: " + handValue + "\n");
                                System.out.println("It's a tie! No one wins!\n");
                                tieGames = tieGames + 1;
                            }
                            gamesPlayed = gamesPlayed + 1;
                            break;
                        }
                        break;
                    case "2":
                        dealersHandValue = cardGenerator.nextInt(11) + 16;
                        System.out.println("\nDealer's hand: " + dealersHandValue);
                        System.out.println("Your hand is: " + handValue + "\n");
                        if (dealersHandValue > handValue && dealersHandValue <= 21) {
                            System.out.println("Dealer wins!\n");
                            dealerWins = dealerWins + 1;

                        } else if (dealersHandValue < handValue) {
                            System.out.println("You win!\n");
                            playerWins = playerWins + 1;

                        } else if (dealersHandValue > 21) {
                            System.out.println("You win!\n");
                            playerWins = playerWins + 1;

                        } else {
                            System.out.println("It's a tie! No one wins!\n");
                            tieGames = tieGames + 1;
                        }
                        gamesPlayed = gamesPlayed + 1;
                        break;
                    case "3":
                        System.out.println("\nNumber of Player wins: " + playerWins);
                        System.out.println("Number of Dealer wins: " + dealerWins);
                        System.out.println("Number of tie games: " + tieGames);
                        System.out.println("Total # of games played is: " + gamesPlayed);
                        if (gamesPlayed == 0) {
                            System.out.println("");
                        }
                        if (gamesPlayed > 0) {
                            percentageWins = (playerWins / gamesPlayed) * 100;
                            System.out.println("Percentage of Player wins: " + percentageWins + "%\n");
                        }
                        break;
                    case "4":
                        break;
                    default:
                        System.out.println("Not a valid input! Please enter an integer value between 1 and 4.");
                }
            }
    }
}
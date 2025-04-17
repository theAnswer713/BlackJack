package com.lucag;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to the Blackjack Program!");
        System.out.println("What is your name?");
        Scanner scan=new Scanner(System.in);
        String name=scan.nextLine();

        Player player=new Player(name);
        Player computer=new Player("Dealer");

        boolean playing=true;
        int w=0;
        int l=0;

        while(playing) {
            Deck deck = new Deck();
            deck.Shuffle();

            player.getHand().clear();
            computer.getHand().clear();

            player.getHand().add(deck.dealCard());
            computer.getHand().add(deck.dealCard());
            player.getHand().add(deck.dealCard());
            computer.getHand().add(deck.dealCard());

            System.out.println(player);
            System.out.println("The dealer has: " + computer.getHand().get(0));

            if (player.blackjackValue()==21) {
                System.out.println("You have a blackjack. You win!");
                w++;
            }
            else if(computer.blackjackValue()==21) {
                System.out.println("The dealer has a blackjack. You lose.");
                l++;
            }
            else {
                String reply = "";
                do {
                    System.out.println("Do you want to hit or stay?");
                    reply = scan.nextLine();
                    if (reply.equalsIgnoreCase("hit")) {
                        player.getHand().add(deck.dealCard());
                        if (player.blackjackValue() > 21) {
                            System.out.println("You busted!");
                            break;
                        }
                        System.out.println(player);
                    } else System.out.println("You stayed.");
                } while (reply.equalsIgnoreCase("hit"));

                while (computer.blackjackValue() <= 16) {
                    computer.getHand().add(deck.dealCard());
                }

                System.out.println(player);
                System.out.println(computer);
                if (player.blackjackValue() > 21) {
                    System.out.println("You lose because you busted.");
                    l++;
                } else if (computer.blackjackValue() > 21) {
                    System.out.println("You win because the dealer busted.");
                    w++;
                } else if (player.blackjackValue() > computer.blackjackValue()) {
                    System.out.println("You win because your hand is better.");
                    w++;
                } else if (player.blackjackValue() < computer.blackjackValue()) {
                    System.out.println("You lose because the dealer's hand is better.");
                    l++;
                } else {
                    System.out.println("You lose because you tied with the dealer.");
                    l++;
                }
            }
                System.out.println("Your record: " + w + "-" + l);
                System.out.println("Do you want to play again?");
                if (scan.nextLine().equalsIgnoreCase("no")) {
                    System.out.println("Goodbye!");
                    playing = false;
                }
                else System.out.println("Let's play again!");

        }
    }
}

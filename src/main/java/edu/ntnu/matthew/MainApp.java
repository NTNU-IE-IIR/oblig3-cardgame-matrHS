package edu.ntnu.matthew;

import edu.ntnu.matthew.UI.PokerCheck;
import java.util.Collection;
import java.util.List;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

public class MainApp {
  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    Hand hand = deck.dealHand(5);
    printCards(hand.getHand());
    System.out.println(hand.checkHand());
    //PokerCheck.runApplication(args);
  }
  
  
  public static void printCards(Collection<PlayingCard> cards) {
    for (PlayingCard card : cards) {
      System.out.println(card.getFace() + " of " + card.getSuit());
    }
  }
}

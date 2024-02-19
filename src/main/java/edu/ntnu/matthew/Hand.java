package edu.ntnu.matthew;

import java.util.ArrayList;
import java.util.Collection;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

public class Hand {
  private ArrayList<PlayingCard> hand;
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  
  public Hand() {
    this.hand = new ArrayList<PlayingCard>();
  }

  /**
   * Method for filling the hand with cards.
   * 
   * @param cards The cards to fill the hand with.
   */
  public void fillHand(Collection<PlayingCard> cards) {
    if (cards == null) {
      throw new IllegalArgumentException("Cards cannot be null");
    }
    
    this.hand = new ArrayList<PlayingCard>(cards);
  }
  
  /**
   * Method for adding a card to the hand.
   * 
   * @param card The card to add to the hand.
   * @throws IllegalArgumentException if card is null.
   */
  public void addCard(PlayingCard card) {
    if (card == null) {
      throw new IllegalArgumentException("Card cannot be null");
    }
    
    this.hand.add(card);
  }
  
  /**
   * Method for removing a card from the hand.
   * 
   * @param card The card to remove from the hand.
   * @throws IllegalArgumentException if card is null.
   */
  public void removeCard(PlayingCard card) {
    if (card == null) {
      throw new IllegalArgumentException("Card cannot be null");
    }

    this.hand.remove(card);
  }
  
  /**
   * Method for getting the hand.
   * 
   * @return The hand.
   */
  public Collection<PlayingCard> getHand() {
    return this.hand;
  }

  /**
   * Checks the hand for a winning combination.
   * 
   */
  public void checkHand() {
    Collection<PlayingCard> checkHand = this.getHand();
    ArrayList<PlayingCard> checkedCards = new ArrayList<PlayingCard>();
    int[] suitCount = new int[4];
    int[] faceCount = new int[13];
    int pairs = 0;
    int threes = 0;
    int fours = 0;
    int flush = 0;
    
    for (PlayingCard card : checkHand) {
      for (int i = 0; i < suits.length; i++) {
        if (card.getSuit() == suits[i]) {
          suitCount[i]++;
        }
      }
      faceCount[card.getFace()-1]++;
      
      checkedCards.add(card);
    }
    
    for (int suitTotal : suitCount) {
      switch (suitTotal) {
        case 5:
          flush++;
          break;
        default:
          break;
      }
    }

    for (int faceTotal : faceCount) {
      switch (faceTotal) {
        case 2:
          pairs++;
          break;
        case 3:
          threes++;
          break;
        case 4:
          fours++;
          break;
        default:
          break;
      }
    }
    
    System.out.println("Pairs: " + pairs);
    System.out.println("Threes: " + threes);
    System.out.println("Fours: " + fours);
    System.out.println("Flush: " + flush);
  }
}

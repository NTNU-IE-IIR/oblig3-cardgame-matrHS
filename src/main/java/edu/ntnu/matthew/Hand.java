package edu.ntnu.matthew;

import java.util.ArrayList;
import java.util.Collection;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

public class Hand {
  private ArrayList<PlayingCard> hand;
  
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
  }
}

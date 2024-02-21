package edu.ntnu.matthew;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
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
  public boolean checkHand() {
    Collection<PlayingCard> checkHand = this.getHand();
    
    int faceSum = checkHand
        .stream()
        .mapToInt((PlayingCard card) -> {
          return card.getFace();
        }).sum();
    
    List<String> numHearts = checkHand
        .stream()
        .filter((PlayingCard card) -> {
          return card.getSuit() == 'H';
        }).map((PlayingCard card) -> {
          return card.getAsString();
        })
        .toList();
    
    boolean sQ = checkHand
        .stream()
        .anyMatch((PlayingCard card) -> {
          return card.getSuit() == 'S' && card.getFace() == 12;
        });
    
    boolean flush = checkHand
        .stream()
        .collect(Collectors.groupingBy(PlayingCard::getSuit,Collectors.counting()))
        .containsValue(5);
    
    return flush;
  }
}

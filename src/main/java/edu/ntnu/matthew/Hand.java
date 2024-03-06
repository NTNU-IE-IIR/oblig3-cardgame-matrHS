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
  public void checkHand() {
    
    int faceSum = getSumOfHand();
    List<String> numHearts = getHeartCards();
    boolean sQ = checkSpadeQueen();
    boolean flush = checkFlush();
    
  }

  /**
   * Checks if the hand contains a flush.
   * 
   * @return True if the hand contains a flush, false otherwise.
   */
  public boolean checkFlush() {
    return this.hand
        .stream()
        .map((PlayingCard card) -> {
          return card.getSuit();
        })
        .collect(Collectors.groupingBy((Character suit) -> {
          return suit.charValue();
        }, Collectors.counting()))
        .values()
        .stream()
        .anyMatch(c -> c >= 5);
  }

  /**
   * Checks if the hand contains the queen of spades.
   * 
   * @return True if the hand contains the queen of spades, false otherwise.
   */
  public boolean checkSpadeQueen() {
    return this.hand
        .stream()
        .anyMatch((PlayingCard card) -> {
          return card.getSuit() == 'S' && card.getFace() == 12;
        });
  }

  /**
   * Takes in a collection of playing cards and returns the heart cards.
   * 
   * @return List of heart cards.
   */
  public List<String> getHeartCards() {
    return this.hand
        .stream()
        .filter((PlayingCard card) -> {
          return card.getSuit() == 'H';
        }).map((PlayingCard card) -> {
          return card.getAsString();
        })
        .toList();
  }

  /**
   * Takes in a collection of playing cards and returns the sum of the cards.
   * 
   * @return The sum of the cards.
   */
  public int getSumOfHand() {
    return this.hand
        .stream()
        .mapToInt((PlayingCard card) -> {
          return card.getFace();
        }).sum();
  }
}

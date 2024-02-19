package edu.ntnu.matthew;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

/**
 * Represents a deck of cards.
 */
public class DeckOfCards {
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private ArrayList<PlayingCard> deck;

  /**
   * Constructor for the deck.
   * Fills deck with 52 cards, 13 of each suit.
   */
  public DeckOfCards() {
    this.deck = new ArrayList<PlayingCard>();
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        this.addCard(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Adds a card to the deck.
   * 
   * @param card The card to add to the deck.
   * @throws IllegalArgumentException if card is null.
   */
  public void addCard(PlayingCard card) {
    if (card == null) {
      throw new IllegalArgumentException("Card cannot be null");
    }
    
    this.deck.add(card);
  }

  /**
   * Returns number of cards representing hand.
   * 
   * @param n Number of cards to deal.
   * @return Collection of cards representing hand.
   */
  public Collection<PlayingCard> dealHand(int n) {
    Collection<PlayingCard> hand = new ArrayList<PlayingCard>();
    PlayingCard foundCard;
    Random random = new Random();
    
    for (int i = 0; i < n; i++) {
      foundCard = this.deck.get(random.nextInt(this.deck.size()));
      hand.add(foundCard);
      this.deck.remove(foundCard);
    }
    
    return hand;
  }
  
  /**
   * Returns entire deck as collection.
   * 
   * @return Collection of cards representing deck.
   */
  public Collection<PlayingCard> getDeck() {
    return this.deck;
  }
}

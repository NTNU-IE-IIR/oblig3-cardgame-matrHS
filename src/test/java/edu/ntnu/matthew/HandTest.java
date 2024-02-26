package edu.ntnu.matthew;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandTest {
  
  DeckOfCards deck;
  Hand flushHand;
  Hand sQHand;
  Hand heartHand;
  
  @BeforeEach
  void initialSetup() {
    this.deck = new DeckOfCards();
    
    this.flushHand = new Hand();
    this.flushHand.addCard(new PlayingCard('H', 1));
    this.flushHand.addCard(new PlayingCard('H', 2));
    this.flushHand.addCard(new PlayingCard('H', 3));
    this.flushHand.addCard(new PlayingCard('H', 4));
    this.flushHand.addCard(new PlayingCard('H', 5));
    
    this.sQHand = new Hand();
    this.sQHand.addCard(new PlayingCard('S', 12));
    this.sQHand.addCard(new PlayingCard('D', 10));
    
    this.heartHand = new Hand();
    this.heartHand.addCard(new PlayingCard('H', 1));
    this.heartHand.addCard(new PlayingCard('H', 2));
    this.heartHand.addCard(new PlayingCard('D', 3));
    this.heartHand.addCard(new PlayingCard('C', 3));
  }

  /**
   * Positive test:
   * Test that the constructor of Hand creates a Hand object.
   */
  @Test
  void testValidConstructor() {
    Hand hand = new Hand();
    assertNotNull(hand);
  }

  /**
   * Positive test:
   * Test that the fillHand method fills the hand with cards.
   */
  @Test
  void testFillHand() {
    Hand hand = new Hand();
    hand.fillHand(this.deck.dealHand(5).getHand());
    assertEquals(5, hand.getHand().size());
  }
  
  
  /**
   * Negative test:
   * Test that the fillHand method throws an IllegalArgumentException when given a null argument.
   */
  @Test
  void testFillHandNull() {
    Hand hand = new Hand();
    assertThrows(IllegalArgumentException.class, () -> hand.fillHand(null));
  }
  
  /**
   * Positive test:
   * Test that the addCard method adds a card to the hand.
   */
  @Test
  void testAddCard() {
    Hand hand = new Hand();
    hand.addCard(new PlayingCard('H', 1));
    assertEquals(1, hand.getHand().size());
  }
  
  /**
   * Negative test:
   * Test that the addCard method throws an IllegalArgumentException when given a null argument.
   */
  @Test
  void testAddCardNull() {
    Hand hand = new Hand();
    assertThrows(IllegalArgumentException.class, () -> hand.addCard(null));
  }
  
  /**
   * Positive test:
   * Test that the removeCard method removes a card from the hand.
   */
  @Test
  void testRemoveCard() {
    Hand hand = new Hand();
    PlayingCard card = new PlayingCard('H', 1);
    hand.addCard(card);
    hand.removeCard(card);
    assertEquals(0, hand.getHand().size());
  }
  
  /**
   * Negative test:
   * Test that the removeCard method throws an IllegalArgumentException when given a null argument.
   */
  @Test
  void testRemoveCardNull() {
    Hand hand = new Hand();
    assertThrows(IllegalArgumentException.class, () -> hand.removeCard(null));
  }

  /**
   * Positive test:
   * Check that hand contains flush.
   * Check that hand contains Queen of Spades
   * Check that hand returns all hearts.
   * Check that hand returns sum of faces.
   */
  @Test
  void testCheckHand() {
    String heartCards = "";
    String expectedHeartCards = "H1H2";
    
    for (String card : this.heartHand.getHeartCards()) {
      heartCards += card;
    }
    
    assertTrue(this.flushHand.checkFlush());
    assertTrue(this.sQHand.checkSpadeQueen());
    assertEquals(expectedHeartCards, heartCards);
    assertEquals(9, this.heartHand.getSumOfHand());
  }



}
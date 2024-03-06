package edu.ntnu.matthew;

import edu.ntnu.matthew.UI.PokerView;
import java.io.FileNotFoundException;

public class PokerViewController {
  private PokerView view;
  private Hand hand;
  private DeckOfCards deck;
  private int handSize;
  
  public PokerViewController(PokerView view) {
    this.view = view;
    setHandSize(5);
    createDeck();
  }

  private void createDeck() {
    this.deck = new DeckOfCards();
  }

  /**
   * Sets the size of the hand to be dealt.
   * 
   * @param handSize The size of the hand to be dealt.
   */
  public void setHandSize(int handSize) {
    this.handSize = handSize;
  }
  
  /**
   * This method is called when the user clicks the "Deal" button.
   */
  public void dealHand() {
    try {
      this.hand = this.deck.dealHand(this.handSize);
      this.view.addCardsToHand(this.hand);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      this.deck = new DeckOfCards();
    }
    view.updateDeckCount(this.deck.getDeck().size());
  }

  public void checkHand() {
    this.view.setSumLabel(this.hand.getSumOfHand());
    this.view.setHeartString(this.hand.getHeartCards());
    this.view.setFlushResult(this.hand.checkFlush());
    this.view.setQSpadeResult(this.hand.checkSpadeQueen());
  }
}

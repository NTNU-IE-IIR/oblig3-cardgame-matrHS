package edu.ntnu.matthew;

import edu.ntnu.matthew.UI.PokerView;

public class PokerViewController {
  private PokerView view;
  private Hand hand;
  private DeckOfCards deck;
  
  public PokerViewController(PokerView view) {
    this.deck = new DeckOfCards();
    this.view = view;
  }

  /**
   * This method is called when the user clicks the "Deal" button.
   */
  public void dealHand() {
    this.hand = this.deck.dealHand(5);
    try {
      this.view.addCardsToHand(this.hand);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package edu.ntnu.matthew.UI;

import edu.ntnu.matthew.DeckOfCards;
import edu.ntnu.matthew.Hand;
import edu.ntnu.matthew.PokerViewController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

public class PokerView extends Application {
  String sumString;
  String heartString;
  private PokerViewController pokerViewController;
  private FlowPane cards;
  private Label sumResult;
  private Label sumHearts;
  private Label flushResult;
  private Label qSpadeResult;
  
  public static void runApplication(String[] args) {
    launch();
  }

  /**
   * Called when Deal button is pressed.
   * Called from controller.
   * 
   * @param hand The hand to be displayed
   * @throws FileNotFoundException If the image file is not found
   */
  public void addCardsToHand(Hand hand) throws FileNotFoundException {
    cards.getChildren().clear();
    for (PlayingCard card : hand.getHand()) {
      Image cardImage = new Image(new FileInputStream("cards/" + card.getAsString() + ".png"));
      ImageView cardImageView = new ImageView(cardImage);
      cardImageView.setPreserveRatio(true);
      cardImageView.setFitHeight(100);
      cards.getChildren().add(cardImageView);
    }
  }

  /**
   * Called when the sum of the hand is calculated.
   * 
   * @param heartString The sum of hearts
   */
  public void setHeartString(String heartString) {
    this.heartString = heartString;
    sumHearts.setText(heartString);
  }
  
  /**
   * Called when the flush is calculated.
   * 
   * @param flushResult The result of the flush
   */
  public void setFlushResult(String flushResult) {
    this.flushResult.setText(flushResult);
  }
  
  /**
   * Called when the queen of spades is checked.
   * 
   * @param qSpadeResult The result of the queen of spades
   */
  public void setQSpadeResult(String qSpadeResult) {
    this.qSpadeResult.setText(qSpadeResult);
  }
  
  /**
   * Called when the sum of the hand is calculated.
   * 
   * @param sumString The sum of the hand
   */
  public void setSumString(String sumString) {
    this.sumString = sumString;
    sumResult.setText(sumString);
  }
  
  @Override
  public void start(Stage stage) throws Exception {
    
    pokerViewController = new PokerViewController(this);
    
    // Constructs the "main" BorderPane that all components get added to
    BorderPane mainLayout = new BorderPane();
    mainLayout.setPadding(new Insets(4));
    
    // Constructs a Hbox to display the cards and adds it to center
    cards = new FlowPane();
    cards.setMinSize(200,200);
    cards.setBackground(Background.fill(Color.GREEN));
    cards.alignmentProperty().setValue(Pos.CENTER);
    cards.borderProperty().setValue(Border.stroke(Color.BLACK));
    cards.setPadding(new Insets(10));
    mainLayout.setCenter(cards);
    
    // Constructs the buttons to add to the Right
    VBox cardButtons = new VBox();
    cardButtons.setSpacing(10);
    cardButtons.alignmentProperty().setValue(Pos.CENTER);
    cardButtons.setPadding(new Insets(8));
    mainLayout.setRight(cardButtons);
    
    Button deal = new Button("Deal Hand");
    deal.setMinWidth(90);
    cardButtons.getChildren().add(deal);
    deal.setOnAction((ActionEvent event) -> {
      pokerViewController.dealHand();
    });
    
    
    Button check = new Button("Check hand");
    check.setMinWidth(90);
    cardButtons.getChildren().add(check);
    
    // Constructs the bottom bar
    VBox cardData = new VBox();
    cardData.setPadding(new Insets(10));
    mainLayout.setBottom(cardData);
    
    HBox topRow = new HBox();
    topRow.setSpacing(10);
    cardData.getChildren().add(topRow);

    Label sum = new Label("Sum of faces: ");
    topRow.getChildren().add(sum);

    sumString = "SUM";
    Label sumResult = new Label(sumString);
    sumResult.styleProperty();
    topRow.getChildren().add(sumResult);

    Label hearts = new Label("Cards of Hearts: ");
    topRow.getChildren().add(hearts);

    heartString = "CARDS"; 
    Label sumHearts = new Label(heartString);
    topRow.getChildren().add(sumHearts);
    
    HBox bottomRow = new HBox();
    bottomRow.setSpacing(10);
    cardData.getChildren().add(bottomRow);

    Label flush = new Label("Flush? ");
    bottomRow.getChildren().add(flush);

    Label flushResult = new Label("Y/N");
    bottomRow.getChildren().add(flushResult);


    Label qSpade = new Label("Queen of Spade? ");
    bottomRow.getChildren().add(qSpade);

    Label qSpadeResult = new Label("Y/N");
    bottomRow.getChildren().add(qSpadeResult);
    
    
    // Creates the main Scene where all the components lie with the borderpane as its root
    Scene mainScene = new Scene(mainLayout,500,500);
    
    stage.setScene(mainScene);
    stage.setTitle("GAMBLING NATION");
    stage.show();
  }
  
  
  
  
  
}

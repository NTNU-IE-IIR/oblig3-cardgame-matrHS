package edu.ntnu.matthew.UI;

import com.sun.javafx.scene.control.InputField;
import edu.ntnu.matthew.DeckOfCards;
import edu.ntnu.matthew.Hand;
import javafx.application.Application;
import javafx.css.Style;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

public class PokerCheck extends Application {
  
  DeckOfCards deck;
  Hand hand;
  
  String sumString;
  String heartString;
  
  
  public static void runApplication(String[] args) {
    launch();
  }
  
  @Override
  public void start(Stage stage) throws Exception{

    // Instantiates the poker deck
    this.deck = new DeckOfCards();
    
    // Instantiates the poker hand
    this.hand = new Hand();
    
    // Constructs the "main" BorderPane that all components get added to
    BorderPane mainLayout = new BorderPane();
    mainLayout.setPadding(new Insets(4));
    
    // Constructs a Hbox to display the cards and adds it to center
    HBox cards = new HBox();
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
  
  
  
  public void dealCards() {
    this.hand = this.deck.dealHand(5);
  }
  
}

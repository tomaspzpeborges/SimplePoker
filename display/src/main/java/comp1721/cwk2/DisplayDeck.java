package comp1721.cwk2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Simple JavaFX application to display a full deck of playing cards.
 *
 * <p>Provided for use in COMP1721 Coursework 2 (advanced solution).</p>
 *
 * @author Nick Efford
 */
public class DisplayDeck extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Create a TilePane to hold the displayed cards

    TilePane tiles = new TilePane();

    tiles.setPrefRows(4);      // suits
    tiles.setPrefColumns(13);  // ranks
    tiles.setHgap(5);
    tiles.setVgap(10);
    tiles.setStyle("-fx-padding: 10; -fx-background-color: gray;");

    // Fill the tiles with images for the set of cards

    for (Card.Suit suit: Card.Suit.values()) {
      for (Card.Rank rank: Card.Rank.values()) {
        FancyCard card = new FancyCard(rank, suit);
        Image image = card.getImage();
        if (image != null) {
          tiles.getChildren().add(new ImageView(image));
        }
        else {
          // Just in case images can't be found
          tiles.getChildren().add(new Label(card.toString()));
        }
      }
    }

    // Set up scene, stage it and make it visible

    Scene scene = new Scene(tiles);

    primaryStage.setTitle("A Deck of Cards");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

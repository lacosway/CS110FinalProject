/**
 * CS 110 Final Project
 * Game of War Functionality
 * @author Lizzie Cosway
 */
import java.util.LinkedList;
import java.util.Queue;

public class War extends Deck
{
   /**
    * Variables
    */
   private Queue<Card> compPile;
   private Queue<Card> playerPile;
   private int compCards;
   private int playerCards;
   
   /**
    * War Constructor
    */
   public War()
   {
      super();
      shuffle();
      compPile = new LinkedList<Card>();
      playerPile = new LinkedList<Card>();
      while (!isEmpty())
      {
         compPile.add(dealCard());
         playerPile.add(dealCard());
      }
   }
   
   /**
    * flip method
    * @param pile The pile of cards, either computer or user
    * @return card The card at top of pile
    */
   public Card flip()
   {
      Card card = new Card(3,Card.SPADES);
      return card;
   }
   
   /**
    * war method
    */
   public Card war()
   {
      Card card = flip();
      return card;
   }
   
   public String score()
   {
      compCards = compPile.size();
      playerCards = playerPile.size();
      String score;
      score = ("Computer: " + compCards + "\tYou: " + playerCards);
      return score;
   }
}
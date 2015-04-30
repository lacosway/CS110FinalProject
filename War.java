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
   private Card playerCard;
   private Card compCard;
   private int compCards;
   private int playerCards;
   private Card[] warCards = new Card[4];
   
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
   public void flip()
   {
      if(compCard.equals(playerCard))
         war();
      else
      {
         compCard = compPile.remove();
         playerCard = playerPile.remove();
      }
   }
   
   /**
    * war method
    */
   public void war()
   {
      warCards[0] = compCard;
      warCards[1] = playerCard;
      compCard = compPile.remove();
      playerCard = playerPile.remove();
      warCards[2] = compCard;
      warCards[3] = playerCard;
      compCard = compPile.remove();
      playerCard = playerPile.remove();
   }
   
   public Card getComp()
   {
      return compCard;
   }
   
   public Card getPlayer()
   {
      return playerCard;
   }
   
   public void returnCards()
   {
      if (playerCard.getRank() > compCard.getRank())
      {
         playerPile.add(playerCard);
         playerPile.add(compCard);
         for (int i=0;warCards[i]!=null; i++)
         {
            playerPile.add(warCards[i]);
            warCards[i] = null;
         }
      }
      else
      {
         compPile.add(compCard);
         compPile.add(playerCard);
         for (int i=0;warCards[i]!=null; i++)
         {
            compPile.add(warCards[i]);
            warCards[i] = null;
         }
      }
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
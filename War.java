/**
 * CS 110 Final Project
 * Game of War Functionality
 * @author Lizzie Cosway
 */
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;

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
      compCard = new Card(Card.QUEEN,Card.SPADES);
      playerCard = new Card(Card.KING,Card.SPADES);
      
      warCards[0] = null;
      warCards[1] = null;
      warCards[2] = null;
      warCards[3] = null;
   }
   
   /**
    * flip method
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
   
   /**
    * getComp method
    * @return compCard
    */
   public Card getComp()
   {
      return compCard;
   }
   
   /**
    * getPlayer method
    * @return playerCard
    */
   public Card getPlayer()
   {
      return playerCard;
   }
   
   /**
    * returnCards method
    */
   public void returnCards()
   {
      if (playerCard.getRank() > compCard.getRank())
      {
         playerPile.add(playerCard);
         playerPile.add(compCard);
         for (int i=0;i<=3; i++)
         {
            if (warCards[i] !=null)
            {
               playerPile.add(warCards[i]);
               warCards[i] = null;
            }
         }
      }
      else
      {
         compPile.add(compCard);
         compPile.add(playerCard);
         for (int i=0;i<=3; i++)
         {
            if (warCards[i] !=null)
            {
               compPile.add(warCards[i]);
               warCards[i] = null;
            }
         }
      }
   }
   
   /**
    * score method
    * @return score The number of cards each player has
    */
   public String score()
   {
      compCards = compPile.size();
      playerCards = playerPile.size();
      String score;
      score = ("Computer: " + compCards + "\nYou: " + playerCards);
      if (compPile.size()==0 || playerPile.size()==0)
         score = "winner";
      return score;
   }
   
   /**
    * winner method
    * @return winner The game over message
    */
   public ImageIcon winner()
   {
      ImageIcon winner;
      if(compPile.size()==52)
         winner = new ImageIcon("youlose.jpg");
      else
         winner = new ImageIcon("youwin.jpg");
         
      return winner;
   }
}
/**
 * CS 110 Final Project
 * Card class: Hold a card object with rank, suit, and card face. 
 * @author Lizzie Cosway
 */
import javax.swing.*;

public class Card
{
   /** Constant of class */
   public final static int SPADES = 0;
   /** Constant of class */
   public final static int CLUBS = 1;
   /** Constant of class */
   public final static int HEARTS = 2;
   /** Constant of class */
   public final static int DIAMONDS = 3;
   /** Constant of class */
   public final static int ACE = 1;
   /** Constant of class */
   public final static int JACK = 11;
   /** Constant of class */
   public final static int QUEEN = 12;
   /** Constant of class */
   public final static int KING = 13;
   /** Variable of class */
   private int rank;
   /** Variable of class */
   private int suit;
   /** Variable of class */
   private ImageIcon image;
   
   /**
    * Constructor
    * @param rank The ranking of the card
    * @param suit The suit of the card
    */
   public Card(int rank, int suit)
   {
      this.rank = rank;
      this.suit = suit;
      
      setFace(rank,suit);
   }
   
   /**
    * setFace method
    * @param r The rank of the card
    * @param s The suit of the card
    */
   public void setFace(int r, int s)
   {
      String suit;
      if (s==SPADES)
         suit = "s.jpg";
      else if (s==CLUBS)
         suit = "c.jpg";
      else if (s==HEARTS)
         suit = "h.jpg";
      else
         suit = "d.jpg";
      
      String rank;   
      if (r==ACE)
         rank = "ace";
      else if (r==2)
         rank = "2";
      else if (r==3)
         rank = "3";
      else if (r==4)
         rank = "4";
      else if (r==5)
         rank = "5";
      else if (r==6)
         rank = "6";
      else if (r==7)
         rank = "7";
      else if (r==8)
         rank = "8";
      else if (r==9)
         rank = "9";
      else if (r==10)
         rank = "10";
      else if (r==JACK)
         rank = "jack";
      else if (r==QUEEN)
         rank = "queen";
      else
         rank = "king";
      
      String imageName = rank+suit;
      image = new ImageIcon(imageName);
   }
   
   /**
    * getSuit method
    * @return suit The suit of the card
    */
   public int getSuit()
   {
      return suit;
   }
   
   /**
    * getRank method
    * @return rank The rank of the card
    */
   public int getRank()
   {
      return rank;
   }
   
   /**
    * getImage method
    * @return image The face of the card
    */
   public ImageIcon getImage()
   {
      return image;
   }
   
   /**
    * equals method
    * @return status Will return true if the card equals the other card in rank
    * @param card2 The card that is being compared to
    */  
   public boolean equals(Card card2)
   {
      boolean status;
      if (rank == card2.rank)
         status = true;
      else
         status = false;   
      return status;
   }
}
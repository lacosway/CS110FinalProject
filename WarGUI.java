/**
 * WarGUI sets up the design of the GUI for this game of war
 * @author Lizzie Cosway
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   /** game The game of war object*/
   private War game;
   /** table The panel for the game*/
   private JPanel table;
   private JPanel cards;
   /** flip Button to press inorder to flip card*/
   private JButton flip;
   /** score Shows the score*/
   private JLabel score;
   /** title Shows the title of game*/
   private JLabel title;
   /** playerImage The face of the players card*/
   private ImageIcon playerImage;
   /** compImage The face of the computers card*/
   private ImageIcon compImage;
   private Card compCard;
   private Card playerCard;
   private JLabel playerLabel;
   private JLabel compLabel;
   /** message Message for score*/
   String message;
   
   Card card;
   /**
    * WarGUI Constructor
    */
   public WarGUI()
   {
      game = new War();
      
      table = new JPanel(new BorderLayout());
      table.setBackground(Color.CYAN);
      
      title = new JLabel("Lizzie's Game of War");
      title.setFont(new Font("FUTURA",Font.PLAIN,36));
      table.add(title,BorderLayout.NORTH);
      
      message = game.score();
      score = new JLabel(message);
      table.add(score,BorderLayout.WEST);
      
      cards = new JPanel(new GridLayout(1,2));
      cards.setBackground(new Color(162,0,37));
      compLabel = new JLabel("~~~~Computer~~~~");
      playerLabel = new JLabel("~~~~You~~~~");
      
      flip = new JButton("Flip");
      flip.addActionListener(new ButtonListener());
      
      cards.add(compLabel);
      cards.add(playerLabel);
      
      table.add(cards,BorderLayout.CENTER);
      table.add(flip,BorderLayout.SOUTH);
      
      add(table);
      
   }  
   
   /** ButtonListener
   */
   private class ButtonListener extends JButton implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         game.flip();
         compCard = game.getComp();
         playerCard = game.getPlayer();
            
         compImage = compCard.getImage();
         compLabel = new JLabel(compImage);
         cards.add(compLabel);
         playerImage = playerCard.getImage();
         playerLabel = new JLabel(playerImage);
         cards.add(playerLabel);
   
      }
   }
}
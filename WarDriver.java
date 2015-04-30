/**
 * CS 110 Final Project
 * Game of War Driver
 *
 * @author Lizzie Cosway
 */
import javax.swing.*;

 public class WarDriver
 {
   public static void main(String []args)
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setSize(500,500);
      frame.validate();
      frame.setVisible(true);
   }
 }
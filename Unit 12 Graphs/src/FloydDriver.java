//mlbillington@fcps.edu, May 2012, June 2014
//uses TJGraphAdjMat

import java.util.Scanner;
import java.io.*;
public class FloydDriver
{
   public static void main( String[] args)throws FileNotFoundException
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("Floyd's Algorithm! Enter file of names: "); 
   											             //cities
      String fileNames = "cities.txt"; //kb.next()+".txt";
      Scanner sc = new Scanner(new File(fileNames));
      int size = sc.nextInt();
      TJGraphAdjMat g = new TJGraphAdjMat(size);
      g.readNames(fileNames);
      System.out.print("Enter file of the matrix: ");//
      //String fileGrid = kb.next()+".txt";
      String fileGrid = "citymatrixweighted.txt";
      g.readGrid(fileGrid);
      System.out.println("\nAdjacency Matrix");
      g.displayGrid();
      System.out.println("\nNumber of Edges: " + g.edgeCount());
      g.allPairsWeighted();    //call Floyd's
      System.out.println();
      g.displayVertices();
      System.out.println("Cost Matrix");
      g.displayGrid();
      System.out.println("\nNumber of Edges: " + g.edgeCount());
      while(true)
      {
         System.out.print("\nWhat is the cost?  Enter start city (-1 to exit): ");
         String from = kb.next();
         if(from.equals("-1"))
            break;
         System.out.print("                Enter end city: "); 
         String to = kb.next();  
         System.out.println( g.getCost(from, to) );
      }
   }
}
	      

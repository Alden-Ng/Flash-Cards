
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alden
 */
public class LanguageFlashCardApplication {
    
    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        
        
        System.out.println("What is the filename containing your flashcards? Exact letters!");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();
        LanguageFlashCards flashcards = new LanguageFlashCards(filename);
        boolean game = true;
        while (game){
            int temp = flashcards.getScore();
            game = flashcards.nextCard();
            if(flashcards.getScore()>temp){
                System.out.println("You're correct!");
            }
            else{
                System.out.println("Sorry, please try again");
            }
            System.out.println("Next? (Y or N)");
            String line = scan.nextLine();
            if("N".equalsIgnoreCase(line)){
                System.out.println("You've got a score of "+flashcards.getScore()+" so far");
                game = false;
            }
        }
        
    }
    
}

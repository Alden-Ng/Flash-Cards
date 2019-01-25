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
public class MultiplicationFlashCardApplication {
    
    public static void main(String[] args){
        System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split(" ");
        int numbers[] = new int[nums.length];
        MultiplicationFlashCards flashcards;
        for (int i = 0; i<nums.length; i++){
                numbers[i] = Integer.parseInt(nums[i]);
            }
        if(nums.length == 1){
            flashcards = new MultiplicationFlashCards(numbers[0]); 
        }
        else{ 
            flashcards = new MultiplicationFlashCards(numbers);
            
        }
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

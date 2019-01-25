import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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
public abstract class AbstractFlashCards {
    private HashMap<String,String> flashCards;
    private ArrayList<String> unansweredCards;
    private int score;
    private Scanner scanner;
    private Random random;
    
    /**
     * Initializes all the class variables.
     * sets score to 0.
     * Called by subclasses to initialize all class variables
     */
    public AbstractFlashCards(){ 
        this.score = 0;
        this.flashCards = new HashMap<>();
        this.unansweredCards = new ArrayList<>();
        scanner = new Scanner(System.in);
        random = new Random();
    }
    
    /** adds a flash card to the array list of flash cards.
     * 
     * @param question is the question of the flash card.
     * @param answer is the answer to the question of the flash card.
     */
    protected void addCard(String question, String answer){ 
        flashCards.put(question, answer);
        
    }
    
    /**
     * This method is called every time a new game starts.
     * The users score resets back to 0.
     * Empties the unansweredCards deck then adds the questions
     * stored in the flashCards in a random order.
     */
    public void reset(){
        score = 0;
        ArrayList arrList = new ArrayList(flashCards.keySet());
        unansweredCards.clear();
        //Collections.shuffle(unansweredCards);
        for (int index = 0; index<arrList.size(); index++) {
            String cards = (String) arrList.get(random.nextInt(arrList.size()));
            while(unansweredCards.contains(cards)){
                cards = (String) arrList.get(random.nextInt(arrList.size()));
            }
            unansweredCards.add(index, cards);
        }
        System.out.println(unansweredCards);
        
    }
    
    /**
     * 
     * @return if there are still flash cards that have not been answered.
     */
    public boolean hasNext(){
        return !unansweredCards.isEmpty();
    }
    /**
     * checks if the user's answer is correct.
     * if the user's answer is correct then the flash card is removed from the 
     * unanswered card deck.
     * if the user's answer is wrong the flash card gets re-shuffled randomly into
     * the unanswered card deck.
     * @return calls hasNext to check if there are still flash cards to answer.
     */
    public boolean nextCard(){
        System.out.println(unansweredCards.get(0));
        String answer = scanner.nextLine();
        if(answer.equals(flashCards.get(unansweredCards.get(0)))){
            unansweredCards.remove(0);
            score++;
        }
        else{
            unansweredCards.add(random.nextInt(unansweredCards.size())+1, unansweredCards.get(0));
            unansweredCards.remove(0);
            System.out.println(unansweredCards);
        }
        return this.hasNext();
    }
    /** Gets the score of the user.
     * 
     * @return An integer representing the users score. 
     */
    public int getScore(){
        return this.score;
    }
}

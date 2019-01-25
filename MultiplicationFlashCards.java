/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alden
 */
public class MultiplicationFlashCards extends AbstractFlashCards {
    
    /**
     * Creates multiplication questions flash cards based off the multiplier
     * multiplied by numbers from 1-12
     * The reset function is called to reset the game to a starting state.
     * @param multiplier is number that creates the flash cards
     * questions for multiplication, multiplying multiplier by numbers from 1-12
     * 
     */
    public MultiplicationFlashCards(int multiplier) {
        super();
        for(int i = 1; i < 13; i ++){
            int answer = multiplier * i;
            super.addCard(multiplier+" * "+i, Integer.toString(answer));
        }
        super.reset();
    }

    /**
     * The reset function is called to reset the game to a starting state.
     * @param multipliers stores multiple numbers from 1-12 that create multiplication
     * flash cards questions of the multipliers being multiplied by numbers from 1-12.
     * 
     */
    public MultiplicationFlashCards(int[] multipliers) {
        super();
        for(int i = 0; i < multipliers.length; i++){
            for(int j = 1; j < 13; j ++){
                int answer = multipliers[i] * j;
                super.addCard(multipliers[i]+" * "+j,String.valueOf(answer));
            }
        }
        super.reset();
    }
}

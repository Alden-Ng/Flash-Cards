
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alden
 */
public class LanguageFlashCards extends AbstractFlashCards {
    private static final String COMMA_DELIMITER = ",";
    private String filename;
    
    /**
     * The default constructor reads in a file flash card questions and answers
     * then stores the questions with the answers in the flashCards
     * The reset function is then called to reset the game to a starting state
     * @param filename is the name of the file that will be read in as the flash cards.
     * @throws java.io.FileNotFoundException if the file being read in is not found.
     * @throws IOException line fails to be read or gets interrupted.
     */
    public LanguageFlashCards(String filename) throws FileNotFoundException, IOException{
        super();
        this.filename = filename;
        FileReader read = new FileReader(this.filename);
        BufferedReader in = new BufferedReader(read);
        String line;
        
        while((line = in.readLine())!=null){
            String[] arrLines = line.split(COMMA_DELIMITER);
            super.addCard(arrLines[0],arrLines[1]); 
        }
        super.reset();
    }
}

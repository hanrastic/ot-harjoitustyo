/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.domain;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import static morsetrainer.domain.Morsetrainer.scanner;

/**
 *
 * @author maisajoo
 */
public class MorseTrainerFuntionality {

    public HashMap<String, String> alphabets = new HashMap<String,String>();
    public HashMap<Integer, String> numbers = new HashMap<Integer, String>();
    int inputIsNumeric = 0;
    
    public MorseTrainerFuntionality(){
        createTables();
    }
    public void createTables(){

        alphabets.put("a", ".-");
        alphabets.put("b", "-...");
        alphabets.put("c", "-.-.");
        alphabets.put("d", "-..");
        alphabets.put("e", ".");
        alphabets.put("f", "..-.");
        alphabets.put("g", "--.");
        alphabets.put("h", "....");
        alphabets.put("i", "..");
        alphabets.put("j", ".---");
        alphabets.put("k", "-.-");      
        alphabets.put("l", ".-..");
        alphabets.put("m", "--");
        alphabets.put("n", "-.");
        alphabets.put("o", "---");
        alphabets.put("p", ".--.");
        alphabets.put("q", "--.-");
        alphabets.put("r", ".-.");
        alphabets.put("s", "...");
        alphabets.put("t", "-");
        alphabets.put("u", "..-");
        alphabets.put("v", "...-");
        alphabets.put("w", ".--");
        alphabets.put("x", "-..-");
        alphabets.put("y", "-.--");
        alphabets.put("z", "--..");
        
        numbers.put(1, ".----");
        numbers.put(2, "..---");
        numbers.put(3, "...--");
        numbers.put(4, "....-");
        numbers.put(5, ".....");
        numbers.put(6, "-....");
        numbers.put(7, "--...");
        numbers.put(8, "---..");
        numbers.put(9, "----.");
        numbers.put(0, "-----");
    }
    
    public void printTable(){
        System.out.println(alphabets);
    }

    public void trainMorse(){
       
        System.out.println("Commands for using MorseTrainer");
        System.out.println("1. See Morse code alphabet table");
        System.out.println("2. Practice by converting letters");
        System.out.println("3. Practice randomly generated letters");
        System.out.println("4. Quit");
                   
        OUTER:
        while (true) {
            System.out.print("What do you want to do ? Type in a command (number): ");
            int command = scanner.nextInt();
            
            switch (command) {
                case 1:
                    printTable();
                    break;
                case 2:
                    convertAlphabetToMorseAndViceVersa();
                    break;
                case 3:
                    trainRandomMorsecode();
                    break;
                case 4:
                    break OUTER;
                default:
                    break;
            }
        }    
    }
    
    public void trainRandomMorsecode(){

        while(true){
            System.out.println("");
            System.out.println("Convert Morse code to corresponding letter or type 'back' to go back to main menu");
            String morse = randomValue();
            System.out.println(morse);            
            System.out.print(">");
            String input = scanner.next().toLowerCase();
            if(input.equals("back")){
                break;
            }else if (input.equals(getAlphabetFromMorse(morse))){
                System.out.println("Well done!");

            }else{
                for(int i = 0; i<1; i++){
                    System.out.println("Try again");
                    System.out.print(">");
                    String input2 = scanner.next();
                    if(input2.equals(getAlphabetFromMorse(morse))){
                        System.out.println("Well done!");
                        i++;
                    }
                }
            }
        }
    }

    public void convertAlphabetToMorseAndViceVersa(){
        while(true){
            System.out.println("");
            System.out.println("Type in alphabets or morsecode to translate it, or type 'back' to go to main menu");
            System.out.print(">");
            String input = scanner.next();
            
            if(input.equals("back")){
                break;
            } else if(input.length() == 5){
                System.out.println( "Morse '" + input + "' as a number: " + getIntegerFromMorse(input));
            }else if(input.contains("-") || input.contains(".")){               
                System.out.println( "Morse '" + input + "' as a alphabet: " + getAlphabetFromMorse(input));                
            }else if (testIfInputIsNumeric(input) == true) {
                System.out.println("'" + input + "' as Morse code: " + getMorsecodeFromInteger(inputIsNumeric));
            }else{                
                System.out.println("'" + input + "' as Morse code: " + getMorsecodeFromAlphabet(input));                
            }
        }
    }
    public boolean testIfInputIsNumeric(String input){
        try {
            inputIsNumeric = Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
   
    public String randomValue(){     
        Random generator = new Random();
        Object[] values = alphabets.values().toArray();
        String randomValue = (String)values[generator.nextInt(values.length)];
            return randomValue;
    }
    
    public String getAlphabetFromMorse(String morseCode){
        //Toimii
        for(Entry<String, String> entry : alphabets.entrySet()){
            if(entry.getValue().equals(morseCode.toLowerCase())){
                return entry.getKey();
            }
        }
        return null;
    }
    
    public String getMorsecodeFromAlphabet(String alphabetLetter){
        //Toimii
        return alphabets.get(alphabetLetter.toLowerCase());
    }
   
    public String getMorsecodeFromInteger (int inputNumber){
        //Toimii
        return numbers.get(inputNumber);
    }
    // int i = Integer.parseInt(input);
    
    public int getIntegerFromMorse (String morse){
       //Toimii
       for(Entry<Integer, String> entry : numbers.entrySet()){
            if(entry.getValue().equals(morse)){
                return entry.getKey();
            }
        }
        return 9999;
    }
    
}
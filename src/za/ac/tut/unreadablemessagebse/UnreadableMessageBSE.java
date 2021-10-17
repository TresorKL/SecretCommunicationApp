/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.unreadablemessagebse;

import za.ac.tut.information.Information;

/**
 *
 * @author tresorkl
 */
public class UnreadableMessageBSE extends Information {
    
 
    @Override
    public String ScrambleTheMessgeToSend() {
        
              String MessageToSend = getMessageToSend();
              
              String UnreadableMeassage = "";
              
           for(int i = 0; i < MessageToSend.length(); i++){ 
           
                 char charAtIndex = MessageToSend.charAt(i); 
              if(Character.isLetter(charAtIndex)){                
                           
                if(Character.isLowerCase(charAtIndex)){           
                    //convert the character to upper case 
                    charAtIndex = Character.toUpperCase(charAtIndex); 
                } 
                 
                  //replacean A with an X 
                if(charAtIndex == 'A'){ 
                    
                    
                    charAtIndex = 'X'; 
                    
                    //check if the letter is a B 
                } else if(charAtIndex == 'B'){ 
                    
                    //replace a B with a Y 
                    charAtIndex = 'Y'; 
                    
                    //check if the letter is a C 
                } else if(charAtIndex == 'C'){ 
                    
                    //replace a C with a Z 
                    charAtIndex = 'Z'; 
                } else { 
                   //move the letter by 3 spaces backwards in the alphabet 
                    int newValue = (int)charAtIndex - 3; 
                     
                    //convert the value to a character 
                    charAtIndex = (char)newValue; 
                } 
            } 

            String strCharAtIndex = Character.toString(charAtIndex); 
             
            //2 marks for creating a readable message 
            UnreadableMeassage = MessageToSend.concat(strCharAtIndex); 
        } 
         
        //returne an unreadable message 
        return UnreadableMeassage; 


    }
    
}

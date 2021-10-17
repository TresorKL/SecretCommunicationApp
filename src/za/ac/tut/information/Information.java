/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.information;

import za.ac.tut.infodatainterface.InformationDataInterface;
import za.ac.tut.infointerface.InformationInterface;
import za.ac.tut.messageexception.MessageException;

/**
 *
 * @author tresorkl
 */
public abstract class  Information implements InformationInterface, InformationDataInterface{
    
    public Information(){
        
    }
    
    private String messageToSend;

    public String getMessageToSend() {
        
        return messageToSend;
    }

    public void setMessageToSend(String messageToSend) throws MessageException{
        
        if(isValid(messageToSend)){
            
        this.messageToSend = messageToSend;
        
        }else{
            
           throw new MessageException("MESSAGE TO SEND MUST NOT CONTAIN DIGITS");
        }
        
    }

    private boolean isValid(String messageToSend) {
       Boolean isValid = false;
       
       for(int i=0; i<messageToSend.length();i++ ){
           
           char chatAtIndex = messageToSend.charAt(i);
           
           if(Character.isAlphabetic(chatAtIndex)){
               isValid = true;
           }
       }
       
       return isValid;
    }
    
    
    
}

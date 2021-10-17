/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.processor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import javax.swing.JOptionPane;
import za.ac.tut.infoprocessorinterface.InformationProcessorInterface;
import za.ac.tut.information.Information;
import za.ac.tut.unreadablemessagebse.UnreadableMessageBSE;
import za.ac.tut.unreadablemsgfse.UnreadableMessageFSE;

/**
 *
 * @author tresorkl
 */
public class InformationProcessor implements InformationProcessorInterface {
    
    
    public InformationProcessor(){
        
    }

    @Override
    public void WriteUnReadableMsgInTheFile(File file, Information[] informations) {
        
        String readableMsg = "";
        
        if(informations[0] instanceof UnreadableMessageBSE){
            
         UnreadableMessageBSE unreadableMesgBSE = (UnreadableMessageBSE) informations[0];
         
         readableMsg = unreadableMesgBSE.ScrambleTheMessgeToSend();
            
        }else if(informations[0] instanceof UnreadableMessageFSE){
            
         UnreadableMessageFSE unreadableMesgFSE = (UnreadableMessageFSE) informations[0];
         
         readableMsg = unreadableMesgFSE.ScrambleTheMessgeToSend();
            
        }
        
        
        try{
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            bw.write(readableMsg);
            
            bw.close();
        }catch(Exception ex){
            
            System.out.print(ex.getMessage());
        }
    }
    
    
    
    @Override
    public void WriteReadableMsgInTheFile(File file, String readableMsg) {
        
          try{
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            bw.write(readableMsg);
            
            bw.close();
        }catch(Exception ex){
            
            System.out.print(ex.getMessage());
        }
    }
        
    
    
    @Override
    public String ReadFromTheFile(File file) {
        
       String records = "";
        try{
            
        String data;
        //open the reading stream
        BufferedReader br = new BufferedReader(new FileReader(file));

        //read data from the file
        data = br.readLine();

        //read whilst there's still data
        while(data != null){
            //concatenate the records
            records = records + data + "\n";

            //read again
            data = br.readLine();
        }

        //close the reading stream
        br.close();

     
       
        }catch(Exception ex){
            
        
        }
        
         return records;
    }

    
    
    @Override
    public String MakeBseMessageReadable(Information[] informations ) {
        
        String unReadableMsg = "";
        
        if(informations[0] instanceof UnreadableMessageBSE){
            
         UnreadableMessageBSE unreadableMesgBSE = (UnreadableMessageBSE) informations[0];
         
         unReadableMsg = unreadableMesgBSE.ScrambleTheMessgeToSend();
            
        }else if(informations[0] instanceof UnreadableMessageFSE){
            
         UnreadableMessageFSE unreadableMesgFSE = (UnreadableMessageFSE) informations[0];
         
         unReadableMsg = unreadableMesgFSE.ScrambleTheMessgeToSend();
            
        }
        
               
              
              String readableMessage = "";
              
           for(int i = 0; i < unReadableMsg.length(); i++){ 
           
                 char charAtIndex = unReadableMsg.charAt(i); 
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
                   //move the letter by 3 spaces forwards in the alphabet 
                    int newValue = (int)charAtIndex + 3; 
                     
                    //convert the value to a character 
                    charAtIndex = (char)newValue; 
                } 
            } 

            String strCharAtIndex = Character.toString(charAtIndex); 
             
            //2 marks for creating a readable message 
            readableMessage = unReadableMsg.concat(strCharAtIndex); 
        } 
         
        //returne an unreadable message 
        return readableMessage; 
       
    }

    @Override
    public String MakeFseMessageReadable(Information[] informations) {
        
        String unReadableMsg = "";
        
        if(informations[0] instanceof UnreadableMessageBSE){
            
         UnreadableMessageBSE unreadableMesgBSE = (UnreadableMessageBSE) informations[0];
         
         unReadableMsg = unreadableMesgBSE.ScrambleTheMessgeToSend();
            
        }else if(informations[0] instanceof UnreadableMessageFSE){
            
         UnreadableMessageFSE unreadableMesgFSE = (UnreadableMessageFSE) informations[0];
         
         unReadableMsg = unreadableMesgFSE.ScrambleTheMessgeToSend();
            
        }
              
              String readableMessage = "";
              
           for(int i = 0; i < unReadableMsg.length(); i++){ 
           
                 char charAtIndex = unReadableMsg.charAt(i); 
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
                   //move the letter by 3 spaces forwards in the alphabet 
                    int newValue = (int)charAtIndex - 3; 
                     
                    //convert the value to a character 
                    charAtIndex = (char)newValue; 
                } 
            } 

            String strCharAtIndex = Character.toString(charAtIndex); 
             
            //2 marks for creating a readable message 
            readableMessage = unReadableMsg.concat(strCharAtIndex); 
        } 
         
        //returne an unreadable message 
        return readableMessage; 
       
    }

    

        
    
    
 
   
}

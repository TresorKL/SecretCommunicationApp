/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretcontactapp;

import java.io.File;
import javax.swing.JOptionPane;
import za.ac.tut.information.Information;
import za.ac.tut.messageexception.MessageException;
import za.ac.tut.processor.InformationProcessor;
import za.ac.tut.unreadablemessagebse.UnreadableMessageBSE;
import za.ac.tut.unreadablemsgfse.UnreadableMessageFSE;

/**
 *
 * @author tresorkl
 */
public class SecretContactApp {

    /**
     * @param args the command line arguments
     */
    
    public static void SendUnreadableMessage( Information[] informations) throws MessageException{
        
       
        
        String messageToSend = JOptionPane.showInputDialog(null, "PLEASE ENTER THE MESSAGE YOU WANTO SEND");
        int scramblingTechnicOption = Integer.parseInt(JOptionPane.showInputDialog(null, "PLEASE CHOSE THE SCRAMBLING TO YOU WANT TO USE"+"\n"+
                                                                                         "1 --- FSE" +"\n"+" 2--- BSE"));
        
        if(scramblingTechnicOption ==1){
            
          Information unreadableMessageFSE = new UnreadableMessageFSE();
          unreadableMessageFSE.setMessageToSend(messageToSend);
          
           informations[0] = unreadableMessageFSE;
          
        }else if(scramblingTechnicOption==2){
            
            Information unreadableMessageBSE = new UnreadableMessageBSE();
            
            unreadableMessageBSE.setMessageToSend(messageToSend);
            
            informations[0]= unreadableMessageBSE;
            
        }
       
        
    }
    public static void main(String[] args) throws MessageException {
        
        
        File readableMessageFile = new File("./readableMessage.txt");
        
        File unreadableMessageFile = new File("./unreadableMessage.txt");
        
        
       InformationProcessor infoProcessor = new InformationProcessor();
       
       Information[] informations =new Information[1];
       
       SendUnreadableMessage(informations);
       
       String readableMessage = "";
       
       
       
       
       
       
       if(informations[0] instanceof UnreadableMessageFSE){
           
          UnreadableMessageFSE unreadableMesgFSE = (UnreadableMessageFSE) informations[0] ;
           
           JOptionPane.showMessageDialog(null, unreadableMesgFSE.ScrambleTheMessgeToSend(), "THE UNREADABLE MESSAGE FSE",JOptionPane.INFORMATION_MESSAGE );
           
           readableMessage = infoProcessor.MakeFseMessageReadable(informations);
            
       }else if(informations[0] instanceof UnreadableMessageBSE){
           
           UnreadableMessageBSE unreadableMesgBSE = (UnreadableMessageBSE) informations[0];
           
           JOptionPane.showMessageDialog(null, unreadableMesgBSE.ScrambleTheMessgeToSend(), "THE UNREADABLE MESSAGE BSE",JOptionPane.INFORMATION_MESSAGE );
           
           readableMessage = infoProcessor.MakeBseMessageReadable(informations);
       }
       
       
       infoProcessor.WriteUnReadableMsgInTheFile(unreadableMessageFile, informations);
        
       infoProcessor.WriteReadableMsgInTheFile(readableMessageFile, readableMessage);
        
        // READ THE READABLE MESSAGE FROM THE FILE
        
        String readableMsg = infoProcessor.ReadFromTheFile(readableMessageFile);
        
        
        JOptionPane.showMessageDialog(null, readableMsg, "READABLE MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
}

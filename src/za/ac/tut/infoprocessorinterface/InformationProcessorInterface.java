/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.infoprocessorinterface;

import java.io.File;
import java.util.List;
import za.ac.tut.information.Information;

/**
 *
 * @author tresorkl
 */
public interface InformationProcessorInterface {
    
    public void WriteUnReadableMsgInTheFile(File file, Information[] informations);
    
    public void WriteReadableMsgInTheFile(File file, String readableMsg);
    
    public String ReadFromTheFile(File file);
    
    public String MakeBseMessageReadable(Information[] informations);
    
    public String MakeFseMessageReadable(Information[] informations);
    
}

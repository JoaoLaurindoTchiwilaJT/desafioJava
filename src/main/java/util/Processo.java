/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tchiwila
 */
public class Processo {
   private List<String> status = new ArrayList<>();

    public String ConvertUUID(String formatString){
        
         // Adicionar hifens no formato adequado
        String formattedUUID = formatString.replaceFirst(
            "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{12})",
            "$1-$2-$3-$4-$5"
        );
        
        return formattedUUID;
    }
       
    public List<String> StatusCombo(String statu){
        this.status.clear();
       
        try {
            if (statu.equalsIgnoreCase("PENDENTE")) {
                
                this.status.add(statu);
                this.status.add("EM_PROGRESSO");
                this.status.add("CONCLUIDA");
                
            } else if(statu.equalsIgnoreCase("EM_PROGRESSO")) {
                
                this.status.add(statu);
                this.status.add("PENDENTE");
                this.status.add("CONCLUIDA");
                
            } else if(statu.equalsIgnoreCase("CONCLUIDA")){
                
                this.status.add(statu);
                this.status.add("EM_PROGRESSO");
                this.status.add("PENDENTE");
                
            }


        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, statu + e);
        }
        
        return  status;
    }
    
}

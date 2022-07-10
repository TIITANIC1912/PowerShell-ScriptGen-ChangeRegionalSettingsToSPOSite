/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powershell.scriptgen.changeregionalsettingstosposite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TIITANIC1912
 */
public class SitesURL {

    /**
     * @return the url
     */
    public ArrayList<String> getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(ArrayList<String> url) {
        this.url = url;
    }
    private ArrayList<String> url;
    File sitesURL;
    
    public SitesURL(){
        url = new ArrayList<String>();
        sitesURL = new File ("SitesURL.txt");
        if(sitesURL.exists()==false){
            try {
                sitesURL.createNewFile();
                FileWriter fw = new FileWriter(sitesURL);
                String str = "https://mydomain.sharepoint.com/sites/mysite\n";
                fw.write(str);
                fw.close();
                System.out.println("LOG-File created.");
            } catch (IOException ex) {
                Logger.getLogger(SitesURL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("LOG-File exist, not created.");
        }
        Load();
    }
    public void Load (){
        
        try {
            FileReader fr = new FileReader(sitesURL);
            BufferedReader br = new BufferedReader(fr);
            
            String data = "";
            
            boolean end=true;
            
            while(end!=false){
                
                String line = "";
                if((line = br.readLine())!=null){
                    getUrl().add(line);
                }
                else{
                    end=false;
                }
                
            }
            br.close();
            
            /*for(int x = 0; x < url.size(); x++){
                System.out.println(url.get(x));
            }*/
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SitesURL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SitesURL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}



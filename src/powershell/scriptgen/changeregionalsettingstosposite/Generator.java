/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powershell.scriptgen.changeregionalsettingstosposite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author TIITANIC1912
 */
public class Generator {
    private Options options;
    private SitesURL siteURL;
    private Version version;
    private String Script;
    
    public Generator(){
        options = new Options();
        siteURL = new SitesURL();
        version = new Version();
    }
    
    public void ScriptGenerator(){
        
        if(integrityCheck()){
        
            String body;

            body = "#Original Script From: https://www.sharepointdiary.com/2019/06/sharepoint-online-change-regional-settings-using-powershell.html";
            body = body + "\n" + "#Documentation for the Regional Options: https://docs.microsoft.com/en-us/previous-versions/office/sharepoint-csom/jj171195(v=office.15)";
            body = body + "\n" + "#Script Generator By: TIITANIC1912 - tiitanic1912@gmail.com";
            body = body + "\n" + "#Generator Version: " + version.getVersion() + ", Build: " + version.getBuild();
            body = body + "\n";
            body = body + "\n";
            body = body + "\n" + "#For this script to work, you need to download the following pre-requisite: https://www.microsoft.com/en-us/download/details.aspx?id=42038";
            body = body + "\n" + "#Load SharePoint CSOM Assemblies";
            body = body + "\n" + "Add-Type -Path \"C:\\Program Files\\Common Files\\Microsoft Shared\\Web Server Extensions\\16\\ISAPI\\Microsoft.SharePoint.Client.dll\"";
            body = body + "\n" + "Add-Type -Path \"C:\\Program Files\\Common Files\\Microsoft Shared\\Web Server Extensions\\16\\ISAPI\\Microsoft.SharePoint.Client.Runtime.dll\"";
            body = body + "\n";
            body = body + "\n" + "#Get Credentials to connect";
            body = body + "\n" + "$Cred= Get-Credential";
            body = body + "\n" + "$Credentials = New-Object Microsoft.SharePoint.Client.SharePointOnlineCredentials($Cred.Username, $Cred.Password)";
            body = body + "\n";

            //Insert Loop Here

            ArrayList<String> url=siteURL.getUrl();
            body = body + "\n" + "#SITES LOOP START";
            for(int x = 0; x < url.size(); x++){
                body = body + "\n" + "#SITE LOOP NUMBER " + x + ".";
                body = body + "\n" + "#SCRIPT LOOP FOR THE SITE " + url.get(x);
                body = body + "\n" + "#Set up the context";
                body = body + "\n" + "$SiteURL = \""+ url.get(x) +"\"";
                body = body + "\n" + "$Ctx = New-Object Microsoft.SharePoint.Client.ClientContext($SiteUrl)";
                body = body + "\n";
                body = body + "\n" + "$Ctx.Credentials = $credential";
                body = body + "\n" + "$Web = $Ctx.Web";
                body = body + "\n";
                body = body + "\n" + "#Update Regional Settings in sharepoint online using powershell";
                body = body + "\n" + "$Web.RegionalSettings.LocaleId = " + options.getLocaleId();
                body = body + "\n" + "$Web.RegionalSettings.WorkDayStartHour = " + options.getWorkDayStartHour();
                body = body + "\n" + "$Web.RegionalSettings.WorkDayEndHour = " + options.getWorkDayEndHour();
                body = body + "\n";
                body = body + "\n" + "$Web.RegionalSettings.FirstDayOfWeek = " + options.getFirstDayOfWeek();
                body = body + "\n" + "$Web.RegionalSettings.Time24 = " + options.getTime24();
                body = body + "\n";
                body = body + "\n" + "$Web.RegionalSettings.CalendarType = " + options.getCalendarType();
                body = body + "\n" + "$Web.RegionalSettings.AlternateCalendarType = " + options.getAlternateCalendarType();
                body = body + "\n";
                body = body + "\n" + "#64 = Sunday; 32 = Monday; 16 = Tuesday; 8 = Wednesday; 4 = Thursday; 2 = Friday; 1 = Saturday; ";
                body = body + "\n" + "$Web.RegionalSettings.WorkDays = " + options.getWorkDays();
                body = body + "\n";
                body = body + "\n" + "$Web.Update()";
                body = body + "\n" + "$Ctx.ExecuteQuery()";
                body = body + "\n" + "#SITE LOOP NUMBER " + x + " ENDED.";

            }
            //body = body + "\n" + "";
            body = body + "\n";
            body = body + "\n" + "echo \"All Operations Completed.\"";
            body = body + "\n" + "pause";
            body = body + "\n";
            body = body + "\n" + "#SITES LOOP ENDED.";
            body = body + "\n" + "#END OF THE SCRIPT.";
            System.out.println(body);
            
            //Creation process for the Script
            
            String finalFileName = "Microsoft SPO Script - Change regional settings on a bunch of sites.ps1";
            
            File powerShellScript = new File (finalFileName);;
            if(powerShellScript.exists()==false){
                try {
                    powerShellScript.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    powerShellScript.delete();
                    powerShellScript.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
            try {
                FileWriter fw = new FileWriter(powerShellScript);
                fw.write(body);
                fw.close();
                System.out.println("POWERSHELL SCRIPT SUCCESSFULLY GENERATED.");
            } catch (IOException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("AN UNEXPECTED ERROR HAS OCCURRED, POWERSHELL SCRIPT CAN'T BE GENERATED.");
            }
            
            
            
            
            
            
        }
        else{
            System.err.println("YOU HAVE AND ERROR, POWERSHELL SCRIPT CAN'T BE GENERATED.");
        }
    }
    
    public boolean integrityCheck(){
        
        boolean condition1 = true, condition2 = true;
        
 
        
        if(siteURL.getUrl()!=null){
            if(siteURL.getUrl().isEmpty()){
                condition1=false;
            }
        }
        else{
            condition1=false;
        }
        if(options.getAlternateCalendarType()!=null){
            if(options.getAlternateCalendarType().isEmpty()){
                condition2=false;
            }
        }
        else{
            condition2=false;
        }
        if(options.getCalendarType()!=null){
            if(options.getCalendarType().isEmpty()){
                condition2=false;
            }
        }
        else{
            condition2=false;
        }
        if(options.getFirstDayOfWeek()!=null){
            if(options.getFirstDayOfWeek().isEmpty()){
                condition2=false;
            }
        }
        else{
            condition2=false;
        }
        if(options.getLocaleId()!=null){
            if(options.getLocaleId().isEmpty()){
                condition2=false;
            }
        }
        else{
            condition2=false;
        }
        if(options.getTime24()!=null){
            if(options.getTime24().isEmpty()){
                condition2=false;
            }
        }
        else{
            condition2=false;
        }
        if(options.getWorkDayEndHour()!=null){
            if(options.getWorkDayEndHour().isEmpty()){
                condition2=false;
            }
        }
        else{
            condition2=false;
        }
        if(options.getWorkDayStartHour()!=null){
            if(options.getWorkDayStartHour().isEmpty()){
                condition2=false;
            }
        }
        else{
            condition2=false;
        }
        if(options.getWorkDays()!=null){
            if(options.getWorkDays().isEmpty()){
                condition2=false;
            }
        }
        else{
            condition2=false;
        }
        
        if(condition1==false){
            System.err.println("Error - You need to fill sites in the SitesURL.txt before executing this script generator, if you don't know how, please remove the file to generate it again and see the example.");
            JOptionPane.showMessageDialog(null, "Error - You need to fill sites in the SitesURL.txt\nbefore executing this script generator, if you don't know how,\nplease remove the file to generate it again and see the example.", "Error - Sites File Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(condition2==false){
            System.err.println("Error - You need to fill the options in the OptionsURL.txt before executing this script generator with all of the options with a correct value, if you don't know how, please remove the file to generate it again and see the example, and for the values, check Microsoft Documentation about \"Microsoft SharePoint Client, Regional Settings Properties\", https://docs.microsoft.com/en-us/previous-versions/office/sharepoint-csom/jj171195(v=office.15)");
            ImageIcon icon = new ImageIcon(Generator.class.getResource("documentation/MicrosoftSharePointClient-RegionalSettingsPropertiesDocumentation.png"));
            //JOptionPane.showMessageDialog(null, "Error - You need to fill the options in the OptionsURL.txt\nbefore executing this script generator with all of the options with a correct value,\nif you don't know how, please remove the file to generate it again and see the example,\nand for the values, check Microsoft Documentation about\n\"Microsoft SharePoint Client, Regional Settings Properties\",\n<html><a hrefr=\"https://docs.microsoft.com/en-us/previous-versions/office/sharepoint-csom/jj171195(v=office.15)\">Documentation</a>", "Error - Options File Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(
                        null,
                        new JLabel("<html>Error - You need to fill the options in the OptionsURL.txt<br/>before executing this script generator with all of the options with a correct value,<br/>if you don't know how, please remove the file to generate it again and see the example,<br/>and for the values, check Microsoft Documentation about<br/>\"Microsoft SharePoint Client, Regional Settings Properties Documentation</html>", icon, JLabel.LEFT),
                        "Error - Options File Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
        
    }
}

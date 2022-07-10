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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TIITANIC1912
 */
public class Options {
    private String localeId;
    private String workDayStartHour;
    private String workDayEndHour;
    private String firstDayOfWeek;
    private String time24;
    private String calendarType;
    private String alternateCalendarType;
    private String workDays;
    File options;
    
    public Options(){
        options = new File ("Options.txt");
        if(options.exists()==false){
            try {
                options.createNewFile();
                FileWriter fw = new FileWriter(options);
                String str = "LOCALEID=1033 #ENGLISH\n"
                        + "WORKDAYSTARTHOUR=8\n"
                        + "WORKDAYENDHOUR=6\n"
                        + "FIRSTDAYOFWEEK=1 #MONDAY\n"
                        + "TIME24=True\n"
                        + "CALENDARTYPE=1 #GREGORIAN\n"
                        + "ALTERNATECALENDARTYPE=0 #NONE\n"
                        + "WORKDAYS=124\n";
                fw.write(str);
                fw.close();
                System.out.println("LOG-File created.");
            } catch (IOException ex) {
                Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("LOG-File exist, not created.");
        }
        Load();
    }
    public void Load (){
        
        try {
            FileReader fr = new FileReader(options);
            BufferedReader br = new BufferedReader(fr);
            
            String data = "";
            
            boolean end=true;
            
            while(end!=false){
                //System.out.println("LOOP");
                //data=data + br.readLine() + "\n";
                String line = "";
                if((line = br.readLine())!=null){
                    String dataArray[] = line.split("=");
                    data=data+line + "\n";
                    try{
                        switch (dataArray[0]){
                            case "LOCALEID":
                                setLocaleId(dataArray[1]);
                                break;
                            case "WORKDAYSTARTHOUR":
                                setWorkDayStartHour(dataArray[1]);
                                break;
                            case "WORKDAYENDHOUR":
                                setWorkDayEndHour(dataArray[1]);
                                break;
                            case "FIRSTDAYOFWEEK":
                                setFirstDayOfWeek(dataArray[1]);
                                break;
                            case "TIME24":
                                setTime24(dataArray[1]);
                                break;
                            case "CALENDARTYPE":
                                setCalendarType(dataArray[1]);
                                break;
                            case "ALTERNATECALENDARTYPE":
                                setAlternateCalendarType(dataArray[1]);
                                break;
                            case "WORKDAYS":
                                setWorkDays(dataArray[1]);
                                break;
                        }
                    }catch(java.lang.ArrayIndexOutOfBoundsException Exception){
                        System.err.println("Error - The Gathering data process Fail, the Script generation may fail.");
                    }
                }
                else{
                    end=false;
                }
                
            }
            br.close();
            /*System.out.println("DATA LENGHT:" + data.length());
            System.out.println("FILE DATA:");
            System.out.println("LOCALEID: " + localeId);
            System.out.println("WORKDAYSTARTHOUR: " + workDayStartHour);
            System.out.println("WORKDAYENDHOUR: " + workDayEndHour);
            System.out.println("FIRSTDAYOFWEEK: " + firstDayOfWeek);
            System.out.println("TIME24: " + time24);
            System.out.println("CALENDARTYPE: " + calendarType);
            System.out.println("ALTERNATECALENDARTYPE: " + alternateCalendarType);
            System.out.println("WORKDAYS: " + workDays);
            
            System.out.println("------------------------------");
            System.out.println("String DATA:");
            System.out.println(data);*/
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @return the localeId
     */
    public String getLocaleId() {
        return localeId;
    }

    /**
     * @param localeId the localeId to set
     */
    public void setLocaleId(String localeId) {
        this.localeId = localeId;
    }

    /**
     * @return the workDayStartHour
     */
    public String getWorkDayStartHour() {
        return workDayStartHour;
    }

    /**
     * @param workDayStartHour the workDayStartHour to set
     */
    public void setWorkDayStartHour(String workDayStartHour) {
        this.workDayStartHour = workDayStartHour;
    }

    /**
     * @return the workDayEndHour
     */
    public String getWorkDayEndHour() {
        return workDayEndHour;
    }

    /**
     * @param workDayEndHour the workDayEndHour to set
     */
    public void setWorkDayEndHour(String workDayEndHour) {
        this.workDayEndHour = workDayEndHour;
    }

    /**
     * @return the firstDayOfWeek
     */
    public String getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    /**
     * @param firstDayOfWeek the firstDayOfWeek to set
     */
    public void setFirstDayOfWeek(String firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
    }

    /**
     * @return the time24
     */
    public String getTime24() {
        return time24;
    }

    /**
     * @param time24 the time24 to set
     */
    public void setTime24(String time24) {
        this.time24 = time24;
    }

    /**
     * @return the calendarType
     */
    public String getCalendarType() {
        return calendarType;
    }

    /**
     * @param calendarType the calendarType to set
     */
    public void setCalendarType(String calendarType) {
        this.calendarType = calendarType;
    }

    /**
     * @return the alternateCalendarType
     */
    public String getAlternateCalendarType() {
        return alternateCalendarType;
    }

    /**
     * @param alternateCalendarType the alternateCalendarType to set
     */
    public void setAlternateCalendarType(String alternateCalendarType) {
        this.alternateCalendarType = alternateCalendarType;
    }

    /**
     * @return the workDays
     */
    public String getWorkDays() {
        return workDays;
    }

    /**
     * @param workDays the workDays to set
     */
    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }
}



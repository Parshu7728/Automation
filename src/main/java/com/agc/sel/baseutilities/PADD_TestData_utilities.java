package com.agc.sel.baseutilities;

import java.io.FileInputStream;
import java.util.Properties;
public class PADD_TestData_utilities {
    public Properties p;
    public FileInputStream fileInput;

    public PADD_TestData_utilities(){
        try {
            Property();
        } catch (Exception e) {
            System.err.println("Error loading properties file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void Property() throws Exception {
        fileInput = new FileInputStream("E:/AutomationAGC/Automation/src/main/resources/Data/PaddTestData.txt");
        this.p = new Properties();
        p.load(fileInput);
    }
    public String dots1(){ return p.getProperty("dots1"); }
    public String dots2(){ return p.getProperty("dots2"); }
    public String removable_prodcut(){ return  p.getProperty("Removable_product");}
    public String Removable_product_name(){ return p.getProperty("Removable_product_name"); }
    public String records_per_page10(){ return p.getProperty("recordsPerPage1"); }
    public String records_per_page20(){ return p.getProperty("recordsPerPage2"); }
    public String records_per_page30(){ return p.getProperty("recordsPerPage3"); }
    public String records_per_page50(){ return p.getProperty("recordsPerPage4"); }
    public int number_of_chemicals18(){ return Integer.parseInt(p.getProperty("numberOfChemicals1"));}
    public int number_of_chemicals100(){ return Integer.parseInt(p.getProperty("numberOfChemicals2"));}

    public String Ansell_Combined_PADD(){ return p.getProperty("PADDCombinedPdfPath");}
    public String Download_Directory(){ return p.getProperty("downloadDirPath");}
}
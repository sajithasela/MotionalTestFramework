package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class ReadCardInfo {

    public static String getBestFor(String card) throws IOException {
        FileInputStream fis=new FileInputStream(".//resources/dataFile/CardInfo.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("BasicInfo");

        XSSFRow row=sheet.getRow(0);
        XSSFCell cell=null;

        int colNum=0;

        for(int i=0; i<row.getLastCellNum();i++){
           // System.out.println("CARD1:"+row.getCell(i).getStringCellValue());
            if(row.getCell(i).getStringCellValue().equals(card)){
                colNum=i;
            }
        }

        row=sheet.getRow(1);
        cell=row.getCell(colNum);

        String bestfor=String.valueOf(cell.getStringCellValue());
        //System.out.println("BestFor:"+bestfor);
        return bestfor;


    }


    public static String getCardType(String card) throws IOException {
        FileInputStream fis=new FileInputStream(".//resources/dataFile/CardInfo.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("BasicInfo");

        XSSFRow row=sheet.getRow(0);
        XSSFCell cell=null;

        int colNum=0;

        for(int i=0; i<row.getLastCellNum();i++){
            // System.out.println("CARD1:"+row.getCell(i).getStringCellValue());
            if(row.getCell(i).getStringCellValue().equals(card)){
                colNum=i;
            }
        }

        row=sheet.getRow(2);
        cell=row.getCell(colNum);

        String cardType=String.valueOf(cell.getStringCellValue());
        //System.out.println("BestFor:"+bestfor);
        return cardType;


    }

    public static String getMinIncome(String card) throws IOException {
        FileInputStream fis=new FileInputStream(".//resources/dataFile/CardInfo.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("BasicInfo");

        XSSFRow row=sheet.getRow(0);
        XSSFCell cell=null;

        int colNum=0;

        for(int i=0; i<row.getLastCellNum();i++){
            // System.out.println("CARD1:"+row.getCell(i).getStringCellValue());
            if(row.getCell(i).getStringCellValue().equals(card)){
                colNum=i;
            }
        }

        row=sheet.getRow(3);
        cell=row.getCell(colNum);

        String minIncome=String.valueOf(cell.getStringCellValue());
        //System.out.println("BestFor:"+bestfor);
        return minIncome;


    }

    public static String getMinIncomeForeign(String card) throws IOException {
        FileInputStream fis=new FileInputStream(".//resources/dataFile/CardInfo.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("BasicInfo");

        XSSFRow row=sheet.getRow(0);
        XSSFCell cell=null;

        int colNum=0;

        for(int i=0; i<row.getLastCellNum();i++){
            // System.out.println("CARD1:"+row.getCell(i).getStringCellValue());
            if(row.getCell(i).getStringCellValue().equals(card)){
                colNum=i;
            }
        }

        row=sheet.getRow(4);
        cell=row.getCell(colNum);

        String minIncome=String.valueOf(cell.getStringCellValue());
        //System.out.println("BestFor:"+bestfor);
        return minIncome;


    }

    public static String getFeeWaiver(String card) throws IOException {
        FileInputStream fis=new FileInputStream(".//resources/dataFile/CardInfo.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("BasicInfo");

        XSSFRow row=sheet.getRow(0);
        XSSFCell cell=null;

        int colNum=0;

        for(int i=0; i<row.getLastCellNum();i++){
            // System.out.println("CARD1:"+row.getCell(i).getStringCellValue());
            if(row.getCell(i).getStringCellValue().equals(card)){
                colNum=i;
            }
        }

        row=sheet.getRow(5);
        cell=row.getCell(colNum);

        String minIncome=String.valueOf(cell.getStringCellValue());
        //System.out.println("BestFor:"+bestfor);
        return minIncome;


    }


    public static String[] getCardBenefits(String card) throws IOException {
        FileInputStream fis=new FileInputStream(".//resources/dataFile/CardInfo.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("CardBenefit");

        XSSFRow row=sheet.getRow(0);
        XSSFCell cell=null;

        int colNum=0;

        for(int i=0; i<row.getLastCellNum();i++){
            // System.out.println("CARD1:"+row.getCell(i).getStringCellValue());
            if(row.getCell(i).getStringCellValue().equals(card)){
                colNum=i;
            }
        }

       

        //row=sheet.getRow(5);
        cell=row.getCell(colNum);
        String[] value = new String[10];
        for(int i=0; i<sheet.getLastRowNum();i++){
            row=sheet.getRow(i);
            if(row!=null){
                cell=row.getCell(colNum);

                if(cell != null){
                    value[i]=cell.getStringCellValue();
                }
            }

        }


//        String minIncome=String.valueOf(cell.getStringCellValue());
//        System.out.println("benefit:"+minIncome);
//        return minIncome;
        return value;


    }
    public static void main(String args[]) throws IOException {
//       String best= getFeeWaiver("DBS Black Visa Card");
//       System.out.println("Best for:"+best);

        getCardBenefits("DBS Altitude Visa Signature Card");
        //System.out.println("Best for:"+benefit);
    }
}

package Apache_poi;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;

public class Create_Write_Excel {

    @Test
    public void writeExcel() throws Exception {
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Write_Test");                                // name of the sheet
//
//        sheet.createRow(0);                                               // 0 means 1st row
//        sheet.getRow(0).createCell(0).setCellValue("Hello");  // creating 1st cell in the first row
//        sheet.getRow(0).createCell(1).setCellValue("World");
//
//        sheet.createRow(1);
//        sheet.getRow(1).createCell(0).setCellValue("Fahad");
//        sheet.getRow(1).createCell(1).setCellValue("Kader");
//        // till now all the above create cells are in the temp memory, now we have to write them in a file
//
//        File file = new File("/Users/fahadkader/Desktop/Git/Selenium/Selenium_Introduction/TestData/test_write.xls");      // given where to create the file
//        FileOutputStream fos = new FileOutputStream(file);
//        workbook.write(fos);
//        workbook.close();


        // for Newer version of Excel: Just change all HSSF to XSSF //

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Write_Test");                                // name of the sheet

        sheet.createRow(0);                                               // 0 means 1st row
        sheet.getRow(0).createCell(0).setCellValue("Hello");  // creating 1st cell in the first row
        sheet.getRow(0).createCell(1).setCellValue("World");

        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue("Fahad");
        sheet.getRow(1).createCell(1).setCellValue("Kader");
        // till now all the above create cells are in the temp memory, now we have to write them in a file

        File file = new File("/Users/fahadkader/Desktop/Git/Selenium/Selenium_Introduction/TestData/test_write2.xlsx");      // given where to create the file
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();


    }
}

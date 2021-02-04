import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author zc
 * @date 2021-01-21 17:18
 */

public class DataProviderTest {

    public Iterator<Object[]> readDataFromCSV(String path){
        //  读取CSV文件方法
        List<Object[]> list = new ArrayList<Object[]>();
        try {
            FileReader is = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(is);
            while(br.ready()){
                list.add(br.readLine().split(","));
            }
            return list.iterator();
        } catch (Exception e) {
            throw new SkipException(e.getMessage());
        }
    }


    public Object[][] getDataFromExcel(String excelPath){
        //  读取excel文件方法
        Workbook book;
        try {
            FileInputStream f = new FileInputStream(excelPath);
            book = new XSSFWorkbook(f);
            Sheet sheet = book.getSheetAt(0);
            int rowInExcel = sheet.getPhysicalNumberOfRows();
            int columnInExcel = sheet.getRow(0).getPhysicalNumberOfCells();
            String[][] obj = new String[rowInExcel-2][columnInExcel];
            for (int row = 2; row < rowInExcel; row++) {
                for (int col = 0; col < columnInExcel; col++) {
                    sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
                    obj[row-2][col] = sheet.getRow(row).getCell(col).getStringCellValue();
//                    System.out.println(obj[row-2][col]);
                }
            }
            return obj;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new SkipException(e.getMessage());
        }
    }


    @DataProvider
    public Iterator<Object[]> getData1() throws UnsupportedEncodingException {
        //  获取CSV方法
        String path = this.getClass().getResource("test.csv").getPath();
        String path1 = java.net.URLDecoder.decode(path, "utf-8");
        System.out.println(path1);
        return readDataFromCSV(path1);

    }


    @DataProvider
    public Object[][] getData2() throws UnsupportedEncodingException {
        //  获取excle方法
        String path = this.getClass().getResource("test.xlsx").getPath();
        String path1 = java.net.URLDecoder.decode(path, "utf-8");
        System.out.println(path1);
        return getDataFromExcel(path1);
    }


    @Test(dataProvider = "getData1")
    public void test1(String text1,String text2) {
        //  打印CSV数据
        System.out.println(text1);
        System.out.println(text2);

    }
}
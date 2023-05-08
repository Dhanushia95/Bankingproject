package CommonFunctionality;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Objects.LoginPageObjects;

public class LoginPage extends OpenDriver {
	@Test
	public void login() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = prop.getProperty("url");
		driver.get(url);
		 File file1 = new File("C:\\Users\\dell\\Documents\\guru99banklogin1.xlsx");
		  fis =new FileInputStream(file1);
		  XSSFWorkbook workbook  = new XSSFWorkbook(fis);
		  XSSFSheet sheet =workbook.getSheetAt(0);
		  	  
		  int rownum = sheet.getLastRowNum(); 
		  System.out.println("last row:"+rownum);
		  int colnum =sheet.getRow(1).getLastCellNum();
		  System.out.println("column num:"+ colnum);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  for(int i =1; i<=rownum;i++)
		  {
			    XSSFRow row =sheet.getRow(i);
       					  
				  String value =row.getCell(0).getStringCellValue();
				  String value1=row.getCell(1).getStringCellValue();
				 
				  PageFactory.initElements(driver, LoginPageObjects.class);
	                
				   // LoginPageObjects.username.click();
			        LoginPageObjects.username.sendKeys(value);
			       // LoginPageObjects.password.click();
			        LoginPageObjects.password.sendKeys(value1);
			        LoginPageObjects.loginbutton.click();
			        driver.switchTo().alert().accept();
			        
					  if(driver.getCurrentUrl().matches(url))
					  {
					  row.createCell(2).setCellValue("passed");
					  }else
					  {
						  row.createCell(2).setCellValue("failed");
					  }
					  
					 
			  
		      FileOutputStream outputstream = new  FileOutputStream(file1);
		      workbook.write(outputstream);
		      outputstream.close();
		  }
		      System.out.println("finished");
	}
	
	

}

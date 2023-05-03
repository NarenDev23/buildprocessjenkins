package org.basestep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnBaseClass {

	public static WebDriver driver;

	public static void browserLaunch(String browser) {

		switch (browser) {
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			break;
		}

	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public WebElement locators(String attributeName, String attributeValue) {
		if (attributeName.equals("id")) {
			WebElement findElement = driver.findElement(By.id(attributeValue));
			return findElement;
		} else if (attributeName.equalsIgnoreCase("name") ) {
			WebElement findElement = driver.findElement(By.id(attributeValue));
			return findElement;
		}else {
			return null;
		}
	}	
	
	public static WebElement xpathLocator(String xpathExpression) {
		WebElement findElement = driver.findElement(By.xpath(xpathExpression));
		return findElement;
	}

	public static void elementTextSend(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	/**
	 * 
	 * @param element
	 */
	public static void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 * @return void
	 */
	public static void createCellInExcel(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\NAREN\\eclipse-workspace\\LearnClassCode\\target\\java.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		book.write(out);
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param olddata
	 * @param newData
	 * @throws IOException return void
	 */
	public static void updateCellData(String sheetName, int rowNum, int cellNum, String olddata, String newData)
			throws IOException {
		File file = new File("C:\\Users\\NAREN\\eclipse-workspace\\LearnClassCode\\target\\java.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String cellValue = cell.getStringCellValue();
		if (cellValue.equals(olddata)) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream(file);
		book.write(out);
	}

	public static Object[][] readExcelData(String sheetName) throws IOException {
		String s = "";
		File file = new File("C:\\Users\\NAREN\\eclipse-workspace\\LearnClassCode\\target\\java.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				System.out.println(cell);
				CellType cellType = sheet.getRow(i).getCell(j).getCellType();
				switch (cellType) {
				case STRING:
					s = cell.getStringCellValue();
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
						s = dateFormat.format(dateValue);
					} else {
						double numericCellValue = cell.getNumericCellValue();
						long value = Math.round(numericCellValue);
						if (value == numericCellValue) {
							s = String.valueOf(value);
						} else {
							s = String.valueOf(numericCellValue);
						}
					}
					break;
				}
				data[i - 1][j] = s;
			}
		}

		return data;
	}

	public static String readExceldata(String sheetName, int rowNum, int cellNum) throws IOException {
		String s = "";

		File file = new File("C:\\Users\\NAREN\\eclipse-workspace\\LearnClassCode\\target\\java.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:

			s = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateType = new SimpleDateFormat("dd/mm/yyyy");
				s = dateType.format(date);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long num = Math.round(numericCellValue);
				if (num == numericCellValue) {
					s = String.valueOf(num);
				} else {
					s = String.valueOf(numericCellValue);
				}

			}
			break;

		default:
			break;
		}
		return s;

	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(getProjectPath() + "\\src\\test\\resources\\Config\\Config.properties"));
		Object object = p.get(key);
		String value = (String) object;
		return value;
	}

	public static void windowSize(int width, int height) {
		Dimension d = new Dimension(width, height);
		driver.manage().window().setSize(d);

	}

	public static void navigationTo(String url) {
		driver.navigate().to(url);
	}
	
	public static void navigationback() {
		driver.navigate().back();			
		}
	
	public static void navigationForward() {
		driver.navigate().forward();
	}
	
	public static void naigationRefresh() {
		driver.navigate().refresh();
	}
	
	public static void selectOnIndex(WebElement element, int index) {
		Select s =new Select(element);
		s.selectByIndex(index);
	}
	
	public static void selectOnValue(WebElement element, String value) {
		Select s =new Select(element);
		s.selectByValue(value);
	}
	 
	public static void clearBox(WebElement element) {
		element.clear();
	}
	
	public static String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

}

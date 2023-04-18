package com.practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class IshinePortal {

	public static WebDriver driver;
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public static ExtentTest test;
	static FileReader f;
	static Properties prop;
	static Base base = new Base();

	@BeforeClass
	public static void readConfigProperties() throws IOException {
		f = new FileReader("C:\\Users\\biswa\\eclipse-workspace\\ISHINE\\configure properties");
		prop = new Properties();
		prop.load(f);
		System.out.println(prop.getProperty("url"));

	}

	@BeforeTest
	public void setExtent() {
		htmlReport = new ExtentHtmlReporter("Report.html");
		htmlReport.config().setDocumentTitle("Automation Report");// Title of the report
		htmlReport.config().setReportName("Functional Report");// Name of the report
		htmlReport.config().setTheme(Theme.DARK);
		extent = new ExtentReports();

		extent.setSystemInfo("Comapny Name", "APMOSYS");
		extent.setSystemInfo("Project Name", "ISHINE");
		extent.setSystemInfo("Test Lead", "Prabhat Padhy");
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("OS", "Window11");
		extent.setSystemInfo("Tester Name", "Biswajit");
		extent.setSystemInfo("Browser", "Chrome");

	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
//		driver.get("http://192.168.21.175:8081/employeeportal/#/login");
		
//		Base.createCSV();

	}

	@Test
	public void Testcase1() throws InterruptedException, IOException {
		String tc1D="Functionalty of sign in button";
		String tcId1="TC_01";
		String tcId2="TC_02";
		String tcId3="TC_03";
		String tcId4="TC_04";
		String tcId5="TC_05";
		String tcId6="TC_06";
		String tcId7="TC_07";
		String tcId8="TC_08";
		String tcId9="TC_09";
		String tcId10="TC_010";
		String tcId11="TC_011";
		String tcId12="TC_012";
		String tcId13="TC_013";
		String tcId14="TC_014";
		String tcId15="TC_015";
		test = extent.createTest(tc1D);

		try {
			Thread.sleep(2000);
			try {

				WebElement ele = driver.findElement(
						By.xpath("/html/body/app-root/app-body/div/app-login/main/div/div/div/div[2]/button"));
				boolean actual = ele.isDisplayed();
				boolean excepted = true;
//		Assert.assertTrue(b);

				if (actual == excepted) {
					test.log(Status.INFO, MarkupHelper.createLabel("Ishine page  is display", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Ishine page  is display")).build());
				
//				Base.writeInCSV(tcId1,tc1D,"pass");
				}else {
					test.log(Status.INFO, MarkupHelper.createLabel("Ishine page  is not display", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Ishine page  is not display")).build());
//					Base.writeInCSV(tcId1,tc1D,"fail");
				}
				
				
			} catch (Exception e) {

				e.printStackTrace();
				test.log(Status.INFO, MarkupHelper.createLabel("Ishine page  is not display", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("Ishine page  is not display")).build());
//				Base.writeInCSV(tcId1,tc1D,"fail");
			}

			
			String tc2D="SIGN Page";
			test = extent.createTest(tc2D);
			try {

				driver.findElement(By.xpath("//*[@id='username']")).sendKeys(prop.getProperty("username"));
				test.log(Status.INFO, "Enter username");
				Thread.sleep(3000);

				driver.findElement(By.xpath("//*[@id='userPassword']")).sendKeys(prop.getProperty("password"));
				test.log(Status.INFO, "Enter password");
				Thread.sleep(3000);

				WebElement SIGN_IN = driver.findElement(By.xpath("//*[text()='SIGN IN']"));
				boolean actual1 = SIGN_IN.isDisplayed();
				boolean excepted1 = true;

				if (actual1 == excepted1) {
					String pass1 = "pass";

					test.log(Status.INFO, MarkupHelper.createLabel("SIGN IN Button  is display", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("SIGN IN Button  is display")).build());

					driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
					test.log(Status.INFO, "Click on sign in Button");
//					Base.writeInCSV(tcId2,tc2D,"pass");
					
				}else {
					test.log(Status.INFO, MarkupHelper.createLabel("SIGN IN Button is not display", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("SIGN IN Button is not display")).build());

//					Base.writeInCSV(tcId2,tc2D,"fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.INFO, MarkupHelper.createLabel("SIGN IN Button is not display", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("SIGN IN Button is not display")).build());

//				Base.writeInCSV(tcId2,tc2D,"fail");
			}

			test = extent.createTest("Validation Of OTP Box");
			try {

				Thread.sleep(3000);
				WebElement otp = driver.findElement(By.xpath("//*[@id=\"userOtp\"]"));
				boolean actual2 = otp.isDisplayed();
				boolean excepted2 = true;

				if (actual2 == excepted2) {
					test.log(Status.INFO, MarkupHelper.createLabel("OTP box is display", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("OTP box is display")).build());
//					Base.writeInCSV(tcId2,tc2D,"pass");
				}
				

			} catch (Exception e) {

				e.printStackTrace();
				test.log(Status.INFO, MarkupHelper.createLabel("OTP box is not display", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("OTP box is not display")).build());
//				Base.writeInCSV(tcId3,tc2D,"fail");
			}

			test = extent.createTest("OTP Enter");

			try {

				driver.findElement(By.xpath("//*[@id=\"userOtp\"]")).sendKeys(prop.getProperty("otp"));
				test.log(Status.INFO, "Enter OTP");
				WebElement otp = driver.findElement(By.xpath("//*[@id=\"userOtp\"]"));
				boolean actual3 = otp.isDisplayed();
				boolean excepted3 = true;
				Thread.sleep(3000);

				if (actual3 == excepted3) {

					test.log(Status.INFO, MarkupHelper.createLabel("OTP is Entered", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("OTP is Entered")).build());

					driver.findElement(By.xpath("//*[text()='Confirm']")).click();
					test.log(Status.INFO, "Click on confirm button");
					Thread.sleep(5000);
				}

			} catch (Exception e) {
				e.printStackTrace();

				e.printStackTrace();
				test.log(Status.INFO, MarkupHelper.createLabel("OTP is not Entered", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("OTP is not Entered")).build());

			}

			test = extent.createTest("Setting icon check");

			try {

				WebElement seticon = driver.findElement(By.xpath("/html/body/app-root/app-sidenav/div/ul/li[2]/a"));
				boolean actual4 = seticon.isDisplayed();
				boolean excepted4 = true;

				if (actual4 == excepted4) {

					test.log(Status.INFO, MarkupHelper.createLabel("Setting Icons is Displayed", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Setting Icons is Displayed")).build());

					driver.findElement(By.xpath("/html/body/app-root/app-sidenav/div/ul/li[2]/a")).click();
					test.log(Status.INFO, "Click on Setting Icon");
					Thread.sleep(3000);
				}
			} catch (Exception e) {
				e.printStackTrace();

				e.printStackTrace();
				test.log(Status.INFO, MarkupHelper.createLabel("Setting Icons is not Displayed", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("Setting Icons is not Displayed")).build());

			}

			test = extent.createTest("Add new Employee");

			try {

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[1]/div[2]/div/div/div/div[1]/div/div/input"))
						.click();
				test.log(Status.INFO, "Click on Add new Employee Button");

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[1]/div[2]/div/div/div/div[1]/div/div/input"))
						.sendKeys(prop.getProperty("EmpId"));
				test.log(Status.INFO, "Enter EmpId");

				try {

					WebElement empid = driver.findElement(By.xpath(
							"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[1]/div[2]/div/div/div/div[1]/div/div/input"));
					boolean actual7 = empid.isDisplayed();
					boolean excepted7 = true;
					if (actual7 == excepted7) {

						test.log(Status.INFO,
								MarkupHelper.createLabel("Click on Add new Employee Button", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Click on Add new Employee Button"))
								.build());

					}

				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Does not Click on Add new Employee Button", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder.createScreenCaptureFromPath(
							base.ScreenshotFile("Does not Click on Add new Employee Button")).build());

				}
				Thread.sleep(2000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[1]/div[2]/div/div/div/div[2]/div/div/input"))
						.sendKeys(prop.getProperty("FullName"));
				test.log(Status.INFO, "Enter FullName");
				Thread.sleep(2000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[1]/div[2]/div/div/div/div[3]/div/div/input"))
						.sendKeys(prop.getProperty("EmailID"));
				test.log(Status.INFO, "Enter EmailID");
				Thread.sleep(2000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[1]/div[2]/div/div/div/div[4]/div/div/input"))
						.sendKeys(prop.getProperty("Secondary_EmailID"));
				test.log(Status.INFO, "Enter Secondary_EmailID");
				Thread.sleep(2000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[1]/div[2]/div/div/div/div[5]/div/div/div/mat-datepicker-toggle/button"))
						.click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]"))
						.click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[2]"))
						.click();
				Thread.sleep(2000);

				driver.findElement(By
						.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-multi-year-view/table/tbody/tr[2]/td[3]/div[1]"))
						.click();
				Thread.sleep(2000);

				driver.findElement(
						By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-year-view/table/tbody/tr[2]/td[3]/div[1]"))
						.click();
				Thread.sleep(2000);

				driver.findElement(
						By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[2]/td[2]/div[1]"))
						.click();
				Thread.sleep(2000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[1]/div[2]/div/div/div/div[6]/div/div/input"))
						.sendKeys(prop.getProperty("Mobile_number"));
				test.log(Status.INFO, "Enter Mobile_number");
				Thread.sleep(2000);

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO,
						MarkupHelper.createLabel("Add new Employee all button is not filled", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("Add new Employee all button is not filled"))
						.build());

			}

			test = extent.createTest("Employment Information");

			try {

				driver.findElement(By.xpath("//*[text()=' Employment Information ']"));
				test.log(Status.INFO, "Go to Employment Information");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,350)", "");

				Thread.sleep(3000);
				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[1]/div/div/div/mat-datepicker-toggle/button"))
						.click();

				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"mat-datepicker-1\"]/mat-calendar-header/div/div/button[1]"))
						.click();

				Thread.sleep(3000);
				driver.findElement(By
						.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-multi-year-view/table/tbody/tr[2]/td[1]/div[1]"))
						.click();

				Thread.sleep(3000);
				driver.findElement(
						By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-year-view/table/tbody/tr[2]/td[2]/div[1]"))
						.click();

				Thread.sleep(3000);
				driver.findElement(
						By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-month-view/table/tbody/tr[1]/td[2]/div[1]"))
						.click();

				Thread.sleep(3000);
				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[2]/div/div/select"))
						.click();
				Thread.sleep(3000);

				Select s = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[2]/div/div/select")));
				s.selectByVisibleText(prop.getProperty("Employment_Status"));
				test.log(Status.INFO, "Enter Employment_Status");

				Thread.sleep(2000);
				Select s1 = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[5]/div/div/select")));
				s1.selectByVisibleText(prop.getProperty("Manager"));
				test.log(Status.INFO, "Enter Manager name");

				Thread.sleep(2000);
				Select s2 = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[7]/div/div/select")));
				s2.selectByVisibleText(prop.getProperty("department"));
				test.log(Status.INFO, "Enter department");

				Thread.sleep(2000);
				Select s3 = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[8]/div/div/select")));
				s3.selectByVisibleText(prop.getProperty("Designation"));
				test.log(Status.INFO, "Enter Designation");

				Thread.sleep(2000);
				Select s4 = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[9]/div/div/select")));
				s4.selectByVisibleText(prop.getProperty("JobRole"));
				test.log(Status.INFO, "Enter JobRole");

				Thread.sleep(2000);
				Select s5 = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[10]/div/div/select")));
				s5.selectByVisibleText(prop.getProperty("Experience"));
				test.log(Status.INFO, "Enter Experience");

				Thread.sleep(2000);
				Select s6 = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[11]/div/div/select")));
				s6.selectByVisibleText(prop.getProperty("Work_Location"));
				test.log(Status.INFO, "Enter Work_Location");

				Thread.sleep(2000);
				Select s7 = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-employee-config/div[2]/div/div[2]/div[1]/div/app-accordion/div/app-accordion-item[2]/div[2]/div/div/div/div[12]/div/div/select")));
				s7.selectByVisibleText(prop.getProperty("Bilable"));
				test.log(Status.INFO, "Enter Bilable");

				Thread.sleep(3000);

				try {

					WebElement createemployee = driver.findElement(By.xpath("(//*[text()='Create Employee'])[2]"));
					boolean actual5 = createemployee.isDisplayed();
					boolean excepted5 = true;
					if (actual5 == excepted5) {

						test.log(Status.INFO,
								MarkupHelper.createLabel("Create Employee Button is Displayed", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Create Employee Button is Displayed"))
								.build());

						driver.findElement(By.xpath("(//*[text()='Create Employee'])[2]")).click();
						test.log(Status.INFO, "click on Create Employee button");

						Thread.sleep(9000);

						driver.findElement(By.xpath("//*[text()='OK']")).click();
						Thread.sleep(4000);

					}

				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Create Employee Button is not Displayed", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Create Employee Button is not Displayed"))
							.build());

				}

				try {

					driver.findElement(
							By.xpath("//*[@id=\"userTabContent\"]/div/app-employee-config/div[1]/div/button[2]"))
							.click();
					Thread.sleep(4000);

					driver.findElement(By.xpath("//*[text()=\"View All Employees\"]")).click();
					WebElement View_All_Employees = driver.findElement(By.xpath("//*[text()=\"View All Employees\"]"));
					boolean actual8 = View_All_Employees.isDisplayed();
					boolean excepted8 = true;
					if (actual8 == excepted8) {

						test.log(Status.INFO,
								MarkupHelper.createLabel("View All Employees Button is Displayed", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder.createScreenCaptureFromPath(
								base.ScreenshotFile("View All Employees Button is Displayed")).build());

					}

				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("View All Employees Button is not Displayed", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder.createScreenCaptureFromPath(
							base.ScreenshotFile("View All Employees Button is not Displayed")).build());

				}

				Thread.sleep(3000);

				try {

					driver.findElement(By.xpath("//*[text()=\"View All Employees Draft\"]")).click();
					test.log(Status.INFO, "click on View All Employees Draft");

					WebElement View_All_Employees_Draft = driver
							.findElement(By.xpath("//*[text()=\"View All Employees Draft\"]"));
					boolean actual9 = View_All_Employees_Draft.isDisplayed();
					boolean excepted9 = true;
					if (actual9 == excepted9) {

						test.log(Status.INFO, MarkupHelper.createLabel("View All Employees Draft Button is Displayed",
								ExtentColor.GREEN));

						test.log(Status.PASS, "",
								MediaEntityBuilder
										.createScreenCaptureFromPath(
												base.ScreenshotFile("View All Employees Draft Button is Displayed"))
										.build());

					}

				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO, MarkupHelper.createLabel("View All Employees Draft Button is not Displayed",
							ExtentColor.RED));

					test.log(Status.FAIL, "",
							MediaEntityBuilder
									.createScreenCaptureFromPath(
											base.ScreenshotFile("View All Employees Draft Button is not Displayed"))
									.build());

				}

				Thread.sleep(4000);

				try {

					driver.findElement(By.xpath("//*[text()=\"View All Domain\"]")).click();
					test.log(Status.INFO, "click on View All Domain");
					WebElement View_All_Domain = driver.findElement(By.xpath("//*[text()=\"View All Domain\"]"));
					boolean actual11 = View_All_Domain.isDisplayed();
					boolean excepted11 = true;
					if (actual11 == excepted11) {
						test.log(Status.INFO,
								MarkupHelper.createLabel("View All Domain Button is Displayed", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("View All Domain Button is Displayed"))
								.build());

					}

				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("View All Domain Button is Displayed", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("View All Domain Button is Displayed"))
							.build());
				}

				Thread.sleep(3000);

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO,
						MarkupHelper.createLabel("Employment Information Button is not Clicked", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder.createScreenCaptureFromPath(
						base.ScreenshotFile("Employment Information Button is not Clicked")).build());
			}

			test = extent.createTest("Department Choose");

			try {

				driver.findElement(By.xpath("//*[@aria-controls='dept']")).click();
				test.log(Status.INFO, "Click on Department");
				Thread.sleep(3000);

				try {

					WebElement Dept = driver.findElement(By.xpath("//*[@aria-controls='dept']"));
					boolean actual11 = Dept.isDisplayed();
					boolean excepted11 = true;
					if (actual11 == excepted11) {

						test.log(Status.INFO,
								MarkupHelper.createLabel("Department Choose is Clicked", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Department Choose is Clicked"))
								.build());

					}
				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Department Choose is not Clicked", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Department Choose is not Clicked"))
							.build());

				}

				Thread.sleep(3000);
				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-dept-config/div[2]/div/div[2]/div[1]/div[1]/div/div/input"))
						.sendKeys(prop.getProperty("department_Name"));
				test.log(Status.INFO, "Enter department_Name");

				Thread.sleep(2000);
				Select depthead = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-dept-config/div[2]/div/div[2]/div[1]/div[2]/div/div/select")));
				depthead.selectByVisibleText(prop.getProperty("Head_of_Department"));
				test.log(Status.INFO, "Enter Head_of_Department");

				Thread.sleep(2000);

				try {

					WebElement Department = driver.findElement(By.xpath(
							"//*[@id=\"userTabContent\"]/div/app-dept-config/div[2]/div/div[2]/div[2]/div/button"));
					boolean actual6 = Department.isDisplayed();
					boolean excepted6 = true;
					if (actual6 == excepted6) {

						test.log(Status.INFO,
								MarkupHelper.createLabel("Department Create is Clicked", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Department Create is Clicked"))
								.build());

						driver.findElement(By.xpath(
								"//*[@id=\"userTabContent\"]/div/app-dept-config/div[2]/div/div[2]/div[2]/div/button"))
								.click();
						Thread.sleep(2000);

						driver.findElement(By.xpath("//*[text()='OK']")).click();

					}

				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Department Create is not Clicked", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Department Create is not Clicked"))
							.build());

				}

				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO, MarkupHelper.createLabel("Department Create is not Clicked", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("Department Create is not Clicked")).build());

			}

			test = extent.createTest("Role Choose");

			try {

				WebElement Degination = driver.findElement(By.xpath("//*[text()='Designation']"));
				Boolean deg = Degination.isDisplayed();
				Assert.assertTrue(deg);

				driver.findElement(By.xpath("//*[text()='Designation']")).click();
				test.log(Status.INFO, "Click on Designation");
				Thread.sleep(2000);

				try {

					WebElement Designation = driver.findElement(By.xpath("//*[text()='Designation']"));
					boolean actual12 = Designation.isDisplayed();
					boolean excepted12 = true;
					if (actual12 == excepted12) {

						test.log(Status.INFO,
								MarkupHelper.createLabel("Designation Button is Clicked", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Designation Button is Clicked"))
								.build());

					}

				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Designation Button is not Clicked", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Designation Button is not Clicked"))
							.build());
				}

				WebElement role = driver.findElement(By.xpath("//*[text()='Role']"));
				Boolean rol = role.isDisplayed();
				Assert.assertTrue(rol);

				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[text()='Role']")).click();
				test.log(Status.INFO, "Click on Role");
				Thread.sleep(2000);

				try {

					WebElement roll = driver.findElement(By.xpath("//*[text()='Role']"));
					boolean actual13 = roll.isDisplayed();
					boolean excepted13 = true;
					if (actual13 == excepted13) {

						test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Role Button", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on Role Button")).build());

					}
				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO, MarkupHelper.createLabel("Does not Clicked on Role Button", ExtentColor.RED));

					test.log(Status.FAIL, "",
							MediaEntityBuilder
									.createScreenCaptureFromPath(base.ScreenshotFile("Does not Clicked on Role Button"))
									.build());

				}

				driver.findElement(By.xpath("//*[text()='Add New Role']")).click();
				test.log(Status.INFO, "Click on Add New Role");
				Thread.sleep(2000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-role-config/div[2]/div/div[2]/div[1]/div[1]/div/div/input"))
						.sendKeys(prop.getProperty("Role_job"));
				test.log(Status.INFO, "Enter Role_job");

				Thread.sleep(5000);

				Select Employee_Role = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-role-config/div[2]/div/div[2]/div[1]/div[2]/div/div/select")));
				Employee_Role.selectByVisibleText(prop.getProperty("Employee_Role"));
				test.log(Status.INFO, "Enter Employee_Role");

				Thread.sleep(2000);
				Select Employee_Department = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-role-config/div[2]/div/div[2]/div[1]/div[3]/div/div/select")));
				Employee_Department.selectByVisibleText(prop.getProperty("Employee_Department"));
				test.log(Status.INFO, "Enter Employee_Department");

				Thread.sleep(3000);
				driver.findElement(By.xpath("(//*[text()='Create Role'])[2]")).click();
				test.log(Status.INFO, "Click on Create Role");

				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[text()='OK']")).click();

				Thread.sleep(15000);
				driver.findElement(By.xpath("//*[text()='Leave']")).click();
				Thread.sleep(5000);

				try {

					driver.findElement(By.xpath("//*[text()='Add Holidays']")).click();
					test.log(Status.INFO, "Click on Add Holidays");
					WebElement AddHolidays = driver.findElement(By.xpath("//*[text()='Add Holidays']"));
					boolean actual14 = AddHolidays.isDisplayed();
					boolean excepted14 = true;
					if (actual14 == excepted14) {
						test.log(Status.INFO,
								MarkupHelper.createLabel("Clicked on Add Holidays Button", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on Add Holidays Button"))
								.build());

					}
				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Does not Clicked on Add Holidays Button", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Does not Clicked on Add Holidays Button"))
							.build());

				}

				Thread.sleep(3000);

				Thread.sleep(2000);
				Select Select_Holiday_type = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[2]/div/div[2]/div[1]/div[1]/div/div/select")));
				Select_Holiday_type.selectByVisibleText(prop.getProperty("Select_Holiday_type"));
				test.log(Status.INFO, "Select_Holiday_type ");

				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[2]/div/div[2]/div[1]/div[2]/div/div/input"))
						.sendKeys(prop.getProperty("Occasion"));
				test.log(Status.INFO, "Enter Occasion ");
				Thread.sleep(5000);

				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('occasionDate').value='2023-03-23'");
				test.log(Status.INFO, "Enter Date ");

				// =========================================

				Select State = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[2]/div/div[2]/div[2]/div[3]/div/div/select")));
				State.selectByVisibleText(prop.getProperty("State"));
				test.log(Status.INFO, "Select State");
				Thread.sleep(3000);

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO, MarkupHelper.createLabel("Does not Clicked on Role Button", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("Does not Clicked on Role Button")).build());
			}

			test = extent.createTest("View Holidays");

			try {

				driver.findElement(By.xpath("//*[text()='View Holidays']")).click();
				test.log(Status.INFO, "Click on View Holidays");
				WebElement Viewholiday = driver.findElement(By.xpath("//*[text()='View Holidays']"));
				boolean actual15 = Viewholiday.isDisplayed();
				boolean excepted15 = true;
				if (actual15 == excepted15) {

					test.log(Status.INFO,
							MarkupHelper.createLabel("Clicked on View Holidays Button", ExtentColor.GREEN));

					test.log(Status.PASS, "",
							MediaEntityBuilder
									.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on View Holidays Button"))
									.build());

				}

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO,
						MarkupHelper.createLabel("Does not Clicked on View Holidays Button", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("Does not Clicked on View Holidays Button"))
						.build());

			}

			test = extent.createTest("Add Leave");

			

				Thread.sleep(3000);

				try {

					driver.findElement(By.xpath("//*[text()='Add Leave Type']")).click();
					test.log(Status.INFO, "Click on Add Leave Type");
					WebElement Addleavetype = driver.findElement(By.xpath("//*[text()='Add Leave Type']"));
					boolean actual16 = Addleavetype.isDisplayed();
					boolean excepted16 = true;
					if (actual16 == excepted16) {
						test.log(Status.INFO,
								MarkupHelper.createLabel("Clicked on Add Leave Type Button", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on Add Leave Type Button"))
								.build());

					}
					
					Thread.sleep(3000);
					driver.findElement(By.xpath(
							"//*[@id=\"userTabContent\"]/div/app-leave-config/div[3]/div/div[2]/div[1]/div[1]/div/div/input"))
							.sendKeys(prop.getProperty("Leave_Type_N"));
					test.log(Status.INFO, "Enter Leave_Type_N");
					Thread.sleep(2000);

					driver.findElement(By.xpath(
							"//*[@id=\"userTabContent\"]/div/app-leave-config/div[3]/div/div[2]/div[1]/div[2]/div/div/input"))
							.sendKeys(prop.getProperty("Leave_Code_N"));
					test.log(Status.INFO, "Enter Leave_Code_N");
					Thread.sleep(2000);

					Thread.sleep(2000);
					Select Gender = new Select(driver.findElement(By.xpath(
							"//*[@id=\"userTabContent\"]/div/app-leave-config/div[3]/div/div[2]/div[1]/div[3]/div/div/select")));
					Gender.selectByVisibleText(prop.getProperty("Gender"));
					test.log(Status.INFO, "Select Gender");

					Thread.sleep(3000);

					driver.findElement(By.xpath(
							"//*[@id=\"userTabContent\"]/div/app-leave-config/div[3]/div/div[2]/div[2]/div[1]/div/div/input"))
							.sendKeys(prop.getProperty("Default_Leave"));
					test.log(Status.INFO, "Enter Default_Leave");
					Thread.sleep(3000);

					driver.findElement(By.xpath("//*[@id=\"leaveDesc\"]")).sendKeys(prop.getProperty("Description"));
					test.log(Status.INFO, "Enter leaveDescription");
					Thread.sleep(3000);

					driver.findElement(By.xpath("//*[@id=\"leaveRules\"]")).sendKeys(prop.getProperty("Rules"));
					test.log(Status.INFO, "Enter Rules");
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[text()='Add']")).click();
					Thread.sleep(3000);

					driver.findElement(By.xpath("//*[text()='OK']")).click();
					Thread.sleep(3000);
					
					
				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Does not Clicked on Add Leave Type Button", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder.createScreenCaptureFromPath(
							base.ScreenshotFile("Does Not Clicked on Add Leave Type Button")).build());
				}

				

				try {

					driver.findElement(By.xpath("//*[text()='View Leave Types']")).click();
					WebElement ViewleaveType = driver.findElement(By.xpath("//*[text()='View Leave Types']"));
					boolean actual17 = ViewleaveType.isDisplayed();
					boolean excepted17 = true;
					if (actual17 == excepted17) {
						test.log(Status.INFO,
								MarkupHelper.createLabel("Clicked on View Leave Types Button", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on View Leave Types Button"))
								.build());

					}
				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Does not Clicked on View Leave Types Button", ExtentColor.RED));

					test.log(Status.FAIL, "",
							MediaEntityBuilder
									.createScreenCaptureFromPath(
											base.ScreenshotFile("Does Not Clicked on View Leave Types Button"))
									.build());
				}
				Thread.sleep(3000);


			test = extent.createTest("Manage Employee leave Balance");

			try {

				driver.findElement(By.xpath("//*[text()='Manage Employee Leave Balance']")).click();
				test.log(Status.INFO, "Click on Manage Employee Leave Balance");
				try {

					WebElement Manage_Employee_Leave_Balance = driver
							.findElement(By.xpath("//*[text()='Manage Employee Leave Balance']"));
					boolean actual18 = Manage_Employee_Leave_Balance.isDisplayed();
					boolean excepted18 = true;
					if (actual18 == excepted18) {
						test.log(Status.INFO, MarkupHelper
								.createLabel("Clicked on Manage Employee leave Balance Button", ExtentColor.GREEN));

						test.log(Status.PASS, "",
								MediaEntityBuilder
										.createScreenCaptureFromPath(
												base.ScreenshotFile("Clicked on Manage Employee leave Balance Button"))
										.build());

					}
				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO, MarkupHelper
							.createLabel("Does not Clicked on Manage Employee leave Balance Button", ExtentColor.RED));

					test.log(Status.FAIL, "", MediaEntityBuilder
							.createScreenCaptureFromPath(
									base.ScreenshotFile("Does Not Clicked on Manage Employee leave Balance Button"))
							.build());
				}

				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[4]/div/div[2]/div[1]/div[1]/div/div/input"))
						.sendKeys("151345");
				Thread.sleep(3000);

				driver.findElement(By.xpath("//*[text()='Get Employee Leave Balance']")).click();
				test.log(Status.INFO, "Click on Employee Leave Balance");
				Thread.sleep(3000);

				driver.findElement(By.xpath("//*[@id=\"userTabContent\"]/div/app-leave-config/div[1]/div/button[6]"))
						.click();
				try {

					WebElement Addleavepolicy = driver.findElement(
							By.xpath("//*[@id=\"userTabContent\"]/div/app-leave-config/div[1]/div/button[6]"));
					boolean actual19 = Addleavepolicy.isDisplayed();
					boolean excepted19 = true;
					if (actual19 == excepted19) {
						test.log(Status.INFO,
								MarkupHelper.createLabel("Clicked on Add leave policy Button", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on Add leave policy Button"))
								.build());

					}
				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO,
							MarkupHelper.createLabel("Does not Clicked on Add leave policy Button", ExtentColor.RED));

					test.log(Status.FAIL, "",
							MediaEntityBuilder
									.createScreenCaptureFromPath(
											base.ScreenshotFile("Does Not Clicked on Add leave policy Button"))
									.build());
				}

				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[1]/div[1]/div/div/input"))
						.sendKeys(prop.getProperty("Policy_Name"));
				test.log(Status.INFO, "Enter Policy_Name");

				Thread.sleep(3000);

				Select Employment_Status = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[1]/div[2]/div/div/select")));
				Employment_Status.selectByVisibleText(prop.getProperty("Employment_Status"));
				test.log(Status.INFO, "Select Employment_Status");

				Thread.sleep(3000);

				Select Leave_Type = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[1]/div[3]/div/div/select")));
				Leave_Type.selectByVisibleText(prop.getProperty("Leave_Type"));
				test.log(Status.INFO, "Select Leave_Type");
				Thread.sleep(3000);

				Select Allow_LeaveApplication = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[2]/div/div/div/select")));
				Allow_LeaveApplication.selectByVisibleText(prop.getProperty("Allow_Leave_Application"));
				test.log(Status.INFO, "Select Allow_Leave_Application");
				Thread.sleep(3000);

				Select MonthlyIncrement = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[3]/div/div/div/select")));
				MonthlyIncrement.selectByVisibleText(prop.getProperty("Monthly_Increment"));
				test.log(Status.INFO, "Select Monthly_Increment");
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[3]/div[2]/div/div/input"))
						.sendKeys(prop.getProperty("Monthly_Increment_value"));
				test.log(Status.INFO, "Enter Monthly_Increment_value");
				Thread.sleep(3000);

				Select One_Time_LeaveLimit = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[4]/div[1]/div/div/select")));
				One_Time_LeaveLimit.selectByVisibleText(prop.getProperty("One_Time_Leave_Limit"));
				test.log(Status.INFO, "Select One_Time_Leave_Limit");
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[4]/div[2]/div/div/input"))
						.sendKeys(prop.getProperty("One_Time_Leave_Minimum_Limit_Value"));
				test.log(Status.INFO, "Enter One_Time_Leave_Minimum_Limit_Value");
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[4]/div[3]/div/div/input"))
						.sendKeys(prop.getProperty("One_Time_Leave_Maximum_Limit_Value"));
				test.log(Status.INFO, "Enter One_Time_Leave_Maximum_Limit_Value");
				Thread.sleep(3000);

				Select Leave_CarryForward = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[5]/div[1]/div/div/select")));
				Leave_CarryForward.selectByVisibleText(prop.getProperty("Leave_Carry_Forward"));
				test.log(Status.INFO, "Select Leave_Carry_Forward");
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[5]/div[2]/div/div/input"))
						.sendKeys(prop.getProperty("Leave_Carry_Forward_Value"));
				test.log(Status.INFO, "Enter Leave_Carry_Forward_Value");
				
				Thread.sleep(3000);

				Select Leave_ValidationExpiration = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[6]/div/div/div/select")));
				Leave_ValidationExpiration.selectByVisibleText(prop.getProperty("Leave_Validation_Expiration"));
				test.log(Status.INFO, "Select Leave_Validation_Expiration");
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[6]/div[2]/div/div/input"))
						.sendKeys(prop.getProperty("Leave_Validation_Expiration_period"));
				test.log(Status.INFO, "Enter Leave_Validation_Expiration_period");
				Thread.sleep(3000);

				Select Leave_App_CountLocking = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[7]/div/div/div/select")));
				Leave_App_CountLocking.selectByVisibleText(prop.getProperty("Leave_App_Count_Locking"));
				test.log(Status.INFO, "Select Leave_App_Count_Locking");
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[7]/div[2]/div/div/input"))
						.sendKeys(prop.getProperty("Leave_App_Count_Locking_Period"));
				test.log(Status.INFO, "Enter Leave_App_Count_Locking_Period");
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[7]/div[3]/div/div/input"))
						.sendKeys(prop.getProperty("Leave_App_Count_value"));
				test.log(Status.INFO, "Enter Leave_App_Count_value");
				Thread.sleep(3000);

				Select Leave_AppProbation = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[8]/div[1]/div/div/select")));
				Leave_AppProbation.selectByVisibleText(prop.getProperty("Leave_App_Probation"));
				test.log(Status.INFO, "Select Leave_App_Probation");
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[8]/div[2]/div/div/input"))
						.sendKeys(prop.getProperty("Leave_Probation_Period"));
				test.log(Status.INFO, "Enter Leave_Probation_Period");
				Thread.sleep(3000);

				driver.findElement(By
						.xpath("//*[@id=\"userTabContent\"]/div/app-leave-config/div[5]/div/div[2]/div[9]/div/button"))
						.click();
				Thread.sleep(3000);

				driver.findElement(By.xpath("//*[text()='OK']")).click();
				Thread.sleep(3000);

				WebElement Leave_Policies = driver.findElement(By.xpath("//*[text()='View Leave Policies']"));
				Boolean leave_ploicies = Leave_Policies.isDisplayed();
				Assert.assertTrue(leave_ploicies);
				Thread.sleep(3000);

				try {

					driver.findElement(By.xpath("//*[text()='View Leave Policies']")).click();
					test.log(Status.INFO, "Click on  View Leave Policies");
					WebElement ViewLeavepolicy = driver.findElement(By.xpath("//*[text()='View Leave Policies']"));
					boolean actual20 = ViewLeavepolicy.isDisplayed();
					boolean excepted20 = true;
					if (actual20 == excepted20) {

						test.log(Status.INFO,
								MarkupHelper.createLabel("Clicked on View Leave Policies Button", ExtentColor.GREEN));

						test.log(Status.PASS, "", MediaEntityBuilder.createScreenCaptureFromPath(
								base.ScreenshotFile("Clicked on View Leave Policies Button")).build());
					}
				} catch (Exception e) {
					e.printStackTrace();

					test.log(Status.INFO, MarkupHelper.createLabel("Does not Clicked on View Leave Policies Button",
							ExtentColor.RED));

					test.log(Status.FAIL, "",
							MediaEntityBuilder
									.createScreenCaptureFromPath(
											base.ScreenshotFile("Does Not Clicked on View Leave Policies Button"))
									.build());

				}
				Thread.sleep(3000);

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO, MarkupHelper
						.createLabel("Does not Clicked on Manage Employee leave Balance Button", ExtentColor.RED));

				test.log(Status.FAIL, "",
						MediaEntityBuilder
								.createScreenCaptureFromPath(
										base.ScreenshotFile("Does Not Clicked on Manage Employee leave Balance Button"))
								.build());
			}

			test = extent.createTest("Home Page");

			try {

				WebElement HomePage = driver.findElement(By.xpath("//*[text()='Home']"));
				Boolean homepage = HomePage.isDisplayed();
				Assert.assertTrue(homepage);
				Thread.sleep(3000);

				driver.findElement(By.xpath("//*[text()='Home']")).click();
				test.log(Status.INFO, " Click on HOME button");
				WebElement HOME = driver.findElement(By.xpath("//*[text()='Home']"));
				boolean actual21 = HOME.isDisplayed();
				boolean excepted21 = true;
				if (actual21 == excepted21) {

					test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Home Button", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on Home Button")).build());

				}
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-home-config/div[2]/div/div[2]/div[1]/div/div/div/input"))
						.sendKeys(prop.getProperty("Event_Name"));
				test.log(Status.INFO, "Enter Event_Name");
				Thread.sleep(3000);

//		driver.findElement(By.xpath("//*[@type='file']")).sendKeys("‪C:\\Users\\biswa\\Downloads\\download.jpg");
//		Thread.sleep(7000);

				driver.findElement(By.xpath("(//*[text()='Set Notification'])[1]")).click();
				test.log(Status.INFO, "Click Set Notification");

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"notificationMsg\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"notificationMsg\"]")).sendKeys(prop.getProperty("Notification"));
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[text()='Set']")).click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[text()='OK']")).click();
				Thread.sleep(3000);

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO, MarkupHelper.createLabel("Does not Clicked on Home Button", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("Does Not Clicked on Home Button")).build());
			}

			test = extent.createTest("Portal Page");

			try {
				driver.findElement(By.xpath("(//*[@class=\"nav-link config__tab-item__link\"])[6]")).click();
				test.log(Status.INFO, "Click on portal page");

				Thread.sleep(3000);

				WebElement Portalpage = driver
						.findElement(By.xpath("(//*[@class=\"nav-link config__tab-item__link\"])[6]"));
				boolean actual22 = Portalpage.isDisplayed();
				boolean excepted22 = true;
				if (actual22 == excepted22) {

					test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Portal Page ", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on Portal Page ")).build());

				}
			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO, MarkupHelper.createLabel("Does not Clicked on Portal Page ", ExtentColor.RED));

				test.log(Status.FAIL, "", MediaEntityBuilder
						.createScreenCaptureFromPath(base.ScreenshotFile("Does Not Clicked on Portal Page ")).build());

			}
			Thread.sleep(3000);

			try {
				driver.findElement(By.xpath("(//*[text()='Enable Appreciation Event'])[1]")).click();
				test.log(Status.INFO, "Click on Enable Appreciation Event");


				WebElement Enable_Appreciation_Event = driver
						.findElement(By.xpath("(//*[text()='Enable Appreciation Event'])[1]"));
				boolean actual23 = Enable_Appreciation_Event.isDisplayed();
				boolean excepted23 = true;
				if (actual23 == excepted23) {

					test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Enable Appreciation Event Button ",
							ExtentColor.GREEN));

					test.log(Status.PASS, "",
							MediaEntityBuilder
									.createScreenCaptureFromPath(
											base.ScreenshotFile("Clicked on Enable Appreciation Event Button "))
									.build());
				}
				driver.findElement(By.xpath("//*[@id=\"fromDatePicker\"]")).click();
				Thread.sleep(6000);

				driver.findElement(
						By.xpath("//*[@id=\"mat-datepicker-2\"]/div/mat-month-view/table/tbody/tr[5]/td[2]/div[1]"))
						.click();
				Thread.sleep(3000);

				driver.findElement(By.xpath("//*[@id=\"toDatePicker\"]")).click();
				Thread.sleep(6000);

				driver.findElement(
						By.xpath("//*[@id=\"mat-datepicker-3\"]/div/mat-month-view/table/tbody/tr[5]/td[2]/div[1]"))
						.click();
				Thread.sleep(3000);

				driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-portal-config/div[3]/div/div[2]/div[2]/div[1]/div/div/input"))
						.sendKeys(prop.getProperty("Event_Name"));
				test.log(Status.INFO, "Enter Event_Name");

				Thread.sleep(3000);

				Select SelectEmployees = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-portal-config/div[3]/div/div[2]/div[2]/div[2]/div/div/select")));
				SelectEmployees.selectByVisibleText(prop.getProperty("Select_Employees"));
				test.log(Status.INFO, "Select Select_Employees");

				Thread.sleep(9000);

				driver.findElement(By.xpath("//*[text()='Create Appreciation Event']")).click();
				test.log(Status.INFO, "Click on  Create Appreciation Event");

				Thread.sleep(9000);

				driver.findElement(By.xpath("//*[text()='OK']")).click();

				Thread.sleep(3000);

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO, MarkupHelper.createLabel("Does not Clicked on Enable Appreciation Event Button  ",
						ExtentColor.RED));

				test.log(Status.FAIL, "",
						MediaEntityBuilder
								.createScreenCaptureFromPath(
										base.ScreenshotFile("Does Not Clicked on Enable Appreciation Event Button  "))
								.build());

			}

			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//*[text()='View Appreciation'])[1]")).click();
				test.log(Status.INFO, "Click on  View Appreciation");

				Thread.sleep(3000);

				WebElement ViewAppreacation = driver.findElement(By.xpath("(//*[text()='View Appreciation'])[1]"));
				boolean actual25 = ViewAppreacation.isDisplayed();
				boolean excepted25 = true;
				if (actual25 == excepted25) {

					test.log(Status.INFO,
							MarkupHelper.createLabel("Clicked on View Appreciation  Button ", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on View Appreciation  Button "))
							.build());

				}

				Thread.sleep(3000);

				Select AppreciationEvent = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-portal-config/div[4]/div/div[2]/div[1]/div/div/div/select")));
				AppreciationEvent.selectByVisibleText(prop.getProperty("Appreciation_Event"));
				test.log(Status.INFO, "Select  Appreciation_Event");

				Thread.sleep(3000);

				Select AppreciationCategories = new Select(driver.findElement(By.xpath(
						"//*[@id=\"userTabContent\"]/div/app-portal-config/div[4]/div/div[2]/div[2]/div/div/div/select")));
				AppreciationCategories.selectByVisibleText(prop.getProperty("Appreciation_Categories"));
				test.log(Status.INFO, "Select  Appreciation_Categories");
				Thread.sleep(3000);

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO,
						MarkupHelper.createLabel("Does not Clicked on View Appreciation  Button  ", ExtentColor.RED));

				test.log(Status.FAIL, "",
						MediaEntityBuilder
								.createScreenCaptureFromPath(
										base.ScreenshotFile("Does Not Clicked on View Appreciation  Button  "))
								.build());

			}

			test = extent.createTest("Logout Page");

			try {

				driver.findElement(By.xpath("//*[@id=\"user-dropdown\"]/i")).click();
				WebElement user_dropdown = driver.findElement(By.xpath("//*[@id=\"user-dropdown\"]/i"));
				boolean actual26 = user_dropdown.isDisplayed();
				boolean excepted26 = true;
				if (actual26 == excepted26) {

					test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Logout Button ", ExtentColor.GREEN));

					test.log(Status.PASS, "", MediaEntityBuilder
							.createScreenCaptureFromPath(base.ScreenshotFile("Clicked on Logout Button")).build());

				}
				Thread.sleep(3000);

				WebElement LogOut = driver.findElement(By.xpath("/html/body/app-root/app-body/nav/ul/li/div/a[2]"));
				Boolean logout = LogOut.isDisplayed();
				Assert.assertTrue(logout);
				Thread.sleep(3000);

				driver.findElement(By.xpath("/html/body/app-root/app-body/nav/ul/li/div/a[2]")).click();
				test.log(Status.INFO, "Click on  LOgout Button");
				Thread.sleep(1000);
				System.out.println("COMPLETED");
				test.log(Status.PASS, " COMPLETED");

			} catch (Exception e) {
				e.printStackTrace();

				test.log(Status.INFO, MarkupHelper.createLabel("Does not Clicked on Logout Button ", ExtentColor.RED));

				test.log(Status.FAIL, "",
						MediaEntityBuilder
								.createScreenCaptureFromPath(base.ScreenshotFile("Does Not Clicked on Logout Button "))
								.build());

			}

			
		} catch (Exception e) {

//			test.log(Status.INFO, MarkupHelper.createLabel("Does not Clicked on Logout Button ", ExtentColor.RED));

			test.log(Status.FAIL, "", MediaEntityBuilder
					.createScreenCaptureFromPath(base.ScreenshotFile("Does Not Clicked on Logout Button ")).build());

		}

	}

	@AfterMethod
	public void browserquit() {
		driver.quit();
	}

}

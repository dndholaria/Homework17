package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class Homepage
{
    //static web driver
    protected static WebDriver driver;

    //TestNG Annotations This will run before every method will run
    @BeforeMethod

    //Non-static method
    public void openBrowser()
    {
        //method sets the system property indicated by the specified key.
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");

        //object driver for chromedriver - through typecasting
        driver =new ChromeDriver();

        //Command to maximise the window
        driver.manage().window().maximize();

        //command to open URL
        driver.get("https://demo.nopcommerce.com/");
    }



    //Non-static return type reusable method for time stamp
    public String timestamp()
    {
       return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

    }

    //Non-static void - with parameter,  reusable method for click on element
    public void clickOnElement(By by )
    {driver.findElement(by).click();

    }

    //Non-static void - with parameter,  reusable method to type and enter text
    public void typeText (By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    ////Non-static return type - with parameter,  reusable method to capture text
    public String getTextFromSite(By by)
    {
        return  driver.findElement(by).getText();


    }
    //TestNG Annotations
        @Test
    public void registerAndCheckDisplayedMessage()
    {
        //command to locate register and click on above URL
        clickOnElement(By.className("ico-register"));


        //Command to locate first name and type Rajesh on registration page
        typeText(By.id("FirstName"),"Rajesh");


        //Command to locate last name and type Patel on registration page
        typeText(By.id("LastName"),"Patel");

        //Command to locate email by id and type email address as per sendKeys on registration page
        typeText(By.id("Email"),"dn"+timestamp()+"@gmail.com");

        //Command to locate password by id and type password as per sendKeys on registration page
        typeText(By.id("Password"),"123456");

        //Command to locate confirm password by id and type password as per sendKeys on registration page
        typeText(By.id("ConfirmPassword"),"123456");


        //command to locate registration button by id locator and click on registration
        clickOnElement(By.id("register-button"));

        //command to locate message if registration success
        String message= getTextFromSite(By.className("result"));

        // print statement to print text after successful registration
        System.out.println(message);
    }

    //TestNG Annotations
         @Test
         public void emailAFriend()
        {
            //Command to find the product Apple MacBook Pro 13-inch using xpath and click.
            clickOnElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[2]/div[1]/div[2]/h2/a"));

            // command to locate email a friend using xpath and click on it.
            clickOnElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));

            //command to locate friend email and enter email address of friend.
            typeText(By.id("FriendEmail"),"bipoin@gmail.com");

            //command to locate your email and enter email address of yours.
            typeText(By.id("YourEmailAddress"),"dbdholaria@gmail.com");

            //command to locate personal message and enter message you want to send to a friend
            typeText(By.id("PersonalMessage"),"Very nice deal to buy today");

            //command to locate send email element and click on it
            clickOnElement(By.name("send-email"));

            //Command to capture the message displayed after sending message to friend.
             String rma = getTextFromSite(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));
             System.out.println(rma);

        }
    //TestNG Annotations
        @Test
        public void homePageCategories()
        {
            //command to copy name of 'Computer' category using xpath and print
            String computer = getTextFromSite(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a"));
            System.out.println("Name of first category= "+computer);

            //command to copy name of 'Electronics' category using xpath and print
            String electronics = getTextFromSite(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"));
            System.out.println("Name of second category= "+electronics );


            //command to copy name of 'Apparel' category using xpath and print
            String apparel = getTextFromSite(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/a"));
            System.out.println("Name of third category= "+apparel );


            //command to copy name of 'Digital Download' category using xpath and print
            String digitalDownload = getTextFromSite(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[4]/a"));
            System.out.println("Name of fourth category= "+digitalDownload );


            //command to copy name of 'Books' category using xpath and print
            String books= getTextFromSite(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]/a"));
            System.out.println("Name of fifth category= "+books);


            //command to copy name of 'Jewelry' category using xpath and print
            String jewelry= getTextFromSite(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[6]/a"));
            System.out.println("Name of sixth category= "+jewelry );


            //command to copy name of 'Gift cards' category using xpath and print
            String giftCards= getTextFromSite(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[7]/a"));
            System.out.println("Name of seventh category= "+giftCards );

        }
    //TestNG Annotations
         @Test
          public void newsComment ()
          {

              //command to go to computer and click
              clickOnElement(By.xpath("//div[@class=\"news-list-homepage\"]/div[2]/div[2]/div[3]/a"));

              //command to find Title using xpath locator and enter title.
              typeText(By.xpath("//input[@class=\"enter-comment-title\"]"),"feedback");

              //command to find comment box using id locator and enter comment
              typeText(By.id("AddNewComment_CommentText"),"Very important news");

              //command to click on add comment by name locator and click on it.
              clickOnElement(By.name("add-comment"));

              //find the message appear after successful adding comment and note down the successful message using get text.
              String comment = getTextFromSite(By.className("result"));

              //print message
              System.out.println("Message appeared after successful adding comment : "+comment);


          }

    //TestNG Annotations
            @Test
            public void products ()
            {
                //command to go to computer and click
                clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a"));

                clickOnElement(By.xpath("//a[@title=\"Show products in category Desktops\"]"));

                //command to go to first item and get the text using X Path

                String name1 = getTextFromSite(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/build-your-own-computer\"]"));
                System.out.println("Name of first item is: "+name1);

                //command to go to 2nd item and get the text using X Path
                String name2= getTextFromSite(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
                System.out.println("Name of second item is: "+name2);

                //command to go to 3rd item and get the text using X Path

                String name3 = getTextFromSite(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
                System.out.println("Name of third item is: "+name3);

            }
                //TestNG Annotations.  This will run after execution of every method
                @AfterMethod
                public void closeBrowser() {
                    driver.close();
                }



}

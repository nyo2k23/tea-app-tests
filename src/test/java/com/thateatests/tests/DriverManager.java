//package com.thateatests.tests;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//import java.util.HashMap;
//
//public class DriverManager {
//    private String browser;
//    private HashMap<String, WebDriver> drivers = new HashMap<>();
//
//    public DriverManager(String browser) {
//        this.browser = browser.toLowerCase();
//        this.addToDrivers();
//    }
//
//    public WebDriver getBrowserDriver() {
//        return drivers.get(this.browser);
//    }
//
//    private void addToDrivers() {
//        drivers.put("chrome", new ChromeDriver());
//        drivers.put("firefox", new FirefoxDriver());
//        drivers.put("ie", new InternetExplorerDriver());
//        drivers.put("edge", new EdgeDriver());
//        drivers.put("safari", new SafariDriver());
//    }
//}

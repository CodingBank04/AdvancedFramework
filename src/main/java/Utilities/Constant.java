package Utilities;

public class Constant {
    public static String ConfigReaderTestReagen="sdma";

    public static  String TEST_APP;
    public static  String URL;
    public static String BROWSER_VERSION;
    public static  String BROWSER_NAME;
    public static  int TIMEOUT_IMPLICIT;
    public static  String hubURL;
    public static String PLATFORM;


    static  {
        ConfigFileReader configFileReader = new ConfigFileReader(ConfigReaderTestReagen);

        if(BROWSER_VERSION==null){

            BROWSER_VERSION = configFileReader.getPropertyValue("browserVersion");
        }
        if(BROWSER_NAME==null){
            if(System.getProperty("browser")!=null){BROWSER_NAME = System.getProperty("browser");}

            else {BROWSER_NAME = configFileReader.getPropertyValue("browser");}

        }
        if(TEST_APP==null){
            if(System.getProperty("testApp")!=null){TEST_APP = System.getProperty("testApp");}
            else {TEST_APP = configFileReader.getPropertyValue("testApp");}
        }

        if(PLATFORM==null){
            if(System.getProperty("platform")!=null){PLATFORM = System.getProperty("platform");}
            else { PLATFORM= configFileReader.getPropertyValue("platform");}
        }


        URL = configFileReader.getPropertyValue("url");
        TIMEOUT_IMPLICIT = Integer.parseInt(configFileReader.getPropertyValue("implicitWaitTime"));
        hubURL = configFileReader.getPropertyValue("hubURL");


    }
}


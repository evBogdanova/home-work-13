package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({"system:properties",
        "classpath:${webdriver}.driver.properties",
        "classpath:local.driver.properties"})
public interface WebDriverConfig extends Config {

    @Key("webdriver.remote")
    boolean isRemote();

    @Key("webdriver.url")
    String getURL();

    @Key("webdriver.browser")
    String getBrowser();

    @Key("webdriver.browser.version")
    String getBrowserVersion();

}

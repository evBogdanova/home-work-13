import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemPropertiesTest {

    @BeforeEach
    public void initProperties() {
        System.setProperty("browser", "chrome");
    }

    @Test
    public void testSystemProperties() {
        String browser = System.getProperty("browser");
        assertThat(browser).isEqualTo("chrome");
    }
}

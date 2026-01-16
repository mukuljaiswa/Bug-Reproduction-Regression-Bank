import os
import re

directory = '/data/Task/Project_1/src/test/java/com/regression/bugs'

for filename in os.listdir(directory):
    if filename.startswith('Bdag_Solved_') and filename.endswith('.java'):
        filepath = os.path.join(directory, filename)
        with open(filepath, 'r') as f:
            content = f.read()
        
        # Add extension
        content = re.sub(r'public class (\w+) \{', r'public class \1 extends BaseTest {', content)
        
        # Remove fields that are now in BaseTest
        content = re.sub(r'\s*private WebDriver driver;\n', '', content)
        content = re.sub(r'\s*private WebDriverWait wait;\n', '', content)
        content = re.sub(r'\s*private static final String BASE_URL = "https://awakening.bdagscan.com/";\n', '', content)
        
        # Remove setup method
        content = re.sub(r'\s*@BeforeClass\s*public void setup\(\) \{[\s\S]*?\n\s*\}\n', '', content)
        
        # Remove tearDown method
        content = re.sub(r'\s*@AfterClass\s*public void tearDown\(\) \{[\s\S]*?\n\s*\}\n', '', content)

        # Remove unused imports
        content = content.replace('import org.openqa.selenium.chrome.ChromeDriver;', '')
        content = content.replace('import org.openqa.selenium.chrome.ChromeOptions;', '')
        content = content.replace('import org.testng.annotations.AfterClass;', '')
        content = content.replace('import org.testng.annotations.BeforeClass;', '')
        content = content.replace('import java.time.Duration;', '')
        
        with open(filepath, 'w') as f:
            f.write(content)

print("Refactoring complete.")

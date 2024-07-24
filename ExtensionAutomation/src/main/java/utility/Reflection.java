package utility;

import java.lang.reflect.Field;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Reflection {

	public static String getElementDetails (WebElement element, Object pageObject) {
        Field[] fields = pageObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(pageObject) == element) {
                    FindBy findBy = field.getAnnotation(FindBy.class);
                    if (findBy != null) {
                        String locator = "";
                        if (!findBy.id().isEmpty()) {
                            locator = "id=\"" + findBy.id() + "\"";
                        } else if (!findBy.xpath().isEmpty()) {
                            locator = "xpath=\"" + findBy.xpath() + "\"";
                        } else if (!findBy.name().isEmpty()) {
                            locator = "name=\"" + findBy.name() + "\"";
                        } else if (!findBy.css().isEmpty()) {
                            locator = "css=\"" + findBy.css() + "\"";
                        } else if (!findBy.className().isEmpty()) {
                            locator = "className=\"" + findBy.className() + "\"";
                        } else if (!findBy.linkText().isEmpty()) {
                            locator = "linkText=\"" + findBy.linkText() + "\"";
                        } else if (!findBy.partialLinkText().isEmpty()) {
                            locator = "partialLinkText=\"" + findBy.partialLinkText() + "\"";
                        } else if (!findBy.tagName().isEmpty()) {
                            locator = "tagName=\"" + findBy.tagName() + "\"";
                        }
                        return field.getName() + " (" + locator + ")";
                    } else {
                        return field.getName();
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
		return "unknown element";
	}
}

package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helper {

	public static Select select(WebElement element) {
		Select dropdown = new Select(element);
		return dropdown;
	}

}

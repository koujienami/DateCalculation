package product.view.page;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class RegisterPage {

	@FindBy(id = "registerButton")
	private SelenideElement registerButton;

	@FindBy(id = "backButton")
	private SelenideElement backButton;

	public String title() {
		return Selenide.title();
	}

	public SimulationPage シミュレーションページへ戻る() {
		backButton.click();
		return page(SimulationPage.class);
	}
}

package product.view.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SimulationPage {

	private static final String URL = "http://localhost:8090/";

	@FindBy(id = "baseDate")
	private SelenideElement baseDate;

	@FindBy(id = "simulationButton")
	private SelenideElement simulationButton;

	@FindBy(id = "registerButton")
	private SelenideElement registerButton;

	public static SimulationPage open() {
		return Selenide.open(URL, SimulationPage.class);
	}

	public String title() {
		return Selenide.title();
	}

	public SimulationPage 計算基準日は(String 計算基準日) {
		baseDate.setValue(計算基準日);
		return page(SimulationPage.class);
	}

	public SimulationPage でシミュレーションする() {
		simulationButton.click();
		return page(SimulationPage.class);
	}

	public RegisterPage 新規登録画面へ遷移する() {
		registerButton.click();
		return page(RegisterPage.class);
	}

	public SelenideElement 検索結果() {
		return $(By.cssSelector(".uk-table tbody"));
	}

}

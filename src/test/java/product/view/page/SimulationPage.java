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

	public SimulationPage ŒvZŠî€“ú‚Í(String ŒvZŠî€“ú) {
		baseDate.setValue(ŒvZŠî€“ú);
		return page(SimulationPage.class);
	}

	public SimulationPage ‚ÅƒVƒ~ƒ…ƒŒ[ƒVƒ‡ƒ“‚·‚é() {
		simulationButton.click();
		return page(SimulationPage.class);
	}

	public RegisterPage V‹K“o˜^‰æ–Ê‚Ö‘JˆÚ‚·‚é() {
		registerButton.click();
		return page(RegisterPage.class);
	}

	public SelenideElement ŒŸõŒ‹‰Ê() {
		return $(By.cssSelector(".uk-table tbody"));
	}

}

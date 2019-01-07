package product.view.page;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class UpdatePage {

	@FindBy(id = "updateButton")
	private SelenideElement updateButton;

	@FindBy(id = "backButton")
	private SelenideElement backButton;

	@FindBy(id = "dateName")
	private SelenideElement dateName;

	@FindBy(id = "adjustmentYear")
	private SelenideElement adjustmentYear;

	@FindBy(id = "adjustmentMonth")
	private SelenideElement adjustmentMonth;

	@FindBy(id = "adjustmentDay")
	private SelenideElement adjustmentDay;

	public String title() {
		return Selenide.title();
	}

	public SimulationPage シミュレーションページへ戻る() {
		backButton.click();
		return page(SimulationPage.class);
	}

	public UpdatePage 日付名は(String 日付名) {
		dateName.setValue(日付名);
		return page(UpdatePage.class);
	}

	public UpdatePage 加減年は(String 加減年) {
		adjustmentYear.setValue(加減年);
		return page(UpdatePage.class);
	}

	public UpdatePage 加減月は(String 加減月) {
		adjustmentMonth.setValue(加減月);
		return page(UpdatePage.class);
	}

	public UpdatePage 加減日は(String 加減日) {
		adjustmentDay.setValue(加減日);
		return page(UpdatePage.class);
	}

	public SimulationPage で更新する() {
		updateButton.click();
		return page(SimulationPage.class);
	}
}

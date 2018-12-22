package product.view;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

public class SimulationViewTest {

	@BeforeClass
	public static void setUp() {
		// タイムアウトの時間を5000ミリ秒にする(デフォルト:4000ミリ秒)
		Configuration.timeout = 5000;

		// ベースURLを変更する (デフォルト:http://localhost:8090)
		Configuration.baseUrl = "http://localhost:8090/";

		// テスト実行後にブラウザを開いたままにしない
		Configuration.holdBrowserOpen = false;
	}

	@Before
	public void setUpTest() {
		open("http://localhost:8090/");
	}

	@Test
	public void シミュレーション画面で計算機準備に20181201を入れて結果が一覧で取得できる事() {
		$(By.id("baseDate")).setValue("20181201");
		$(By.id("simulation")).click();

		$(By.cssSelector(".uk-table tbody")).shouldBe(visible);
	}

	@Test
	public void シミュレーション画面から新規登録画面へ遷移できる事() throws Exception {
		$(By.id("register")).click();

		assertThat(title()).isEqualTo("計算式登録");
	}
}

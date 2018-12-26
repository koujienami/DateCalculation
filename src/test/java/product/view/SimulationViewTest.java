package product.view;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeborne.selenide.Configuration;

import product.view.page.RegisterPage;
import product.view.page.SimulationPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class SimulationViewTest {

	private SimulationPage page;

	@BeforeClass
	public static void setUp() {
		Configuration.holdBrowserOpen = false;
	}

	@Before
	public void setUpTest() {
		page = SimulationPage.open();
	}

	@Test
	public void シミュレーション画面で計算基準日に20181201を入れて結果が一覧で取得できる事() {
		SimulationPage actual = page.計算基準日は("20181201").でシミュレーションする();

		actual.検索結果().shouldBe(visible);
	}

	@Test
	public void シミュレーション画面から新規登録画面へ遷移できる事() throws Exception {
		RegisterPage actual = page.新規登録画面へ遷移する();

		assertThat(actual.title()).isEqualTo("計算式登録");
	}
}

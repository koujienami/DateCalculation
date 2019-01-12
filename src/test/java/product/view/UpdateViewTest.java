package product.view;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeborne.selenide.Configuration;

import product.view.page.SimulationPage;
import product.view.page.UpdatePage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestPropertySource(locations = "classpath:test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UpdateViewTest {

	private UpdatePage page;

	@BeforeClass
	public static void setUp() {
		Configuration.holdBrowserOpen = false;
	}

	@Before
	public void setUpTest() {
		page = SimulationPage.open().計算基準日は("20181201").でシミュレーションする().更新画面へ遷移する(1);
	}

	@Test
	public void No1_更新画面からシミューレーション画面へ戻れる事() {
		SimulationPage actual = page.シミュレーションページへ戻る();

		assertThat(actual.title()).isEqualTo("計算結果確認");
	}

	@Test
	public void No2_更新画面で更新できる事() throws Exception {
		SimulationPage simulationPage = page.日付名は("前年").加減年は("-1").加減月は("0").加減日は("0").で更新する();
		SimulationPage actual = simulationPage.計算基準日は("20181201").でシミュレーションする();

		actual.検索結果().shouldBe(visible);
		assertThat(actual.検索結果の件数()).isEqualTo(2);
	}
}

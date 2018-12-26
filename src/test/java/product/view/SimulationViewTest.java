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
	public void ƒVƒ~ƒ…ƒŒ[ƒVƒ‡ƒ“‰æ–Ê‚ÅŒvZŠî€“ú‚É20181201‚ğ“ü‚ê‚ÄŒ‹‰Ê‚ªˆê——‚Åæ“¾‚Å‚«‚é–() {
		SimulationPage actual = page.ŒvZŠî€“ú‚Í("20181201").‚ÅƒVƒ~ƒ…ƒŒ[ƒVƒ‡ƒ“‚·‚é();

		actual.ŒŸõŒ‹‰Ê().shouldBe(visible);
	}

	@Test
	public void ƒVƒ~ƒ…ƒŒ[ƒVƒ‡ƒ“‰æ–Ê‚©‚çV‹K“o˜^‰æ–Ê‚Ö‘JˆÚ‚Å‚«‚é–() throws Exception {
		RegisterPage actual = page.V‹K“o˜^‰æ–Ê‚Ö‘JˆÚ‚·‚é();

		assertThat(actual.title()).isEqualTo("ŒvZ®“o˜^");
	}
}

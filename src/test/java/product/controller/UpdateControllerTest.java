package product.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import product.service.CalculationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class UpdateControllerTest {

	private MockMvc sut;

	@MockBean
	private CalculationService service;

	@Autowired
	private UpdateController target;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		sut = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void 更新ページのリクエスト結果が正常となりサービスの検索を呼ばれてViewとしてupdateが返る事() throws Exception {
		sut.perform(get("/update/{dateId}", "Y01"))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));

		verify(service, times(1)).search("Y01");
	}

	@Test
	public void 更新ページで更新処理を行うとサービスで処理されてシミュレーション画面に遷移される事() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01").param("dateName", "テスト日付名"))
			.andExpect(status().isOk())
			.andExpect(view().name("simulation"));

		verify(service, times(1)).update(any());
	}

	@Test
	public void 更新ページで日付名がNULLの状態で更新処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01"))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));
	}

	@Test
	public void 更新ページで日付名が空の状態で更新処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01").param("dateName", ""))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));
	}

	@Test
	public void 更新ページで日付名が空白の状態で更新処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01").param("dateName", " "))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));
	}

	@Test
	public void 更新ページで日付名が32桁以上の状態で更新処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01").param("dateName", "123456789012345678901234567890123"))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));
	}
}

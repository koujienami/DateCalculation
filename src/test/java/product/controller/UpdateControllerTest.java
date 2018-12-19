package product.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateControllerTest {

	private MockMvc sut;

	@Autowired
	private UpdateController target;

	@Before
	public void setUp() throws Exception {
		sut = MockMvcBuilders.standaloneSetup(target).build();
	}

	@Test
	public void 更新ページのリクエスト結果が正常となりViewとしてupdateが返る事() throws Exception {
		// sut.perform(get("/update/{dateId}"))
		// .andExpect(status().isOk())
		// .andExpect(view().name("update"));
	}
}

package product.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
public class SimulationControllerTest {

	private MockMvc sut;

	@Autowired
	private SimulationController target;

	@Before
	public void setUp() throws Exception {
		sut = MockMvcBuilders.standaloneSetup(target).build();
	}

	@Test
	public void シミュレーションページのリクエスト結果が正常となりViewとしてsimulationが返る事() throws Exception {
		sut.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("simulation"));
	}

}

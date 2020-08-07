package za.co.valr.valrtest;

import org.assertj.core.api.Assert;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ValrTestApplicationTests {

	@Autowired
	private WebApplicationContext context;
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {

	}

	@Test
	void contextLoads() {
		assertTrue(context.containsBean("swaggerApi"));
		assertTrue(context.containsBean("orderBookRepository"));
	}

	@Test
	public void actuatorIsUp() throws Exception {
		this.mockMvc.perform(get("/actuator/health")).
				andExpect(status().isOk())
				.andExpect(content().contentType("application/vnd.spring-boot.actuator.v3+json"))
				.andExpect(content().string("{\"status\":\"UP\"}"));
	}

}

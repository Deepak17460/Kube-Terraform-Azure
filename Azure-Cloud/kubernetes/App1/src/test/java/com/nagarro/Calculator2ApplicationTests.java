package com.nagarro;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Calculator2ApplicationTests {

	@Test
	void contextLoads() {
		assertNotNull(Calculator2Application.class);
	}
	
	@Test
    void testMain() {
        // Ensure that the main method runs without errors
        Calculator2Application.main(new String[] {});
    }

    @Test
    void testServletInitializer() {
        // Ensure that the ServletInitializer properly configures the application
        ServletInitializer servletInitializer = new ServletInitializer();
        SpringApplicationBuilder builder = servletInitializer.configure(new SpringApplicationBuilder());
        assertNotNull(builder);
    }

}

package com.example.demo.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class TestController {
	
	@Autowired
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
    		  RestDocumentationContextProvider restDocumentation) {
			this.mockMvc = MockMvcBuilders
			      .webAppContextSetup(webApplicationContext)
			      .apply(documentationConfiguration(restDocumentation))
			      .build();	
    				}
    
    
	@Test
	public void testGreetings() throws Exception {	
		this.mockMvc
		.perform(RestDocumentationRequestBuilders.get("/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8")).andDo(document("demo"));
        
	}
	
	

}

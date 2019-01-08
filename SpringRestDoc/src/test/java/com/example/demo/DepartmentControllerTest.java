package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.restdocs.SpringCloudContractRestDocs;
import org.springframework.cloud.contract.wiremock.restdocs.WireMockRestDocs;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureRestDocs("build/generated-snippets")
public class DepartmentControllerTest {

	private MockMvc mockMvc;
	ObjectMapper mapper = new ObjectMapper();
	 @BeforeEach
	    public void setUp(WebApplicationContext webApplicationContext,  RestDocumentationContextProvider restDocumentation) {    
	        this.mockMvc = MockMvcBuilders
	                .webAppContextSetup(webApplicationContext)
	                .apply(documentationConfiguration(restDocumentation).operationPreprocessors()
	                		.withResponseDefaults(prettyPrint())).build();
	    }
	
	@Test
	public void getAllDepartments() 
	{
			  try {
				this.mockMvc.perform(get("/department").accept("application/json;charset=UTF-8"))
				  	.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andExpect(jsonPath("$", Matchers.notNullValue())) 
					.andExpect(jsonPath("$.id", is("8"))) 
					.andExpect(jsonPath("$.name", is("SOPRA"))) 
					.andExpect(jsonPath("$.description", is("TOTOT")))
					.andDo(WireMockRestDocs.verify()
							//.jsonPath("$.id", is("8"))
							.contentType(MediaType.valueOf("application/json"))
							.stub("getAllDepartments"))
					.andDo(document("getAllDepartments", SpringCloudContractRestDocs.dslContract())
					);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

		
	}



package cn.edu.henu.analytics;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStream;

@SpringBootTest
public class RealEstateTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    void validationTest() throws Exception {
        InputStream is = new ClassPathResource("realEstateInput.xlsx").getInputStream();
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        mockMvc.perform(
                MockMvcRequestBuilders.post(
                        "/realEstate/validate")
                        .content(bytes)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(
                        MockMvcResultMatchers
                                .status()
                                .isOk()
                );
    }
    @Test
    void submissionTest() throws Exception {
        InputStream is = new ClassPathResource("realEstateInput.xlsx").getInputStream();
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        mockMvc.perform(MockMvcRequestBuilders.post("/realEstate/submit")
                .content(bytes)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

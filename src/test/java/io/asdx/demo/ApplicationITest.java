package io.asdx.demo;


import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import io.asdx.demo.domain.model.Country;
import io.asdx.demo.domain.model.Submission;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationITest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void servesIndex() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(model().attributeExists("countries", "submission"))
            .andExpect(model().attribute("countries", contains(
                Country.builder().id("0").name("Hungary").build(),
                Country.builder().id("1").name("Canada").build()
            )));
    }

    @Test
    public void processesForm() throws Exception {
        mockMvc.perform(post("/submitForm").contentType(APPLICATION_FORM_URLENCODED).content("firstName=hello"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attributeExists("submission"))
            .andExpect(model().attribute("submission", equalTo(Submission.builder().firstName("hello").build())));
    }
}

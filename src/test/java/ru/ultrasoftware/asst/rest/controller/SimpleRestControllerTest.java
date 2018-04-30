package ru.ultrasoftware.asst.rest.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ru.ultrasoftware.asst.rest.domain.PingPong;
import ru.ultrasoftware.asst.security.WebSecurityConfig;

@RunWith(SpringRunner.class)

@WebMvcTest(SimpleRestController.class)
@Import(WebSecurityConfig.class)
public class SimpleRestControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setup() {
    	
    }

    @Test
    public void testPingPongGet() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/simple/pingPong?ping=test")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("test"));
    }

    @Test
    public void testPingPongPost() throws Exception {
        String pingPongStr = objectMapper.writeValueAsString(new PingPong("hello"));
        mvc.perform(
                MockMvcRequestBuilders
                        .post("/simple/pingPong")
                        .content(pingPongStr)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(pingPongStr));
    }
}

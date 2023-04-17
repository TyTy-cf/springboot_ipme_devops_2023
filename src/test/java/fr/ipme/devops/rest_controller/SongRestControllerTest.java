package fr.ipme.devops.rest_controller;

import fr.ipme.devops.controller.SongController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SongRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListSuccess() throws Exception {
        mockMvc.perform(get("/api/song"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getListContent() throws Exception {
        mockMvc.perform(get("/api/song"))
                .andExpect(content().string(containsString("IPME song")));
    }

}

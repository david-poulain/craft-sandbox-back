package com.wyn.craftsandbox.back.exposition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserAPIIT {

    @Autowired
    private MockMvc mvc;

    @Test
    void list_all_users() throws Exception {
        mvc.perform(get("/api/v1/user"))
                .andExpect(status().isOk());
    }

}

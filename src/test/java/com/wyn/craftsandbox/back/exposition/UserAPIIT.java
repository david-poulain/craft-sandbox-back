package com.wyn.craftsandbox.back.exposition;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("h2-local")
@AutoConfigureMockMvc
class UserAPIIT {
    public static final String USER_API_END_POINT = "api/v1/user";

    @Autowired
    private MockMvc mvc;

    @Test
    void list_all_users() throws Exception {
        addUser("Chuck", "Norris");
        addUser("Will", "Smith");

        users()
                .andExpect(jsonPath("$.[0].id").value("0"))
                .andExpect(jsonPath("$.[0].firstName").value("Chuck"))
                .andExpect(jsonPath("$.[0].lastName").value("Norris"))
                .andExpect(jsonPath("$.[1].id").value("1"))
                .andExpect(jsonPath("$.[1].firstName").value("Will"))
                .andExpect(jsonPath("$.[1].lastName").value("Smith"));
    }

    private ResultActions users() throws Exception {
        return mvc.perform(get("/" + USER_API_END_POINT))
                .andExpect(status().isOk());
    }

    private ResultActions addUser(String firstName, String lastName) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(new UserCreationRequest(firstName, lastName));

        return mvc.perform(
                post("/" + USER_API_END_POINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        )
                .andExpect(status().isOk());
    }
}

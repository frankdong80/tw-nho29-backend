package com.thoughtworks.nho.nho29.web.controller;

import com.thoughtworks.nho.nho29.authentication.AuthenticationHandlerInterceptor;
import com.thoughtworks.nho.nho29.domain.DocRepository;
import com.thoughtworks.nho.nho29.domain.TaskCardRepository;
import com.thoughtworks.nho.nho29.service.DocService;
import com.thoughtworks.nho.nho29.service.TaskCardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskCardController.class)
public class TaskCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationHandlerInterceptor authenticationHandlerInterceptor;

    @MockBean
    private DocService docService;

    @MockBean
    private TaskCardService taskCardService;

    @MockBean
    private DocRepository docRepository;

    @MockBean
    private TaskCardRepository taskCardRepository;

    @Test
    public void getTrainingCardTest() throws Exception {
        Long clubId = 1001L;
        Long cardId = 1001L;

        String expected = "{\"id\":1001,\"name\":\"任务卡1001\",\"icon\":\"https://img.zcool.cn/community/012db458fca3fda8012160f7f86d21.png@1280w_1l_2o_100sh.png\",\"description\":\"欢迎来到任务卡1001\",\"trainingClubId\":1001,\"docs\":[{\"id\":1001,\"name\":\"文档1001\",\"url\":\"https://info.thoughtworks.com/rs/thoughtworks2/images/agile_maturity_model.pdf\"},{\"id\":1002,\"name\":\"文档1002\",\"url\":\"https://info.thoughtworks.com/rs/thoughtworks2/images/twebook-perspectives-estimation_1.pdf\"}]}";
        this.mockMvc.perform(get("/training-clubs/{clubId}/task-cards/{cardId}", clubId, cardId))
                .andDo(print()).andExpect(status().isOk());
//                .andExpect(jsonPath("$.id", is(1001)));
    }
}

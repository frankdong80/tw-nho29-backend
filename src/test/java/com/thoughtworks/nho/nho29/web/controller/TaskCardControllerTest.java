package com.thoughtworks.nho.nho29.web.controller;

import com.thoughtworks.nho.nho29.authentication.AuthenticationHandlerInterceptor;
import com.thoughtworks.nho.nho29.domain.Doc;
import com.thoughtworks.nho.nho29.domain.TaskCard;
import com.thoughtworks.nho.nho29.service.DocService;
import com.thoughtworks.nho.nho29.service.TaskCardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskCardController.class)
public class TaskCardControllerTest {
    @Autowired
    private MockMvc mvc;

//    @InjectMocks
//    private TaskCardController taskCardController;

    private TaskCard taskcard;

    private String expectJson;

    private List<Doc> docs;

    @MockBean
    private AuthenticationHandlerInterceptor authenticationHandlerInterceptor;

    @MockBean
    private DocService docService;

    @MockBean
    private TaskCardService taskCardService;

    @Before
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
        taskcard = new TaskCard(1001l, "任务卡1001", "欢迎来到任务卡1001", "https://img.zcool.cn/community/012db458fca3fda8012160f7f86d21.png@1280w_1l_2o_100sh.png", 1001l, 0l);
        expectJson = "[{\"id\":1001,\"name\":\"任务卡1001\",\"description\":\"欢迎来到任务卡1001\",\"icon\":\"https://img.zcool.cn/community/012db458fca3fda8012160f7f86d21.png@1280w_1l_2o_100sh.png\",\"trainingClubId\":1001,\"testPaperId\":0},{\"id\":1002,\"name\":\"任务卡1002\",\"description\":\"欢迎来到任务卡1002\",\"icon\":\"https://img.zcool.cn/community/012db458fca3fda8012160f7f86d21.png@1280w_1l_2o_100sh.png\",\"trainingClubId\":1001,\"testPaperId\":0}]";
        this.docs = new LinkedList<>();
        this.docs.add(new Doc(1001L, "文档1001", "https://info.thoughtworks.com/rs/thoughtworks2/images/twebook-perspectives-estimation_1.pdf", 1001L));
        this.docs.add(new Doc(1002L, "文档1002", "https://info.thoughtworks.com/rs/thoughtworks2/images/https://info.thoughtworks.com/rs/thoughtworks2/images/twebook-perspectives-estimation_1.pdf", 1002L));
    }

    @Test
    public void integrate_test_TaskCardController_with_correct_clubId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/training-clubs/1001/task-cards").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expectJson)));
    }

    @Test
    public void integrate_test_TaskCardController_with_wrong_clubId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/training-clubs/1/task-cards").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void test_TaskCardController_with_correct_clubId() throws Exception {
        when(taskCardService.getTaskCardListByTrainingClubId(anyLong()))
                .thenReturn(Arrays.asList(taskcard, taskcard));
        Long clubId = 1001l;
//        assertEquals(Arrays.asList(taskcard, taskcard), taskCardController.getTrainingCardsByTrainingClubId(clubId));
    }

    @Test
    public void getTrainingCardByClubIdAndCardIdTest() throws Exception {
        when(this.taskCardService.getTaskCardById(this.taskcard.getId())).thenReturn(this.taskcard);
        when(this.docService.getDocsByTaskCardId(this.taskcard.getId())).thenReturn(this.docs);

        this.mvc.perform(get("/training-clubs/{clubId}/task-cards/{cardId}",
                taskcard.getTrainingClubId(),
                taskcard.getId()).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.docs", hasSize(2)))
                .andExpect(jsonPath("$.name", is(taskcard.getName())));
    }
}

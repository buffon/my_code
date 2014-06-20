package controller;

import my_shoot.service.BaseService;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author: harry.chen
 * @since: 14-6-20 上午10:48
 */
public class MyControllerTest {

    private MockMvc mockMvc;
    private MyController myController = new MyController();

    private BaseService baseService;

    @BeforeClass
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(myController).build();
        baseService = Mockito.mock(BaseService.class);

        Field passportServiceField = MyController.class.getDeclaredField("baseService");
        passportServiceField.setAccessible(true);
        passportServiceField.set(myController, baseService);
    }

    @Test
    public void testMy() throws Exception {
        Mockito.when(baseService.base()).thenReturn("chenyehui");
        MvcResult result = this.mockMvc.perform(get("/base")).andExpect(status().isOk()).andReturn();

        String res = result.getResponse().getContentAsString();

        assertEquals(res, "");
    }
}

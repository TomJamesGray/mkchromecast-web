package com.gray.mkchromecastweb;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BrowseController.class)
public class BrowseControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    VideoStore videoStore;

    @Test
    public void testExtractLocalPathFromURL(){
        assert Arrays.equals(BrowseController.extractLocalPathFromURL(
                BrowseController.LIST_BASE_URL + "test/one"
        ), new String[]{"test", "one"});
    }

    @Test
    public void testGetVideosNonEmpty() throws Exception {
        when(videoStore.getVideosAndDirectories(any(String[].class))).
                thenReturn(new String[]{"vid1", "vid2"});
        mockMvc.perform(
                get(BrowseController.LIST_BASE_URL + "test/one")
        ).andExpect(status().is(200));

    }

    @Test
    public void testGetVideosEmpty() throws Exception {
        when(videoStore.getVideosAndDirectories(any(String[].class))).
                thenReturn(null);
        mockMvc.perform(get(BrowseController.LIST_BASE_URL + "test/one")).
                andExpect(status().is(404));
    }


}

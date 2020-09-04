package com.sam.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SiswaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPostStudentInvalid() throws Exception {
        SiswaRequest request = new SiswaRequest();

        MockHttpServletRequestBuilder builder = post("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request));
        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // email sudah ada
    // isBadRequest
    // success
    @Test
    void testPostStudent() throws Exception {
        SiswaRequest request = new SiswaRequest();
        request.setNama("Sammi Aldhi Yanto");
        request.setNisn("12345");
        request.setKelas("XII MIPA 1");
        request.setJurusan(Jurusan.MIPA);
        request.setUmur(19);
        request.setTanggalLahir(20);
        request.setBulanLahir(10);
        request.setTahunLahir(2001);
        request.setEmail("Sammidev4@gmail.com");
        request.setNoTelp("0923xxxxx");
        request.setAlamat("Tinggam");
        MockHttpServletRequestBuilder builder = post("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request));
        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
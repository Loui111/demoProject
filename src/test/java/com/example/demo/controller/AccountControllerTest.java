package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("getAllAcount")
  void getAllAccount() throws Exception{
//    MultiValueMap<String, Long>

  }

  @Test
  @DisplayName("getOneAccount")
  void getAccount() throws Exception{


  }

  @Test
  @DisplayName("getOneAccount")
  void getAccountByName() throws Exception{
    //param 세팅
    MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
    param.add("name", "IT_TEAM22");

    //mockMvc
    ResultActions resultActions = mockMvc.perform(post("/account")
        .params(param)
        .contentType(MediaType.APPLICATION_JSON));

    //
    resultActions.andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("2"))
        .andDo(print());
  }
}
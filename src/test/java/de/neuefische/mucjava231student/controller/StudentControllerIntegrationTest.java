package de.neuefische.mucjava231student.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    void getAllStudents_whenApiCalledAndListIsEmpty_thenExpectStatusOkAndReturnEmptyListAsJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    @DirtiesContext
    void getAllStudents_whenApiCalledAndListIsNotEmpty_thenExpectStatusOkAndReturnListOfStudentsAsJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType("application/json")
                        .content(
                                """
                                        {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().json(
                                """
                                        {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                        """
                        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [
                                    {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                ]
                                """
                ));
    }

    @Test
    @DirtiesContext
    void getStudentById_whenStudentByIdExist_thenExpectStatusOkAndReturnStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType("application/json")
                        .content(
                                """
                                        {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().json(
                                """
                                        {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                        """
                        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                    {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                """
                ));
    }

    @Test
    @DirtiesContext
    void addStudent_whenApiCalled_thenExpectStatusOkAndReturnSavedStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType("application/json")
                        .content(
                                """
                                        {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                    {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                """
                ));
    }

    @Test
    @DirtiesContext
    void updateStudent_whenStudentExist_thenExpectStatusOkAndReturnUpdatedStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType("application/json")
                        .content(
                                """
                                        {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().json(
                                """
                                    {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                """
                        ));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/students/1")
                        .contentType("application/json")
                        .content(
                                """
                                        {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 33,
                                            "isActiveStudent": true
                                        }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                    {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 33,
                                            "isActiveStudent": true
                                        }
                                """
                ));
    }

    @Test
    @DirtiesContext
    void deleteStudent_whenStudentExist_thenExpectStatusOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType("application/json")
                        .content(
                                """
                                        {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().json(
                                """
                                    {
                                            "id": "1",
                                            "name": "Mathias",
                                            "age": 32,
                                            "isActiveStudent": true
                                        }
                                """
                        ));

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/students/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
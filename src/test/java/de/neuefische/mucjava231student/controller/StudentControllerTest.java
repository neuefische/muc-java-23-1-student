package de.neuefische.mucjava231student.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    void getAllStudents_whenStudentListIsEmpty_thenExpectStatusOKAndReturnEmptyListAsJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    @DirtiesContext
    void getStudentById_whenStudentExistByGivenId_thenExpectStatusOkAndReturnStudent() throws Exception {
        Student student = new Student("1", "Mathias", "Java Bootcamp");
        studentRepository.save(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students/{id}", student.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                   {
                                       "id": "1",
                                       "name": "Mathias",
                                       "course": "Java Bootcamp"
                                   }
                                """
                ));
    }

    @Test
    @DirtiesContext
    void addStudent_thenExpectStatusOkAndReturnStudentAsJason() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                           {
                                              "id": "1",
                                              "name": "Mathias",
                                              "course": "Java Bootcamp"
                                           }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                   {
                                       "id": "1",
                                       "name": "Mathias",
                                       "course": "Java Bootcamp"
                                   }
                                """
                ));
    }
}
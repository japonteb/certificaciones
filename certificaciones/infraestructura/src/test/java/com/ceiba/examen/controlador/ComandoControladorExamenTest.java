package com.ceiba.examen.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.certificacion.servicio.testdatabuilder.ComandoCertificacionTestDataBuilder;
import com.ceiba.examen.comando.ComandoExamen;
import com.ceiba.examen.servicio.testdatabuilder.ComandoExamenTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorExamen.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorExamenTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia no crear un examen que ya está asignado a un cliente y certificación")
    void deberiaNoCrearUnExamen() throws Exception{
        // arrange
        ComandoExamen examen = new ComandoExamenTestDataBuilder()
        		.conComandoCertificacion(new ComandoCertificacionTestDataBuilder().conId(1L).build())
        		.build();
        // act - assert
        mocMvc.perform(post("/examenes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(examen)))
        		.andExpect(status().is4xxClientError());
    }
    
    @Test
    @DisplayName("Deberia crear un examen")
    void deberiaCrearUnExamen() throws Exception{
        // arrange
        ComandoExamen examen = new ComandoExamenTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/examenes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(examen)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 2}"));;
    }

}

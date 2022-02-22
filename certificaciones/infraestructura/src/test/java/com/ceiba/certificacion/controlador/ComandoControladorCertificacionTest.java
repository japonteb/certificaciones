package com.ceiba.certificacion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.certificacion.comando.ComandoCertificacion;
import com.ceiba.certificacion.servicio.testdatabuilder.ComandoCertificacionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCertificacion.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorCertificacionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una certificación")
    void deberiaCrearUnaCertificacion() throws Exception{
        // arrange
        ComandoCertificacion certificacion = new ComandoCertificacionTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/certificaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(certificacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar una certificación")
    void deberiaActualizarUnaCertificacion() throws Exception{
        // arrange
        Long id = 1L;
        ComandoCertificacion certificacion = new ComandoCertificacionTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/certificaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(certificacion)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar una certificación")
    void deberiaEliminarUnCertificacion() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/certificaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/certificaciones")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}

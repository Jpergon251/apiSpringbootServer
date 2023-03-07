package es.joseantonioperez.proyectospringjose;

import es.joseantonioperez.proyectospringjose.repositories.JuegoPartidaJugadorRepository;
import es.joseantonioperez.proyectospringjose.repositories.JuegoRepository;
import es.joseantonioperez.proyectospringjose.repositories.JugadorRepository;
import es.joseantonioperez.proyectospringjose.repositories.PartidaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProyectoSpringJoseApplicationTests {

    @Autowired
    MockMvc mvc;
    @Autowired
    JuegoRepository juegoRepository;
    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    JuegoPartidaJugadorRepository juegoPartidaJugadorRepository;

    @Test
    void contextLoads() {
        assert juegoRepository.count() == 5;
        assert partidaRepository.count() == 10;
        assert jugadorRepository.count() == 15;
    }

    @Test
    void listaJugadorTest() throws Exception{
        mvc.perform(get("/juego/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Hearthstone"));
    }
}

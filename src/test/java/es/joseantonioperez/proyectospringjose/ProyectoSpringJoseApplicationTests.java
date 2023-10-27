package es.joseantonioperez.proyectospringjose;

import es.joseantonioperez.proyectospringjose.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProyectoSpringJoseApplicationTests {


    @Autowired
    MockMvc mvc;

    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        assert partidaRepository.count() == 10;
        assert jugadorRepository.count() == 15;
        //assert juegoPartidaJugadorRepository.count() == 10;
        assert userRepository.count() == 1;
    }

    public String authenticateAndGetToken() throws Exception {
        String username = "Jose";
        String password = "pestillo";

        return mvc.perform(MockMvcRequestBuilders.post("/token")
                        .with(httpBasic(username, password)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
    @Test
    void listaTest() throws Exception {

        mvc.perform(get("/jugador/").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + authenticateAndGetToken() ))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        mvc.perform(get("/juego/").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + authenticateAndGetToken() ))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        mvc.perform(get("/partidas/").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + authenticateAndGetToken()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }
    @Test
    void creationTest() throws Exception{

        String testJuego = "{\"nombre\": \"Minecraft\"}";
        mvc.perform(post("/juego/create")
                        .header("Authorization", "Bearer " + authenticateAndGetToken())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(testJuego))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Minecraft"));


        long partidaCount = partidaRepository.count();
        String testPartida = "{\"duracion\": 1500.0}";
        mvc.perform(post("/partidas/create")
                        .header("Authorization", "Bearer " + authenticateAndGetToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testPartida))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.duracion").value(1500.0));
        assert partidaRepository.count() == partidaCount +1;

        long jugadorCount = jugadorRepository.count();
        String testJugador = "{\"nombre\": \"Noob69\", \"edad\": 23, \"horasJugadas\": 3000}";
        mvc.perform(post("/jugador/create")
                        .header("Authorization", "Bearer " + authenticateAndGetToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testJugador))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Noob69"))
                .andExpect(jsonPath("$.edad").value(23))
                .andExpect(jsonPath("$.horasJugadas").value(3000));
        assert jugadorRepository.count() == jugadorCount +1;

    }
    @Test
    void updateTest() throws Exception {

        String testJuego = "{\"nombre\": \"Minecraft\"}";
        mvc.perform(put("/juego/2/")
                        .header("Authorization", "Bearer " + authenticateAndGetToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testJuego))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Minecraft"));

        String testPartida = "{\"duracion\": 1500.0}";
        mvc.perform(put("/partidas/3/")
                        .header("Authorization", "Bearer " + authenticateAndGetToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testPartida))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.duracion").value(1500.0));

        String testjugador = "{\"nombre\": \"lewis\", \"edad\": 24, \"horasJugadas\": 6000}";

        mvc.perform(put("/jugador/2/")
                        .header("Authorization", "Bearer " + authenticateAndGetToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testjugador))
                .andExpect(status().isOk()) // test result
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("lewis"))
                .andExpect(jsonPath("$.edad").value(24))
                .andExpect(jsonPath("$.horasJugadas").value(6000));

    }
    @Test
    void deleteTest() throws Exception {


        mvc.perform(delete("/juego/3/").contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + authenticateAndGetToken()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));


        long partidaCount = partidaRepository.count();

        mvc.perform(delete("/partidas/5/").contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + authenticateAndGetToken()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        assert partidaRepository.count() == partidaCount - 1;
        long jugadorCount = jugadorRepository.count();

        mvc.perform(delete("/jugador/6/").contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + authenticateAndGetToken()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        assert jugadorRepository.count() == jugadorCount - 1;
    }
}
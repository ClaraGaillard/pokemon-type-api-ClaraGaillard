package com.miage.altea.tp.pokemon_type_api.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import com.miage.altea.tp.pokemon_type_api.Application;
import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes= Application.class)
class PokemonTypeControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PokemonTypeController controller;

    @Test
    void pokemonTypeController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getPokemon_withId25_ShouldReturnPikachu() throws Exception {
        var url = "http://localhost:" + port + "/pokemon-types/25";

        var pikachu = this.restTemplate.getForObject(url, PokemonType.class);

        assertNotNull(pikachu);
        assertEquals(25, pikachu.getId());
        assertEquals("pikachu", pikachu.getName());
        assertEquals(4, pikachu.getHeight());
    }
}
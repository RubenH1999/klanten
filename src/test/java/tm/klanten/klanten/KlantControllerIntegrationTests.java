package tm.klanten.klanten;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tm.klanten.klanten.model.Klant;
import tm.klanten.klanten.repository.KlantRepository;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class KlantControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KlantRepository klantRepository;

    private Klant klant1 = new Klant("Ruben", "Horemans", "0001", "0493049076", "rubenhoremans1999@gmail.com", "TM");
    private Klant klant2 = new Klant("Klant", "Test", "0002", "0493234276", "rubenhoreman9@gmail.com", "TM");
    private Klant klantToBeDeleted = new Klant("Test", "klant", "0003", "034323234", "rubenns1999@gmail.com", "TM");

    @BeforeEach
    public void beforeAllTests() {
        klantRepository.deleteAll();
        klantRepository.save(klant1);
        klantRepository.save(klant2);
        klantRepository.save(klantToBeDeleted);
    }

    @AfterEach
    public void afterAllTests() { klantRepository.deleteAll();}

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenKlant_whenGetKlantenByBedrijf_thenReturnJsonKlant() throws Exception {
        mockMvc.perform(get("/klanten/bedrijf/{bedrijf}", "TM"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].voornaam", is("Ruben")))
                .andExpect(jsonPath("$[0].achternaam", is("Horemans")))
                .andExpect(jsonPath("$[0].klantnummer", is("0001")))
                .andExpect(jsonPath("$[0].gsmNummer", is("0493049076")))
                .andExpect(jsonPath("$[0].email", is("rubenhoremans1999@gmail.com")))
                .andExpect(jsonPath("$[0].bedrijf", is("TM")));
    }
}

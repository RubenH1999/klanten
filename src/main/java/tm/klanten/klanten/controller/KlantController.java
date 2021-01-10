package tm.klanten.klanten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tm.klanten.klanten.model.Klant;
import tm.klanten.klanten.repository.KlantRepository;

import java.util.List;

@RestController
@RequestMapping("klanten")
public class KlantController {

    @Autowired
    private KlantRepository klantRepository;

    @GetMapping
    public List<Klant> getKlanten() {
        return klantRepository.findAll();
    }

    @GetMapping("/klantnummer")
    public Klant getKlantByKlantnummer(@RequestParam String klantnummer) {
        return klantRepository.findKlantenByKlantnummer(klantnummer);
    }

    @GetMapping("/bedrijf/{bedrijf}")
    public List<Klant> getKlantenByBedrijf(@PathVariable String bedrijf) {
        return klantRepository.findKlantenByBedrijf(bedrijf);
    }
}

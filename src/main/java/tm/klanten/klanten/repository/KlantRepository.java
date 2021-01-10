package tm.klanten.klanten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tm.klanten.klanten.model.Klant;

import java.util.List;

public interface KlantRepository  extends JpaRepository<Klant,Long> {

    Klant findKlantenByKlantnummer(String klantNummer);

    List<Klant> findKlantenByBedrijf(String bedrijf);
}

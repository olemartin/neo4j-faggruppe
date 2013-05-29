package no.bekk.nosql.integration;

import no.bekk.nosql.domain.Faggruppe;
import no.bekk.nosql.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Repository {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private Neo4jTemplate template;

    public void populate() {
        Person knut = new Person("Knut Dullum");
        Person kris = new Person("Kristoffer Dyrkorn");
        Person mik = new Person("Mikael Vik");
        Person eiv = new Person("Eivind Bergstøl");
        Person veg = new Person("Vegard Skjefstad");
        Person ket = new Person("Ketil S. Velle");
        Person and = new Person("Andreas Heim");

        Faggruppe nosql = new Faggruppe("NoSQL");
        nosql.leggTilMedlem(knut, kris, mik, eiv, veg, ket, and);
        lagre(nosql);
        lagre(knut, kris, mik, eiv, veg, ket, and);
    }

    private void lagre(Object... objects) {
        for (Object object : objects) {
            template.save(object);
        }
    }
}

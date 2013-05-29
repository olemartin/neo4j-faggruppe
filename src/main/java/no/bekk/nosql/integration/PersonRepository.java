package no.bekk.nosql.integration;

import no.bekk.nosql.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PersonRepository
        extends GraphRepository<Person> {

    @Query(
            "start gruppe=node:faggruppe(navn = {navn}) " +
            "match person -[:MEDLEM_AV]-> gruppe " +
            "return person")
    public Iterable<Person> medlemmerAvFaggruppe(
            @Param("navn") String navn);

    //@Query("start gruppe=node:faggruppe(navn = {navn}) match person -[:MEDLEM_AV]-> gruppe return person")
    //public Iterable<Person> hentMedlemmerAvFaggruppenSomPersonErMedlemAv(@Param("navn") String navn);
}
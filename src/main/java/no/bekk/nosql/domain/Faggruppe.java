package no.bekk.nosql.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Faggruppe {

    @GraphId
    Long id;
    @Indexed(indexName = "faggruppe", indexType = IndexType.FULLTEXT)
    private String navn;


    @RelatedTo(type = "MEDLEM")
    private Set<Person> medlemmer = new HashSet<>();

    @RelatedTo(type = "JOBBER_MED")
    private Set<Fag> jobberMed = new HashSet<>();

    private Faggruppe() {
    }

    public Faggruppe(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public Set<Person> getMedlemmer() {
        return medlemmer;
    }

    public Set<Fag> getJobberMed() {
        return jobberMed;
    }

    public void leggTilMedlem(Person... personer) {
        for (Person person : personer) {
            person.erMedlemAv(this);
            medlemmer.add(person);
        }
    }
}

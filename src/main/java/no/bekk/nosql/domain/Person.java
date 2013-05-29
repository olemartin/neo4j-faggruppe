package no.bekk.nosql.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Person {

    @GraphId
    Long id;
    @Indexed(indexName = "person", indexType = IndexType.FULLTEXT)
    private String navn;

    @RelatedTo(type = "MEDLEM_AV")
    private Faggruppe faggruppe;

    @RelatedTo(type = "KAN")
    private Set<Fag> kan  = new HashSet<>();

    private Person() {
    }

    public Person(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public Faggruppe getFaggruppe() {
        return faggruppe;
    }

    public Set<Fag> getKan() {
        return kan;
    }

    public void erMedlemAv(Faggruppe faggruppe) {
        this.faggruppe = faggruppe;
    }
}

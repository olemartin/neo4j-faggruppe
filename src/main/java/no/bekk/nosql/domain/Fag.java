package no.bekk.nosql.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class Fag {

    @GraphId
    Long id;
    @Indexed(indexName = "faggruppe", indexType = IndexType.FULLTEXT)
    private String navn;


    private Fag() {
    }


    public Fag(String navn) {
        this.navn = navn;
    }


    public String getNavn() {
        return navn;
    }
}

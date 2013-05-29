package no.bekk.nosql.integration;


import no.bekk.nosql.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
@Transactional
public class PersonRepositoryIntTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    Repository repository;


    @Before
    public void initDatabase() {
        repository.populate();
    }

    @Test
    public void testHentMedlemmerAvFaggruppe() {
        Iterable<Person> persons = personRepository.medlemmerAvFaggruppe("NoSQL");
        int i = 0;

        for (Person ignored : persons) {
            i++;
        }
        assertThat(i, is(7));
    }


    @Test
    public void testCypher() {
//        String q = "start prosjekt1=node:prosjekt(navn = \"NAV\") " +
//                "match person -[:KAN]-> fag <-[:BRUKTE]- prosjekt1 " +
//                "with count(fag) as knownTech, person, prosjekt1 " +
//                "where length(()<-[:BRUKTE]-prosjekt1)=knownTech " +
//                "return person";
//        EndResult<Person> personer = faggruppeRepository.query(q, new HashMap<String, Object>());
//        for (Person person : personer) {
//            System.out.println(person.getNavn());
//        }

    }
}

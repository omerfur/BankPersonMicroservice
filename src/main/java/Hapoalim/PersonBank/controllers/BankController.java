package Hapoalim.PersonBank.controllers;


import Hapoalim.PersonBank.Entities.Person;
import Hapoalim.PersonBank.Entities.enums.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;


    @GetMapping("/readAllPeople")
    public List<Person> readAllPeople()
    {
       return Arrays.asList(restTemplate.getForEntity(environment.getProperty("personMicroservice")+"/readMultipulPersons",Person [].class).getBody());
    }

    @GetMapping("/readAllPeopleStartWithAOrK")
    public List<Person> readAllPeopleStartWithAOrK()
    {
        return readAllPeople().stream().filter(p->(p.getName().startsWith("A")) || (p.getName().startsWith("K"))).collect(Collectors.toList());
    }

    @GetMapping("/getAllPeopleFromIsraelWithAvgWight")
    public List<Person> getAllPeopleFromIsraelWithAvgWight()
    {
        List<Person> allPeople = readAllPeople();
        double avgWeight = allPeople.stream().mapToDouble(Person::getWeight).average().getAsDouble();
        return allPeople.stream().filter(p->p.getAddress().getState()==State.Israel && p.getWeight()>avgWeight).collect(Collectors.toList());
    }

}

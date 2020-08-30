package com.junit.testing.spring.service;

import com.junit.testing.spring.model.Persona;
import com.junit.testing.spring.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class PersonaService
{

    @Autowired
    PersonaRepository personaRepository;

    public boolean isTelephoneNumberValid(int id)
    {
        Persona p = personaRepository.getPersonaById(id);
        if(p.getPhoneNumber().contains("+"))
            return true;
        else
            return false;
    }

    public String isLegal(int id)
    {
        Persona p = personaRepository.getPersonaById(id);
        if(p.getAge()>18)
            return "Its Legal";
        else
            return "Its Ilegal";
    }

    public Integer amountOfRegistries()
    {
        ArrayList<Persona> personaArrayList = personaRepository.getAll();
        if(personaArrayList != null)
            return personaArrayList.size();
        else
            return 0;
    }
}

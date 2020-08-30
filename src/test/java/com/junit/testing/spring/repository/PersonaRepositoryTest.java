package com.junit.testing.spring.repository;

import com.junit.testing.spring.model.Persona;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaRepositoryTest
{

    PersonaRepository personaRepository = new PersonaRepository();
    Persona p;

    @Test
    public void ifGetPersonaByIdIsFoundThenReturnTrue()
    {
        p = personaRepository.getPersonaById(1);
        boolean status = (p.getId() == 1);
        assertEquals(true, status);
    }

    @Test
    public void ifGetPersonaByIdIsNOTFoundThenReturnTrue()
    {
        p = personaRepository.getPersonaById(77);
        boolean status = (p.getId() == 99999);
        assertEquals(true, status);
    }

    @Test
    public void getAllPersonasShouldReturnAListOf5()
    {
        ArrayList<Persona> personaArrayList = personaRepository.getAll();
        assertEquals(6, personaArrayList.size());
    }





}

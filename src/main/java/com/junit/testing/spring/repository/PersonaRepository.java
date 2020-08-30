package com.junit.testing.spring.repository;

import com.junit.testing.spring.model.NullPersona;
import com.junit.testing.spring.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PersonaRepository
{
    private ArrayList<Persona> personasList = new ArrayList<Persona>();

    private void init()
    {
        Persona p = new Persona(1, "Juan", "Paulich", "+35412354", 20);
        Persona p2 = new Persona(2, "Hernan", "Pizarro", "35412354", 20);
        Persona p3 = new Persona(3, "Melania", "Gelati", "+3523112354",30);
        Persona p4 = new Persona(4, "John", "Doe", "+2582535412354", 35);
        Persona p5 = new Persona(5, "John", "Doe", "+2582535412354", 35);
        personasList.add(p);
        personasList.add(p2);
        personasList.add(p3);
        personasList.add(p4);
        personasList.add(p5);
    }

    public Persona getPersonaById(int id)
    {
        init();
        for(Persona p : personasList)
        {
            if(p.getId() == id)
                return p;
        }
        NullPersona emptyPersona = new NullPersona();
        return new Persona(emptyPersona.getId(), emptyPersona.getName(), emptyPersona.getLastname(), emptyPersona.getPhoneNumber(), emptyPersona.getAge());
    }


    public ArrayList<Persona> getAll()
    {
        init();
        Persona p = new Persona(6, "Rocio", "Córdoba", "+32135349", 17);
        personasList.add(p);
        return personasList;
    }
}

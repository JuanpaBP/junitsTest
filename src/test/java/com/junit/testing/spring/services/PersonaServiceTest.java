package com.junit.testing.spring.services;

import com.junit.testing.spring.model.Persona;
import com.junit.testing.spring.repository.PersonaRepository;
import com.junit.testing.spring.service.PersonaService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.*;

public class PersonaServiceTest
{

    Persona p  = new Persona(1, "Juan", "Paulich", "+35412354", 30);
    Persona p2 = new Persona(1, "Juan", "Paulich", "35412354", 17);

    ArrayList<Persona> personasList = new ArrayList<>();
    @Mock
    PersonaRepository personaRepository;

    @InjectMocks
    PersonaService personaService = new PersonaService();


    @BeforeEach
    public void init()
    {
        initMocks(this);
        when(personaRepository.getPersonaById(anyInt())).thenReturn(p);
        personasList.add(p);
        personasList.add(p2);
        when(personaRepository.getAll()).thenReturn(personasList);
    }

    @Test
    public void ifTelephoneNumberHasAPlusThenReturnTrue()
    {
        boolean status = personaService.isTelephoneNumberValid(123124);
        assertEquals(true, status);
    }

    @Test
    public void ifTelephoneNumberHasntAPlusThenReturnTrue()
    {
        p.setPhoneNumber("354432135");
        boolean status = personaService.isTelephoneNumberValid(123123);
        assertEquals(false, status);
    }

    @Test
    public void ifAgeIsOver18ThenReturnItsLegal()
    {
        String message = personaService.isLegal(123123);
        assertEquals("Its Legal", message);
    }

    @Test
    public void ifAgeIsUnder18ThenReturnItsIlegal()
    {
        when(personaRepository.getPersonaById(anyInt())).thenReturn(p2);
        String message = personaService.isLegal(123123);
        assertEquals("Its Ilegal", message);
    }

    @Test
    public void ifAmountOfRegistriesIsNotNullThenReturnNotZero()
    {
        int amount = personaService.amountOfRegistries();
        assertFalse(amount == 0);
    }

    @Test
    public void ifAmountOfRegistriesIsNullThenReturnZero()
    {
        when(personaRepository.getAll()).thenReturn(null);
        int amount = personaService.amountOfRegistries();
        assertTrue(amount == 0);
    }

    @Test
    public void ifAmountOfRegistriesIsEmptyThenReturnZero()
    {
        when(personaRepository.getAll()).thenReturn(new ArrayList<Persona>());
        int amount = personaService.amountOfRegistries();
        assertTrue(amount == 0);
    }

}

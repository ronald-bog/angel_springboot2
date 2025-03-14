package com.universidad.ppooii.apirest.services;

import com.universidad.ppooii.apirest.entities.Persona;
import com.universidad.ppooii.apirest.repositories.PersonaRepository;
import com.universidad.ppooii.apirest.services.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.SecureRandom;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    // Métodos CRUD
    @Override
    public void guardar(Persona persona) {
        Integer edad = calcularEdad(persona.getFechanacimiento(), LocalDate.now()).getYears();
        String edadClinica = calcularEdadClinica(persona.getFechanacimiento(), LocalDate.now());
        persona.setEdad(edad);
        persona.setEdadclinica(edadClinica);
        personaRepository.save(persona);
        System.out.println(createLogin(persona));
    }

    public static Period calcularEdad(Date persona, LocalDate fechaActual) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String fecha = sdf.format(persona);
        String fechaSolo = fecha.split("T")[0];
        LocalDate fechaLocalDate = LocalDate.parse(fechaSolo);
        //return Period.between(fechaLocalDate, fechaActual).getYears();
        return Period.between(fechaLocalDate, fechaActual);
    }

    public static String calcularEdadClinica(Date persona, LocalDate fechaActual) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//        String fecha = sdf.format(persona);
//        String fechaSolo = fecha.split("T")[0];
//        LocalDate fechaLocalDate = LocalDate.parse(fechaSolo);
        Period period = calcularEdad(persona, LocalDate.now());
        int years = period.getYears();
        int meses = period.getMonths();
        int dias = period.getDays();

        // Construir la cadena de texto
        StringBuilder edadClinicaBuilder = new StringBuilder();
        if (years > 0) {
            edadClinicaBuilder.append(years).append(" years");
        }
        if (meses > 0) {
            if (!edadClinicaBuilder.isEmpty()) {
                edadClinicaBuilder.append(" ");
            }
            edadClinicaBuilder.append(meses).append(" meses");
        }
        if (dias > 0) {
            if (!edadClinicaBuilder.isEmpty()) {
                edadClinicaBuilder.append(" ");
            }
            edadClinicaBuilder.append(dias).append(" días");
        }

        return edadClinicaBuilder.toString();
    }

    public static String createLogin(Persona persona) {
        String primerNombre = persona.getPnombre();
        char pLetraApellido = persona.getPapellido().charAt(0);
        long idUser = persona.getId();
        return primerNombre + pLetraApellido + idUser;
    }


    public static String passwordOrKey(int longitud, char pOK) {
        String caracteres = pOK == 'P' ?
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+":
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
                ;
        StringBuilder sb = new StringBuilder(longitud);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indice));
        }
        return sb.toString();
    }


//    @Override
//    public void guardar(Persona persona) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//        String fecha = sdf.format(persona.getFechanacimiento());
//        String fechaSolo = fecha.split("T")[0];
//        LocalDate fechaLocalDate = LocalDate.parse(fechaSolo);
//        Integer edad = calcularEdad(fechaLocalDate, LocalDate.now());
//        persona.setEdad(edad);
//        personaRepository.save(persona);
//    }
//
//    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
//        return Period.between(fechaNacimiento, fechaActual).getYears();
//    }

    @Override
    public void actualizar(long id, Persona persona) {
        Persona person = personaRepository.findById(id).get();
        person.setIdentificacion(persona.getIdentificacion());
        person.setPnombre(persona.getPnombre());
        person.setSnombre(persona.getSnombre());
        person.setPapellido(persona.getPapellido());
        person.setSapellido(persona.getSapellido());
        person.setEmail(persona.getEmail());
        person.setFechanacimiento(persona.getFechanacimiento());
        person.setEdad(persona.getEdad());
        person.setEdadclinica(persona.getEdadclinica());
        personaRepository.save(person);
    }

    @Override
    public void eliminar(long id) {
        Persona person = personaRepository.findById(id).get();
        personaRepository.delete(person);
    }

    @Override
    public List<Persona> consultarPersona() {
        System.out.println(passwordOrKey(12,'P'));
        System.out.println(passwordOrKey(10,'K'));
        return personaRepository.findAll();
    }

    // Búsquedas Específicas

    @Override
    public Persona findByidentificacion(long identificacion) {
        return personaRepository.findByidentificacion(identificacion);
    }

    @Override
    public List<Persona> findByedad(int edad) {
        return personaRepository.findByedad(edad);
    }


    @Override
    public List<Persona> findBypapellido(String papellido) {
        return personaRepository.findBypapellido(papellido);
    }


    @Override
    public List<Persona> findBypnombre(String p_nombre) {
        return personaRepository.findBypnombre(p_nombre);
    }


}

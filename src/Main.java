

import java.io.File;
import java.time.LocalDate;

import javax.xml.bind.JAXBException;

import dad.javafx.jaxb.Agenda;
import dad.javafx.jaxb.Contacto;
import dad.javafx.jaxb.Telefono;
import dad.javafx.jaxb.TipoTelefono;

public class Main {

	public static void main(String[] args) throws JAXBException {
		
		Contacto c1 = new Contacto();
		c1.setNombre("Chuck Norris");
		c1.setFechaNacimiento(LocalDate.of(1965, 5, 27));
		c1.getTelefonos().add(new Telefono(TipoTelefono.MOVIL, 922102030L));

		Contacto c2 = new Contacto();
		c2.setNombre("Kurt Russell");

		Contacto c3 = new Contacto();
		c3.setNombre("Sylvester Stallone");
		
		Agenda agenda = new Agenda();
		agenda.getContactos().add(c1);
		agenda.getContactos().add(c2);
		agenda.getContactos().add(c3);	
		
		agenda.save(new File("agenda.xml"));
		
		agenda = Agenda.load(new File("agenda.xml"));
		
		System.out.println(agenda.getContactos().get(0).getNombre());

	}

}

package dad.javafx.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Test {

	public static void main(String[] args) throws JAXBException {

		Contacto c1 = new Contacto();
		c1.setNombre("Chuck Norris");

		Contacto c2 = new Contacto();
		c2.setNombre("Kurt Russell");

		Contacto c3 = new Contacto();
		c3.setNombre("Sylvester Stallone");
		
		Agenda agenda = new Agenda();
		agenda.getContactos().add(c1);
		agenda.getContactos().add(c2);
		agenda.getContactos().add(c3);	
		
		JAXBContext context = JAXBContext.newInstance(Agenda.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(agenda, new File("agenda.xml"));
	}

}

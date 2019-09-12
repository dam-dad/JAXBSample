package dad.javafx.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlRootElement
@XmlType
public class Agenda {
	private ListProperty<Contacto> contactos;

	public Agenda() {
		contactos = new SimpleListProperty<>(this, "contactos", FXCollections.observableArrayList());
	}

	public final ListProperty<Contacto> contactosProperty() {
		return this.contactos;
	}

	@XmlElement
	public final ObservableList<Contacto> getContactos() {
		return this.contactosProperty().get();
	}

	public final void setContactos(final ObservableList<Contacto> contactos) {
		this.contactosProperty().set(contactos);
	}
	
	public void save(File file) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Agenda.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(this, file);		
	}
	
	public static Agenda load(File file) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Agenda.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (Agenda) unmarshaller.unmarshal(file);		
	}

}
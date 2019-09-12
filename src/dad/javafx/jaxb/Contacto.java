package dad.javafx.jaxb;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlType
public class Contacto {
	private StringProperty nombre;
	private ObjectProperty<LocalDate> fechaNacimiento;
	private ListProperty<Telefono> telefonos;

	public Contacto() {
		nombre = new SimpleStringProperty(this, "nombre");
		fechaNacimiento = new SimpleObjectProperty<>(this, "fechaNacimiento");
		telefonos = new SimpleListProperty<>(this, "telefonos", FXCollections.observableArrayList());
	}

	public final StringProperty nombreProperty() {
		return this.nombre;
	}

	@XmlAttribute
	public final String getNombre() {
		return this.nombreProperty().get();
	}

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public final ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}

	@XmlAttribute
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public final LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}

	public final void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimientoProperty().set(fechaNacimiento);
	}

	public final ListProperty<Telefono> telefonosProperty() {
		return this.telefonos;
	}

	public final ObservableList<Telefono> getTelefonos() {
		return this.telefonosProperty().get();
	}

	public final void setTelefonos(final ObservableList<Telefono> telefonos) {
		this.telefonosProperty().set(telefonos);
	}

}

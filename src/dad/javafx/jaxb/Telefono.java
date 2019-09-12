package dad.javafx.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

@XmlType
public class Telefono {
	private ObjectProperty<TipoTelefono> tipo;
	private LongProperty numero;

	public Telefono(TipoTelefono tipo, Long numero) {
		this.tipo = new SimpleObjectProperty<>(this, "tipo", tipo);
		this.numero = new SimpleLongProperty(this, "numero", numero);
	}
	
	public Telefono() {
		this(TipoTelefono.FIJO, 0L);
	}
	
	public final ObjectProperty<TipoTelefono> tipoProperty() {
		return this.tipo;
	}

	@XmlAttribute
	public final TipoTelefono getTipo() {
		return this.tipoProperty().get();
	}

	public final void setTipo(final TipoTelefono tipo) {
		this.tipoProperty().set(tipo);
	}

	public final LongProperty numeroProperty() {
		return this.numero;
	}

	@XmlAttribute
	public final long getNumero() {
		return this.numeroProperty().get();
	}

	public final void setNumero(final long numero) {
		this.numeroProperty().set(numero);
	}

}

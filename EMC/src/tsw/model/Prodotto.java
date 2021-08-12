package tsw.model;

import java.util.List;
import java.util.Objects;

public class Prodotto {
	private int id;
	private String nome;
	private String descrizione;
	private long prezzoBase;
	private int iva;
	private int idcategoria;

	public Prodotto(int id, String nome, String descrizione, long prezzoBase, int iva, int idcategoria) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzoBase = prezzoBase;
		this.iva = iva;
		this.idcategoria = idcategoria;
	}

	public Prodotto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public long getPrezzoBase() {
		return prezzoBase;
	}

	public void setPrezzoBase(long prezzoBase) {
		this.prezzoBase = prezzoBase;
	}

	public int getIva() {return iva;}

	public void setIva(int iva) {this.iva = iva; }

	public String getPrezzoEuro() {
		return String.format("%.2f", (prezzoBase / 100.)+((prezzoBase/100.)*iva)/100.);
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int categoria) {
		this.idcategoria = categoria;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzoBase=" + prezzoBase
				+ ", categorie=" + idcategoria + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Prodotto prodotto = (Prodotto) o;
		return id == prodotto.id && prezzoBase == prodotto.prezzoBase && iva == prodotto.iva && idcategoria == prodotto.idcategoria && Objects.equals(nome, prodotto.nome) && Objects.equals(descrizione, prodotto.descrizione);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, descrizione, prezzoBase, iva, idcategoria);
	}
}

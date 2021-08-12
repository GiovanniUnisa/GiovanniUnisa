package tsw.model;

import java.util.Collection;
import java.util.LinkedHashMap;


public class Carrello {
	public static class ProdottoQuantita {
		private Prodotto prodotto;
		private int quantita;

		public ProdottoQuantita() {
		}

		public ProdottoQuantita(Prodotto prodotto, int quantita) {
			this.prodotto = prodotto;
			this.quantita = quantita;
		}

		public int getQuantita() {
			return quantita;
		}

		public void setQuantita(int quantita) {
			this.quantita = quantita;
		}

		public Prodotto getProdotto() {
			return prodotto;
		}

		public double getPrezzoTotCent() {
			return quantita * ((prodotto.getPrezzoBase()+((prodotto.getPrezzoBase()*prodotto.getIva())/100.)));
		}

		public String getPrezzoTotEuro() {
			return String.format("%.2f", quantita * ((prodotto.getPrezzoBase()/100.)+((prodotto.getPrezzoBase()/100)*prodotto.getIva())/100.));
		}
	}

	private LinkedHashMap<Integer, ProdottoQuantita> prodotti = new LinkedHashMap<>();

	public Collection<ProdottoQuantita> getProdotti() {
		return prodotti.values();
	}

	public ProdottoQuantita get(int prodId) {
		return prodotti.get(prodId);
	}

	public void put(Prodotto prodotto, int quantita) {
		prodotti.put(prodotto.getId(), new ProdottoQuantita(prodotto, quantita));
	}

	public ProdottoQuantita remove(int prodId) {
		return prodotti.remove(prodId);
	}

	public long getPrezzoTotCent() {
		return prodotti.values().stream().mapToLong(p -> (long) p.getPrezzoTotCent()).sum();
	}

	public String getPrezzoTotEuro() {
		return String.format("%.2f", getPrezzoTotCent()/100.);
	}

	@Override
	public String toString() {
		return "Carrello [prodotti=" + prodotti + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodotti == null) ? 0 : prodotti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrello other = (Carrello) obj;
		if (prodotti == null) {
			if (other.prodotti != null)
				return false;
		} else if (!prodotti.equals(other.prodotti))
			return false;
		return true;
	}

}
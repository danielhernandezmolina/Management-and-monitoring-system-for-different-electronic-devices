package dispositivosElectronicos05;

public class SesionUso {

	private double horas;
	private double consumo;
	private double temperaturaMax;

	public SesionUso(double horas, double consumo, double temperaturaMax) {
		this.horas = horas;
		this.consumo = consumo;
		this.temperaturaMax = temperaturaMax;
	}

	public double getHoras() {
		return horas;
	}

	public double getConsumo() {
		return consumo;
	}

	public double getTemperaturaMax() {
		return temperaturaMax;
	}

	@Override
	public String toString() {
		return "SesionUso [hours=" + horas + ", consumption=" + consumo + ", maxTemperature=" + temperaturaMax + "]";
	}

}

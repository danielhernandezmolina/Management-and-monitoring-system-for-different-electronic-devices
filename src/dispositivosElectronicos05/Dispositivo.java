package dispositivosElectronicos05;

import java.util.ArrayList;

import dispositivosElectronicos05.SesionUso;

public class Dispositivo {

	private String codigo;
	private String nombre;
	private String tipo;

	private ArrayList<SesionUso> sesiones;

	public Dispositivo(String codigo, String nombre, String tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.sesiones = new ArrayList<>();
	}

	public void registrarSesion(SesionUso sesion) {

		sesiones.add(sesion);

	}

	public double mediaConsumo() {

		if (sesiones.isEmpty()) {

			System.out.println("No hay sesiones");
			return 0.0;
		} else {
			double suma = 0;
			for (SesionUso s : sesiones) {
				suma = suma + s.getConsumo();

			}
			return suma / sesiones.size();
		}

	}

	public double mediaTemperatura() {

		if (sesiones.isEmpty()) {

			System.out.println("No hay sesiones");
			return 0.0;
		} else {
			double suma = 0;
			for (SesionUso s : sesiones) {
				suma = suma + s.getTemperaturaMax();
			}
			return suma / sesiones.size();

		}

	}

	public double totalHorasUso() {

		if (sesiones.isEmpty()) {

			System.out.println("No hay sesiones");
			return 0.0;
		} else {
			double suma = 0;
			for (SesionUso s : sesiones) {
				suma = suma + s.getHoras();
			}

			return suma;
		}

	}

	public SesionUso sesionMayorConsumo() {

		if (sesiones.isEmpty()) {

			System.out.println("No hay sesiones");
			return null;
		} else {
			SesionUso sesionGanadora = null;
			double mayorConsumo = -1;

			for (SesionUso s : sesiones) {
				if (s.getConsumo() > mayorConsumo) {

					mayorConsumo = s.getConsumo();

					sesionGanadora = s;

				}

			}
			return sesionGanadora;
		}

	}

	@Override
	public String toString() {
		return "Dispositivo [codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", mediaConsumo()="
				+ mediaConsumo() + ", mediaTemperatura()=" + mediaTemperatura() + ", totalHorasUso()=" + totalHorasUso()
				+ "]";
	}

	public void mostrarSesiones() {

		if (sesiones.isEmpty()) {

			System.out.println("No hay sesiones");

		} else {
			for (SesionUso i : sesiones) {

				System.out.println("Sesion:" + i);
			}
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public ArrayList<SesionUso> getSesiones() {
		return sesiones;
	}

}

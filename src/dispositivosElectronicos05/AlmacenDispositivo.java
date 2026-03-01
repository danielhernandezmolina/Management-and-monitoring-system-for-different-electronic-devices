package dispositivosElectronicos05;

import java.util.ArrayList;
import java.util.HashMap;
import dispositivosElectronicos05.Dispositivo;

public class AlmacenDispositivo {

	private Dispositivo[] inventario;
	private int contador;
	private HashMap<String, Dispositivo> indicePorCodigo;

	public AlmacenDispositivo(Dispositivo[] inventario, int contador, HashMap<String, Dispositivo> indicePorCodigo) {

		this.inventario = new Dispositivo[30];
		this.contador = 0;
		this.indicePorCodigo = new HashMap<>();
	}

	public AlmacenDispositivo() {

		this.inventario = new Dispositivo[30];
		this.contador = 0;
		this.indicePorCodigo = new HashMap<>();
	}

	public boolean altaDispositivo(Dispositivo d) {

		if (indicePorCodigo.containsKey(d.getCodigo())) {
			// Si entra aquí, es que ya existe, por lo tanto no lo añadimos.
			return false;
		}

		if (contador < 30) {

			inventario[contador] = d;

			contador++;

			indicePorCodigo.put(d.getCodigo(), d);

			return true;

		} else {
			System.out.println("Se ha superado el numero de dispositivos");
			return false;

		}

	}

	public Dispositivo buscarPorCodigo(String codigo) {

		if (indicePorCodigo.containsKey(codigo)) {
			return indicePorCodigo.get(codigo);

		} else {
			return null;
		}
	}

	public void listarDispositivos() {

		if (indicePorCodigo.isEmpty()) {
			System.out.println("No hay dispositivos registrados.");
			return;
		}

		for (Dispositivo i : inventario) {

			// Evitar espacios en blanco

			if (i != null) {
				System.out.println(i);
			}
		}
	}

	public double mediaGlobalConsumo() {

		if (inventario == null) {
			System.out.println("No hay dispositivos registrados");

			return 0.0;
		} else {
			double suma = 0;

			for (Dispositivo d : indicePorCodigo.values()) {

				suma = suma + d.mediaConsumo();

			}

			return suma / indicePorCodigo.size();

		}
	}

	public Dispositivo dispositivoMasUsado() {

		if (contador == 0) {
			System.out.println("No hay dispositivos registrados");

			return null;
		} else {

			Dispositivo dispMasUsado = null;
			double masUsado = -1;

			for (Dispositivo d : inventario) {

				// Compruebo que el dispositivo no sea null para que no siga recorriendo hasta
				// 30
				if (d != null) {

					if (d.totalHorasUso() > masUsado) {
						masUsado = d.totalHorasUso();
						dispMasUsado = d;
					}
				}

			}
			return dispMasUsado;
		}
	}

}

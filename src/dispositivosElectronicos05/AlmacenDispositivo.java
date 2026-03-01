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
			// If it enters here, it means it already exists, therefore we do not add it.
			return false;
		}

		if (contador < 30) {

			inventario[contador] = d;

			contador++;

			indicePorCodigo.put(d.getCodigo(), d);

			return true;

		} else {
			System.out.println("The maximum number of devices has been exceeded");
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
			System.out.println("No devices registered.");
			return;
		}

		for (Dispositivo i : inventario) {

			// Avoid blank spaces (null elements)

			if (i != null) {
				System.out.println(i);
			}
		}
	}

	public double mediaGlobalConsumo() {

		if (inventario == null) {
			System.out.println("No devices registered");

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
			System.out.println("No devices registered");

			return null;
		} else {

			Dispositivo dispMasUsado = null;
			double masUsado = -1;

			for (Dispositivo d : inventario) {

				// I check that the device is not null so it doesn't keep iterating up to
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

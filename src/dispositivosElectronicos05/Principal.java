package dispositivosElectronicos05;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AlmacenDispositivo almacen = new AlmacenDispositivo();

		int opcion = -1;

		do {

			try {

				System.out.println("\n--- MENÚ ---");
				System.out.println("1. Dar de alta un dispositivo");
				System.out.println("2. Registrar sesión de uso en un dispositivo");
				System.out.println("3. Mostrar información de un dispositivo");
				System.out.println("4. Listar todos los dispositivos");
				System.out.println("5. Mostrar estadisticas globales");
				System.out.println("6. Salir");
				System.out.print("Elige opción: ");

				opcion = Integer.parseInt(sc.nextLine());

				switch (opcion) {
				case 1: // Dar de alta un dispositivo

					System.out.println("Introduce el código del dispositivo: ");
					String codigo = sc.nextLine();

					System.out.println("Introduce el nombre de usuario: ");
					String nombreUsuario = sc.nextLine();

					System.out.println("Introduce el tipo de dispositivo (Tablet, movil, portatil..): ");
					String tipoDispositivo = sc.nextLine();

					Dispositivo dispositivo1 = new Dispositivo(codigo, nombreUsuario, tipoDispositivo);

					if (almacen.altaDispositivo(dispositivo1) == true) {

						System.out.println("Dispositivo añadido correctamente");

					} else {
						System.out.println("El codigo insertado ya existe en el sistema");
					}

					break;

				case 2: // Registrar sesion de uso en un dispositivo

					System.out.println("Introduce el código del dispositivo: ");
					String codigo2 = sc.nextLine();

					if (almacen.buscarPorCodigo(codigo2) == null) {
						System.out.println("El codigo de dispositivo insertado no es valido");
						break;
					} else {

						System.out.println("Introduce las horas de uso: ");
						double usoDispositivo = Double.parseDouble(sc.nextLine());

						if (usoDispositivo <= 0) {
							do {
								System.out.println("Introduce un numero mayor que 0.0: ");
								usoDispositivo = Double.parseDouble(sc.nextLine());

							} while (usoDispositivo <= 0.0);
						}

						System.out.println("Introduce el consumo del dispositivo: ");
						double consumoDispositivo = Double.parseDouble(sc.nextLine());

						if (consumoDispositivo <= 0.0) {
							do {
								System.out.println("Introduce un numero mayor que 0: ");
								consumoDispositivo = Double.parseDouble(sc.nextLine());
							} while (consumoDispositivo <= 0.0);
						}

						System.out.println("Introduce la temperatura maxima del dispositivo: ");
						double temperaturaMaxima = Double.parseDouble(sc.nextLine());

						if (temperaturaMaxima <= 0.0) {
							do {
								System.out.println("Introduce un numero mayor que 0: ");
								temperaturaMaxima = Double.parseDouble(sc.nextLine());
							} while (temperaturaMaxima <= 0.0);
						}

						SesionUso sesion = new SesionUso(usoDispositivo, consumoDispositivo, temperaturaMaxima);

						Dispositivo dispositivoReal = almacen.buscarPorCodigo(codigo2);

						dispositivoReal.registrarSesion(sesion);
						
						System.out.println("Registro realizado con exito!");

					}

					break;

				case 3: // Mostrar información de un dispositivo

					System.out.println("Introduce el código del dispositivo: ");
					String codigo3 = sc.nextLine();

					Dispositivo dispositivoEncontrado = almacen.buscarPorCodigo(codigo3);

					if (dispositivoEncontrado == null) {
						System.out.println("El codigo de dispositivo insertado no es valido");
						break;
					} else {

						System.out.println(dispositivoEncontrado.toString());

						System.out.println("Historial de sesiones:");

						dispositivoEncontrado.mostrarSesiones();
					}

					break;

				case 4: // Listar todos los dispositivos

					almacen.listarDispositivos();

					break;

				case 5: // Mostrar estadisticas globales

					System.out.println("Media global de consumo: " + almacen.mediaGlobalConsumo());

					Dispositivo masUsado = almacen.dispositivoMasUsado();
					if (masUsado != null) {
						System.out.println("El dispositivo más usado es: " + masUsado.toString());
					} else {
						System.out.println("No hay datos para calcular el más usado.");
					}

					break;

				case 6: // Salir

					System.out.println("Cerrando programa...");

					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("Introduce un numero valido");
			}

		} while (opcion != 6);

	}

}

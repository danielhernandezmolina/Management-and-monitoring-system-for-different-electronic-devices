package dispositivosElectronicos05;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AlmacenDispositivo almacen = new AlmacenDispositivo();

		int opcion = -1;

		do {

			try {

				System.out.println("\n--- MENU ---");
				System.out.println("1. Register a device");
				System.out.println("2. Register a usage session for a device");
				System.out.println("3. Show device information");
				System.out.println("4. List all devices");
				System.out.println("5. Show global statistics");
				System.out.println("6. Exit");
				System.out.print("Choose option: ");

				opcion = Integer.parseInt(sc.nextLine());

				switch (opcion) {
				case 1: // Register a device

					System.out.println("Enter the device code: ");
					String codigo = sc.nextLine();

					System.out.println("Enter the username: ");
					String nombreUsuario = sc.nextLine();

					System.out.println("Enter the device type (Tablet, mobile, laptop..): ");
					String tipoDispositivo = sc.nextLine();

					Dispositivo dispositivo1 = new Dispositivo(codigo, nombreUsuario, tipoDispositivo);

					if (almacen.altaDispositivo(dispositivo1) == true) {

						System.out.println("Device added successfully");

					} else {
						System.out.println("The inserted code already exists in the system");
					}

					break;

				case 2: // Register a usage session for a device

					System.out.println("Enter the device code: ");
					String codigo2 = sc.nextLine();

					if (almacen.buscarPorCodigo(codigo2) == null) {
						System.out.println("The inserted device code is not valid");
						break;
					} else {

						System.out.println("Enter the hours of use: ");
						double usoDispositivo = Double.parseDouble(sc.nextLine());

						if (usoDispositivo <= 0) {
							do {
								System.out.println("Enter a number greater than 0.0: ");
								usoDispositivo = Double.parseDouble(sc.nextLine());

							} while (usoDispositivo <= 0.0);
						}

						System.out.println("Enter the device consumption: ");
						double consumoDispositivo = Double.parseDouble(sc.nextLine());

						if (consumoDispositivo <= 0.0) {
							do {
								System.out.println("Enter a number greater than 0: ");
								consumoDispositivo = Double.parseDouble(sc.nextLine());
							} while (consumoDispositivo <= 0.0);
						}

						System.out.println("Enter the maximum temperature of the device: ");
						double temperaturaMaxima = Double.parseDouble(sc.nextLine());

						if (temperaturaMaxima <= 0.0) {
							do {
								System.out.println("Enter a number greater than 0: ");
								temperaturaMaxima = Double.parseDouble(sc.nextLine());
							} while (temperaturaMaxima <= 0.0);
						}

						SesionUso sesion = new SesionUso(usoDispositivo, consumoDispositivo, temperaturaMaxima);

						Dispositivo dispositivoReal = almacen.buscarPorCodigo(codigo2);

						dispositivoReal.registrarSesion(sesion);
						
						System.out.println("Registration completed successfully!");

					}

					break;

				case 3: // Show device information

					System.out.println("Enter the device code: ");
					String codigo3 = sc.nextLine();

					Dispositivo dispositivoEncontrado = almacen.buscarPorCodigo(codigo3);

					if (dispositivoEncontrado == null) {
						System.out.println("The inserted device code is not valid");
						break;
					} else {

						System.out.println(dispositivoEncontrado.toString());

						System.out.println("Session history:");

						dispositivoEncontrado.mostrarSesiones();
					}

					break;

				case 4: // List all devices

					almacen.listarDispositivos();

					break;

				case 5: // Show global statistics

					System.out.println("Global average consumption: " + almacen.mediaGlobalConsumo());

					Dispositivo masUsado = almacen.dispositivoMasUsado();
					if (masUsado != null) {
						System.out.println("The most used device is: " + masUsado.toString());
					} else {
						System.out.println("No data to calculate the most used.");
					}

					break;

				case 6: // Exit

					System.out.println("Closing program...");

					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("Enter a valid number");
			}

		} while (opcion != 6);

	}

}

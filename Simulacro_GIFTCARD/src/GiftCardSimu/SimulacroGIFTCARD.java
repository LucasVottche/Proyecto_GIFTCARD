package GiftCardSimu;

import java.util.Scanner;

public class SimulacroGIFTCARD {

	public static final String GIF1 = "TRAVESIA";
	public static final String GIF2 = "GASTRONOMIA";
	public static final String GIF3 = "VIAJE";
	public static final String OP1 = "S";
	public static final String OP2 = "N";
	public static final String BARRA = "-------------------------------------------------------------";
	public static int TRAVESIA = 500;
	public static int GASTRONOMIA = 1500;
	public static int VIAJE = 30000;
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int ingreso;
		double ingresoPrecio = 0;
		double totalRecaudado = 0;
		double mayorMonto = 0;
		int comprasRealizadas = 0;
		int regalosTravesia = 0;
		String mayorActv = "";
		String opcionCompr = "";
		String actividad = "";

		opcionCompr = desearComprar();
		System.out.println(BARRA);
		while (!opcionCompr.equals("N")) {
			menuGift();
			System.out.println(BARRA);
			ingreso = ingresoActividad();
			actividad = elegirActividad(ingreso);
			System.out.println(BARRA);
			ingresoPrecio = ingresoPrecio(ingreso);
			totalRecaudado = totalRecaudado + ingresoPrecio;
			comprasRealizadas++;
			if (ingresoPrecio > mayorMonto) {
				mayorMonto = ingresoPrecio;
				mayorActv = actividad;
			}
			if (actividad == GIF1) {
				regalosTravesia++;
			}
			/// 2doIngreso
			System.out.println(BARRA);
			opcionCompr = desearComprar();
			System.out.println(BARRA);
		}
		System.out.println(BARRA);
		mostrarResultado(totalRecaudado, mayorActv, mayorMonto, comprasRealizadas, regalosTravesia);
		System.out.println(BARRA);
	}

	public static void menuGift() {
		System.out.println("Elija la actividad que desea regalar:\r\n" + "1- travesía (desde $500)\r\n"
				+ "2- gastronomía (desde $1.500)\r\n" + "3- viaje (desde $30.000)\r\n" + "");
	}

	public static int ingresoActividad() {
		int ingreso;
		System.out.print("Ingrese la actividad que desea elegir : ");
		ingreso = input.nextInt();
		return ingreso;
	}

	public static String elegirActividad(int ingreso) {
		String elegir = "";
		switch (ingreso) {
		case 1:
			elegir = GIF1;
			break;
		case 2:
			elegir = GIF2;
			break;
		case 3:
			elegir = GIF3;
			break;
		default:
			break;
		}
		return elegir;

	}

	public static double ingresoPrecio(int ingreso) {
		double precio;
		System.out.print("Ingrese el Precio de la actividad : " + "$");
		precio = input.nextDouble();
		precio = validadPrecio(ingreso, precio);
		return precio;
	}

	public static double validadPrecio(int ingreso, double precio) {
		double valid = 0;

		switch (ingreso) {
		case 1:
			valid = TRAVESIA;
			while (precio < valid) {
				System.out.println("Error: el precio debe ser mayor a :" + TRAVESIA);
				precio = input.nextDouble();
			}
			break;
		case 2:
			valid = GASTRONOMIA;
			while (precio < valid) {
				System.out.println("Error: el precio debe ser mayor a :" + GASTRONOMIA);
				precio = input.nextDouble();
			}
			break;
		case 3:
			valid = VIAJE;
			while (precio < valid) {
				System.out.println("Error: el precio debe ser mayor a :" + VIAJE);
				precio = input.nextDouble();
			}
			break;
		default:
			break;
		}
		return precio;
	}

	public static String desearComprar() {
		String otraCompra = "";
		System.out.print("Desea cargar una compra ?(S/N) : ");
		otraCompra = input.next().toUpperCase();
		while ((!otraCompra.equals(OP1)) && !otraCompra.equals(OP2)) {
			System.out.print("Desea cargar una compra ?(S/N)  : ");
			otraCompra = input.next().toUpperCase();
		}

		return otraCompra;
	}

	public static void mostrarResultado(double totalRecaudado, String mayorActv, double mayorMonto,
			int comprasRealizadas, int regalosTravesia) {
		System.out.println("Total de plata recaudada : $" + totalRecaudado);
		System.out.println("Regalo de mayor monto es : " + mayorActv + " y es de " + " $ " + mayorMonto);
		System.out.println("Cantidad de compras realizadas : " + comprasRealizadas);
		System.out.println("Cantidad de regalos travesía : " + regalosTravesia);
		System.out.println("Monto promedio : " + "$" + Math.round((totalRecaudado/comprasRealizadas)));
	}
}

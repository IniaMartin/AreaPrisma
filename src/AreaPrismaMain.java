

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

	/**
	 * Clase que representa el programa principal. Se trata de un calculo del area de un Prisma,
	 * donde el usuario escribe el numero de prismas a calcular y ademas escribe la base 
	 * (longitud) y la altura. Esta desarrollado con la interfaz GUI.
	 * @author Virginia Martin
	 * @version 1.0
	 * */
public class AreaPrismaMain {

	/**
	 * Punto de entrada/arranque de la aplicacion
	 * @param args
	 * @throws InputMismatException
	 * @throws NullPointerException
	 * */
	public static void main(String[] args) {
		/**
		 * Variables que se usaran a lo largo del progama
		 * @param baseT base (longitud) del prisma que escribe el usuario
		 * @param alturaP altura del Prisma que escribe el usuario
		 * @param cantidad numero de prismas las cuales se calcularan su area
		 * @param contador numero que ira contando y mostrando en cada prisma
		 * @param listaprisma lista de los prismas que se van generando
		 * @param areas lista de areas calculadas de todos los prismas
		 * */
		double baseT=0;
		double alturaP=0;
		int cantidad=0;
		int contador=1;
		ArrayList<AreaPrismaClase> listaprisma= new ArrayList<>();
		List<Double> areas = new ArrayList<>();
		
		JOptionPane.showMessageDialog(null, "~~Calculo del area del Prisma~~");
		
		do {
			cantidad=(int)leerValor("Introduce la cantidad de prismas a calcular:");
		}while(cantidad<=0);
		
		for(int i=0;i<cantidad;i++) {
			do {
				baseT=leerValor("Longitud del prisma "+(i+1)+":");
			}while(baseT<=0);
			
			do {
				alturaP=leerValor("Altura del prisma "+(i+1)+":");
			}while(alturaP<=0);
			
			insertarenListas(baseT, alturaP, listaprisma, areas);
		}
		
		ordenarAreas(areas);
		
		JOptionPane.showMessageDialog(null, "Prismas creados:");
		mostrarPrismas(contador, listaprisma, areas);
		
		
	}
	/**
	 * Ordena la lista de areas generadas de menor a mayor.
	 * @param areas lista de areas creadas
	 * */
	private static void ordenarAreas(List<Double> areas) {
		areas.sort(null);
		Collections.reverse(areas);
	}
	/**
	 * Inserta los valores de la base (longitud) y altura del prisma al objeto Prisma,
	 * para luego calcular el area e insertar el objeto completo a la lista de objetos prismas.
	 * Ademas anyado cada area del prisma a otra lista para luego poder ordenar de menor a mayor.
	 * @param baseT longitud del prisma que escribe el usuario
	 * @param alturaP altura del Prisma que escribe el usuario
	 * @param listaprisma lista de los prismas que se van generando
	 * */
	private static void insertarenListas(double baseT, double alturaP, ArrayList<AreaPrismaClase> listaprisma,
			List<Double> areas) {
		AreaPrismaClase prisma;
		prisma = new AreaPrismaClase(baseT, alturaP);
		listaprisma.add(prisma);
		areas.add(prisma.areaTotal(baseT, alturaP));
	}
	/**
	 * Muestra los prismas que el usuario ha insertado, comparando la lista de areas con la lista 
	 * del prisma llamando al metodo del area total, para que salga ordenado
	 * @param contador numero que ira contando y mostrando en cada prisma
	 * @param listaprisma lista de todos los prismas
	 * @param areas lista de areas calculadas de todos los prismas
	 * */
	private static void mostrarPrismas(int contador, ArrayList<AreaPrismaClase> listaprisma, List<Double> areas) {
		for (Double x:areas) {
			for(AreaPrismaClase y:listaprisma) {
				if(x == y.areaTotal(y.getBaseTriangulo(), y.getAlturaPrisma())){
					JOptionPane.showMessageDialog(null, "Prisma "+contador+": \nBase: "+y.getBaseTriangulo()+"\nAltura: "+y.getAlturaPrisma()+"\nArea total: "+y.areaTotal(y.getBaseTriangulo(), y.getAlturaPrisma()));
				}
			}
		}
	}

	/**
	 * Solicita un numero al usuario, evitando que ponga numeros negativos, 0 o
	 * cualquier otro caracter no numerico
	 * @param numero el numero decimal positivo para que sea el numero de prismas,
	 * la base o la altura
	 * @return numero si se cumple que es double positivo
	 * */
	public static double leerValor(String mensaje) {
		double numero=0;
		try {
			numero = new Double(JOptionPane.showInputDialog(mensaje));
		} catch (NumberFormatException e) {
			numero=-1;
		} catch (NullPointerException p) {
			System.exit(0);
		}
		return numero;
	}
}

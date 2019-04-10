

/**
 * Clase que representa el objeto Prisma. Con sus atributos y metodos para calcular su area
 * @author Virginia Martin
 * */
public class AreaPrismaClase {
	/**
	 * Atributos del objeto prisma
	 * @param baseTriangulo base, longitud, del prisma
	 * @param alturaPrisma altura del prisma
	 * */
	private double baseTriangulo;
	private double alturaPrisma;
	
	/**
	 * Constructor para inicializar la base y la altura del prisma
	 * @param baseTriangulo base, longitud, del prisma
	 * @param alturaPrisma altura del prisma
	 * */
	AreaPrismaClase(double baseTriangulo, double alturaPrisma){
		this.baseTriangulo=baseTriangulo;
		this.alturaPrisma=alturaPrisma;
	}
	/** Getters y Setters del atributo altura del prisma
	 * @return devuelve ambos atributos, baseTriangulo y alturaPrisma, ya establecidos
	 * */
	public double getBaseTriangulo() {
		return baseTriangulo;
	}

	public void setBaseTriangulo(double baseTriangulo) {
		this.baseTriangulo = baseTriangulo;
	}

	public double getAlturaPrisma() {
		return alturaPrisma;
	}

	public void setAlturaPrisma(double alturaPrisma) {
		this.alturaPrisma = alturaPrisma;
	}
	
	/**
	 * Calcula el area total del prisma, a traves de los metodos areaBase y areaLateral
	 * utilizando la base y la altura.
	 * @param baseTriangulo base, longitud, del prisma
	 * @param alturaPrisma altura del prisma
	 * @return devuelve el calculo del area total del prisma
	 * */
	public double areaTotal(double baseTriangulo, double alturaPrisma) {
		return (2*this.areaBase(baseTriangulo) + this.areaLateral(baseTriangulo, alturaPrisma));
	}
	/**
	 * Calcula el area lateral del prisma descartando los triangulos base, a traves del metodo 
	 * perimetro utilizando la base y la altura.
	 * @param baseTriangulo base, longitud, del prisma
	 * @param alturaPrisma altura del prisma
	 * @return devuelve el calculo del area lateral del prisma sin los triangulos base
	 * */
	private double areaLateral(double baseTriangulo, double alturaPrisma) {
		return (this.perimetro(baseTriangulo)*alturaPrisma);
	}
	/**
	 * Calcula el perimetro de la base del prisma, que es un triangulo equilatero, utilizando
	 * la base.
	 * @param baseTriangulo base, longitud, del prisma
	 * @return devuelve el calculo del perimetro del triangulo base
	 * */
	private double perimetro(double baseTriangulo) {
		return (3*baseTriangulo);
	}
	/**
	 * Calcula el area Base la base del prisma que es un triangulo equilatero, utilizando la base.
	 * @param baseTriangulo base, longitud, del prisma
	 * @return devuelve el calculo del area de la base
	 * */
	private double areaBase(double baseTriangulo) {
		return (baseTriangulo*this.alturaTriangulo(baseTriangulo))/2;
	}
	/**
	 * Calcula la altura de la base del prisma que es un triangulo equilatero, utilizando la base.
	 * @param baseTriangulo base, longitud, del prisma
	 * @return devuelve el calculo de la altura de la base
	 * */
	private double alturaTriangulo(double baseTriangulo) {
		return (Math.sqrt(3)/2*baseTriangulo);
	}
}

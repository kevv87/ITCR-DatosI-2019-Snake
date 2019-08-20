package logica;

/**
 * Una simple clase para guardar dos coordenadas, debe tener:
 *   Atributos:
 *     Los suficientes para guardar las dos coordenadas
 *   Metodos:
 *     Un metodo para trasladar el punto, es decir, yo le paso un cambio en ambas
 *     coordenadas y me devuelve un nuevo punto con las nuevas coordenadas
 *     Un metodo para igualar
 * */
public class Point {
   private final int x;    // The X coordinate
    private final int y;    // The Y coordinate

    /**
     * The package-visible constructor. Not meant to be used outside the package.
     *
     * @param x The X coordinate.
     * @param y The Y coordinate.
     */
    Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return The X coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * @return The Y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * @param dx The change in x.
     * @param dy The change in y.
     * @return A new Point which is the result of translation of this point.
     */
    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }

    /**
     * @param other The "other" point to compare against.
     * @return {@code true} if the other Object is an instance of Point and
     * has the same coordinates.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point)) return false;
        Point point = (Point) other;
        return x == point.x & y == point.y;
    }

    public String toString() {
        return x + ", " + y;
    }
}

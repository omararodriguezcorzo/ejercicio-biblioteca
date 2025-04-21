package libros;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String isbn, String titutlo, String autor, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titutlo;
        this.autor = autor;
        this.disponible = disponible;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

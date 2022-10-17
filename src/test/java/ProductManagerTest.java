import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductManagerTest {

    @Test
    public void shouldAdd(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Maths", 100, "Pythagor");

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchBy(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Maths", 100, "Pythagor");
        Book book2 = new Book(2, "Mathematics", 200, "Archimed");
        Book book3 = new Book(3, "Physics", 300, "Newtone");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Math");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Maths", 100, "Pythagor");
        Book book2 = new Book(2, "Mathematics", 200, "Archimed");
        Book book3 = new Book(3, "Physics", 300, "Newtone");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.removeById(1);

        Product[] expected = {book2, book3};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatches(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Maths", 100, "Pythagor");
        Book book2 = new Book(2, "Mathematics", 200, "Archimed");
        Book book3 = new Book(3, "Physics", 300, "Newtone");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        boolean expected = true;
        boolean actual = manager.matches(book3, "y" );

        Assertions.assertArrayEquals(new boolean[]{expected}, new boolean[] {actual});
    }

    @Test
    public void shouldNotMatchesBook(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Maths", 100, "Pythagor");
        Book book2 = new Book(2, "Mathematics", 200, "Archimed");
        Book book3 = new Book(3, "Physics", 300, "Newtone");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        boolean expected = false;
        boolean actual = manager.matches(book1, "z" );

        Assertions.assertArrayEquals(new boolean[]{expected}, new boolean[] {actual});
    }

    @Test
    public void shouldAddSmartphone(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 100, "Apple");

        manager.add(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchBySmartpone(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 100, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 200, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Lenovo", 300, "China");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Phone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdSmartphone(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 100, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 200, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Lenovo", 300, "China");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.removeById(2);

        Product[] expected = {smartphone1, smartphone3};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSmartphone(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 100, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 200, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Lenovo", 300, "China");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        boolean expected = true;
        boolean actual = manager.matches(smartphone1, "I" );

        Assertions.assertArrayEquals(new boolean[]{expected}, new boolean[] {actual});
    }

    @Test
    public void shouldNotMatches(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 100, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 200, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Lenovo", 300, "China");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone1);

        boolean expected = false;
        boolean actual = manager.matches(smartphone2, "e" );

        Assertions.assertArrayEquals(new boolean[]{expected}, new boolean[] {actual});
    }
}

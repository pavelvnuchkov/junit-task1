import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BookTest {

    static Author author;
    static Book book;

    @BeforeAll
    static void beforeAll() {
        author = new Author("Лев", "Толстой", 5);
        book = new Book("Война и мир", 1830, author, 1000);
    }

    @Test
    void isBigTest() {
        boolean result = book.isBig();
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Лев, true",
            "Толстой,true",
            "Тол, true",
            "Павел, false",
            "Иванов, false"
    })
    public void matchesTest(String name, boolean expected){
        Assertions.assertEquals(expected, book.matches(name));
    }

    @Test
    void estimatePriceTest() {
        int result = book.estimatePrice();
        int expected = 1;
        Assertions.assertNotEquals(expected, result);
    }


}
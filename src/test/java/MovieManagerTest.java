import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    @Test
    public void shouldAddAllMovies() {
        MovieManager manager = new MovieManager();
        manager.add("Один дома");
        manager.add("Брат");
        manager.add("Титаник");
        String[] expected = {"Один дома", "Брат", "Титаник"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.add("Один дома");
        manager.add("Брат");
        manager.add("Титаник");
        manager.add("Аватар");
        manager.add("Такси");
        manager.add("Матрица");
        String[] expected = {"Матрица", "Такси", "Аватар", "Титаник", "Брат"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add("Один дома");
        manager.add("Брат");
        manager.add("Титаник");
        manager.add("Аватар");
        String[] expected = {"Аватар", "Титаник", "Брат"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldReturnAllIfLessThanLimit() {
        MovieManager manager = new MovieManager(); // Лимит равен 5
        manager.add("Один дома");

        String[] expected = {"Один дома"};
        assertArrayEquals(expected, manager.findLast());
    }
}

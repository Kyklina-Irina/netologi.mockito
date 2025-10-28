package ru.netology.filmmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    @Test
    public void shouldAddOneFilm() {
        FilmManager manager = new FilmManager();
        manager.addFilm("Бладшот");
        String[] expected = {"Бладшот"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastWhenLessThanLimit() {
        FilmManager manager = new FilmManager();
        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        String[] expected = {"Вперёд", "Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWhenMoreThanLimit() {
        FilmManager manager = new FilmManager();
        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель «Белград»");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-невидимка");
        manager.addFilm("Тролли. Мировой тур");
        manager.addFilm("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель «Белград»"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWithCustomLimit() {
        FilmManager manager = new FilmManager(3);
        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель «Белград»");
        manager.addFilm("Джентльмены");

        String[] expected = {"Джентльмены", "Отель «Белград»", "Вперёд"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldReturnEmptyArrayIfNoFilms() {
        FilmManager manager = new FilmManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findLast());
    }
}
package ru.netology.filmmanager;

public class FilmManager {
    private String[] films = new String[0];
    private int limit;

    // Конструктор по умолчанию — лимит 5
    public FilmManager() {
        this(5);
    }

    // Конструктор с указанием лимита
    public FilmManager(int limit) {
        this.limit = limit;
    }

    // Добавление фильма
    public void addFilm(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[films.length] = film;
        films = tmp;
    }

    // Получение всех фильмов
    public String[] findAll() {
        return films;
    }

    // Получение последних N фильмов (в обратном порядке)
    public String[] findLast() {
        int resultLength;
        if (films.length < limit) {
            resultLength = films.length;
        } else {
            resultLength = limit;
        }

        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}
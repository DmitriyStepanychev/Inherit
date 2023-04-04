package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String query = "Позвонить родителям";

        Boolean expected = true;
        Boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String query = "Пойти гулять";

        Boolean expected = false;
        Boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void matchesMeetingTrueTopic() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Выкатка 3й версии приложения";

        Boolean expected = true;
        Boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingTrueProject() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Приложение НетоБанка";

        Boolean expected = true;
        Boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingFalse() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Whatsapp";

        Boolean expected = false;
        Boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesEpicTrue() {
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);
        String query = "Яйца";

        Boolean expected = true;
        Boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesEpicFalse() {
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);
        String query = "Колбаса";

        Boolean expected = false;
        Boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}

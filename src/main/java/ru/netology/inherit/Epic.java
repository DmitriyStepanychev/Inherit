package ru.netology.inherit;

public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
//       String[] subtasks = new String[];
//        for (int i = 0; i < subtasks.length; i++) {
//            if (subtasks[i].contains(query)) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        return false;
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
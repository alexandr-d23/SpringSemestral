package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.entities.Achievement;
import ru.itis.diner.semestral.model.AchievementTypes;
import ru.itis.diner.semestral.entities.Action;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class AchievementServiceImplDb implements AchievementService {
    @Override
    public void addAction(int userId, Action action) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "insert into user_actions(type, value, user_id) select ?,0,? " +
                        "where not exists (select * from user_actions where type = ? AND user_id = ?);"+
                        "UPDATE user_actions SET value = value + ? where type = ? AND user_id = ?;");
        ) {
            int i = 1;
            statement.setString(i++, action.getType().name());
            statement.setInt(i++, userId);
            statement.setString(i++, action.getType().name());
            statement.setInt(i++, userId);
            statement.setLong(i++, action.getValue());
            statement.setString(i++, action.getType().name());
            statement.setInt(i++, userId);
            statement.executeUpdate();
        }
    }


    @Override
    public <T extends Action> Collection<T> getUserActions(int userId) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_actions WHERE user_id = ?;");
        ) {
            statement.setInt(1, userId);
            ResultSet set = statement.executeQuery();
            Collection<T> actions = new ArrayList<>();
            while (set.next()) {
                AchievementTypes type = AchievementTypes.valueOf(set.getString("type"));
                int value = set.getInt("value");
                actions.add((T) new Action(type, value));
            }
            return actions;
        }
    }


    @Override
    public <T extends Achievement> Collection<T> getAchievements() throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM achievements;");
        ) {
            ResultSet set = statement.executeQuery();
            Collection<T> achievements = new ArrayList<>();
            while (set.next()) {
                AchievementTypes type = AchievementTypes.valueOf(set.getString("type"));
                int id = set.getInt("id");
                int value = set.getInt("required_value");
                String description = set.getString("description");
                achievements.add((T) new Achievement(id, type, value, description));
            }
            return achievements;
        }
    }


    @Override
    public <T extends Achievement> Collection<T> getAchievementsWithProgress(int userId) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement =
                connection.prepareStatement(
                        "SELECT a.id, a.type, a.required_value, a.description, " +
                                "ua.value FROM achievements as a LEFT JOIN user_actions" +
                                " as ua on a.type = ua.type AND ua.user_id = ?;");
        ) {
            statement.setInt(1, userId);
            ResultSet set = statement.executeQuery();
            Collection<T> achievements = new ArrayList<>();
            while (set.next()) {
                AchievementTypes type = AchievementTypes.valueOf(set.getString("type"));
                int id = set.getInt("id");
                int value = set.getInt("required_value");
                String description = set.getString("description");
                int currentValue = set.getInt("value");
                T achievement = (T) new Achievement(id, type, value, currentValue, description);
                achievement.setCurrentValue(currentValue);
                if (currentValue >= value) achievement.setGot(true);
                achievements.add(achievement);
            }
            return achievements;
        }
    }

    @Override
    public <T extends Achievement> Collection<T> getUserAchievements(int userId) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_achievement as ua join achievements as a on a.id = ua.achievement_id where ua.user_id = ?;");
        ) {
            statement.setInt(1, userId);
            ResultSet set = statement.executeQuery();
            Collection<T> achievements = new ArrayList<>();
            while (set.next()) {
                AchievementTypes type = AchievementTypes.valueOf(set.getString("type"));
                int value = set.getInt("required_value");
                int id = set.getInt("id");
                String description = set.getString("description");
                T achievement = (T) new Achievement(id, type, value, description);
                achievements.add(achievement);
            }
            return achievements;
        }
    }

    @Override
    public void updateUserAchievements(int userId) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO user_achievement(user_id, achievement_id)\n" +
                "        SELECT actions.user_id, ach.id  FROM achievements AS ach JOIN\n" +
                "                (SELECT ua.value, ua.user_id, ua.type FROM user_actions  AS ua WHERE ua.user_id = ?)\n" +
                "        AS actions  ON ach.type = actions.type WHERE ach.required_value <= actions.value AND NOT\n" +
                "        EXISTS (SELECT * FROM user_achievement WHERE user_id = actions.user_id AND achievement_id = ach.id);\n" +
                "\n" +
                "        INSERT INTO user_actions(type, value, user_id) SELECT 'GET_ACHIEVEMENT',0, ?\n" +
                "        WHERE NOT EXISTS (SELECT * FROM user_actions WHERE TYPE = 'GET_ACHIEVEMENT' AND user_id = ?);\n" +
                "        UPDATE user_actions SET value = ( SELECT COUNT(*) FROM user_achievement WHERE user_id = ?)  WHERE type = 'GET_ACHIEVEMENT' AND user_id = ?;");
        ) {
            int i = 1;
            statement.setInt(i++, userId);
            statement.setInt(i++, userId);
            statement.setInt(i++, userId);
            statement.setInt(i++, userId);
            statement.setInt(i++, userId);
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteAchievement(int achievementId) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM achievements where id = ?;");
        ) {
            statement.setInt(1, achievementId);
            statement.executeUpdate();
        }
    }

    @Override
    public void addAchievement(Achievement achievement) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO achievements (type, required_value, description) values (?,?,?);");
        ) {
            int i = 1;
            statement.setString(i++, achievement.getType().name());
            statement.setInt(i++, achievement.getRequiredValue());
            statement.setString(i++, achievement.getDescription());
            statement.executeUpdate();
        }

    }

    @Override
    public void updateAchievement(Achievement achievement) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE  achievements SET type = ?, required_value = ?, description = ? where id = ?;");
        ) {
            int i = 1;
            statement.setString(i++, achievement.getType().name());
            statement.setInt(i++, achievement.getRequiredValue());
            statement.setString(i++, achievement.getDescription());
            statement.setInt(i++, achievement.getId());
            statement.executeUpdate();
        }
    }
}

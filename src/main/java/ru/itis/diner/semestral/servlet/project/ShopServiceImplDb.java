package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.model.BoostTypes;
import ru.itis.diner.semestral.entities.Booster;
import ru.itis.diner.semestral.entities.ShopBooster;
import ru.itis.diner.semestral.entities.User;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ShopServiceImplDb implements ShopService{

    @Override
    public <K extends ShopBooster> Answer buyBooster(int userId, int itemId) throws SQLException {
        UserService<User> service = new UserServiceImplDb<>();
        User user = service.getUser(userId);
        ShopBooster item = getItemById(itemId);
        Answer<User> answer;
        if(user.getScore().compareTo(BigInteger.valueOf(item.getCost()))<0){
            answer = new Answer(false, "Недостаточно денег");
        }
        else{
            user.setScore(user.getScore().subtract(BigInteger.valueOf(item.getCost())));
            user.addBooster(item);
            service.addBooster(user, item);
            answer = new Answer(true);
        }
        answer.setResource(user);
        return answer;
    }




    private ShopBooster getBoosterFromSet(ResultSet set, Connection connection) throws SQLException {
        int id = set.getInt("id");
        BoostTypes type = BoostTypes.valueOf(set.getString("item_type"));
        int cost = set.getInt("cost");
        int value = set.getInt("value");
        String description = set.getString("description");
        return new Booster(id,cost,type,value,description,id);
    }

    @Override
    public <K extends ShopBooster> Collection<K> getItems() throws SQLException {
        Collection<K> collection = new ArrayList<>();
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM products;");
        ) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                collection.add((K) getBoosterFromSet(set, connection));
            }
            return collection;
        }
    }

    @Override
    public ShopBooster getItemById(int itemId) throws SQLException {
        try(Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM products where id = ?;");
        ) {
            statement.setInt(1, itemId);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return getBoosterFromSet(set, connection);
            }
            return null;
        }
    }

}

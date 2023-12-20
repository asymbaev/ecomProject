package clothingStore;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;


public class ClothingServiceImp implements ClothingService {
    private Connection connection;

    public ClothingServiceImp(Connection connection) {
        this.connection = JDBConnection.getConnection();
    }

   // private ArrayList<Clothes> clothesList = new ArrayList<>();

//    public ClothingServiceImp() {
//        this.clothesList = clothesList;


    @Override
    public void addClothes(Clothes clothes) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO clothes(id, type, size, price, quantity) VALUES (?,?,?,?,?)"))
                {
                    statement.setInt(1, clothes.getId());
                    statement.setString(2, clothes.getType());
                    statement.setDouble(3, clothes.getSize());
                    statement.setDouble(4, clothes.getPrice());
                    statement.setInt(5, clothes.getQuantity());

                    statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//        clothesList.add(clothes);
//        System.out.println("Added successfully!");
    }

    @Override
    public List<Clothes> displayClothes() {
        List<Clothes> clothesList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM clothes")) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String type = rs.getString("type");
                    double size = rs.getDouble("size");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");

                    Clothes clothes = new Clothes(id, type, size, price, quantity);
                    clothesList.add(clothes);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clothesList;
//        if (clothesList.isEmpty()) {
//            System.out.println("Your cart is empty!");
//        } else
//            for (Clothes clothes : clothesList) {
//                System.out.println(clothes);
//            }
//        return clothesList;
    }

    @Override
    public Clothes removeClothesById(int Id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM clothes WHERE id =?")) {
            statement.setInt(1, Id);
            statement.executeUpdate();
            System.out.println("Successfully removed");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


//        for (Clothes c1 : clothesList) {
//            try {
//                if (c1.getId() == (Id)) {
//                    clothesList.remove(c1);
//                    System.out.println("Your item removed from your card successfully");
//                    break;
//
//                } else {
//                    System.out.println("No items found");
//                }
//
//            } catch (ConcurrentModificationException e) {
//                System.out.println("error");
//            }
//        }

    @Override
    public void updateClothesByType(String type) {
        try(PreparedStatement statement = connection.prepareStatement("UPDATE clothes SET id = ? type = ? size =? price=? quantity=? WHERE id = ? ")) {
        statement.setInt(1, Clothes.getId());
        statement.setString(2, Clothes.getType());
        statement.setDouble(3, Clothes.getSize());
        statement.setDouble(4, Clothes.getPrice());
        statement.setInt(5, Clothes.getQuantity());
        statement.executeUpdate();
            System.out.println("Updated Successfully thank You");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

//        for (Clothes c1 : clothesList) {
//            if (c1.getType().equals(type)) {
//                c1.setType(c1.getType());
//            } else {
//                System.out.println("Item with " + type + " not found");
//                break;

//            }
//        }
    }
}

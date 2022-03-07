package com.example.bdd;

import com.example.beans.SuperZeroModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuperZConnection {

    private GetConnection _getConnection = new GetConnection();
    private Connection _connection;

    //Constructor
    public SuperZConnection(Connection connection){
        _connection = connection;
    }

    //Get Methods
    public ArrayList<SuperZeroModel> GetAllSuperZ(){
        ArrayList<SuperZeroModel> allSuperZ = new ArrayList<SuperZeroModel>();
        String sql = "SELECT * FROM superZ;";
        try {
            PreparedStatement preparedStatement = _connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                SuperZeroModel superZ = new SuperZeroModel();
                superZ.Id = result.getInt("Id");
                superZ.Name = result.getString("Name");
                superZ.PhoneNumber = result.getString("PhoneNumber");
                superZ.City = result.getString("City");
                superZ.Latitude = result.getString("Latitude");
                superZ.Longitude = result.getString("Longitude");
                superZ.BusinessIncidents = result.getString("BusinessIncidents");
                superZ.Quote = result.getString("Quote");
                allSuperZ.add(superZ);
            }
            result.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSuperZ;
    }

    //Post Method
    public void PostNewSuperZ(SuperZeroModel superZToPost){
        _connection = _getConnection.getConnection();
        String sql ="INSERT INTO superZ(Name, PhoneNumber, Latitude, Longitude, City, BusinessIncidents, Quote, Picture) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
        if(superZToPost != null){
            try{
                PreparedStatement preparedStatement = _connection.prepareStatement(sql);
                preparedStatement.setString(1, superZToPost.getName());
                preparedStatement.setString(2, superZToPost.getPhoneNumber());
                preparedStatement.setString(3, superZToPost.getLatitude());
                preparedStatement.setString(4, superZToPost.getLongitude());
                preparedStatement.setString(5, superZToPost.getCity());
                preparedStatement.setString(6, superZToPost.getBusinessIncidents());
                preparedStatement.setString(7, superZToPost.getQuote());
                preparedStatement.setString(8, superZToPost.getPicture());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

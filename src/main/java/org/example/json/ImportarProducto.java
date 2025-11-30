package org.example.json;

import org.example.db.DBconnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImportarProducto {

    private static final String API_URL = "https://dummyjson.com/products";

    public void importarProductos() {
        try {
            String json = descargarJSON(API_URL);
            insertarProductos(json);
        } catch (Exception e) {
            System.out.println("Error importando productos: " + e.getMessage());
        }
    }

    // DESCARGAR JSON DESDE INTERNET
    private String descargarJSON(String urlWeb) throws Exception {
        URL url = new URL(urlWeb);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linea;

        while ((linea = br.readLine()) != null) {
            sb.append(linea);
        }

        br.close();
        return sb.toString();
    }

    // INSERTAR PRODUCTOS EN LA BD
    private void insertarProductos(String json) throws Exception {
        Connection con = DBconnection.getConnection();

        JSONObject jsonObj = new JSONObject(json);
        JSONArray productos = jsonObj.getJSONArray("products");

        String sql = "INSERT IGNORE INTO productos (id, nombre, descripcion, cantidad, precio) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        for (int i = 0; i < productos.length(); i++) {

            JSONObject p = productos.getJSONObject(i);

            ps.setInt(1, p.getInt("id"));
            ps.setString(2, p.getString("title"));
            ps.setString(3, p.getString("description"));
            ps.setInt(4, p.getInt("stock"));
            ps.setDouble(5, p.getDouble("price"));

            ps.executeUpdate();
        }
    }
}

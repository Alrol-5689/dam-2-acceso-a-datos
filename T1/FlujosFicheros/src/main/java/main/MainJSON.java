package main;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.UserJSON;
import model.UserResponse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("deprecation")
public class MainJSON {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            URL url = new URL("https://dummyjson.com/users/search?q=John");
            UserResponse response = mapper.readValue(url, UserResponse.class);
            for(UserJSON item : response.getUsers()) {
                System.out.println(item);
            }
        } catch (MalformedURLException e) {
            System.out.println("Error en la URL");
        } catch (StreamReadException e) {
            System.out.println("Error en la StreamRead");
        } catch (DatabindException e) {
            System.out.println("Error en la Databind");
        } catch (IOException e) {
            System.out.println("Error en la IO");
        }
    }
}

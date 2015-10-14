package com.example.juangutierrezalvarez.futbolaction.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.client.Response;

/**
 * Created by Juan Gutierrez on 30/06/2015.
 */
public class Utilidades
{

    public static String getDataFromResponse(Response response){
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Metodo que construye un json array a partir de un string
     * @param data
     * @return
     */
    public static JSONArray buildJSarrayFromString(String data){
        JSONArray jArray=null;
        try {
            jArray = new JSONArray(data);
        }catch (Throwable t){
            Log.e("Autenticloud", "Error al pasar los datos a Json" + t.toString());
        }
        return jArray;
    }
    /**
     * Metodo que construye un json object a partir de un string
     * @param data
     * @return
     */
    public static JSONObject buildJSobjectFromString(String data){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(data);
        }catch (Throwable t){
            Log.e("Autenticloud", "Error al pasar los datos a Json" + t.toString());
        }
        return jsonObject;
    }

    /**
     * Método que realiza un md5
     * @param md5
     * @return
     */
    public static String crypterAutenticloud(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}

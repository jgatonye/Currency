package com.example.john.renteasy;

import com.example.john.renteasy.models.Currency;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

public class CurrencyService {

    public static void findCurrency(Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.CURRENCY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.FORMAT_LABEL,Constants.FORMAT_VALUE);
        urlBuilder.addQueryParameter(Constants.CURRENCY_LABEL, Constants.CURRENCY_VALUE);
        urlBuilder.addQueryParameter(Constants.SOURCE_LABEL, Constants.SOURCE_VALUE);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Currency> processResults(Response response){
        ArrayList<Currency> currencies = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()){
                JSONObject currencyJSON = new JSONObject(jsonData);
                JSONObject businessesJSON = currencyJSON.getJSONObject("businesses");
                for (int i = 0; i<businessesJSON.length(); i++){
                    JSONObject restaurantJSON = businessesJSON.getJSONObject(i);
                    String quote = currencyJSON.getString("quotes");

                    Currency currency = new Currency(quote);
                    currencies.add(currency);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return currencies;
    }
}

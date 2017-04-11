package com.example.john.renteasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.john.renteasy.models.Currency;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CurrencyExchangeActivity extends AppCompatActivity {
    public static final String TAG = CurrencyExchangeActivity.class.getSimpleName();



    @Bind(R.id.listView) ListView mListView;
    public ArrayList<Currency> mCurrencies = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange);
        ButterKnife.bind(this);

        getCurrency();

    }


    private void getCurrency(){
        final CurrencyService currencyService = new CurrencyService();
        currencyService.findCurrency(new  Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                    mCurrencies = currencyService.processResults(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}

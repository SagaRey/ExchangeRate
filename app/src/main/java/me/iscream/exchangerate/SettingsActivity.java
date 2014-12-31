package me.iscream.exchangerate;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SettingsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        updateDate();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateExchangeRate(View view) {
        //获取汇率
        new Thread(){
            @Override
            public void run(){
                try {
                    Document doc = Jsoup.connect(getString(R.string.url)).get();
                    Elements elements = doc.select("#content > div > div.mainbox > div > div.dzMain > div.mark > table > tbody");
                    Elements trs =  elements.get(0).select("tr");
                    Elements currencies =  trs.get(0).select("th");
                    Elements exchangeRates =  trs.get(1).select("td");
                    SharedPreferences sp = getSharedPreferences("exchange_rate", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    int i = 0;
                    for (Element currency : currencies){
//                        System.out.println(currency.text() + " : " + exchangeRates.get(i).text());
                        editor.putString(currency.text(), exchangeRates.get(i).text());
                        i++;
                    }
                    editor.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateDate();
    }

    public void initExchangeRate(View view) {

        //初始化汇率
        SharedPreferences sp = getSharedPreferences("exchange_rate", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(getResources().getString(R.string.date),getResources().getString(R.string.default_date));
        editor.putString(getResources().getString(R.string.usd),getResources().getString(R.string.default_usd));
        editor.putString(getResources().getString(R.string.jpy),getResources().getString(R.string.default_jpy));
        editor.putString(getResources().getString(R.string.gbp),getResources().getString(R.string.default_gbp));
        editor.putString(getResources().getString(R.string.eur),getResources().getString(R.string.default_eur));
        editor.putString(getResources().getString(R.string.hkd),getResources().getString(R.string.default_hkd));
        editor.commit();
        updateDate();
    }

    private void updateDate(){
        TextView textView = (TextView)findViewById(R.id.update_date);
        SharedPreferences sp = getSharedPreferences("exchange_rate", MODE_PRIVATE);
        textView.setText(sp.getString(getResources().getString(R.string.date), ""));
    }
}

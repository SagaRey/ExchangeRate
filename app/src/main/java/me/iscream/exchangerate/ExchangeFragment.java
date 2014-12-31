package me.iscream.exchangerate;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import me.iscream.exchangerate.MainActivity.PlaceholderFragment;

public class ExchangeFragment extends PlaceholderFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_exchange, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final SharedPreferences sp = getActivity().getSharedPreferences("exchange_rate", 0);
        final Editor editor = sp.edit();
        final TextView input = (TextView)getActivity().findViewById(R.id.input);
        final TextView output = (TextView)getActivity().findViewById(R.id.output);
        Button clear = (Button)getActivity().findViewById(R.id.clear);
        Button dot = (Button)getActivity().findViewById(R.id.dot);
        Button delete = (Button)getActivity().findViewById(R.id.delete);
        Button zero = (Button)getActivity().findViewById(R.id.zero);
        Button one = (Button)getActivity().findViewById(R.id.one);
        Button two = (Button)getActivity().findViewById(R.id.two);
        Button three = (Button)getActivity().findViewById(R.id.three);
        Button four = (Button)getActivity().findViewById(R.id.four);
        Button five = (Button)getActivity().findViewById(R.id.five);
        Button six = (Button)getActivity().findViewById(R.id.six);
        Button seven = (Button)getActivity().findViewById(R.id.seven);
        Button eight = (Button)getActivity().findViewById(R.id.eight);
        Button nine = (Button)getActivity().findViewById(R.id.nine);
        RadioGroup radioGroup = (RadioGroup)getActivity().findViewById(R.id.currencyList);
        final ImageView imageView = (ImageView)getActivity().findViewById(R.id.currencyImg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.usdRadio:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.usd));
                        editor.putString(getResources().getString(R.string.currency), getResources().getString(R.string.usd));
                        break;
                    case R.id.jpyRadio:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.jpy));
                        editor.putString(getResources().getString(R.string.currency), getResources().getString(R.string.jpy));
                        break;
                    case R.id.gbpRadio:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.gbp));
                        editor.putString(getResources().getString(R.string.currency), getResources().getString(R.string.gbp));
                        break;
                    case R.id.eurRadio:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.eur));
                        editor.putString(getResources().getString(R.string.currency), getResources().getString(R.string.eur));
                        break;
                    case R.id.hkdRadio:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.hkd));
                        editor.putString(getResources().getString(R.string.currency), getResources().getString(R.string.hkd));
                        break;
                }
                editor.commit();
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("0.0");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + ".");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "0");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "1");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "2");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "3");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "4");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "5");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "6");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "7");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "8");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "9");
                output.setText(Float.parseFloat(input.getText().toString().equals("")?"0":input.getText().toString()) * 100 / Float.parseFloat(sp.getString(sp.getString(getResources().getString(R.string.currency), ""), "")) + "");
            }
        });
    }
}
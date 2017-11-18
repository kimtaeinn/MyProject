package com.example.taeinkim.openmovieinfo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button movie_btn;
    TextView movie_info;

    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyyMMdd");

    String current_date = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie_btn = (Button) findViewById(R.id.movie_btn);
        movie_info = (TextView) findViewById(R.id.movie_info);

        mDate = new Date(System.currentTimeMillis());
        current_date = String.valueOf(Integer.parseInt(mFormat.format(mDate)) - 1);

        movie_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MovieInfoTask().execute();
            }
        });
    }

    private class MovieInfoTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            StringBuffer resp3 = null;
            try {
                URL reqUrl = null;
                HttpURLConnection httpConn2 = null;

                reqUrl = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
                        + "?" + "key" + "=" + "153b2379fcdbd1f5f74a4acb5d993e05" + "&" + "targetDt" + "=" + current_date);

                httpConn2 = (HttpURLConnection) reqUrl.openConnection();

                // URL을 요청하는 방법 설정 (GET|POST|HEAD|OPTIONS|PUT|DELETE|TRACE, 기본 설정: GET)
                httpConn2.setRequestMethod("GET");

                httpConn2.setConnectTimeout(10000);    //< 연결 제한시간(단위 : msec, 0은 무한)
                httpConn2.setReadTimeout(0);           //< 읽기 제한시간(단위 : msec, 0은 무한)

                resp3 = new StringBuffer();

                InputStream responseBody = httpConn2.getInputStream();

                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                System.out.println("responseBodyReader = " + responseBodyReader);

                int resCode = 0;
                resCode = httpConn2.getResponseCode();

                System.out.println("resCode = " + resCode);

                if (resCode < 400) {

                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(httpConn2.getInputStream(), "UTF-8"));
                    while ((line = br.readLine()) != null) {

                        System.out.println("line = " + line);
                        resp3.append(line);

                    }
                    br.close();

                    JSONObject json = new JSONObject(resp3.toString());
                    JSONObject json_two = json.getJSONObject("boxOfficeResult");
                    JSONArray jsonArray = json_two.getJSONArray("dailyBoxOfficeList");
                    System.out.println("jsonArray = " + jsonArray);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        json = jsonArray.getJSONObject(i);

                        MovieInfoName.rnum.add(json.getString("rnum"));
                        MovieInfoName.rank.add(json.getString("rank"));
                        MovieInfoName.rankOldAndNew.add(json.getString("rankOldAndNew"));
                        MovieInfoName.movieNm.add(json.getString("movieNm"));
                        MovieInfoName.openDt.add(json.getString("openDt"));
                        MovieInfoName.salesAmt.add(json.getString("salesAmt"));
                        MovieInfoName.salesShare.add(json.getString("salesShare"));
                        MovieInfoName.salesAcc.add(json.getString("salesAcc"));
                        MovieInfoName.audiCnt.add(json.getString("audiCnt"));
                        MovieInfoName.audiAcc.add(json.getString("audiAcc"));
                        MovieInfoName.showCnt.add(json.getString("showCnt"));

                    }


                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return resp3.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            movie_info.setText(s);
        }
    }
}
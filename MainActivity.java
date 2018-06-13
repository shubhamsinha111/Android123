package com.example.shubham.imgdownload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    int isOperatorPressed=0;
    ImageDownloader task1,task2;
    ImageView downloadImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadImg = findViewById(R.id.downloadImg);
        //task = new ImageDownloader();

    }
    public void downloadImage(View view)
    {

        Bitmap myImage;

      //  Button b1 = findViewById(R.id.button);
       // Button b2 = findViewById(R.id.button2);
        //Button b3 = findViewById(R.id.button3);
        //Button b4 = findViewById(R.id.button4);
        try {
            //downloadImg.setImageBitmap(null);
            if(isOperatorPressed==0) {
                Log.i("img","image0");
                task1=new ImageDownloader();
                myImage = task1.execute("https://media.gettyimages.com/photos/sachin-tendulkar-of-india-waves-to-fans-during-day-one-of-the-first-picture-id136109765?s=612x612").get();

                downloadImg.setImageBitmap(myImage);
                isOperatorPressed++;
            }
           else if(isOperatorPressed==1)
            {
                Log.i("img","image1");
                task2=new ImageDownloader();
                myImage = task2.execute("https://qph.fs.quoracdn.net/main-qimg-bec6682199424b319df0999c7bf1d530-c").get();
                downloadImg.setImageBitmap(myImage);
                Log.i("img","image end");
                isOperatorPressed++;
            }
            else if (isOperatorPressed==2)
            {
                Log.i("img","image1");
                task2=new ImageDownloader();
                myImage = task2.execute("http://static.dnaindia.com/sites/default/files/styles/full/public/2018/04/24/675279-sachin-social.jpg").get();
                downloadImg.setImageBitmap(myImage);
                Log.i("img","image end");
                isOperatorPressed=0;
            }

           // myImage1 = task.execute("http://www.coer.ac.in/images/gallery/committee/connect.jpg").get();
           //  downloadImg.setImageBitmap(myImage1);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public class ImageDownloader extends AsyncTask<String,Void,Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String...urls)
        {
            try
            {
                URL url = new URL(urls[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                connection.disconnect();
                return myBitmap;
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            }catch(IOException e)
            {
                e.printStackTrace();
            }
            return null;

        }
        protected void onProgressUpdate()
        {
            Log.i("async","progress update");
        }
        protected void onPostExecute(Bitmap result)
        {
            Log.i("async","post execute");
        }
        protected void onPreExecute()
        {
            Log.i("async","pre execute");
        }


    }
}

package com.example.udemyplanetapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<Planet>
{
        private ArrayList<Planet> planetsArrayList;
         Context context;
        //constructor for MyCustomAdapter class
         public MyCustomAdapter( @NonNull ArrayList<Planet> planetsArrayList, Context context) {
         super(context, R.layout.item_list_layout,planetsArrayList);

         this.planetsArrayList=planetsArrayList;
         this.context = context;
    }
      /*
      view holder class used to cache referencesto the views within an item
    , so that they dont need to be repetedly looked up during scrollind
       */

      //נגדיר ייחוס למצביעים כפי שיש לנו במחלקה שיצרנו
        private static  class MyViewHolder
      {
        TextView planetName,mooncount;
        ImageView planetImage;
    }
    @NonNull
    @Override
         /* this methos is used to create and return  a view  for a spesific item in the list  */
       public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //convertView is a recyclered view that can be reused to improove performance of the list

      //get the planet object for the current position
      Planet planet =getItem(position);
           //inflate layout
      MyViewHolder myViewHolder;
      final  View result;
        if(convertView==null)
        {
            myViewHolder= new MyViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_list_layout,parent,false);
            //fonding the views---מציאת הפקדים בתוך הקובץ והכנסת הנתונים למופע של המחלקה
            myViewHolder.planetName=(TextView) convertView.findViewById(R.id.planetName);
            myViewHolder.mooncount=(TextView) convertView.findViewById(R.id.moon_count_text);
            myViewHolder.planetImage=(ImageView) convertView.findViewById(R.id.imageView);
            result=convertView;
            convertView.setTag(myViewHolder);
        }
        else {//יש VIEW ואנחנו עכשיו ממחזרים אותו למשל בגלילה של המסך
            myViewHolder=(MyViewHolder)convertView.getTag();
            result=convertView;
        }
        //getting the data from the module class-planet
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.mooncount.setText(planet.getMoonCount());
        myViewHolder.planetImage.setImageResource(planet.getPlanetImage());
        return result;
    }
}


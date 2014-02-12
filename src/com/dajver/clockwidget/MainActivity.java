package com.dajver.clockwidget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class MainActivity extends AppWidgetProvider{

	@Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		
         //Создаем новый RemoteViews
         RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);

         Date now = new Date();  
         
         Calendar c = Calendar.getInstance();
         c.set(2013, Calendar.MARCH, 10, 1, 58);
         SimpleDateFormat format = new SimpleDateFormat("EEEE", Locale.US);
         DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
         DateFormat time = new SimpleDateFormat("h:mm", Locale.US);
         DateFormat part_of_day = new SimpleDateFormat("a", Locale.US);
         
         remoteViews.setTextViewText(R.id.time, String.valueOf(time.format(now)));
         remoteViews.setTextViewText(R.id.date, String.valueOf(dateFormat.format(now)));
         remoteViews.setTextViewText(R.id.day_of_the_week,String.valueOf(format.format(now)));
         remoteViews.setTextViewText(R.id.part_of_day,String.valueOf(part_of_day.format(now)));
         
         //обновляем виджет
         appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
}

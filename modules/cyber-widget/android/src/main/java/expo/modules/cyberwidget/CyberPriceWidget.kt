package expo.modules.cyberwidget

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class CyberPriceWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        Log.d("hsq~", "onUpdate")
        val intent = Intent(context, CyberPriceWidget::class.java)
        intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        val pendingIntent = PendingIntent.getBroadcast(
            context, 0, intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(
            AlarmManager.ELAPSED_REALTIME,
            SystemClock.elapsedRealtime(),
            1000, // 1 second
            pendingIntent
        )
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
        Log.d("hsq~", "onEnabled")
    }

    override fun onDisabled(context: Context) {
        Log.d("hsq~", "onDisabled")
        // Enter relevant functionality for when the last widget is disabled
        val intent = Intent(context, CyberPriceWidget::class.java)
        intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        val pendingIntent = PendingIntent.getBroadcast(
            context, 0, intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(pendingIntent)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        Log.d("hsq~", "onReceive")
        if (AppWidgetManager.ACTION_APPWIDGET_UPDATE == intent?.action) {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(ComponentName(context!!, CyberPriceWidget::class.java))
            price += 0.1f
            for (appWidgetId in appWidgetIds) {
                updateAppWidget(context, appWidgetManager, appWidgetId, price)
            }
        }
    }

    companion object {

        private var price = 8.3f

        @SuppressLint("DefaultLocale")
        internal fun updateAppWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int,
            price: Float = 8.3f
        ) {
            Log.d("hsq~", "updateAppWidget$appWidgetId")
            val title = "Cyber Price"
            val content = String.format("%.2f", price)

            val views = RemoteViews(context.packageName, R.layout.red_widget)

            views.setTextViewText(R.id.title, title)
            views.setTextViewText(R.id.content, content)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

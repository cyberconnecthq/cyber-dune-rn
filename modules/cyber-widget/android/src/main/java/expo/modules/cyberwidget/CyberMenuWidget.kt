package expo.modules.cyberwidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class CyberMenuWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    companion object {

        internal fun updateAppWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {
            val title = "DUA"
            val content = "976"

            val views = RemoteViews(context.packageName, R.layout.menu_widget)
            views.setOnClickPendingIntent(R.id.profile_button, PendingIntent.getActivity(context, 0, Intent("com.cyberconnect.link3.WALLET").apply { addCategory(Intent.CATEGORY_DEFAULT) },
                PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE))
            views.setOnClickPendingIntent(R.id.transfer_button, PendingIntent.getActivity(context, 0, Intent("com.cyberconnect.link3.TRANSFER").apply { addCategory(Intent.CATEGORY_DEFAULT) },
                PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE))
            views.setOnClickPendingIntent(R.id.qr_button, PendingIntent.getActivity(context, 0, Intent("com.cyberconnect.link3.QR").apply { addCategory(Intent.CATEGORY_DEFAULT) },
                PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE))
            views.setOnClickPendingIntent(R.id.scan_button, PendingIntent.getActivity(context, 0, Intent("com.cyberconnect.link3.SCAN").apply { addCategory(Intent.CATEGORY_DEFAULT) },
                PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE))

            views.setTextViewText(R.id.title, title)
            views.setTextViewText(R.id.content, content)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

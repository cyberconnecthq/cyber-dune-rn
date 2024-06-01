package expo.modules.cyberwidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class LineWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.line_widget_layout)

            // 创建一个折线图数据集
            val lineDataSet = LineDataSet(getData(), "Sample Data").apply {
                setColor(Color.CYAN);
                setCircleColor(Color.CYAN);
                setLineWidth(1f);
                circleRadius = 1f;
                setDrawCircleHole(false);
                valueTextSize = 0f;
                mode = LineDataSet.Mode.CUBIC_BEZIER
            }
            val lineData = LineData(lineDataSet).apply {
                setDrawValues(false)
                setValueTextSize(1f)
            }

            // 设置图表属性
            val lineChart = LineChart(context).apply {
                setDrawGridBackground(false) // 设置是否绘制网格背景
                description.isEnabled = false // 设置是否显示描述
                xAxis.isEnabled = false // 设置是否显示X轴
                axisLeft.isEnabled = true // 设置是否显示左侧Y轴
                axisLeft.textSize = 1f
                axisRight.isEnabled = false // 设置是否显示右侧Y轴
                legend.isEnabled = true // 设置是否显示图例
                legend.textSize = 6f
                legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
                legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
                setBackgroundResource(R.drawable.widget_background)
            }

            lineChart.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            // 测量和布局LineChart
            val widthSpec = View.MeasureSpec.makeMeasureSpec(200.dp(), View.MeasureSpec.EXACTLY)
            val heightSpec = View.MeasureSpec.makeMeasureSpec(160.dp(), View.MeasureSpec.EXACTLY)
            lineChart.measure(widthSpec, heightSpec)
            lineChart.layout(0, 0, lineChart.measuredWidth, lineChart.measuredHeight)


            lineChart.data = lineData
            lineChart.invalidate() // 刷新图表

            Log.d("hsq~","lineChart.width:${lineChart.width},lineChart.height:${lineChart.height}")
            // 将图表添加到Widget
            val bitmap = Bitmap.createBitmap(lineChart.width, lineChart.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            lineChart.draw(canvas)

            views.setImageViewBitmap(R.id.line_chart, bitmap)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
    private fun getData(): List<Entry> {
        val data: MutableList<Entry> = ArrayList()
        data.add(Entry(1f, 2000f))
        data.add(Entry(2f, 3000f))
        data.add(Entry(3f, 5001f))
        data.add(Entry(4f, 7000f))
        data.add(Entry(5f, 7500f))
        data.add(Entry(6f, 8000f))
        data.add(Entry(7f, 8800f))
        return data
    }

}

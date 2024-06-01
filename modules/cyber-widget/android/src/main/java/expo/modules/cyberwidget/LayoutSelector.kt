package expo.modules.cyberwidget

object LayoutSelector {

    /**
     * layout
     */
    fun selectLayout(): Int {
        val randomNumber = (0..4).random()
        return when (randomNumber % 5) {
            0 -> R.layout.green_widget
            1 -> R.layout.blue_widget
            2 -> R.layout.red_widget
            3 -> R.layout.orange_widget
            else -> R.layout.brown_widget
        }
    }
}
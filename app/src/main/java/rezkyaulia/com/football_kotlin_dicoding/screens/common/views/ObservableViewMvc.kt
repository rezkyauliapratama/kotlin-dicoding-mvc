package rezkyaulia.com.football_kotlin_dicoding.screens.common.views

interface ObservableViewMvc<ListenerType> : ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)
}
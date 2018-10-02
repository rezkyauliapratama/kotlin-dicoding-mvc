package rezkyaulia.com.football_kotlin_dicoding.screens.common.base.views

import android.content.Context
import android.support.annotation.StringRes
import android.view.View


abstract class BaseViewMvc: ViewMvc  {

    override var rootView: View? = null


    protected fun <T : View> findViewById(id: Int): T? {
        return rootView?.findViewById(id)
    }

    protected fun getContext(): Context? {
        return rootView?.context
    }

    protected fun getString(@StringRes id: Int): String? {
        return getContext()?.getString(id)
    }
}

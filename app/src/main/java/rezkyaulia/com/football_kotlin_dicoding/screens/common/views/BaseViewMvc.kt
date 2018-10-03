package rezkyaulia.com.football_kotlin_dicoding.screens.common.views

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.annotation.StringRes
import android.view.View


abstract class BaseViewMvc: ViewMvc {

    override var dataBinding: ViewDataBinding? = null

    protected fun getContext(): Context? {
        return dataBinding?.root?.context
    }

    protected fun getString(@StringRes id: Int): String? {
        return getContext()?.getString(id)
    }
}

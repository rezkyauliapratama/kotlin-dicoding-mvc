package rezkyaulia.com.football_kotlin_dicoding.screens.common.screennavigator

import rezkyaulia.com.football_kotlin_dicoding.screens.common.FragmentFrameHelper.FragmentFrameHelper
import rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent.LastEventFragment

class ScreensNavigator(private val mFragmentFrameHelper: FragmentFrameHelper) {


    fun toQuestionsList() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(LastEventFragment.newInstance())
    }
}

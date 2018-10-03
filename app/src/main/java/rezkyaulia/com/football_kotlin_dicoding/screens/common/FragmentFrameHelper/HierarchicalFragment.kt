package rezkyaulia.com.football_kotlin_dicoding.screens.common.FragmentFrameHelper

import android.support.v4.app.Fragment

interface HierarchicalFragment {
    /**
     * In case of UP navigation when Fragments back-stack is empty, the Fragment returned by this
     * method will be navigated to. If this method returns null, then UP navigation will be
     * delegated to enclosing Activity.
     * @return hierarchical parent Fragment of this Fragment; null this Fragment has no hierarchical
     * parent
     */
    val hierarchicalParentFragment: Fragment?
}

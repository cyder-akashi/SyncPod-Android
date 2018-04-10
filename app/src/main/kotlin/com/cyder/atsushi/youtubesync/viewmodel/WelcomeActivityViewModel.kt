package com.cyder.atsushi.youtubesync.viewmodel

import com.cyder.atsushi.youtubesync.view.helper.Navigator
import com.cyder.atsushi.youtubesync.viewmodel.base.ActivityViewModel
import javax.inject.Inject

/**
 * Created by chigichan24 on 2018/01/12.
 */

class WelcomeActivityViewModel @Inject constructor(
        private val navigator: Navigator
) : ActivityViewModel() {
    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    fun onSignInClicked() = navigator.navigateToSignInActivity()

    fun onSignUpClicked() = navigator.navigateToSignUpActivity()
}
package com.templatesfjr.nubank.utils

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.templatesfjr.nubank.view.main.MainActivity

class NubankRouter(private val activity: AppCompatActivity) {

    fun goToMainActivity(tagFirebase: String? = null) {
//        addTrackingScreen(tagFirebase)
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }

    fun goToBB(tagFirebase: String? = null) {
//        addTrackingScreen(tagFirebase)
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }

    fun showActivityClearTop(targetActivity: Class<*>) {
        activity.startActivity(
            Intent(
                activity,
                targetActivity
            ).apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) })
    }

    fun finishWithAnimation(enterAnim: Int, exitAnim: Int) {
        activity.run {
            finish()
            overridePendingTransition(enterAnim, exitAnim)
        }
    }

    fun finish() {
//        finishWithAnimation(R.anim.enter_animation, R.anim.slide_out_down)
    }

    fun setResult(resultIntent: Intent) {
        activity.setResult(Activity.RESULT_OK, resultIntent)
    }

    fun onBackPressed() {
//        addTrackingScreen(CreditAnalytics.BB)
        activity.onBackPressed()
    }

    fun finishActivity() {
//        addTrackingScreen(CreditAnalytics.AA)
        activity.finish()
    }

    fun finishAffinity() {
        activity.finishAffinity()
    }
}
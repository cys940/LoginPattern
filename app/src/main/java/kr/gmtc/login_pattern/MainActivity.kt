package kr.gmtc.login_pattern

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.andrognito.patternlockview.PatternLockView
import com.andrognito.patternlockview.listener.PatternLockViewListener
import com.andrognito.patternlockview.utils.PatternLockUtils
import com.andrognito.patternlockview.utils.ResourceUtils
import kr.gmtc.login_pattern.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.pattern.addPatternLockListener(object : PatternLockViewListener {
            override fun onStarted() {
                Log.d(this.javaClass.simpleName, "Pattern drawing started")
            }

            override fun onProgress(progressPattern: MutableList<PatternLockView.Dot>?) {
                Log.d(this.javaClass.simpleName,  "Pattern progress: " +
                        PatternLockUtils.patternToString(binding.pattern, progressPattern))
            }

            override fun onComplete(pattern: MutableList<PatternLockView.Dot>?) {
                Log.d(this.javaClass.simpleName, "Pattern complete: " +
                        PatternLockUtils.patternToString(binding.pattern, pattern))
            }

            override fun onCleared() {
                Log.d(this.javaClass.simpleName, "Pattern has been cleared")
            }
        })
    }
}
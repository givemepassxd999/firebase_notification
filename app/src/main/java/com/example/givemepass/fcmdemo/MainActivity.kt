package com.example.givemepass.fcmdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.msg_text
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMsgEvent(msgEvent: String) {
        Log.e("fcm", "msg:${msgEvent}")
        msg_text.text = msgEvent
    }

    override fun onPause() {
        super.onPause()
        EventBus.getDefault().unregister(this)
    }
}

package com.example.givemepass.fcmdemo


class MyNotice private constructor() {

    private var mOnMessageReceivedListener: OnMessageReceivedListener? = null

    interface OnMessageReceivedListener {
        fun onMessageReceived(s: String)
    }

    fun setOnMessageReceivedListener(listener: OnMessageReceivedListener) {
        mOnMessageReceivedListener = listener
    }

    fun notifyOnMessageReceived(s: String) {
        mOnMessageReceivedListener?.let { it.onMessageReceived(s) }
    }

    companion object {
        val instance = MyNotice()
    }
}

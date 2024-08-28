package com.test

import android.content.Intent
import android.widget.Button
import com.example.common.core.base.BaseActivity
import com.example.proj.home.HomeActivity
import com.example.proj.home.R

/**
 * @author: cb
 * @date: 2024/8/27 21:59
 * @desc: search module单独运行
 */
class HomeTestActivity : BaseActivity(R.layout.activity_test_home) {

    override fun initView() {
        super.initView()


        findViewById<Button>(R.id.shome).setOnClickListener {
            startActivity(Intent(this@HomeTestActivity, HomeActivity::class.java))
        }
    }
}
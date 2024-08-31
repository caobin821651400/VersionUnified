package com.example.project

import android.os.Bundle
import android.widget.Button
import com.example.common.core.Router
import com.example.common.core.base.BaseActivity
import com.example.proj.search.SearchActivity
import com.therouter.TheRouter

class MainActivity : BaseActivity(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.home).setOnClickListener {
            TheRouter.build(Router.ROUTER_HOME).navigation(this)
        }
        findViewById<Button>(R.id.search).setOnClickListener {
            TheRouter.build(Router.ROUTER_SEARCH).navigation(this)
        }


        //这里可以引用到aar中的class
        val claz = SearchActivity::class.java
    }
}
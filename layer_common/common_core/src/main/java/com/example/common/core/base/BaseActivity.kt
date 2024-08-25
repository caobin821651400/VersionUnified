package com.example.common.core.base

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * @author: cb
 * @date: 2024/7/30
 * @desc: Activity基类
 */
abstract class BaseActivity(contentLayoutId: Int) : FragmentActivity(contentLayoutId) {

    private var viewModel: BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
        initParam()
        initView()
        initViewObservable()
        initData()
    }


    /**
     * 初始化 ViewModule
     * @return  BaseViewModel
     */
    protected open fun getViewModel(): BaseViewModel? {
        return null
    }


    /**
     * 解析参数
     */
    protected open fun initParam() {}

    /**
     * view一些操作
     */
    protected open fun initView() {}

    /**
     * 请求接口
     */
    protected open fun initData() {}

    /**
     * liveData or flow 处理的地方
     */
    protected open fun initViewObservable() {}


}
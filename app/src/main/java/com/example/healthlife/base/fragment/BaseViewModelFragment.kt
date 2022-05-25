package com.example.healthlife.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.coroutineScope
import com.example.healthlife.base.viewmodel.BaseViewModel
import com.example.healthlife.ext.getVmClazz
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 描述　: ViewModelFragment基类，自动把ViewModel注入Fragment
 */
abstract class BaseViewModelFragment<VM : BaseViewModel> : BaseFragment() {

    //是否第一次加载
    private var isFirst: Boolean = true

    lateinit var viewModel: VM

    lateinit var mActivity: AppCompatActivity

    /**
     * 当前Fragment绑定的视图布局
     */
    abstract fun layoutId(): Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //@WARN:owner: 在单Activity架构下设定为Activity，保证获取到的只有一个ViewModel对象
        viewModel = createViewModel()
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFirst = true
        initView(savedInstanceState)
        createObserver()
        registerDefUIChange()
        initData()
    }


    private fun registerDefUIChange() {

    }

    override fun onResume() {
        super.onResume()
        onVisible()
    }

    private fun onVisible() {
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {
            // 延迟加载 防止 切换动画还没执行完毕时数据就已经加载好了，这时页面会有渲染卡顿
            lifecycle.coroutineScope.launch {
                delay(lazyLoadTime())
                lazyLoadData()
                isFirst = false
            }
        }
    }

    /**
     * 懒加载
     */
    abstract fun lazyLoadData()

    /**
     * 创建viewModel  使用反射获取viewModel实例
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(getViewModelOwner())[getVmClazz(this)]
    }

    /**
     * 初始化view
     */
    abstract fun initView(savedInstanceState: Bundle?)


    /**
     * 创建观察者
     */
    abstract fun createObserver()


    /**
     * Fragment执行onViewCreate后触发的方法
     */
    open fun initData() {}


    /**
     * 延迟加载 防止 切换动画还没执行完毕时数据就已经加载好了，这时页面会有渲染卡顿  bug
     * 这里传入你想要延迟的时间，延迟时间可以设置比转场动画时间长一点 单位： 毫秒
     * 不传默认 300毫秒
     * @return Long
     */
    open fun lazyLoadTime(): Long {
        return 300
    }

    /**
     * 在单Activity架构下设定为Activity，保证获取到的只有一个ViewModel对象
     * 返回Activity 可以共享viewModel，此时viewModel 存在activity viewModelStore
     *
     * @return viewModelStoreOwner
     */
    open fun getViewModelOwner(): ViewModelStoreOwner {
        return this
    }
}
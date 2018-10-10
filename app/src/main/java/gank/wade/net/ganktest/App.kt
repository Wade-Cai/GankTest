package gank.wade.net.ganktest
import android.app.Application

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager
import com.squareup.leakcanary.LeakCanary
import gank.wade.net.ganktest.utils.Utils

/**
 *@创建人 Wade
 *@项目名称 GankTest
 *@包名
 *@创建时间 2018/10/9 17:35
 *@描述 ${TODO}
 *——————————————
 *@版本 $$Rev$$
 *@更新者 $$Author$$
 *@更新时间 $$Date$$
 *@更新描述 ${TODO}
 */
class App : Application() {

    init {
        instance = this
    }

    companion object {
        @get:Synchronized
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()

        // 初始化 LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)

        BGASwipeBackManager.getInstance().init(this)
        ConfigManage.initConfig(this)
        Utils.init(this)

    }

    fun exitApp() {
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(0)
    }
}
package gank.wade.net.ganktest.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 *@创建人 Wade
 *@项目名称 GankTest
 *@包名 gank.wade.net.ganktest.utils
 *@创建时间 2018/10/10 10:29
 *@描述 ${TODO}
 *——————————————
 *@版本 $$Rev$$
 *@更新者 $$Author$$
 *@更新时间 $$Date$$
 *@更新描述 ${TODO}
 */
class Utils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        /**
         * 初始化工具类
         *
         * @param context 上下文
         */
        fun init(context: Context) {
            Utils.context = context.applicationContext
        }

        /**
         * 获取ApplicationContext
         *
         * @return ApplicationContext
         */
        fun getContext(): Context {
            if (context != null) return context!!
            throw NullPointerException("u should init first")
        }

        /**
         * 使用浏览器打开链接
         */
        fun openLink(context: Context, content: String) {
            val issuesUrl = Uri.parse(content)
            val intent = Intent(Intent.ACTION_VIEW, issuesUrl)
            context.startActivity(intent)
        }
    }
}
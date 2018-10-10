package gank.wade.net.ganktest.module.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import butterknife.BindView
import com.bumptech.glide.Glide
import gank.wade.net.ganktest.R
import gank.wade.net.ganktest.base.BaseActivity
import gank.wade.net.ganktest.config.ConstantsImageUrl
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

/**
 *@创建人 Wade
 *@项目名称 GankTest
 *@包名 gank.wade.net.ganktest.module.splash
 *@创建时间 2018/10/10 14:35
 *@描述 ${TODO}
 *——————————————
 *@版本 $$Rev$$
 *@更新者 $$Author$$
 *@更新时间 $$Date$$
 *@更新描述 ${TODO}
 */
class SplashActivity : BaseActivity() {

    private var isIn: Boolean = false

    @BindView(R.id.splash_tv_jump)
    private lateinit var mTvJump: TextView


    override val contentViewLayoutID: Int
        get() = R.layout.activity_splash

    override fun initView(savedInstanceState: Bundle?) {
        val i = Random().nextInt(ConstantsImageUrl.TRANSITION_URLS.size)
        // 先显示默认图

        splash_iv_defult_pic.setImageDrawable(resources.getDrawable(R.drawable.img_transition_default))
        Glide.with(this)
                .load(ConstantsImageUrl.TRANSITION_URLS[i])
                .placeholder(R.drawable.img_transition_default)
                .error(R.drawable.img_transition_default)
                .into(splash_iv_pic)
        Handler().postDelayed({ splash_iv_defult_pic.visibility = View.GONE }, 1500)

        Handler().postDelayed({ toMainActivity() }, 3500)
        splash_tv_jump.setOnClickListener { toMainActivity() }
    }

    override fun isSupportSwipeBack(): Boolean {
        return false
    }

    /**
     * 跳转到主页面
     */
    private fun toMainActivity() {
//        if (isIn) {
//            return
//        }
//        val intent = Intent(this, HomeActivity::class.java)
//        startActivity(intent)
//        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out)
//        finish()
//        isIn = true
    }

}
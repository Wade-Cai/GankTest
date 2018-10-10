package gank.wade.net.ganktest

import android.content.Context

/**
 *@创建人 Wade
 *@项目名称 GankTest
 *@包名 gank.wade.net.ganktest
 *@创建时间 2018/10/9 17:37
 *@描述 ${TODO}
 *——————————————
 *@版本 $$Rev$$
 *@更新者 $$Author$$
 *@更新时间 $$Date$$
 *@更新描述 ${TODO}
 */

object ConfigManage {

    private const val spName = "app_config"
    private const val key_isListShowImg = "isListShowImg"
    private const val key_thumbnailQuality = "thumbnailQuality"

    private var isListShowImg: Boolean = false
    private var thumbnailQuality: Int = 0

    @JvmStatic
    fun initConfig(context: Context){
        val sharedPreferences = context.getSharedPreferences(spName,Context.MODE_PRIVATE)
        // 列表是否显示图片
        isListShowImg = sharedPreferences.getBoolean(key_isListShowImg, true)
        // 缩略图质量 0：原图 1：默认 2：省流
        thumbnailQuality = sharedPreferences.getInt(key_thumbnailQuality, 1)
    }

    @JvmStatic fun isListShowImg(): Boolean {
        return isListShowImg
    }
    @JvmStatic
    fun setListShowImg(listshowImg: Boolean){
        val sharedPreferences = App.instance.getSharedPreferences(spName, Context.MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        edit.putBoolean(key_isListShowImg,listshowImg)
        if(edit.commit()){
            isListShowImg = listshowImg
        }
    }

    @JvmStatic fun getThumbnailQuality(): Int {
        return thumbnailQuality
    }

    @JvmStatic fun setThumbnailQuality(thumbnailQuality: Int) {
        val sharedPreferences = App.instance.getSharedPreferences(spName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(key_thumbnailQuality, thumbnailQuality)
        if (editor.commit()) {
            this.thumbnailQuality = thumbnailQuality
        }
    }

}
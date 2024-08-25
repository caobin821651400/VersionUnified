import java.util.Date

/**
 * @author: cb
 * @date: 2023/10/12 20:23
 * @desc: 描述
 */
object ProjectVersion {

    const val compileSdk = 33
    const val targetSdk = 33
    const val minSdk = 19
    const val versionCode = 100
    const val versionName = "1.0.0"
    const val applicationId = "com.example.project"

    /**
     * 项目接口的地址
     */
    const val url = "http://baidu.com"

    /**
     * 定义参数
     */
    var param = false


    //可以根据项目需求定义更多的变量.......

    /**
     * 获取打包时间
     * @return String
     */
    fun getCurrDate(): String {
        val date = Date()
        val dateStr = date.time
        return "$dateStr"
    }
}
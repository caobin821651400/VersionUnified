pluginManagement {
    includeBuild("version-plugin")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { setUrl("https://maven.aliyun.com/repository/google/") }
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin/") }
        maven { setUrl("https://jitpack.io") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://maven.aliyun.com/repository/google/") }
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin/") }
        maven { setUrl("https://jitpack.io") }
//        maven {
//            isAllowInsecureProtocol = true//允许http
//            setUrl("http://nexus.tvplus.club:11574/repository/maven-dianshijia/")
//        }

        //解决打release包提示：
        // Direct local .aar file dependencies are not supported when building an aar
        //升级gradle后debug没问题，release提示无法挂载libs里面的aar
        gradle.settingsEvaluated {
            val index = rootDir.toString().length
            val list = ArrayList<String>()
            rootProject.children.forEach { child ->
                val absPath = child.projectDir.toString()
                if (absPath.length <= index) return@forEach
                val step1 = absPath.substring(index)
                val step2 = step1.replace("\\", "/")
                list.add(".${step2}/libs")
            }

            flatDir {
                dirs(list)
//                dirs("./layer_extends/extend_cdnbye/libs")
            }
        }
    }
}

val SEARCH_IS_AAR = providers.gradleProperty("proj_search_aar").get() == "true"

rootProject.name = "VersionUnified"
include(":app")


//**********************************基础层**********************************//
include(":base_util")
project(":base_util").projectDir = File("./layer_base/base_util")
//**********************************基础层**********************************//

//**********************************中间层**********************************//
include(":common_core")
project(":common_core").projectDir = File("./layer_common/common_core")
//**********************************中间层**********************************//

//**********************************扩展库**********************************//
include(":extends_ijk")
project(":extends_ijk").projectDir = File("./layer_extends/extends_ijk")
//**********************************扩展库**********************************//

//**********************************业务层**********************************//
include(":proj_home")
project(":proj_home").projectDir = File("./layer_project/proj_home")

//不是aar引入源码，当让这里也可以放到自己公司的maven库中
if (!SEARCH_IS_AAR) {
    include(":proj_search")
    project(":proj_search").projectDir = File("./layer_project/proj_search")
}
//**********************************业务层**********************************//
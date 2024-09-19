package com.min.b_module_test

import android.app.Instrumentation
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep
import kotlin.jvm.Throws

/**
 *Created by ming on 2024/9/19.
 */
@RunWith(AndroidJUnit4::class)
class MyTest : TestCase() {

    lateinit var instrumentation: Instrumentation
    lateinit var uiDevice: UiDevice
    private val packageName = "com.min.b_module_test"

    @Before
    fun startUp() {
        instrumentation = InstrumentationRegistry.getInstrumentation()
        uiDevice = UiDevice.getInstance(instrumentation)
    }

    @Test
    fun testA() {
        //1.启动App
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
            packageName
        )?.apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)
        Log.d(TAG, "Step No:1 ,打开MyApp")
        sleep(5.0f)

        //2、邮箱输入username
        val email = uiDevice.findObject(UiSelector().text("Email"))
        email.click()
        email.legacySetText("username")
        Log.d(TAG, "Step NO:2 ,点击邮箱输入框，并输入username")
        sleep(5.0f)

        //3、密码输入123ab
        val pwd = uiDevice.findObject(UiSelector().text("Password"))
        pwd.click()
        pwd.legacySetText("123123")
        uiDevice.pressBack()
        Log.d(TAG, "Step NO: 3 ,点击密码输入框,并输入123123")
        sleep(5.0f)

        //3,点击登录按钮
        // 找到并点击登录按钮，使用waitForExists确保元素存在
        val btn = uiDevice.findObject(UiSelector().text("login"))
        if (btn.waitForExists(5000)) {  // 等待5秒钟
            btn.click()
            Log.d(TAG, "Step No: 4 , 点击登录按钮")
        } else {
            Log.e(TAG, "Login button not found")
        }
        sleep(5.0f)


    }

    @Throws(java.lang.Exception::class)
    private fun sleep(second: Float) {
        Thread.sleep(if (second > 0) (second * 1000).toLong() else 500)
    }

}
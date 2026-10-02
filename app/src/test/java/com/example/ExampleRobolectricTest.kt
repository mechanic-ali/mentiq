package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Məntiq Quiz", appName)
  }

  @Test
  fun `verify 91 questions loaded`() {
    val totalQuestions = com.example.data.repository.questionsPart1.size +
        com.example.data.repository.questionsPart2.size +
        com.example.data.repository.questionsPart3.size
    assertEquals(91, totalQuestions)
  }
}

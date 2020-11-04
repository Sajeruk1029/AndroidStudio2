package com.example.unittest

import org.json.JSONArray
import org.json.JSONObject
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testAPI()
    {
        print(FirstTest("http://newsapi.org/v2/top-headlines?country=us&apiKey=1b93bc09293f461aa6ce921812fc7294").get_result())


        //assertNull(JSONObject(FirstTest("http://newsapi.org/v2/top-headlines?country=us&apiKey=1b93bc09293f461aa6ce921812fc7294").get_result()).getJSONArray("articles"))
        //assertEquals((JSONObject(FirstTest("http://newsapi.org/v2/top-headlines?country=us&apiKey=1b93bc09293f461aa6ce921812fc7294").get_result()).getJSONArray("articles").getJSONObject(0).get("author")).toString(), "")
        //assertEquals((JSONArray(FirstTest("http://newsapi.org/v2/top-headlines?country=us&apiKey=1b93bc09293f461aa6ce921812fc7294").get_result())).getJSONObject(0).getString("author"), "")
    }

}
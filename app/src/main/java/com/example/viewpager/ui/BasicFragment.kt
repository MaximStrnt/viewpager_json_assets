package com.example.tableone.ui

import androidx.fragment.app.Fragment
import com.example.tableone.APP_ACTIVITY
import com.example.tableone.Animal
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

open class BasicFragment: Fragment() {


   open fun initJSON(array: String, box: ArrayList<Animal>  ) {

        try {
            val jsonObject = JSONObject(getJsonDataFromAsset("animals.json" ))
            val jsonArray = jsonObject.getJSONArray(array)
            for (i in 0 until jsonArray.length()) {
                val userData = jsonArray.getJSONObject(i)

                val img = userData.getString("picture").toString()

                val id = getResourceId(img.toString(), "drawable", APP_ACTIVITY.getPackageName());

                val name = userData.getString("name").toString()
                val text = userData.getString("text").toString()

                box.add(Animal(id, name, text))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


    open fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = APP_ACTIVITY.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


    open fun getResourceId(variableName: String?, resourceName: String?, packageName: String?): Int {
        return try {
            resources.getIdentifier(variableName, resourceName, packageName)
        } catch (e: Exception) {
            e.printStackTrace()
            -1
        }
    }


}
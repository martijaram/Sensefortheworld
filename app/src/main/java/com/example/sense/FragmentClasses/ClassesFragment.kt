package com.example.sense.FragmentClasses

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sense.BottomNavigationActivity
import com.example.sense.HelperClasses.TAGS
import com.example.sense.R
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.fragment_classes.*


/**
 * A simple [Fragment] subclass.
 */
class ClassesFragment : AppCompatActivity() {

    var itKeyCourses: String? = null
    var itkeyAccountValues: String? = null

    var coursePhysicsTrueOrFalseValue: String? = null
    var courseChemistryTrueOrFalseValue: String? = null
    var courseBiologyTrueOrFalseValue: String? = null

    var tags: TAGS? = null

    private val courseMapIntialization: MutableMap<String, Any> = HashMap()



    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_classes)

        tags = TAGS()

        val sharedPreferences: SharedPreferences = getSharedPreferences("com.example.sense.FragmentClasses.sharedpreferences", Context.MODE_PRIVATE)
        val text = findViewById(R.id.textViewScore) as TextView
        val buttona: View = findViewById<View>(R.id.physicsCardView) as View
        buttona.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                sharedPreferences.edit().putString(tags?.CURRENT_COURSE_ACTIVITY, tags?.PHYSICS_COURSE).apply()
                if (!coursePhysicsTrueOrFalseValue.equals("true")) {

                    courseMapIntialization["Course"] = tags?.PHYSICS_COURSE.toString()
                    courseMapIntialization["CourseAdvancement"] = 0


                }


            }
        })

        val buttonb: View = findViewById<View>(R.id.chemistryCourseButtom) as View
        buttonb.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                sharedPreferences.edit().putString(tags?.CURRENT_COURSE_ACTIVITY, tags?.CHEMISTRY_COURSE).apply()

                if (!courseChemistryTrueOrFalseValue.equals("true")) {

                    courseMapIntialization["Course"] = tags?.CHEMISTRY_COURSE.toString()
                    courseMapIntialization["CourseAdvancement"] = 0

                }

            }

        })
        val buttonc: View = findViewById<View>(R.id.biologyCourseButtom) as View
        buttonc.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                sharedPreferences.edit().putString(tags?.CURRENT_COURSE_ACTIVITY, tags?.BIOLOGY_COURSE).apply()

                if (!courseBiologyTrueOrFalseValue.equals("true")) {
                    courseMapIntialization["Course"] = tags?.BIOLOGY_COURSE.toString()
                    courseMapIntialization["CourseAdvancement"] = 0

                }

            }

        })
    }



    fun goToHome() {
        var intent = Intent(applicationContext, BottomNavigationActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }



}
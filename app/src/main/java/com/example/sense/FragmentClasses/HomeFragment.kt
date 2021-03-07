package com.example.sense.FragmentClasses

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sense.BottomNavigationActivity
import com.example.sense.FragmentCourses.FragmentCoursesTree.PhysicsCourseFragment
import com.example.sense.HelperClasses.TAGS
import com.example.sense.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    var imageViewForCourse: FloatingActionButton? = null
    var textViewForCourse: TextView? = null

    var imageViewForCoins: ImageView? = null

    var currentCourse: String? = null

    var bottomNavigationActivity: BottomNavigationActivity? = null

    var intent: Intent? = null

    var tags: TAGS? = null
    var courseStats: String? = null

    var physicsCourseFragment: Fragment? = null

    var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        bottomNavigationActivity = BottomNavigationActivity()

        physicsCourseFragment = PhysicsCourseFragment()

        imageViewForCourse = view.findViewById(R.id.floatingActionButton)

        imageViewForCourse?.setOnClickListener {
            intent = Intent(activity, ClassesFragment::class.java)
            startActivity(intent)
        }

        tags = TAGS()

        sharedPreferences = (context as AppCompatActivity).getSharedPreferences("com.example.sense.FragmentClasses.sharedpreferences", Context.MODE_PRIVATE)

        currentCourse = sharedPreferences?.getString(tags?.CURRENT_COURSE_ACTIVITY, null)

        if (currentCourse == null) {
            // Do Nothing
        } else {
            if (currentCourse.equals(tags?.CHEMISTRY_COURSE)) {
                imageViewForCourse?.setImageResource(R.drawable.flask)

                (context as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.frameLayoutCourseTreeDisplay, physicsCourseFragment!!).commit()
            }
            if (currentCourse.equals(tags?.PHYSICS_COURSE)) {
                imageViewForCourse?.setImageResource(R.drawable.universe)
            }
            if (currentCourse.equals(tags?.BIOLOGY_COURSE)) {
                imageViewForCourse?.setImageResource(R.drawable.biology)
            }
        }

        return view
    }
}

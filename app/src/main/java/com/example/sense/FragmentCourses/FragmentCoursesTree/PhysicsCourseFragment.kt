package com.example.sense.FragmentCourses.FragmentCoursesTree


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sense.CoursesClasses.PhysicsIntro
import com.example.sense.HelperClasses.TAGS
import com.example.sense.R


/**
 * A simple [Fragment] subclass.
 */
class PhysicsCourseFragment : Fragment(), View.OnClickListener{
    var tags: TAGS? = null
    var sharedPreferences: SharedPreferences? = null

    var scrollview: ScrollView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_physics_course, container, false)

        scrollview = view?.findViewById(R.id.scrollViewForCoursePhysics)
        scrollview!!.post { scrollview!!.fullScroll(ScrollView.FOCUS_DOWN) }

        tags = TAGS()

        sharedPreferences = view.context.getSharedPreferences("com.example.sense.FragmentClasses.sharedpreferences", Context.MODE_PRIVATE)

        val button: ImageView = view.findViewById(R.id.imageViewForIntroMoonPhysics)
        button.setOnClickListener(this)

        return view
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this.context, PhysicsIntro::class.java)
        startActivity(intent)
    }

}
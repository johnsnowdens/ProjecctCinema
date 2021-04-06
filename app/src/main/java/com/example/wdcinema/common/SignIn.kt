package com.example.wdcinema.common

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.wdcinema.R
import com.example.wdcinema.api.wdapi
import com.example.wdcinema.databinding.ActivitySignInBinding
import org.json.JSONObject

class SignIn : AppCompatActivity() {
    lateinit var requestQueue:RequestQueue
    lateinit var binding:ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
       requestQueue = Volley.newRequestQueue(this)



        binding.SignUpbtnIn.setOnClickListener {
            val intentt = Intent(this,SignUpActivity::class.java)
            startActivity(intentt)
        }

        binding.SignInbtnIn.setOnClickListener {
            val login = binding.login.text.toString()
            val password = binding.password.text.toString()
            if( login.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(login).matches()) {
                Toast.makeText(this, "Не правильный Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener }

            val request = JsonObjectRequest(
                Request.Method.POST,
                wdapi.auth,
                JSONObject()
                    .put("email",login)
                    .put("password",password),
                { response ->
                    Toast.makeText(this, "успешно", Toast.LENGTH_SHORT).show()

                },
                { error ->
                    Toast.makeText(this, "успешно", Toast.LENGTH_SHORT).show()
                    val i = Intent(this,MainActivity::class.java)
                    startActivity(i)
                })
            requestQueue.add(request)




        }
    }
}
//https://github.com/PsssUm/lesson7
//class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {
//    private var navPosition: BottomNavigationPosition = BottomNavigationPosition.FIRST
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        initBottomNavigation()
//    }
//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        navPosition = findNavigationPositionById(item.itemId)
//        return switchFragment(navPosition)
//    }
//    private fun initBottomNavigation() {
//        bottomNavigation.setOnNavigationItemSelectedListener(this)
//        bottomNavigation.selectedItemId = R.id.first
//    }
//    private fun switchFragment(navPosition: BottomNavigationPosition): Boolean {
//        val fragment = supportFragmentManager.findFragment(navPosition)
//        if (fragment.isAdded) return false
//        detachFragment()
//        attachFragment(fragment, navPosition.getTag())
//        supportFragmentManager.executePendingTransactions()
//        return true
//    }
//
//    private fun FragmentManager.findFragment(position: BottomNavigationPosition): Fragment {
//        return findFragmentByTag(position.getTag()) ?: position.createFragment()
//    }
//
//    private fun detachFragment() {
//        supportFragmentManager.findFragmentById(R.id.container)?.also {
//            supportFragmentManager.beginTransaction().detach(it).commit()
//        }
//    }
//
//    private fun attachFragment(fragment: Fragment, tag: String) {
//        if (fragment.isDetached) {
//            supportFragmentManager.beginTransaction().attach(fragment).commit()
//        } else {
//            supportFragmentManager.beginTransaction().add(R.id.container, fragment, tag).commit()
//        }
//        // Set a transition animation for this transaction.
//        supportFragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .commit()
//    }


//фрагмент
//open class FirstFragment : Fragment() {
//
//    companion object {
//        val TAG: String = FirstFragment::class.java.simpleName
//        fun newInstance() = FirstFragment()
//    }
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.first_fragment, container, false)
//        return view
//    }
//}
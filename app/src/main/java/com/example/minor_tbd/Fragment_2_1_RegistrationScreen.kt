package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Fragment_2_1_RegistrationScreen : Fragment() {
    lateinit var auth: FirebaseAuth

    lateinit var headingHey: TextView
    lateinit var btn_Next_Text: TextView
    lateinit var btn_next: TextView

    lateinit var btn_cancel: Button

    lateinit var et_Name: EditText
    lateinit var et_Surname: EditText
    lateinit var et_Email: EditText
    lateinit var et_Pass: EditText
    lateinit var et_confirmPass: EditText
    lateinit var et_MobNo: EditText
    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_2_1_registration_screen, container, false)
        v.apply {

            headingHey = findViewById(R.id.heading_Hey)
            btn_Next_Text = findViewById(R.id.tv_btnNxt)

            var tv_gradient = mutableListOf(headingHey, btn_Next_Text)
            MainActivity.textShader(tv_gradient)

            et_Name = findViewById(R.id.et_Name)
            et_Surname = findViewById(R.id.et_Surname)
            et_Email = findViewById(R.id.et_EmailAddress)
            et_Pass = findViewById(R.id.et_pass)
            et_confirmPass = findViewById(R.id.et_confirm_pass)
            et_MobNo = findViewById(R.id.et_MobileNumber)
            progressBar = findViewById(R.id.progressBar)
            progressBar.setProgress((100 / 3), true)
            progressBar.max = 100

            auth = FirebaseAuth.getInstance()

            var databaseObject = Database.getDatabaseOb(context)

            btn_next = findViewById(R.id.btn_Next)

            btn_next.setOnClickListener {
                if (et_Name.text.toString() == "")
                    Toast.makeText(context, "Name field empty", Toast.LENGTH_SHORT).show()
                else if (et_Email.text.toString() == "")
                    Toast.makeText(context, "Email field empty", Toast.LENGTH_SHORT).show()
                else if (et_Pass.text.toString() == "")
                    Toast.makeText(context, "Password field empty", Toast.LENGTH_SHORT).show()
                else if (et_confirmPass.text.toString() == "")
                    Toast.makeText(context, "Confirm your password", Toast.LENGTH_SHORT).show()
                else if (et_MobNo.text.toString() == "" || et_MobNo.text.toString().length != 10)
                    Toast.makeText(
                        context,
                        "Contact field empty or Invalid contact number entered",
                        Toast.LENGTH_SHORT
                    ).show()
                else if (et_confirmPass.text.toString() != et_Pass.text.toString())
                    Toast.makeText(context, "Wrong Password entered", Toast.LENGTH_SHORT).show()
                else {
                    CoroutineScope(Dispatchers.IO).launch {
                        databaseObject.userInfoDao().insertUser(
                            UserInfo(
                                0,
                                et_Name.text.toString(),
                                et_Surname.text.toString(),
                                et_Email.text.toString(),
                                et_Pass.text.toString(),
                                et_MobNo.text.toString()
                            )
                        )
                    }

                    /*
                        Functionality to let the user sign in using email-id and password
                    */
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            auth.createUserWithEmailAndPassword(et_Email.text.toString(), et_Pass.text.toString())
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        checkLoggedInState()
                                    } else {
                                        checkAccountExistence()
                                    }
                                }
                        } catch (e: Exception) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    // -----------------------------------------------------------------------------
                }

            }

            btn_cancel = findViewById(R.id.btn_Cancel)
            btn_cancel.setOnClickListener {
                parentFragmentManager.popBackStack()
                parentFragmentManager.beginTransaction().apply {
                    remove(this@Fragment_2_1_RegistrationScreen)
                    commit()
                }
            }
        }
        return v
    }

    /*
        Function to check if the email used for registration is already exists in firebase
     */
    private fun checkAccountExistence() {
        FirebaseAuth.getInstance()
            .fetchSignInMethodsForEmail(et_Email.text.toString())
            .addOnCompleteListener() { task ->
                if (task.result?.signInMethods?.size == 0) {
                    checkLoggedInState()
                } else {
                    Toast.makeText(context, "Email already in use!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    /*
        Function to check the logged-in-state
     */
    private fun checkLoggedInState() {
        if (auth.currentUser == null) {
            Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT)
                .show()
        } else {
            parentFragmentManager.beginTransaction().apply {
                addToBackStack("Student_or_Pro")
                setCustomAnimations(
                    R.anim.slide_in_from_right,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out_from_left
                )
                replace(R.id.FragmentHolder, Fragment_2_1_1_RegistrationScreen_StudentOrPro())
                commit()
            }
        }
    }
}
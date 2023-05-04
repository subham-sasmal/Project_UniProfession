package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import soup.neumorphism.NeumorphButton


class Fragment_Student_Interest : Fragment() {
    private lateinit var interestAndroidAppDev: ConstraintLayout
    private lateinit var interestAI: ConstraintLayout
    private lateinit var interestCloudComputing: ConstraintLayout
    private lateinit var interestDevOps: ConstraintLayout
    private lateinit var interestDataScience: ConstraintLayout
    private lateinit var interestDataAnalytics: ConstraintLayout
    private lateinit var interestGameDev: ConstraintLayout
    private lateinit var interestMachineLearning: ConstraintLayout
    private lateinit var interestNLP: ConstraintLayout
    private lateinit var interestWebDev: ConstraintLayout

    private lateinit var textAndroidAppDev: TextView
    private lateinit var textAI: TextView
    private lateinit var textCloudComputing: TextView
    private lateinit var textDevOps: TextView
    private lateinit var textDataScience: TextView
    private lateinit var textDataAnalytics: TextView
    private lateinit var textGameDev: TextView
    private lateinit var textMachineLearning: TextView
    private lateinit var textNLP: TextView
    private lateinit var textWebDev: TextView

    private lateinit var checkButtonAndroidAppDev: View
    private lateinit var checkButtonAI: View
    private lateinit var checkButtonCloudComputing: View
    private lateinit var checkButtonDevOps: View
    private lateinit var checkButtonDataScience: View
    private lateinit var checkButtonDataAnalytics: View
    private lateinit var checkButtonGameDev: View
    private lateinit var checkButtonMachineLearning: View
    private lateinit var checkButtonNLP: View
    private lateinit var checkButtonWebDev: View

    private lateinit var interestButton: TextView
    private lateinit var nextButton: TextView
    private lateinit var btn_back: Button
    private lateinit var btn_next: NeumorphButton
    private lateinit var progressBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_student_interest, container, false)

        v.apply {
            val checkSelectedList = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

            progressBar = findViewById(R.id.progressBar)
            progressBar.max = 100
            progressBar.setProgress(98,true)

            interestAndroidAppDev = findViewById(R.id.android_app_dev_layout)
            interestAI = findViewById(R.id.ai_layout)
            interestCloudComputing = findViewById(R.id.cloud_computing_layout)
            interestDevOps = findViewById(R.id.devOps_layout)
            interestDataScience = findViewById(R.id.dataScience_layout)
            interestDataAnalytics = findViewById(R.id.dataAnalytics_layout)
            interestGameDev = findViewById(R.id.gameDev_layout)
            interestMachineLearning = findViewById(R.id.machineLearning_layout)
            interestNLP = findViewById(R.id.nlp_layout)
            interestWebDev = findViewById(R.id.webDev_layout)

            textAndroidAppDev = findViewById(R.id.tv_interest_android_app_dev)
            textAI = findViewById(R.id.tv_interest_ai)
            textCloudComputing = findViewById(R.id.tv_interest_cloudcomputing)
            textDevOps = findViewById(R.id.tv_interest_devOps)
            textDataScience = findViewById(R.id.tv_interest_dataScience)
            textDataAnalytics = findViewById(R.id.tv_interest_dataAnalytics)
            textGameDev = findViewById(R.id.tv_interest_gameDev)
            textMachineLearning = findViewById(R.id.tv_interest_machineLearning)
            textNLP = findViewById(R.id.tv_interest_nlp)
            textWebDev = findViewById(R.id.tv_interest_webDev)

            checkButtonAndroidAppDev = findViewById(R.id.andoid_app_dev_radio_button)
            checkButtonAI = findViewById(R.id.ai_radio_button)
            checkButtonCloudComputing = findViewById(R.id.cloudComputing_radio_button)
            checkButtonDevOps = findViewById(R.id.devOps_radio_button)
            checkButtonDataScience = findViewById(R.id.dataScience_radio_button)
            checkButtonDataAnalytics = findViewById(R.id.dataAnalytics_radio_button)
            checkButtonGameDev = findViewById(R.id.gameDev_radio_button)
            checkButtonMachineLearning = findViewById(R.id.machineLearning_radio_button)
            checkButtonNLP = findViewById(R.id.nlp_radio_button)
            checkButtonWebDev = findViewById(R.id.webDev_radio_button)

            interestButton = findViewById(R.id.tvHeading_Interests)
            nextButton = findViewById(R.id.tv_btnNxt)

            val interestTextList = mutableListOf(interestButton, nextButton)
            MainActivity.textShader(interestTextList)

            /**
             * Changing the state of selection whenever user selects or deselects Android Application Development interest
             */
            interestAndroidAppDev.setOnClickListener() {
                if (checkSelectedList[0] == 0) {
                    interestAndroidAppDev.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textAndroidAppDev.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonAndroidAppDev.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[0] = 1
                } else if (checkSelectedList[0] == 1) {
                    interestAndroidAppDev.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textAndroidAppDev.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonAndroidAppDev.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[0] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects Artificial Intelligence interest
             */
            interestAI.setOnClickListener() {
                if (checkSelectedList[1] == 0) {
                    interestAI.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textAI.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonAI.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[1] = 1
                } else if (checkSelectedList[1] == 1) {
                    interestAI.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textAI.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonAI.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[1] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects Cloud Computing interest
             */
            interestCloudComputing.setOnClickListener() {
                if (checkSelectedList[2] == 0) {
                    interestCloudComputing.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textCloudComputing.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonCloudComputing.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[2] = 1
                } else if (checkSelectedList[2] == 1) {
                    interestCloudComputing.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textCloudComputing.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonCloudComputing.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[2] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects DevOps interest
             */
            interestDevOps.setOnClickListener() {
                if (checkSelectedList[3] == 0) {
                    interestDevOps.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textDevOps.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonDevOps.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[3] = 1
                } else if (checkSelectedList[3] == 1) {
                    interestDevOps.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textDevOps.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonDevOps.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[3] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects Data Science interest
             */
            interestDataScience.setOnClickListener() {
                if (checkSelectedList[4] == 0) {
                    interestDataScience.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textDataScience.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonDataScience.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[4] = 1
                } else if (checkSelectedList[4] == 1) {
                    interestDataScience.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textDataScience.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonDataScience.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[4] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects Data Analytics interest
             */
            interestDataAnalytics.setOnClickListener() {
                if (checkSelectedList[5] == 0) {
                    interestDataAnalytics.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textDataAnalytics.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonDataAnalytics.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[5] = 1
                } else if (checkSelectedList[5] == 1) {
                    interestDataAnalytics.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textDataAnalytics.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonDataAnalytics.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[5] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects Game Development interest
             */
            interestGameDev.setOnClickListener() {
                if (checkSelectedList[6] == 0) {
                    interestGameDev.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textGameDev.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonGameDev.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[6] = 1
                } else if (checkSelectedList[6] == 1) {
                    interestGameDev.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textGameDev.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonGameDev.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[6] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects Machine Learning interest
             */
            interestMachineLearning.setOnClickListener() {
                if (checkSelectedList[7] == 0) {
                    interestMachineLearning.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textMachineLearning.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonMachineLearning.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[7] = 1
                } else if (checkSelectedList[7] == 1) {
                    interestMachineLearning.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textMachineLearning.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonMachineLearning.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[7] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects Natural Language Processing interest
             */
            interestNLP.setOnClickListener() {
                if (checkSelectedList[8] == 0) {
                    interestNLP.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textNLP.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonNLP.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[8] = 1
                } else if (checkSelectedList[8] == 1) {
                    interestNLP.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textNLP.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonNLP.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[8] = 0
                }
            }


            /**
             * Changing the state of selection whenever user selects or deselects Web Development interest
             */
            interestWebDev.setOnClickListener() {
                if (checkSelectedList[9] == 0) {
                    interestWebDev.setBackgroundResource(R.drawable.bg_interest_tag_selected)
                    textWebDev.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                    checkButtonWebDev.setBackgroundResource(R.drawable.interest_selected_state_icon)
                    checkSelectedList[9] = 1
                } else if (checkSelectedList[9] == 1) {
                    interestWebDev.setBackgroundResource(R.drawable.bg_interest_tag_unselected)
                    textWebDev.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.interest_default_state_color
                        )
                    )
                    checkButtonWebDev.setBackgroundResource(R.drawable.interest_normal_state_icon)
                    checkSelectedList[9] = 0
                }
            }


            btn_back = findViewById(R.id.btn_Cancel)
            btn_back.setOnClickListener {
                parentFragmentManager.popBackStack()
                parentFragmentManager.beginTransaction().apply {
                    remove(this@Fragment_Student_Interest)
                    commit()
                }
            }

            btn_next = findViewById(R.id.btn_Next)
            btn_next.setOnClickListener() {
                var cntr = 0
                for(i in 0..9) {
                    if(checkSelectedList[i] == 1)
                        cntr++
                }

                if(cntr == 0)
                    Toast.makeText(context, "Please select at least 1 interest of your choice", Toast.LENGTH_SHORT).show()
                else
                {

                    //Call the welcome screen page
                    parentFragmentManager.beginTransaction().apply {
                        addToBackStack("Registration Complete Welcome String")
                        setCustomAnimations(R.anim.slide_in_from_right,R.anim.slide_out_from_left)
                        replace(R.id.FragmentHolder, Fragment_RegistrationComplete_Welcome()).commit()
                    }
                }
            }
        }

        return v
    }
}
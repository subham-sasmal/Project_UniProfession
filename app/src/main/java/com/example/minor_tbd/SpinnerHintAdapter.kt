package com.example.minor_tbd

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat

class SpinnerHintAdapter(context: Context,@LayoutRes layout : Int, domainList: List<String> ): ArrayAdapter<String>(context, layout, domainList) {

    override fun isEnabled(position: Int): Boolean {
        return position != 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View = super.getView(position, convertView, parent)
        var textView: TextView = view as TextView
        if (position == 0)
            textView.setTextColor(ContextCompat.getColor(context,R.color.spinner_dropdown_hint))
        else
            textView.setTextColor(ContextCompat.getColor(context, R.color.raisin_black_medium))
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View = super.getDropDownView(position, convertView, parent)
        var textView: TextView = view as TextView
        if (position == 0)
            textView.setTextColor(ContextCompat.getColor(context,R.color.et_hint))
        else
            textView.setTextColor(ContextCompat.getColor(context, R.color.raisin_black_medium))
        return view
    }

}
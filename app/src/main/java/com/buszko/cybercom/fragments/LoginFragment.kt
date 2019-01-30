package com.buszko.cybercom.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.buszko.cybercom.R
import com.buszko.cybercom.viewmodels.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginEditText: EditText
    private lateinit var searchButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)

        loginEditText = view.findViewById(R.id.login_edit_text)
        loginEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                loginViewModel.setLogin(text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        loginViewModel.getLogin().observe(this, Observer {
                login -> searchButton.isEnabled = !login.isNullOrEmpty()
        })

        searchButton = view.findViewById(R.id.search_button)
        searchButton.setOnClickListener {
            loginViewModel.clear()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.addToBackStack("")?.replace(R.id.fragment_container, TumblrPostsFragment())
            transaction?.commit()
        }

        activity?.title = getString(R.string.app_name)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        loginViewModel = ViewModelProviders.of(activity!!).get(LoginViewModel::class.java)
    }
}
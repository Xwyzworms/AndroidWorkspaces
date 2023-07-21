package com.example.simplereactive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.core.content.ContextCompat
import com.example.simplereactive.databinding.ActivityMainBinding
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.Function3

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailStream : Observable<Boolean> = RxTextView.textChanges(binding.edEmail).skipInitialValue().map { email->
            !Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        val passwordStream : Observable<Boolean> = RxTextView.textChanges(binding.edPassword).skipInitialValue().map { password ->
            password.length < 6
        }

        val passwordConfirmationStream : Observable<Boolean> = Observable.merge(
            RxTextView.textChanges(binding.edPassword)
                .map { password->
                    password.toString() != binding.edConfirmPassword.text.toString()
                },

            RxTextView.textChanges(binding.edConfirmPassword)
                .map{ confirmationPassword->
                    confirmationPassword.toString() != binding.edPassword.text.toString()
                }
        )

        emailStream.subscribe {
            showEmailExistsAlert(it)
        }
        passwordStream.subscribe{
            showPasswordMinimalAlert(it)
        }

        passwordConfirmationStream.subscribe {
            showPasswordConfirmationAlert(it)
        }
        
        val invalidFieldStream = Observable.combineLatest(
            emailStream,
            passwordStream,
            passwordConfirmationStream,
            Function3{ emailInvalid, passwordInvalid, passwordConfirmationInvalid ->
                !emailInvalid && !passwordInvalid && !passwordConfirmationInvalid
            })

        invalidFieldStream.subscribe{isValid->
            if(isValid) {
                binding.btnRegister.isEnabled = true
                binding.btnRegister.setBackgroundColor(getColor(R.color.purple_500))
            }
            else {
                binding.btnRegister.isEnabled = false
                binding.btnRegister.setBackgroundColor(getColor(R.color.black))
            }
        }
    }

    private fun showEmailExistsAlert(isNotValid : Boolean) {
        binding.edEmail.error = if(isNotValid) getString(R.string.email_not_valid) else null
    }

    private fun showPasswordMinimalAlert(isNotValid: Boolean) {
        binding.edPassword.error = if(isNotValid) getString(R.string.password_not_valid) else null
    }


    private fun showPasswordConfirmationAlert(isNotValid: Boolean) {
        binding.edConfirmPassword.error = if(isNotValid) getString(R.string.password_not_same) else null
    }

}
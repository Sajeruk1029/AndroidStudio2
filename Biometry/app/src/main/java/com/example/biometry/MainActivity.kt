package com.example.biometry

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.widget.Toast
import androidx.annotation.RequiresApi
import android.app.KeyguardManager
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Key
import javax.crypto.KeyGenerator


class MainActivity : AppCompatActivity() {

    var cancellationSignal : CancellationSignal? = null

    val authenticationCallback : BiometricPrompt.AuthenticationCallback
        get() = @RequiresApi(Build.VERSION_CODES.P)
        object : BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                super.onAuthenticationError(errorCode, errString)

                Toast.makeText(applicationContext, "Error code: ${errorCode}. Error message: ${errString}.", Toast.LENGTH_SHORT).show()

            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                super.onAuthenticationSucceeded(result)

                Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()

                startActivity(Intent(applicationContext, MainActivity2::class.java))

            }
        }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?){

        var keyguardManager : KeyguardManager? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

        if(keyguardManager != null) {

            if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
                Toast.makeText(applicationContext, "You haven`t biometric scanner!", Toast.LENGTH_SHORT).show()
            }

            if(keyguardManager!!.isKeyguardSecure){
                Toast.makeText(applicationContext, "Biometric auth is disable!", Toast.LENGTH_SHORT).show()
            }

            if(ActivityCompat.checkSelfPermission(applicationContext, android.Manifest.permission.USE_BIOMETRIC) != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext, "Access denied!", Toast.LENGTH_SHORT).show()
            }
        }

        butauth.setOnClickListener() {
            val biometricPrompt: BiometricPrompt =
                BiometricPrompt.Builder(applicationContext).setTitle("Auth..")
                    .setSubtitle("Scanning biometri...")
                    .setDescription("Scanning you biometri for auth").setNegativeButton(
                    "Cancel",
                    applicationContext.mainExecutor,
                    DialogInterface.OnClickListener() { dialog, which ->
                        Toast.makeText(
                            applicationContext,
                            "Auth canceled!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }).build()

            biometricPrompt.authenticate(getCancellationsignal(),
                applicationContext.mainExecutor,
                authenticationCallback
            )

        }
    }

    fun getCancellationsignal() : CancellationSignal{

        cancellationSignal = CancellationSignal()

        cancellationSignal?.setOnCancelListener {
            Toast.makeText(applicationContext, "User has been cancel auth!", Toast.LENGTH_SHORT).show()
        }

        return cancellationSignal as CancellationSignal
    }

}
package com.SenjaMalaka.senjamalakareservation

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.SenjaMalaka.senjamalakareservation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var menu = 0

        supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_PemesananFragment()).commit()

        binding.ButtonMenuPemesanan.setOnClickListener{
            menu = 1
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_PemesananFragment()).commit()
        }
        binding.ButtonMenuSewaFotografer.setOnClickListener{
            menu = 2
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_SewaFotograferFragment()).commit()
        }
        binding.ButtonMenuSewaLiveMusic.setOnClickListener{
            menu = 3
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_SewaLiveMusicFragment()).commit()
        }
        binding.ButtonMenuSewaBeanBag.setOnClickListener{
            menu = 4
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_SewaBeanBagFragment()).commit()
        }
        binding.ButtonMenuUpdateEvent.setOnClickListener{
            menu = 5
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_UpdateEventFragment()).commit()
        }

        onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (menu != 1)
                {
                    binding.ButtonMenuPemesanan.performClick()
                }

                else {
                    finishAffinity()
                }
            }
        })
    }
}
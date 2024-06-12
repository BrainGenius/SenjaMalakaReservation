package com.SenjaMalaka.senjamalakareservation

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.SenjaMalaka.senjamalakareservation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var menu = 0

        supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_PemesananFragment()).commit()
        setActiveButton(binding.ButtonMenuPemesanan)

        binding.ButtonMenuPemesanan.setOnClickListener {
            menu = 1
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_PemesananFragment()).commit()
            setActiveButton(binding.ButtonMenuPemesanan)
        }
        binding.ButtonMenuSewaFotografer.setOnClickListener {
            menu = 2
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_SewaFotograferFragment()).commit()
            setActiveButton(binding.ButtonMenuSewaFotografer)
        }
        binding.ButtonMenuSewaLiveMusic.setOnClickListener {
            menu = 3
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_SewaLiveMusicFragment()).commit()
            setActiveButton(binding.ButtonMenuSewaLiveMusic)
        }
        binding.ButtonMenuSewaBeanBag.setOnClickListener {
            menu = 4
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_SewaBeanBagFragment()).commit()
            setActiveButton(binding.ButtonMenuSewaBeanBag)
        }
        binding.ButtonMenuUpdateEvent.setOnClickListener {
            menu = 5
            supportFragmentManager.beginTransaction().replace(R.id.Menu_Fragment, Menu_UpdateEventFragment()).commit()
            setActiveButton(binding.ButtonMenuUpdateEvent)
        }

        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (menu != 1) {
                    binding.ButtonMenuPemesanan.performClick()
                } else {
                    finishAffinity()
                }
            }
        })
    }

    private fun setActiveButton(activeButton: ImageButton) {
        // Reset all button backgrounds to default
        binding.ButtonMenuPemesanan.setBackgroundResource(R.drawable.menu_pemesanan)
        binding.ButtonMenuSewaFotografer.setBackgroundResource(R.drawable.menu_sewafotografer)
        binding.ButtonMenuSewaLiveMusic.setBackgroundResource(R.drawable.menu_sewalivemusic)
        binding.ButtonMenuSewaBeanBag.setBackgroundResource(R.drawable.menu_sewabeanbag)
        binding.ButtonMenuUpdateEvent.setBackgroundResource(R.drawable.menu_updateevent)

        // Set the active button background to active drawable
        when (activeButton.id) {
            R.id.ButtonMenu_Pemesanan -> activeButton.setBackgroundResource(R.drawable.menu_pemesanan_active)
            R.id.ButtonMenu_SewaFotografer -> activeButton.setBackgroundResource(R.drawable.menu_sewafotografer_active)
            R.id.ButtonMenu_SewaLiveMusic -> activeButton.setBackgroundResource(R.drawable.menu_sewalivemusic_active)
            R.id.ButtonMenu_SewaBeanBag -> activeButton.setBackgroundResource(R.drawable.menu_sewabeanbag_active)
            R.id.ButtonMenu_UpdateEvent -> activeButton.setBackgroundResource(R.drawable.menu_updateevent_active)
        }
    }
}

package com.psm.imlaundry

import android.content.res.Configuration
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //Manejar de forma global nuesto drawer
    private lateinit var drawer: DrawerLayout
    //Configura el icono de la aplicación ubicado a la izquierda de la barra de acciones o la barra de herramientas
    //para abrir y cerrar el cajón de navegación
    private lateinit var toggle: ActionBarDrawerToggle
    //Indice de nuestra seleccion
    private var intSelection:Int =  0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarHome)

        drawer = findViewById(R.id.drawer_layout)

        //Es el icono de hamburguesa
        //El contexto, drawlayout, toolbar, accesibilidad texto cuando abre, accesibilidad texto cuando cierra
        toggle = ActionBarDrawerToggle(this, drawer, toolbarHome, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        //conectamos nuestros toogle con el navigation draw
        drawer.addDrawerListener(toggle)
        //lo habilitamos para la navegación "ascendente" a través de
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //Habilitamos el icono de la aplicación a través
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        //Para capturar el evento click de las opciones de menu
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_home -> {

                Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
                toolbarHome.setTitle("Inicio")
                this.intSelection =  0

            }
            R.id.nav_item_search -> {
                Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show()
                toolbarHome.setTitle("Buscar")
                this.intSelection =  1

            }
            R.id.nav_item_branches -> {
                Toast.makeText(this, "Sucursales", Toast.LENGTH_SHORT).show()
                toolbarHome.setTitle("Sucursales")
                this.intSelection =  2
            }
            R.id.nav_item_profile -> {
                Toast.makeText(this, "Mi perfil", Toast.LENGTH_SHORT).show()
                toolbarHome.setTitle("Mi perfil")
                this.intSelection =  3
            }
            R.id.nav_item_bag -> {
                Toast.makeText(this, "Mi bolsa", Toast.LENGTH_SHORT).show()
                toolbarHome.setTitle("Mi bolsa")
                this.intSelection =  4
            }
            R.id.nav_item_orders -> {
                Toast.makeText(this, "Mis pedidos", Toast.LENGTH_SHORT).show()
                toolbarHome.setTitle("Mis pedidos")
                this.intSelection =  5
            }
            R.id.nav_item_logout -> {
                Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show()
                toolbarHome.setTitle("Cerrar sesión")
                this.intSelection =  6
            }
        }

        //Cierra las opciones de menu
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
        return true
    }


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        //toggle.onConfigurationChanged(newConfig)
        Toast.makeText(this, "onConfigurationChanged", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }


}
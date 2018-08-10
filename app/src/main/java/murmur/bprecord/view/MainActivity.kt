package murmur.bprecord.view

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import murmur.bprecord.R
import murmur.bprecord.databinding.ActivityMainBinding
import murmur.bprecord.model.db.entity.BpEntity
import java.util.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders
                .of(this, factory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.allRecyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.bpData.observe(this, Observer{
            if (it != null) {
                binding.allRecyclerView.adapter = BpAdapter(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showEditDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.edit_dialog)
        val button = dialog.findViewById<Button>(R.id.confirm_button)
        val editText = dialog.findViewById<EditText>(R.id.edit_text)
        button.setOnClickListener {
            val string = editText.text.toString()
            val split = string.split(" ")
            if (split.size == 3) {
                try {
                    val entry = BpEntity(null, Date().time, split[0].toDouble(),
                            split[1].toDouble(), split[2].toInt())
                    viewModel.addNewEntry(entry)
                    dialog.cancel()
                } catch (e: Exception) {
                    Toast.makeText(this, "wrong usage ${e.message}",
                            Toast.LENGTH_LONG).show()
                }

            } else {
                Toast.makeText(this, "wrong usage", Toast.LENGTH_SHORT).show()

            }
        }
        dialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.add_button -> {
                showEditDialog()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
